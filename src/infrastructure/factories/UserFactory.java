package infrastructure.factories;

import com.fasterxml.jackson.databind.JsonNode;

import infrastructure.dao.IUserDao;
import domain.User;

public class UserFactory {


    private static UserFactory instance;

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public void addUser(JsonNode json) {
        int id = json.get("id").intValue();
        User user = new User(id);
        IUserDao userDao = DaoFactory.getUserDao();
        userDao.getUsers().add(user);

    }


}
