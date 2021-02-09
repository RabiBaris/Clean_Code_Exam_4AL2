package infrastructure.factories;

import com.fasterxml.jackson.databind.JsonNode;
import domain.Book;
import infrastructure.dao.IBookDao;

public class BookFactory {
    private static BookFactory instance;

    private BookFactory() {
    }

    public static BookFactory getInstance() {
        if (instance == null) {
            instance = new BookFactory();
        }
        return instance;
    }

    public void addBook(JsonNode json) {
        int id = json.get("id").intValue();
        String title = json.get("title").textValue();
        String author = json.get("authorName").textValue();
        Book book = new Book(id, title, author);
        IBookDao bookDao = DaoFactory.getBookDao();
        bookDao.getBooks().add(book);

    }
}
