package org.sef.student.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.sef.student.Exceptions.CouldNotWriteUsersException;
import org.sef.student.Exceptions.UsernameAlreadyExistsException;
import org.sef.student.Model.Game;
import org.sef.student.Model.Item;
import org.sef.student.Model.User;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Games {
   private static List<Game> games ;
   private static final Path Games_PATH = FileSystemService.getPathToFile("games", "games.json");
   public static void loadGamesFromFile() throws IOException {
      if (!Files.exists(Games_PATH)) {
         FileUtils.copyURLToFile(Objects.requireNonNull(Users.class.getClassLoader().getResource("games.json")), Games_PATH.toFile());
      }

      ObjectMapper objectMapper = new ObjectMapper();

      games = objectMapper.readValue(Games_PATH.toFile(), new TypeReference<List<Game>>() {
      });
   }
   public static void addGame(String user,
                              String champ,
                              List<Item> items,
                              String isWin){
      games.add(new Game(user,
              champ,
              items,
              isWin));
      persistGames();
   }
   public static List getGames(String champion,String username)
   {
      return games;
   }
   private static void persistGames() {
      try {
         ObjectMapper objectMapper = new ObjectMapper();
         objectMapper.writerWithDefaultPrettyPrinter().writeValue(Games_PATH.toFile(), games);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   public static List<Game> getGames()
   {
      return games;
   }
}
