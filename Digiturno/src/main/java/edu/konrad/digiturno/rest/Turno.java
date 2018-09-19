/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.rest;

import edu.konrad.digiturno.controllers.CRUDRestController;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service("Turno")
public class Turno implements Comparable<Turno> {

    private String facultad;
    private int seq_turno;
    private String numero_turno;
    private Date hora_solicitud;
    private Date hora_atencion;
    private Date hora_finalizacion;
    private String nombre_usuario;
    private int identificacion_usuario;
    private String programa_usuario;
    private String genero;
    private String semestre;
    private ArrayList<String>rol = new ArrayList<>();
    private String facultad_usuario;
    private String semestre_actual_usuario;
    private String servicio_seleccionado;
    private Date hora_priorizada;
    private String rolSeleccionado;

    public String getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(String rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getSeq_turno() {
        return seq_turno;
    }

    public void setSeq_turno(int seq_turno) {
        this.seq_turno = seq_turno;
    }

    public String getNumero_turno() {
        return numero_turno;
    }

    public void setNumero_turno(String numero_turno) {
        this.numero_turno = numero_turno;
    }

    public Date getHora_solicitud() {
        return hora_solicitud;
    }

    public void setHora_solicitud(Date hora_solicitud) {
        this.hora_solicitud = hora_solicitud;
    }

    public Date getHora_atencion() {
        return hora_atencion;
    }

    public void setHora_atencion(Date hora_atencion) {
        this.hora_atencion = hora_atencion;
    }

    public Date getHora_finalizacion() {
        return hora_finalizacion;
    }

    public void setHora_finalizacion(Date hora_finalizacion) {
        this.hora_finalizacion = hora_finalizacion;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getIdentificacion_usuario() {
        return identificacion_usuario;
    }

    public void setIdentificacion_usuario(int identificacion_usuario) {
        this.identificacion_usuario = identificacion_usuario;
    }

    public String getPrograma_usuario() {
        return programa_usuario;
    }

    public void setPrograma_usuario(String programa_usuario) {
        this.programa_usuario = programa_usuario;
    }

    public String getFacultad_usuario() {
        return facultad_usuario;
    }

    public void setFacultad_usuario(String facultad_usuario) {
        this.facultad_usuario = facultad_usuario;
    }

    public String getSemestre_actual_usuario() {
        return semestre_actual_usuario;
    }

    public void setSemestre_actual_usuario(String semestre_actual_usuario) {
        this.semestre_actual_usuario = semestre_actual_usuario;
    }

    public String getServicio_seleccionado() {
        return servicio_seleccionado;
    }

    public void setServicio_seleccionado(String servicio_seleccionado) {
        this.servicio_seleccionado = servicio_seleccionado;
    }

    public Date getHora_priorizada() {
        return hora_priorizada;
    }

    public void setHora_priorizada(Date hora_priorizada) {
        this.hora_priorizada = hora_priorizada;
    }

    public void crearTurnoBase(String identificacionUsuario) {
        this.setIdentificacion_usuario(Integer.valueOf(identificacionUsuario));
        callSoapWebService(CRUDRestController.soapEndpointUrl, CRUDRestController.soapAction);
    }

    public void setPriorizada() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.hora_solicitud);
        if (this.rolSeleccionado.equalsIgnoreCase("Estudiante")) {
            cal.add(Calendar.MINUTE, -5);
            this.hora_priorizada = cal.getTime();
        } else {
            if (this.rolSeleccionado.equalsIgnoreCase("Externo")) {
                this.hora_priorizada = cal.getTime();
            } else {
                //Funcionario
                cal.add(Calendar.MINUTE, -10);
                this.hora_priorizada = cal.getTime();
            }
        }
    }

    @Override
    public int compareTo(Turno turno) {
        return this.hora_priorizada.compareTo(turno.getHora_priorizada());
    }

    private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String myNamespace = "ws";
        String myNamespaceURI = "http://ws.iceberg_ca.konrad.com/";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("ws:onQueryData");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg0");
        //soapBodyElem1.addTextNode("506142044");
        soapBodyElem1.addTextNode(String.valueOf(getIdentificacion_usuario()));

    }

    private void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);
            // Print the SOAP Response
            //System.out.println("Response SOAP Message:");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            soapResponse.writeTo(baos);
            String x = baos.toString();
            //System.err.println(x);
            JSONObject xmlJSONObj = XML.toJSONObject(x);
            asignarDatosServicio(xmlJSONObj);
            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getRol() {
        return rol;
    }

    public void setRol(ArrayList<String> rol) {
        this.rol = rol;
    }

    private void asignarDatosServicio(JSONObject xmlJSONObj) {
        String jsonPrettyPrintString = xmlJSONObj.toString(5);
        //System.out.println(jsonPrettyPrintString);

        //Estudiante
        /*String nombre=xmlJSONObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body")
                .getJSONObject("ns2:onQueryDataResponse").getJSONObject("return").getString("nombreRazonSocial");
        nombre+= " " +xmlJSONObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body")
                .getJSONObject("ns2:onQueryDataResponse").getJSONObject("return").getString("primerApellido");
        nombre+= " " +xmlJSONObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body")
                .getJSONObject("ns2:onQueryDataResponse").getJSONObject("return").getString("segundoApellido");
*/

        Boolean externo = !xmlJSONObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body")
                .getJSONObject("ns2:onQueryDataResponse").has("return");
        if (externo == false) {
            Object datosJson = xmlJSONObj.getJSONObject("soap:Envelope").getJSONObject("soap:Body")
                    .getJSONObject("ns2:onQueryDataResponse").get("return");
            if (datosJson instanceof JSONArray) {
                JSONArray datosJsonArray = (JSONArray) datosJson;
                JSONObject datosIniciales = datosJsonArray.getJSONObject(0);
                String nombre = datosIniciales.getString("nombreRazonSocial");
                nombre += " " + datosIniciales.getString("primerApellido");
                nombre += " " + datosIniciales.getString("segundoApellido");
                this.setNombre_usuario(nombre);

                for (int x =0; x<datosJsonArray.length(); x++){
                    datosIniciales = datosJsonArray.getJSONObject(x);
                    this.rol.add(datosIniciales.getString("tipoUsuario"));
                }
                //this.setGenero(datosIniciales.getString("sexo"));
            } else if (datosJson instanceof JSONObject) {
                JSONObject datosObject = (JSONObject) datosJson;

                String nombre = datosObject.getString("nombreRazonSocial");
                nombre += " " + datosObject.getString("primerApellido");
                nombre += " " + datosObject.getString("segundoApellido");
                this.setNombre_usuario(nombre);

                this.rol.add(datosObject.getString("tipoUsuario"));

                //this.setGenero(((JSONObject) datosJson).getString("sexo"));
            }
        } else {
            this.setNombre_usuario("Invitado");
            this.rol.add("EXTERNO");
        }
    }

    private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        createSoapEnvelope(soapMessage);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        soapMessage.saveChanges();
        /* Print the request message, just for debugging purposes */
        //System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        //System.out.println("\n");
        return soapMessage;
    }


}
