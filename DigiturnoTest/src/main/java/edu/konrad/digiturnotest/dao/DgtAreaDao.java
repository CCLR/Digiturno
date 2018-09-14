/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.dao;


import edu.konrad.digiturnotest.model.DgtArea;
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
public class DgtAreaDao {
    
    private SessionFactory sessionFactory;

    /**
     * Constructor de la clase, el cual crea una instancia del sessionFactory
     */
    public DgtAreaDao() {
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
     * Devuelve todos los datos registrados en la tabla 
     * @return lista de objetos
     */
    public List<DgtArea> getAllArea(){
        List<DgtArea> areaModelList = null;       
         try {
            Session session = this.sessionFactory.openSession();
            areaModelList = session.createQuery("FROM DgtArea").list();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtAreaDao.getAllArea()");
        }
        return areaModelList;
    }
    
    
    /**
     * Actualiza el registro, si el objeto pasada como parametro tiene un id mayor que 0, es decir que 
     * existe en la BD, por el contrario si el objeto no es mayor que 0 quiere decir que el dato no existe, por lo cual se debe
     * agregar
     * @param area
     * @throws Exception 
     */ 
      public void adicionaOActualizaArea(DgtArea area) throws Exception{
        try{
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            if(area.getSeqArea() > 0){
                session.update(area);
            }else{
                session.persist(area);
            }
            session.getTransaction().commit();
            session.close();
        }catch(ConstraintViolationException | JDBCConnectionException | DataException e){  
                System.out.println("Error en AnsDaoImpl.adicionaOActualiza(): " + e.getMessage());
                throw new Exception(e);
        }

    }
     
      /**
    * trae un dato en especifico
    * @param area 
    */  
    public DgtArea getArea(int idArea) { 
        DgtArea v_area =  new DgtArea();       
         try {
            Session session = this.sessionFactory.openSession();
             session.beginTransaction();          
             v_area= (DgtArea) session.get(DgtArea.class, idArea);
             System.out.println("area " + v_area);
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtAreaDao.getArea()");
        }
         return v_area;
    }
      
   /**
    * elimina un registro de la Bd, que corresponda al objeto pasado como parametro
    * @param area 
    */  
    public void deleteArea(int idArea) { 
        DgtArea areaE = new DgtArea();
        
         try {
            Session session = this.sessionFactory.openSession();
             session.beginTransaction(); 
             areaE = (DgtArea) session.get(DgtArea.class, idArea);
             System.out.println("as: "+ areaE);
              session.delete(areaE);
            session.getTransaction().commit();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtAreaDao.deleteArea()");
        }
    }
    
    
    
    
    
}
