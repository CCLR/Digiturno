/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.dao;

import edu.konrad.digiturnotest.model.DgtArea;
import edu.konrad.digiturnotest.model.DgtAuditoriaTurno;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author Cristian Lopez
 */
public class DgtAuditoriaTurnoDao {
    
     private SessionFactory sessionFactory;

    /**
     * Constructor de la clase, el cual crea una instancia del sessionFactory
     */
    public DgtAuditoriaTurnoDao() {
         this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
     /**
     * Establece una conexión a base de datos a mediante objeto SessionFactory
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Devuelve todos los datos registrados en la tabla DgtAuditoriaTurno
     * @return lista de objetos DgtAuditoriaTurno
     */
    public List<DgtAuditoriaTurno> getAllAuditoria(){
        List<DgtAuditoriaTurno> dgtAuditoriaTurnoModelList = null;       
         try {
            Session session = this.sessionFactory.openSession();
            dgtAuditoriaTurnoModelList = session.createQuery("FROM DgtAuditoriaTurno").list();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtAuditoriaTurnoDao.getAllAuditoria()");
        }
        return dgtAuditoriaTurnoModelList;
    }
    
    
    /**
     * Actualiza el registro, si el auditoria pasada como parametro tiene un id mayor que 0, es decir que 
     * existe en la BD, por el contrario si el auditoria no es mayor que 0 quiere decir que el dato no existe, por lo cual se debe
     * agregar
     * @param auditoria
     * @throws Exception 
     */ 
      public void adicionaOActualizaAuditoria(DgtAuditoriaTurno auditoria) throws Exception{
        try{
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            if(auditoria.getNumeroTurno()> 0){
                session.update(auditoria);
            }else{
                session.persist(auditoria);
            }
            session.getTransaction().commit();
            session.close();
        }catch(ConstraintViolationException | JDBCConnectionException | DataException e){  
                System.out.println("Error en DgtAuditoriaTurnoDao.adicionaOActualizaAuditoria(): " + e.getMessage());
                throw new Exception(e);
        }

    }
     
      /**
    * trae un dato en especifico
    * @param auditoria 
    */  
    public DgtAuditoriaTurno getAuditoria(int idAuditoria) { 
        DgtAuditoriaTurno v_auditoria =  new DgtAuditoriaTurno();       
         try {
            Session session = this.sessionFactory.openSession();
             session.beginTransaction();          
             v_auditoria= (DgtAuditoriaTurno) session.get(DgtAuditoriaTurno.class, idAuditoria);             
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtAuditoriaTurnoDao.getAuditoria()");
        }
         return v_auditoria;
    }
      
   /**
    * Elimina un registro de la Bd, que corresponda al objeto pasado como parametro
    * @param idAuditoria 
    */  
    public void deleteAuditoria(int idAuditoria) { 
        DgtAuditoriaTurno auditoriaE = new DgtAuditoriaTurno();
        
         try {
            Session session = this.sessionFactory.openSession();
             session.beginTransaction(); 
             auditoriaE = (DgtAuditoriaTurno) session.get(DgtAuditoriaTurno.class, idAuditoria);
             System.out.println("as: "+ auditoriaE);
              session.delete(auditoriaE);
            session.getTransaction().commit();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtAuditoriaTurnoDao.deleteAuditoria()");
        }
    }
}
