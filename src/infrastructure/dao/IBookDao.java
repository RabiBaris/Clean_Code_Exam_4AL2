package infrastructure.dao;

import domain.Book;

import java.util.List;

public interface IBookDao {
    public List<Book> getBooks();
    public Book getBookByTitle(String title);
    public List<String> getAllTitles();
}
