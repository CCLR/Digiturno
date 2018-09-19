/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.service;

import edu.konrad.digiturno.model.ServicioModel;
import java.util.List;

/**
 *
 * @author Cristian Lopez
 */
public interface ServicioService {

    ServicioModel findById(long id);

    List<ServicioModel> findServiciosPadreXRol(String rol);

    ServicioModel findByName(String name);

    void saveServicio(ServicioModel servicio);

    void updateServicio(ServicioModel servicio);

    void deleteServicioById(long id);

    List<ServicioModel> findServiciosPadreXSecAntecesor(int secAntecesor);

    List<ServicioModel> findAllServicio();

    List<ServicioModel> findServiciosXRol();

    List<ServicioModel> findServiciosXPadre(long id);

    List<ServicioModel> findServiciosPadre();

    void deleteAllServicio();

    boolean isServicioExist(ServicioModel servicio);
}
