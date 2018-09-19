/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.dao;

import edu.konrad.digiturno.model.AreaModel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Cristian Lopez
 */
public class AreaDaoImpl implements AreaDao {

    @Autowired
    private SessionFactory sessionFactory;

    //setter for sessionFactory
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AreaModel findById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AreaModel area = new AreaModel();
        try {
            area = (AreaModel) session.get(AreaModel.class, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return area;
    }

    public AreaModel findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AreaModel area = new AreaModel();
        String hql = "from edu.konrad.digiturno.model.AreaModel where namArea = ?";
        try {
            Query query = session.createQuery(hql);
            query.setParameter(0, name);
            area = (AreaModel) query.uniqueResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return area;
    }

    public void saveArea(AreaModel area) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (area != null) {
            try {
                session.save(area);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                session.close();
            }

        }

    }

    public void updateArea(AreaModel area) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (area != null) {
            try {
                session.update(area);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                session.close();
            }

        }

    }

    public void deleteAreaById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AreaModel area = new AreaModel();
        try {
            area = (AreaModel) session.get(AreaModel.class, id);
            session.delete(area);
            transaction.commit();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            transaction.rollback();
            session.close();
            System.out.println("Error en DgtAuditoriaTurnoDao.getAllAuditoria()");
            System.out.println("Error." + e);
        }

    }

    @SuppressWarnings("unchecked")
    public List<AreaModel> findAllArea() {
        List<AreaModel> area = new ArrayList<AreaModel>();
        Session session = sessionFactory.openSession();
        area = session.createQuery("From edu.konrad.digiturno.model.AreaModel").list();
        return area;
    }

    public void deleteAllArea() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery("delete from Area").executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }

    }

    public boolean isAreaExist(AreaModel area) {

        return findByName(area.getNamArea()) != null;
    }

}
