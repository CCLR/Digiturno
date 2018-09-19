/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.dao;

import edu.konrad.digiturno.model.ClienteServicioModel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Cristian Lopez
 */
public class ClienteServicioDaoImpl implements ClienteServicioDao{

     @Autowired
	private SessionFactory sessionFactory;
     
     //setter for sessionFactory
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
     @SuppressWarnings("unchecked")
    public List<ClienteServicioModel> findAllServicio() {
        List<ClienteServicioModel> clienteServicio = new ArrayList<ClienteServicioModel>();
        Session session = sessionFactory.openSession();
        clienteServicio = session.createQuery("From edu.konrad.digiturno.model.ClienteServicioModel").list();
        return clienteServicio;   
    }
    
    
    
}
