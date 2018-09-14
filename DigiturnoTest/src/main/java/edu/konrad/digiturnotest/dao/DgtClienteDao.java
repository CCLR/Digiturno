/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.dao;

import edu.konrad.digiturnotest.model.DgtCliente;
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
public class DgtClienteDao {
     private SessionFactory sessionFactory;

    /**
     * Constructor de la clase, el cual crea una instancia del sessionFactory
     */
    public DgtClienteDao() {
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
    public List<DgtCliente> getAllCliente(){
        List<DgtCliente> clienteModelList = null;       
         try {
            Session session = this.sessionFactory.openSession();
            clienteModelList = session.createQuery("FROM DgtCliente").list();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtClienteDao.getAllCliente()");
        }
        return clienteModelList;
    }
    
    
    /**
     * Actualiza el registro, si el objeto pasada como parametro tiene un id mayor que 0, es decir que 
     * existe en la BD, por el contrario si el objeto no es mayor que 0 quiere decir que el dato no existe, por lo cual se debe
     * agregar
     * @param cliente
     * @throws Exception 
     */ 
      public void adicionaOActualizaCliente(DgtCliente cliente) throws Exception{
        try{
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            if(cliente.getClienteCedulaPk()> 0){
                session.update(cliente);
            }else{
                session.persist(cliente);
            }
            session.getTransaction().commit();
            session.close();
        }catch(ConstraintViolationException | JDBCConnectionException | DataException e){  
                System.out.println("Error en DgtClienteDao.adicionaOActualizaCliente(): " + e.getMessage());
                throw new Exception(e);
        }

    }
     
      /**
    * trae un dato en especifico
    * @param area 
    */  
    public DgtCliente getCliente(int idCliente) { 
        DgtCliente v_area =  new DgtCliente();       
         try {
            Session session = this.sessionFactory.openSession();
             session.beginTransaction();          
             v_area= (DgtCliente) session.get(DgtCliente.class, idCliente);
             System.out.println("area " + v_area);
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtClienteDao.getCliente()");
        }
         return v_area;
    }
      
   /**
    * elimina un registro de la Bd, que corresponda al objeto pasado como parametro
    * @param area 
    */  
    public void deleteCliente(int idCliente) { 
        DgtCliente areaE = new DgtCliente();
        
         try {
            Session session = this.sessionFactory.openSession();
             session.beginTransaction(); 
             areaE = (DgtCliente) session.get(DgtCliente.class, idCliente);
             System.out.println("as: "+ areaE);
              session.delete(areaE);
            session.getTransaction().commit();
            session.close();
        } catch (ConstraintViolationException | JDBCConnectionException | DataException e) {
            System.out.println("Error en DgtClienteDao.deleteCliente()");
        }
    }
    
}
