/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.service;

import edu.konrad.digiturno.dao.ClienteServicioDao;
import edu.konrad.digiturno.model.ClienteServicioModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Cristian Lopez
 */
public class ClienteServicioServiceImpl implements ClienteServicioService{
    
        @Autowired
        private ClienteServicioDao clienteServicioDao;
        
         public void setClienteServicioDao(ClienteServicioDao clienteServicioDao) {
		this.clienteServicioDao = clienteServicioDao;
	}
           /**
         * Usa el objeto Dao para encontrar todos los registros de la tabla
         * @return 
         */
	@Override
	public List<ClienteServicioModel> findAllServicio() {
		return clienteServicioDao.findAllServicio();
	}
}
