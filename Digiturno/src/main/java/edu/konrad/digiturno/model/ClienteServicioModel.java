/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Cristian Lopez
 */
@Entity
@Table(name = "DGT_CLIENTE_SERVICIO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//very imp
public class ClienteServicioModel {

    @Id
    @Column(name = "SEC_CLIENTE_SERVICIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sec_cliente_servicio")
    @SequenceGenerator(name = "sec_cliente_servicio", sequenceName = "DTS_CLIENTE_SERVICIO")
    private int seqClienteServicio;
    
    @Column(name = "SEC_CLIENTE")
    private int secCliente;
    
    @Column(name = "SEC_SERVICIO")
    private int secServicio;

    public int getSeqClienteServicio() {
        return seqClienteServicio;
    }

    public void setSeqClienteServicio(int seqClienteServicio) {
        this.seqClienteServicio = seqClienteServicio;
    }

    public int getSecCliente() {
        return secCliente;
    }

    public void setSecCliente(int secCliente) {
        this.secCliente = secCliente;
    }

    public int getSecServicio() {
        return secServicio;
    }

    public void setSecServicio(int secServicio) {
        this.secServicio = secServicio;
    }

    public ClienteServicioModel(int seqClienteServicio, int secCliente, int secServicio) {
        this.seqClienteServicio = seqClienteServicio;
        this.secCliente = secCliente;
        this.secServicio = secServicio;
    }

    public ClienteServicioModel() {
    }

    @Override
    public String toString() {
        return "ClienteServicio{" + "seqClienteServicio=" + seqClienteServicio + ", secCliente=" + secCliente + ", secServicio=" + secServicio + '}';
    }
    
    
}
