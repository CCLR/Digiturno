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
@Table(name = "DGT_CLIENTE_SERVICIO")
public class DgtClienteServicio {

    @Id
    @Column(name = "SEQ_CLIENTE_SERVICIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cliente_servicio")
    @SequenceGenerator(name = "seq_cliente_servicio", sequenceName = "DTS_CLIENTE_SERVICIO")
    private int seqClienteServicio;

    @Column(name = "SEQ_CLIENTE_F1")
    private int seqClienteF1;

    @Column(name = "SEQ_SERVICIO_F2")
    private int seqServicioF2;

    public int getSeqClienteServicio() {
        return seqClienteServicio;
    }

    public void setSeqClienteServicio(int seqClienteServicio) {
        this.seqClienteServicio = seqClienteServicio;
    }

    public int getSeqClienteF1() {
        return seqClienteF1;
    }

    public void setSeqClienteF1(int seqClienteF1) {
        this.seqClienteF1 = seqClienteF1;
    }

    public int getSeqServicioF2() {
        return seqServicioF2;
    }

    public void setSeqServicioF2(int seqServicioF2) {
        this.seqServicioF2 = seqServicioF2;
    }

    @Override
    public String toString() {
        return "DgtClienteServicio{" + "seqClienteServicio=" + seqClienteServicio + ", seqClienteF1=" + seqClienteF1 + ", seqServicioF2=" + seqServicioF2 + '}';
    }

}
