package services;

import dao.UserCookieDAO;
import models.entities.UserCookie;

import java.util.List;

public class UserCookieService {
    private static UserCookieDAO userCookieDao;

    public UserCookieService() {
        userCookieDao = new UserCookieDAO();
    }

    public void persist(UserCookie entity) {
        userCookieDao.openCurrentSessionwithTransaction();
        userCookieDao.persist(entity);
        userCookieDao.closeCurrentSessionwithTransaction();
    }

    public void update(UserCookie entity) {
        userCookieDao.openCurrentSessionwithTransaction();
        userCookieDao.update(entity);
        userCookieDao.closeCurrentSessionwithTransaction();
    }

    public UserCookie findById(int id) {
        userCookieDao.openCurrentSession();
        UserCookie userCookie = userCookieDao.findById(id);
        userCookieDao.closeCurrentSession();
        return userCookie;
    }

    public void delete(int id) {
        userCookieDao.openCurrentSessionwithTransaction();
        UserCookie userCookie = userCookieDao.findById(id);
        userCookieDao.delete(userCookie);
        userCookieDao.closeCurrentSessionwithTransaction();
    }

    public List<UserCookie> findAll() {
        userCookieDao.openCurrentSession();
        List<UserCookie> users = userCookieDao.findAll();
        userCookieDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userCookieDao.openCurrentSessionwithTransaction();
        userCookieDao.deleteAll();
        userCookieDao.closeCurrentSessionwithTransaction();
    }

    public UserCookieDAO userDao() {
        return userCookieDao;
    }
}