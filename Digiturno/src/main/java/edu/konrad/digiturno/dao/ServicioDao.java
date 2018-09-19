/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.dao;

import edu.konrad.digiturno.model.ServicioModel;
import java.util.List;

/**
 *
 * @author Cristian Lopez
 */
public interface ServicioDao {
    
        ServicioModel findById(long id);

	ServicioModel findByName(String name);

	void saveServicio(ServicioModel servicio);

	void updateServicio(ServicioModel servicio);

	void deleteServicioById(long id);

	List<ServicioModel> findAllServicio();
        
        List<ServicioModel> findServiciosPadre();
        
        List<ServicioModel> findServiciosXRol();
        
        List<ServicioModel> findServiciosXPadre(long id);
        
        List<ServicioModel> findServiciosPadreXRol(String rol);
        
        List<ServicioModel> findServiciosPadreXSecAntecesor(int secAntecesor);

	void deleteAllServicio();

	boolean isServicioExist(ServicioModel servicio);
}
