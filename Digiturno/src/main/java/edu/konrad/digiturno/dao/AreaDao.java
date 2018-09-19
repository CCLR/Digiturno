/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.dao;

import edu.konrad.digiturno.model.AreaModel;
import java.util.List;

/**
 *
 * @author Cristian Lopez
 */
public interface AreaDao {
    
        AreaModel findById(long id);

	AreaModel findByName(String name);

	void saveArea(AreaModel area);

	void updateArea(AreaModel area);

	void deleteAreaById(long id);

	List<AreaModel> findAllArea();

	void deleteAllArea();

	boolean isAreaExist(AreaModel area);
}
