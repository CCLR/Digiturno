/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.controller;

import edu.konrad.digiturnotest.dao.DgtAreaDao;
import edu.konrad.digiturnotest.dao.DgtAuditoriaTurnoDao;
import edu.konrad.digiturnotest.dao.DgtClienteDao;
import edu.konrad.digiturnotest.dao.MensajeDaoImpl;
import edu.konrad.digiturnotest.model.DgtArea;
import edu.konrad.digiturnotest.model.DgtAuditoriaTurno;
import edu.konrad.digiturnotest.model.DgtCliente;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lpajaro
 */
@RestController
public class InicioController implements Serializable {

    /**
     * Prueba conexion
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping("/inicio")
    public ModelAndView inicio(Model model, HttpServletRequest request) {

        MensajeDaoImpl v_mensajedao = new MensajeDaoImpl();
        DgtAreaDao v_dgtArea = new DgtAreaDao();
        ModelAndView mv = new ModelAndView("testDigiturno");
        try {
            mv.addObject("mensajes", v_mensajedao.listar());
           /* System.out.println("Lista " + v_dgtArea.getAllArea());
            System.out.println("cantidad " + v_dgtArea.getAllArea().size());
            v_dgtArea.addArea();
            System.out.println("Lista " + v_dgtArea.getAllArea());
            System.out.println("cantiadad " + v_dgtArea.getAllArea().size());
            v_dgtArea.editArea();
            System.out.println("Lista " + v_dgtArea.getAllArea());
            v_dgtArea.deleteArea();
            System.out.println("Lista " + v_dgtArea.getAllArea());
            System.out.println("cantiadad " + v_dgtArea.getAllArea().size());*/

            //System.out.println("cantiadad " + v_mensajedao.listar().size());
        } catch (Exception ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (mv);
    }

    /**
     * trae todos los elementos de la tabla area
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public List<DgtArea> listaAreas() throws Exception {
        DgtAreaDao v_dgtArea = new DgtAreaDao();
//        DgtArea area = new DgtArea();
//        area.setNamArea("Cancelacion");
//        v_dgtArea.adicionaOActualizaArea(area);
       
        return v_dgtArea.getAllArea();
    }
    
    /**
     * Permite traer un elemento en especifico de la tabla area
     * @param idArea
     * @return 
     */
    @RequestMapping(value = "/areas/{area}", method = RequestMethod.GET)
    public DgtArea obtenerArea(@PathVariable("area") int idArea) {
        DgtAreaDao v_dgtArea = new DgtAreaDao();
        //v_dgtArea.deleteArea(idArea);
        return v_dgtArea.getArea(idArea);
    }
    
     /**
     * trae todos los elementos de la tabla auditoria
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/auditoria", method = RequestMethod.GET)
    public List<DgtAuditoriaTurno> listaAuditorias() throws Exception {
        DgtAuditoriaTurnoDao v_dgtauditoria = new DgtAuditoriaTurnoDao();       
        return v_dgtauditoria.getAllAuditoria();
    }
    
//    /**
//     * trae todos los elementos de la tabla auditoria
//     * @return
//     * @throws Exception 
//     */
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<DgtCliente> listaClientes() throws Exception {
        DgtClienteDao v_dgtcliente = new DgtClienteDao();       
        return v_dgtcliente.getAllCliente();
    }
        
   @RequestMapping(method = RequestMethod.POST, value = "/o")
    @ResponseBody public ResponseEntity<DgtArea> crearArea(@RequestBody DgtArea body) {
        DgtAreaDao v_dgtAreaDao = new DgtAreaDao();
        try {
            v_dgtAreaDao.adicionaOActualizaArea(body);
            return new ResponseEntity<DgtArea>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<DgtArea>(body, HttpStatus.BAD_REQUEST);
        }
    }
    
    
}

