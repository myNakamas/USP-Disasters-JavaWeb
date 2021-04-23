package services;

import dao.DisasterDAO;
import models.entities.Disaster;

import java.util.ArrayList;
import java.util.List;

public class DisasterService {
    private static DisasterDAO disasterDao;

    public DisasterService() {
        disasterDao = new DisasterDAO();
    }

    public void persist(Disaster entity) {
        disasterDao.openCurrentSessionwithTransaction();
        disasterDao.persist(entity);
        disasterDao.closeCurrentSessionwithTransaction();
    }

    public void update(Disaster entity) {
        disasterDao.openCurrentSessionwithTransaction();
        disasterDao.update(entity);
        disasterDao.closeCurrentSessionwithTransaction();
    }

    public Disaster findById(Long id) {
        disasterDao.openCurrentSession();
        Disaster disaster = disasterDao.findById(id);
        disasterDao.closeCurrentSession();
        return disaster;
    }

    public Disaster findByDisasterId(String id) {
        disasterDao.openCurrentSession();
        for(Disaster x : this.findAll(-1))
        {
            if(x.getDisasterId().equals(id))
            {
                disasterDao.closeCurrentSession();
                return x;
            }
        }
        disasterDao.closeCurrentSession();
        return null;
    }

    public Disaster findBy(String id){
        return null;
    }

    public void delete(Long id) {
        disasterDao.openCurrentSessionwithTransaction();
        Disaster disaster = disasterDao.findById(id);
        disasterDao.delete(disaster);
        disasterDao.closeCurrentSessionwithTransaction();
    }

    public List<Disaster> findAll(int max) {
        disasterDao.openCurrentSession();
        List<Disaster> disasters = disasterDao.findAll(max);
        disasterDao.closeCurrentSession();
        return disasters;
    }

    public void deleteAll() {
        disasterDao.openCurrentSessionwithTransaction();
        disasterDao.deleteAll();
        disasterDao.closeCurrentSessionwithTransaction();
    }

    public DisasterDAO disasterDao() {
        return disasterDao;
    }

    public ArrayList<Disaster> findAllByCountry(String Country) {
        disasterDao.openCurrentSession();
        ArrayList<Disaster> result = new ArrayList<>();
        for(Disaster x : this.findAll(-1))
        {
            if(x.getCountry().equals(Country))
            {
                result.add(x);
            }
        }
        disasterDao.closeCurrentSession();
        return result;
    }
}