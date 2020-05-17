package org.sef.student.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.sef.student.Exceptions.ChampExistsExeption;
import org.sef.student.Exceptions.CouldNotWriteUsersException;
import org.sef.student.Exceptions.UsernameAlreadyExistsException;
import org.sef.student.Model.Champion;
import org.sef.student.Model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Champions {
    private static List<Champion> champs;
    private static final Path Champ_PATH = FileSystemService.getPathToFile("champions.json");

    public static void loadChampionsFromFile() throws IOException {
        if (!Files.exists(Champ_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(Users.class.getClassLoader().getResource("champions.json")), Champ_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        champs = objectMapper.readValue(Champ_PATH.toFile(), new TypeReference<List<Champion>>() {
        });
    }

    public static void addChampion(String name, String creator) throws ChampExistsExeption {
        checkNameDoesNotAlreadyExist(name);
        champs.add(new Champion(name, creator));
        persistChamps();
    }

    private static void checkNameDoesNotAlreadyExist(String name) throws ChampExistsExeption {
        for (Champion champ : champs) {
            if (Objects.equals(name, champ.getName()))
                throw new ChampExistsExeption(name);
        }
    }

    private static void persistChamps() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(Champ_PATH.toFile(), champs);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }
}
