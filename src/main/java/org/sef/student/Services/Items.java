package org.sef.student.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.sef.student.Exceptions.ChampExistsExeption;
import org.sef.student.Exceptions.CouldNotWriteUsersException;
import org.sef.student.Exceptions.ItemExistsExeption;
import org.sef.student.Model.Champion;
import org.sef.student.Model.Item;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Items {
    private static List<Item> items;
    private static final Path Item_PATH = FileSystemService.getPathToFile("items.json");

    public static void loadItemsFromFile() throws IOException {
        if (!Files.exists(Item_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(Users.class.getClassLoader().getResource("items.json")), Item_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        items = objectMapper.readValue(Item_PATH.toFile(), new TypeReference<List<Item>>() {
        });
    }

    public static void addItem(String name) throws ItemExistsExeption {
        checkNameDoesNotAlreadyExist(name);
        items.add(new Item(name));
        persistItems();
    }

    private static void checkNameDoesNotAlreadyExist(String name) throws ItemExistsExeption {
        for (Item item : items) {
            if (Objects.equals(name, item.getName()))
                throw new ItemExistsExeption(name);
        }
    }

    private static void persistItems() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(Item_PATH.toFile(), items);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }
}
