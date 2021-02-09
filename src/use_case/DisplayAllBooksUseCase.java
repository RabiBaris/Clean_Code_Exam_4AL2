package use_case;

import domain.Book;
import infrastructure.dao.IBookDao;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.MessageFactory;

import java.util.List;

public class DisplayAllBooksUseCase {

    private void display() {
        IBookDao bookDao = DaoFactory.getBookDao();
        List<Book> books = bookDao.getBooks();
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString());
        }
        MessageFactory.getMessage().send(sb.toString());
    }

    public DisplayAllBooksUseCase() {
        display();
    }
}
