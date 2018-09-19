/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.dao;

import edu.konrad.digiturno.model.ServicioModel;
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
public class ServicioDaoImpl implements ServicioDao {

    @Autowired
    private SessionFactory sessionFactory;

    //setter for sessionFactory
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ServicioModel findById(long id) {
        System.out.println("Daoservicio:");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ServicioModel servicio = new ServicioModel();
        System.out.println("Daoservicio:" + servicio);
        try {
            System.out.println("Wepale");
            servicio = (ServicioModel) session.get(ServicioModel.class, id);
            System.out.println("Servicio: " + servicio);
            System.out.println("ASDASD");
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return servicio;
    }

    public ServicioModel findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ServicioModel servicio = new ServicioModel();
        String hql = "from edu.konrad.digiturno.model.ServicioModel where namServicio = ?";
        try {
            Query query = session.createQuery(hql);
            query.setParameter(0, name);
            servicio = (ServicioModel) query.uniqueResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return servicio;
    }

    public void saveServicio(ServicioModel servicio) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (servicio != null) {
            try {
                session.save(servicio);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                session.close();
            }

        }

    }

    public void updateServicio(ServicioModel servicio) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (servicio != null) {
            try {
                session.update(servicio);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                session.close();
            }

        }

    }

    public void deleteServicioById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ServicioModel servicio = new ServicioModel();
        try {
            servicio = (ServicioModel) session.get(ServicioModel.class, id);
            session.delete(servicio);
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
    public List<ServicioModel> findAllServicio() {
        List<ServicioModel> servicio = new ArrayList<ServicioModel>();
        Session session = sessionFactory.openSession();
        servicio = session.createQuery("From edu.konrad.digiturno.model.ServicioModel").list();
        return servicio;
    }

    @SuppressWarnings("unchecked")
    public List<ServicioModel> findServiciosXPadre(long id) {
        List<ServicioModel> servicio = new ArrayList<ServicioModel>();
        Session session = sessionFactory.openSession();
        servicio = session.createSQLQuery("  SELECT nam_servicio, sec_servicio, servicio_antecesor\n"
                + "   FROM dgt_servicio  where servicio_antecesor = " + id).addEntity(ServicioModel.class).list();
        //servicio = session.createQuery("from edu.konrad.digiturno.model.ServicioModel where servicioAntecesor = 0").list();

        return servicio;
    }

    @SuppressWarnings("unchecked")
    public List<ServicioModel> findServiciosPadre() {
        List<ServicioModel> servicio = new ArrayList<ServicioModel>();
        Session session = sessionFactory.openSession();
        servicio = session.createSQLQuery("select  nam_servicio, sec_servicio, servicio_antecesor, tipo_servicio from dgt_servicio where servicio_antecesor =0 ").addEntity(ServicioModel.class).list();
        //servicio = session.createQuery("from edu.konrad.digiturno.model.ServicioModel where servicioAntecesor = 0").list();

        return servicio;
    }

    @SuppressWarnings("unchecked")
    public List<ServicioModel> findServiciosPadreXRol(String rol) {
        List<ServicioModel> servicio = new ArrayList<ServicioModel>();
        Session session = sessionFactory.openSession();
        servicio = session.createSQLQuery("select  dgt_servicio.* from dgt_tipo_usuario \n"
                + "inner join dgt_tipo_usuario_servicio on dgt_tipo_usuario_servicio.sec_tipo_usuario = dgt_tipo_usuario.sec_tipo_usuario \n"
                + "inner join dgt_servicio on dgt_tipo_usuario_servicio.sec_servicio = dgt_servicio.sec_servicio \n"
                + "where lower (dgt_tipo_usuario.nam_tipo_usuario) = lower ('" + rol + "') ").addEntity(ServicioModel.class).list();
        //servicio = session.createQuery("from edu.konrad.digiturno.model.ServicioModel where servicioAntecesor = 0").list();

        return servicio;
    }

    
    @SuppressWarnings("unchecked")
    public List<ServicioModel> findServiciosPadreXSecAntecesor(int secAntecesor) {
        List<ServicioModel> servicio = new ArrayList<ServicioModel>();
        Session session = sessionFactory.openSession();
        servicio = session.createSQLQuery("select * from dgt_servicio where servicio_antecesor = "+secAntecesor).addEntity(ServicioModel.class).list();
        return servicio;
    }

    
    
    @SuppressWarnings("unchecked")
    public List<ServicioModel> findServiciosXRol() {
        List<ServicioModel> servicio = new ArrayList<ServicioModel>();
        Session session = sessionFactory.openSession();
        servicio = session.createSQLQuery("select  s.sec_servicio, s.nam_servicio, s.servicio_antecesor, s.tipo_servicio from  dgt_servicio  s inner join dgt_tipo_usuario_servicio on dgt_tipo_usuario_servicio.sec_servicio = s.sec_servicio  \n"
                + "inner join dgt_tipo_usuario on dgt_tipo_usuario_servicio.sec_tipo_usuario = dgt_tipo_usuario.sec_tipo_usuario\n"
                + "where  lower(dgt_tipo_usuario.nam_tipo_usuario) = lower('EsTudiante')").addEntity(ServicioModel.class).list();

        for (ServicioModel it : servicio) {
            System.out.println("SEQ: " + it.getSeqServicio());
            List<Object[]> o1 = new ArrayList<Object[]>();
            o1 = session.createSQLQuery("SELECT sec_servicio, servicio_antecesor, nam_servicio, tipo_servicio, LEVEL\n"
                    + "      FROM dgt_servicio\n"
                    + "      START WITH sec_servicio = 1 \n"
                    + "      CONNECT BY PRIOR sec_servicio = servicio_antecesor\n"
                    + "      ORDER SIBLINGS BY nam_servicio").list();
            /*  if(!o1.isEmpty() || o1 != null) {
                           int level =0;
                           for(Object[] it2: o1){
                               level=
                               System.out.println("it2:"+it2 );
                               for(Object it3: it2){
                                   System.out.println("Seipo: "+it3.toString());
                               }
                              
                               
                           }
                       }  */
        }
        //servicio = session.createQuery("from edu.konrad.digiturno.model.ServicioModel where servicioAntecesor = 0").list();

        return servicio;
    }

    public void deleteAllServicio() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery("delete from ServicioModel").executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }

    }

    public boolean isServicioExist(ServicioModel servicio) {

        return findByName(servicio.getNamServicio()) != null;
    }

}
