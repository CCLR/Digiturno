/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.service;

import edu.konrad.digiturno.dao.ServicioDao;
import edu.konrad.digiturno.model.ServicioModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Cristian Lopez
 */
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioDao servicioDao;

    /**
     * Settea el atributo del bean Dao
     *
     * @param servicioDao
     */
    public void setServicioDao(ServicioDao servicioDao) {
        this.servicioDao = servicioDao;
    }

    /**
     * Usa el objeto Dao para encontrar un registro por el Id pasado como
     * parametro
     *
     * @param id
     * @return
     */
    @Override
    public ServicioModel findById(long id) {
        System.out.println("Servs:" + id);
        return servicioDao.findById(id);
    }

    /**
     * Usa el objeto Dao para encontrar un registro por el nombre pasado como
     * parametro
     *
     * @param name
     * @return
     */
    @Override
    public ServicioModel findByName(String name) {
        
        return servicioDao.findByName(name);
    }

    /**
     * Usa el objeto Dao para guardar el registro pasado como parametro
     *
     * @param servicio
     */
    @Override
    public void saveServicio(ServicioModel servicio) {
        servicioDao.saveServicio(servicio);
        
    }

    /**
     * Usa el objeto Dao para actualizar el registro pasado como parametro
     *
     * @param servicio
     */
    @Override
    public void updateServicio(ServicioModel servicio) {
        servicioDao.updateServicio(servicio);
        
    }

    /**
     * Usa el objeto Dao para borrar el registro con el id pasado como parametro
     *
     * @param id
     */
    @Override
    public void deleteServicioById(long id) {
        servicioDao.deleteServicioById(id);
        
    }

    /**
     * Usa el objeto Dao para encontrar todos los registros de la tabla
     *
     * @return
     */
    @Override
    public List<ServicioModel> findAllServicio() {
        
        return servicioDao.findAllServicio();
    }
    
    @Override
    public List<ServicioModel> findServiciosXPadre(long id) {
        System.out.println("Vuelve");
        List<ServicioModel> s = new ArrayList<>();
        s = servicioDao.findServiciosXPadre(id);
        System.out.println("Vuelvex2");
        if (s.isEmpty() || s == null) {
            System.out.println("Servicio es final");
        }
        return s;
    }
    
    @Override
    public List<ServicioModel> findServiciosPadre() {
        
        return servicioDao.findServiciosPadre();
    }
    
    @Override
    public List<ServicioModel> findServiciosPadreXRol(String rol) {
        
        return servicioDao.findServiciosPadreXRol(rol);
    }
    
    @Override
    public List<ServicioModel> findServiciosXRol() {
        
        return servicioDao.findServiciosXRol();
    }

    /**
     * Usa el objeto Dao para borrar todos los regisro de la tabla
     */
    @Override
    public void deleteAllServicio() {
        servicioDao.deleteAllServicio();
        
    }

    /**
     * Usa el objeto Dao para encontrar un registro pasdo como parametro
     *
     * @param servicio
     * @return boolean
     */
    @Override
    public boolean isServicioExist(ServicioModel servicio) {
        
        return servicioDao.isServicioExist(servicio);
    }
    
    @Override
    public List<ServicioModel> findServiciosPadreXSecAntecesor(int secAntecesor) {
        return servicioDao.findServiciosPadreXSecAntecesor(secAntecesor);
    }
    
}
