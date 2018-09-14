/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Lopez
 */
@Entity
@Table(name = "DGT_CLIENTE")
public class DgtCliente {

    @Id
    @Column(name = "CLIENTE_CEDULA_PK")
    private Long clienteCedulaPk;

    @Column(name = "NAM_CLIENTE")
    private String namCliente;

    @Column(name = "APELLIDO_CLIENTE")
    private String apellidoCliente;

    @Column(name = "CORREO_CLIENTE")
    private String correoCliente;

    @Column(name = "CLAVE_CLIENTE")
    private String claveCliente;

    public Long getClienteCedulaPk() {
        return clienteCedulaPk;
    }

    public void setClienteCedulaPk(Long clienteCedulaPk) {
        this.clienteCedulaPk = clienteCedulaPk;
    }

    public String getNamCliente() {
        return namCliente;
    }

    public void setNamCliente(String namCliente) {
        this.namCliente = namCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(String claveCliente) {
        this.claveCliente = claveCliente;
    }

    @Override
    public String toString() {
        return "DgtCliente{" + "clienteCedulaPk=" + clienteCedulaPk + ", namCliente=" + namCliente + ", apellidoCliente=" + apellidoCliente + ", correoCliente=" + correoCliente + ", claveCliente=" + claveCliente + '}';
    }

    public DgtCliente() {
    }

}
