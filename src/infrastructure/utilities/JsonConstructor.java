package infrastructure.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.dao.IUserDao;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.BookFactory;
import infrastructure.factories.UserFactory;

public class JsonConstructor {

    private JsonNode json;

    public JsonConstructor() throws IOException {

    }



    public void init () throws IOException {
        StringBuilder contentOfUser = new StringBuilder();
        Stream<String> linesOfUser = Files.lines(Paths.get("resources/user.json"));
        contentOfUser.append(linesOfUser.collect(Collectors.joining(System.lineSeparator())));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonOfUsers = mapper.readTree(contentOfUser.toString());
        UserFactory userFactory = UserFactory.getInstance();
        for (JsonNode json : jsonOfUsers) {
            userFactory.addUser(json);
        }
        IUserDao userDao = DaoFactory.getUserDao();
        StringBuilder contentOfBook = new StringBuilder();
        Stream<String> linesOfBook = Files.lines(Paths.get("resources/books.json"));
        contentOfBook.append(linesOfBook.collect(Collectors.joining(System.lineSeparator())));
        JsonNode jsonOfBooks = mapper.readTree(contentOfBook.toString());
        BookFactory bookFactory = BookFactory.getInstance();
        for (JsonNode json : jsonOfBooks) {
            bookFactory.addBook(json);
        }
    }
}
