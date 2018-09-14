/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.dao;

import edu.konrad.digiturnotest.model.MensajeModel;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author lpajaro
 */
public class MensajeDaoImpl {
    
    private SessionFactory sessionFactory;

    /**
     * Constructor de la clase, inicializa objeto SessionFactory con conexion
     * a base de datos 
     */
    public MensajeDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    /**
     * Establece una conexión a base de datos a mediante objeto SessionFactory
     * @param sessionFactory 
     */    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Devuelve lista de objetos MensajeModel
     * @return lista de objetos AnsModel
     * @throws Exception propaga excepcion de base de datos
     */
    public List<MensajeModel> listar() throws Exception{
        
        List<MensajeModel> MensajeModelList = null;
        
        try{
        Session session = this.sessionFactory.openSession();
	MensajeModelList = session.createQuery("FROM MensajeModel").list();            
	session.close();
        }catch(ConstraintViolationException | JDBCConnectionException | DataException e){
            System.out.println("Error en MensajeDaoImpl.listar()");
        }
	return MensajeModelList;
        
    }
}
