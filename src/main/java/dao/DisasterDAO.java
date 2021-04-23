package dao;

import dao.interfaces.DaoInterface;
import models.entities.Disaster;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

@SuppressWarnings("unchecked")
public class DisasterDAO{
    private Session currentSession;

    private Transaction currentTransaction;

    public DisasterDAO(){

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

    public void persist(Disaster entity) {
        getCurrentSession().save(entity);
    }

    public void update(Disaster entity) {
        getCurrentSession().update(entity);
    }

    public Disaster findById(Long id) {
        return getCurrentSession().get(Disaster.class, id);
    }
    public void delete(Disaster entity) {
        getCurrentSession().delete(entity);
    }

    public List<Disaster> findAll(int max) {
        if( max == -1){
            return (List<Disaster>) getCurrentSession().createQuery("from Disaster").list();
        }
        else {
            return (List<Disaster>) getCurrentSession().createQuery("from Disaster").setMaxResults(max).list();
        }
    }

    public List<Disaster> findAllByCountry(String Country, int max) {
        if( max == -1) {
            return (List<Disaster>) getCurrentSession().createQuery("from Disaster where Disaster.country = " + Country).list();
        }
        else{
            return (List<Disaster>) getCurrentSession().createQuery("from Disaster where Disaster.country = " + Country).setMaxResults(max).list();
        }
    }

    public void deleteAll() {
        List<Disaster> entityList = findAll(-1);
        for (Disaster entity : entityList) {
            delete(entity);
        }
    }
}