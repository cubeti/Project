package org.sef.student.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.sef.student.Exceptions.ChampExistsExeption;
import org.sef.student.Exceptions.CouldNotWriteUsersException;
import org.sef.student.Model.Champion;
import org.sef.student.Model.Message;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Messages {
    private static List<Message> msg;
    private static final Path MSG_PATH = FileSystemService.getPathToFile("messages.json");

    public static void loadMSGFromFile() throws IOException {
        if (!Files.exists(MSG_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(Users.class.getClassLoader().getResource("messages.json")), MSG_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        msg = objectMapper.readValue(MSG_PATH.toFile(), new TypeReference<List<Message>>() {
        });
    }

    public static void addMSG(String name, String dest,String text) {
        msg.add(new Message(name,dest,text));
        persistMSG();
    }
    public static List<Message> getMessages()
    {
        return msg;
    }


    private static void persistMSG() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(MSG_PATH.toFile(), msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
