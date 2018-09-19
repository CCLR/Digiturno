/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.service;

import edu.konrad.digiturno.dao.AreaDao;
import edu.konrad.digiturno.model.AreaModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Cristian Lopez
 */
public class AreaServiceImpl implements AreaService{
    
    @Autowired
	private AreaDao areaDao;

	/**
         * Settea el atributo del bean Dao
         * @param areaDao 
         */
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

        /**
         * Usa el objeto Dao para encontrar un registro por el Id pasado como parametro
         * @param id
         * @return 
         */
	@Override
	public AreaModel findById(long id) {

		return areaDao.findById(id);
	}

        /**
         * Usa el objeto Dao para encontrar un registro por el nombre pasado como parametro
         * @param name
         * @return 
         */
	@Override
	public AreaModel findByName(String name) {

		return areaDao.findByName(name);
	}

        /**
         * Usa el objeto Dao para guardar el registro pasado como parametro
         * @param area 
         */
	@Override
	public void saveArea(AreaModel area) {
		areaDao.saveArea(area);

	}

        /**
         * Usa el objeto Dao para actualizar el registro pasado como parametro
         * @param area 
         */
	@Override
	public void updateArea(AreaModel area) {
		areaDao.updateArea(area);

	}

        /**
         * Usa el objeto Dao para borrar el registro con el id pasado como parametro
         * @param id 
         */
	@Override
	public void deleteAreaById(long id) {
		areaDao.deleteAreaById(id);

	}

        /**
         * Usa el objeto Dao para encontrar todos los registros de la tabla
         * @return 
         */
	@Override
	public List<AreaModel> findAllArea() {

		return areaDao.findAllArea();
	}

        /**
         * Usa el objeto Dao para borrar todos los regisro de la tabla
         */
	@Override
	public void deleteAllArea() {
		areaDao.deleteAllArea();

	}

        /**
         * Usa el objeto Dao para encontrar un registro pasdo como parametro
         * @param area
         * @return boolean
         */
	@Override
	public boolean isAreaExist(AreaModel area) {

		return areaDao.isAreaExist(area);
	}

}
