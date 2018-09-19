package edu.konrad.digiturno.controllers;

import edu.konrad.digiturno.rest.Turno;
import edu.konrad.digiturno.rest.TraerUsuarioResponse;
import edu.konrad.digiturno.model.AreaModel;
import edu.konrad.digiturno.model.ClienteServicioModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.konrad.digiturno.model.MyCustomer;
import edu.konrad.digiturno.model.ServicioModel;
import edu.konrad.digiturno.service.AreaService;
import edu.konrad.digiturno.service.ClienteServicioService;
import edu.konrad.digiturno.service.CustomerService;
import edu.konrad.digiturno.service.ServicioService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
 

@CrossOrigin (origins="192.168.43.89:3000")
@RestController // combination of @Controller and @ResponseBody annotations
public class CRUDRestController {
    public static final String soapEndpointUrl = "http://serviciosweb.konradlorenz.edu.co:8080/ControlAcceso/servicesCxF/DigiTurnoDataNewPort";
public static final String soapAction = "urn:OnQueryData";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private ServicioService servicioService;
    
    /*@Autowired
    private Turno turno;
    */

    @Autowired
    private ClienteServicioService clienteServicioService;

    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    //setter for customerService
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
   
 @CrossOrigin 
@RequestMapping(method = RequestMethod.GET, value = "traerUsuario/{identificacion}")
@ResponseBody
public ResponseEntity<TraerUsuarioResponse> traerUsuario(@PathVariable String identificacion) {
    Turno x = new Turno();
    x.crearTurnoBase(identificacion);
    //turno.crearTurnoBase(identificacion);
    return new ResponseEntity<TraerUsuarioResponse>(new TraerUsuarioResponse(x), HttpStatus.OK);
}


    // Add Customer
    @RequestMapping(value = "/customer/new", method = RequestMethod.POST)
    public ResponseEntity<Void> addCustomer(@RequestBody MyCustomer customer, UriComponentsBuilder ucb) {
        if (customerService.isCustomerExist(customer)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {

            customerService.saveCustomer(customer);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    // Add Customer
    @RequestMapping(value = "/area/new", method = RequestMethod.POST)
    public ResponseEntity<Void> addArea(@RequestBody AreaModel area, UriComponentsBuilder ucb) {
        if (areaService.isAreaExist(area)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {

            areaService.saveArea(area);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucb.path("/area/{id}").buildAndExpand(area.getSeqArea()).toUri());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    // Add Customer
    @RequestMapping(value = "/servicio/new", method = RequestMethod.POST)
    public ResponseEntity<Void> addServicio(@RequestBody ServicioModel servicio, UriComponentsBuilder ucb) {
        if (servicioService.isServicioExist(servicio)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {

            servicioService.saveServicio(servicio);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucb.path("/servicio/{id}").buildAndExpand(servicio.getSeqServicio()).toUri());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    // Get Single Customer
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MyCustomer> getCustomer(@PathVariable("id") int id) {

        MyCustomer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MyCustomer>(customer, HttpStatus.OK);
    }

    // Get Single Customer
    @RequestMapping(value = "/area/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaModel> getArea(@PathVariable("id") long id) {

        AreaModel area = areaService.findById(id);
        if (area == null) {
            return new ResponseEntity<AreaModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AreaModel>(area, HttpStatus.OK);
    }

    // Get Single Customer
    @RequestMapping(value = "/servicio/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicioModel> getServicio(@PathVariable("id") long id) {

        ServicioModel servicio = servicioService.findById(id);
        System.out.println("Id;" + servicio);
        if (servicio == null) {
            return new ResponseEntity<ServicioModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ServicioModel>(servicio, HttpStatus.OK);
    }

    // Get All Customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<List<MyCustomer>> listAllCustomers() {        
        List<MyCustomer> customers = customerService.findAllCustomers();        
        if (customers.isEmpty()) {
            return new ResponseEntity<List<MyCustomer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MyCustomer>>(customers, HttpStatus.OK);
    }

     // Get All Customers
    @RequestMapping(value = "/clienteservicio", method = RequestMethod.GET)
    public ResponseEntity<List<ClienteServicioModel>> listAllClienteServicio() {
       
        List<ClienteServicioModel> clienteServicio = clienteServicioService.findAllServicio();        
        if (clienteServicio.isEmpty()) {
            return new ResponseEntity<List<ClienteServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ClienteServicioModel>>(clienteServicio, HttpStatus.OK);
    }
    
    
    // Get All Customers
    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public ResponseEntity<List<AreaModel>> listAllAreas() {
        List<AreaModel> areas = areaService.findAllArea();
        if (areas.isEmpty()) {
            return new ResponseEntity<List<AreaModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AreaModel>>(areas, HttpStatus.OK);
    }

    // Get All Customers
    @RequestMapping(value = "/servicio", method = RequestMethod.GET)
    public ResponseEntity<List<ServicioModel>> listAllServicios() {
        List<ServicioModel> servicio = servicioService.findAllServicio();
        if (servicio.isEmpty()) {
            return new ResponseEntity<List<ServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ServicioModel>>(servicio, HttpStatus.OK);
    }

    // Get All Customers
    @RequestMapping(value = "/servicios/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ServicioModel>> listAllServiciosXPadre(@PathVariable("id") int id) {
        List<ServicioModel> servicio = servicioService.findServiciosXPadre(id);
        if (servicio.isEmpty()) {
            return new ResponseEntity<List<ServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ServicioModel>>(servicio, HttpStatus.OK);
    }

    // Get All Customers
    @RequestMapping(value = "/servicios", method = RequestMethod.GET)
    public ResponseEntity<List<ServicioModel>> listAllServiciosPadre() {
        List<ServicioModel> servicio = servicioService.findServiciosPadre();
        if (servicio.isEmpty()) {
            return new ResponseEntity<List<ServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ServicioModel>>(servicio, HttpStatus.OK);
    }
    
    // Get All Customers
    @RequestMapping(value = "/serviciosP/{rol}", method = RequestMethod.GET)
    public ResponseEntity<List<ServicioModel>> listAllServiciosPadreXRol(@PathVariable("rol") String rol) {
        List<ServicioModel> servicio = servicioService.findServiciosPadreXRol(rol);
        if (servicio.isEmpty()) {
            return new ResponseEntity<List<ServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ServicioModel>>(servicio, HttpStatus.OK);
    }
    
    // Get All Customers
    @RequestMapping(value = "/serviciosSecA/{secA}", method = RequestMethod.GET)
    public ResponseEntity<List<ServicioModel>> listAllServiciosPadreXRol(@PathVariable("secA") int secA) {
        List<ServicioModel> servicio = servicioService.findServiciosPadreXSecAntecesor(secA);
        if (servicio.isEmpty()) {
            return new ResponseEntity<List<ServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ServicioModel>>(servicio, HttpStatus.OK);
    }
    
    // Get All Customers
    @RequestMapping(value = "/serviciosUltimo", method = RequestMethod.GET)
    public ResponseEntity<List<ServicioModel>> listAllServiciosXRol() {
        List<ServicioModel> servicio = servicioService.findServiciosXRol();
        if (servicio.isEmpty()) {
            return new ResponseEntity<List<ServicioModel>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ServicioModel>>(servicio, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/getjson", method = RequestMethod.GET)
@ResponseBody
public String getJson() {
    JSONObject json = new JSONObject();
     JSONObject subJson = new JSONObject();
    subJson .put("key", "value");
    json.put("key", subJson);
    return json.toString();
}

    // Update Customer
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MyCustomer> updateCustomer(@PathVariable("id") int id, @RequestBody MyCustomer cus) {

        MyCustomer customer = customerService.findById(id);

        if (customer == null) {
            return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
        }

        customer.setName(cus.getName());
        customer.setAge(cus.getAge());
        customer.setEmail(cus.getEmail());
        customer.setCity(cus.getCity());

        customerService.updateCustomer(customer);
        return new ResponseEntity<MyCustomer>(customer, HttpStatus.OK);
    }

    // Update Customer
    @RequestMapping(value = "/area/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AreaModel> updateArea(@PathVariable("id") int id, @RequestBody AreaModel are) {

        AreaModel area = areaService.findById(id);

        if (area == null) {
            return new ResponseEntity<AreaModel>(HttpStatus.NOT_FOUND);
        }

        area.setNamArea(are.getNamArea());

        areaService.updateArea(area);
        return new ResponseEntity<AreaModel>(area, HttpStatus.OK);
    }

    // Delete Customer
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MyCustomer> deleteCustomer(@PathVariable("id") long id) {

        MyCustomer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
        }

        customerService.deleteCustomerById(id);
        return new ResponseEntity<MyCustomer>(HttpStatus.NO_CONTENT);
    }

    // Delete Customer
    @RequestMapping(value = "/area/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AreaModel> deleteArea(@PathVariable("id") long id) {

        AreaModel area = areaService.findById(id);
        if (area == null) {
            return new ResponseEntity<AreaModel>(HttpStatus.NOT_FOUND);
        }

        areaService.deleteAreaById(id);
        return new ResponseEntity<AreaModel>(HttpStatus.NO_CONTENT);
    }

    // Delete All Customers
    @RequestMapping(value = "/customer/deleteall", method = RequestMethod.DELETE)
    public ResponseEntity<MyCustomer> deleteAllCustomers() {

        customerService.deleteAllCustomers();
        return new ResponseEntity<MyCustomer>(HttpStatus.NO_CONTENT);
    }

    // Delete All Customers
    @RequestMapping(value = "/areas/deleteall", method = RequestMethod.DELETE)
    public ResponseEntity<AreaModel> deleteAllAreas() {
        customerService.deleteAllCustomers();
        return new ResponseEntity<AreaModel>(HttpStatus.NO_CONTENT);
    }

}
