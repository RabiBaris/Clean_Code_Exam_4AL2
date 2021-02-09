package infrastructure.dao.memoryList;

import domain.Book;
import infrastructure.dao.IBookDao;

import java.util.ArrayList;
import java.util.List;

public class BookDaoMemoryList implements IBookDao {
    private List<Book> books = new ArrayList<>();
    private static BookDaoMemoryList instance;

    private BookDaoMemoryList() {
    }

    public static BookDaoMemoryList getInstance() {
        if (instance == null) {
            instance = new BookDaoMemoryList();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle() == title) {
                return book;
            }
        }
        return null;
    }

    public List<String> getAllTitles () {
        List<String> result = new ArrayList <>();
        for (Book book : books) {
            result.add(book.getTitle());
        }
        return result;
    }
}




