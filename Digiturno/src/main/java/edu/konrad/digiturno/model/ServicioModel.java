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
import javax.persistence.Transient;

/**
 *
 * @author Cristian Lopez
 */
@Entity
@Table(name = "DGT_SERVICIO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class ServicioModel {
     @Id
    @Column(name = "SEC_SERVICIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_servicio")
    @SequenceGenerator(name = "seq_servicio", sequenceName = "DTS_SERVICIO")
    private long seqServicio;

    @Column(name = "SERVICIO_ANTECESOR")
    private long servicioAntecesor;

    @Column(name = "NAM_SERVICIO")
    private String namServicio;
    
    @Column(name = "TIPO_SERVICIO")
    private long tipoServicio;

    public long getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(long tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
    
   
    
    

    public long getSeqServicio() {
        return seqServicio;
    }

    public void setSeqServicio(long seqServicio) {
        this.seqServicio = seqServicio;
    }

    public long getServicioAntecesor() {
        return servicioAntecesor;
    }

    public void setServicioAntecesor(long servicioAntecesor) {
        this.servicioAntecesor = servicioAntecesor;
    }

    public String getNamServicio() {
        return namServicio;
    }

    public void setNamServicio(String namServicio) {
        this.namServicio = namServicio;
    }

    @Override
    public String toString() {
        return "DgtServicio{" + "seqServicio=" + seqServicio + ", servicioAntecesor=" + servicioAntecesor + ", namServicio=" + namServicio + '}';
    }

    public ServicioModel(long seqServicio, int servicioAntecesor, String namServicio) {
        this.seqServicio = seqServicio;
        this.servicioAntecesor = servicioAntecesor;
        this.namServicio = namServicio;
    }

    public ServicioModel() {
    }
    
    
}
