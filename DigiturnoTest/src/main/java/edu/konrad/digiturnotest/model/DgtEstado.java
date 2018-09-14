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
@Table(name = "DGT_ESTADO")
public class DgtEstado {

    @Id
    @Column(name = "SEQ_ESTADO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_estado")
    @SequenceGenerator(name = "seq_estado", sequenceName = "DTS_ESTADO")
    private int seqEstado;

    @Column(name = "NAM_ESTADO")
    private String namEstado;

    @Column(name = "TIEMPO_MAXIMO_MINUTOS")
    private String tiempoMaximoMinutos;

    public int getSeqEstado() {
        return seqEstado;
    }

    public void setSeqEstado(int seqEstado) {
        this.seqEstado = seqEstado;
    }

    public String getNamEstado() {
        return namEstado;
    }

    public void setNamEstado(String namEstado) {
        this.namEstado = namEstado;
    }

    public String getTiempoMaximoMinutos() {
        return tiempoMaximoMinutos;
    }

    public void setTiempoMaximoMinutos(String tiempoMaximoMinutos) {
        this.tiempoMaximoMinutos = tiempoMaximoMinutos;
    }

    @Override
    public String toString() {
        return "DgtEstado{" + "seqEstado=" + seqEstado + ", namEstado=" + namEstado + ", tiempoMaximoMinutos=" + tiempoMaximoMinutos + '}';
    }

}
