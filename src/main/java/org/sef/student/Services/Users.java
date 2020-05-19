package org.sef.student.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.sef.student.Exceptions.*;
import org.sef.student.Model.User;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

public class Users {

    private static String k = "Bar12345Bar12345";
    private static String s;
    //SecretKey key = KeyGenerator.getInstance("AES").generateKey();
    private static SecretKey key;
    private static  Encryption encrypter;
    private static List<User> users;
    private static User curent=new User();
    private static final Path USERS_PATH = FileSystemService.getPathToFile("users", "users.json");
    public static void setCurrentUser(String username,String role)
    {
        curent.setUsername(username);
        curent.setRole(role);
    }
    public static void loadUsersFromFile() throws IOException {
        key=new SecretKeySpec(k.getBytes(), "AES");
        try {
            encrypter = new Encryption(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(Users.class.getClassLoader().getResource("users.json")), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        users.add(new User(username, encode(password), role));
        persistUsers();
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
    public static String checkAccountExist(String username,String password){
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                if( Objects.equals(password,decode(user.getPassword())))
                    return user.getRole();
        }
        return null;
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static String encode(String str)
    {
        try {
           s = encrypter.encrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static String decode(String str)
    {
        try {
            s= encrypter.decrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static String getCurrentUsername()
    {
        return curent.getUsername();
    }

}
