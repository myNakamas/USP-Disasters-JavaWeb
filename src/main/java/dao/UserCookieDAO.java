package dao;

import models.entities.UserCookie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class UserCookieDAO {
    private Session currentSession;

    private Transaction currentTransaction;

    public UserCookieDAO(){

    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(UserCookie entity) {
        getCurrentSession().save(entity);
    }

    public void update(UserCookie entity) {
        getCurrentSession().update(entity);
    }

    public UserCookie findById(long id) {
        return getCurrentSession().get(UserCookie.class, id);
    }
    public void delete(UserCookie entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<UserCookie> findAll() {
        return (List<UserCookie>) getCurrentSession().createQuery("from UserCookie").list();
    }

    public void deleteAll() {
        List<UserCookie> entityList = findAll();
        for (UserCookie entity : entityList) {
            delete(entity);
        }
    }
}