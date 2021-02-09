package infrastructure.factories;

import infrastructure.dao.IBookDao;
import infrastructure.dao.IUserDao;
import infrastructure.dao.memoryList.BookDaoMemoryList;
import infrastructure.dao.memoryList.UserDaoMemoryList;

public class DaoFactory {

    public static IUserDao getUserDao(){
        return UserDaoMemoryList.getInstance();
    }

    public static IBookDao getBookDao(){
        return BookDaoMemoryList.getInstance();
    }


}
