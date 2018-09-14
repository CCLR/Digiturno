/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.model;

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
@Table(name = "DGT_SERVICIO")
public class DgtServicio {

    @Id
    @Column(name = "SEQ_SERVICIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_servicio")
    @SequenceGenerator(name = "seq_servicio", sequenceName = "DTS_SERVICIO")
    private int seqServicio;

    @Column(name = "SERVICIO_ANTECESOR")
    private int servicioAntecesor;

    @Column(name = "NAM_SERVICIO")
    private String namServicio;

    public int getSeqServicio() {
        return seqServicio;
    }

    public void setSeqServicio(int seqServicio) {
        this.seqServicio = seqServicio;
    }

    public int getServicioAntecesor() {
        return servicioAntecesor;
    }

    public void setServicioAntecesor(int servicioAntecesor) {
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

}
