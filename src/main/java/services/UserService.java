package services;

import dao.UserDAO;
import models.entities.User;

import java.util.List;

public class UserService {
    private static UserDAO userDao;

    public UserService() {
        userDao = new UserDAO();
    }

    public void persist(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(int id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(int id) {
        userDao.openCurrentSessionwithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }

    public UserDAO userDao() {
        return userDao;
    }

    public User logIn(User user) throws Exception {
        userDao.openCurrentSession();
        User result = null;

        if(user.getUsername().isBlank() || user.getPassword().isBlank()) {
            userDao.closeCurrentSession();
            throw new Exception("Please fill all fields!");
        }

        for(User x : this.findAll())
        {
            if(user.equals(x))
            {
                result = x;
            }
        }
        userDao.closeCurrentSession();
        return result;
    }

    public User findByUsername(String username) {
        userDao.openCurrentSession();
        User result = null;
        for(User x : this.findAll())
        {
            if(x.getUsername().equals(username))
            {
                result = x;
            }
        }
        userDao.closeCurrentSession();
        return result;
    }
}