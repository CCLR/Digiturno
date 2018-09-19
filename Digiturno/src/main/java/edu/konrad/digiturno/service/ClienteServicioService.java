/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.service;

import edu.konrad.digiturno.model.ClienteServicioModel;
import java.util.List;

/**
 *
 * @author Cristian Lopez
 */
public interface ClienteServicioService  {
    
     List<ClienteServicioModel> findAllServicio();
}
