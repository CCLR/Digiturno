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
@Table(name = "DGT_CLIENTE_ROL")
public class DgtClienteRol {

    @Id
    @Column(name = "SEQ_CLIENTE_ROL")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cliente_rol")
    @SequenceGenerator(name = "seq_cliente_rol", sequenceName = "DTS_CLIENTE_ROL")
    private int seqClienteRol;

    @Column(name = "MODULO_ATENCION")
    private String moduloAtencion;

    @Column(name = "SEQ_AREA_F3")
    private int seqAreaF3;

    @Column(name = "CLIENTE_CEDULA_F1")
    private Long clienteCedulaF1;

    @Column(name = "SEQ_ESTADO_F4")
    private int seqEstadoF4;

    @Column(name = "SEQ_ROL_F2")
    private int seqRolF2;

    public int getSeqClienteRol() {
        return seqClienteRol;
    }

    public void setSeqClienteRol(int seqClienteRol) {
        this.seqClienteRol = seqClienteRol;
    }

    public String getModuloAtencion() {
        return moduloAtencion;
    }

    public void setModuloAtencion(String moduloAtencion) {
        this.moduloAtencion = moduloAtencion;
    }

    public int getSeqAreaF3() {
        return seqAreaF3;
    }

    public void setSeqAreaF3(int seqAreaF3) {
        this.seqAreaF3 = seqAreaF3;
    }

    public Long getClienteCedulaF1() {
        return clienteCedulaF1;
    }

    public void setClienteCedulaF1(Long clienteCedulaF1) {
        this.clienteCedulaF1 = clienteCedulaF1;
    }

    public int getSeqEstadoF4() {
        return seqEstadoF4;
    }

    public void setSeqEstadoF4(int seqEstadoF4) {
        this.seqEstadoF4 = seqEstadoF4;
    }

    public int getSeqRolF2() {
        return seqRolF2;
    }

    public void setSeqRolF2(int seqRolF2) {
        this.seqRolF2 = seqRolF2;
    }

    @Override
    public String toString() {
        return "DgtClienteRol{" + "seqClienteRol=" + seqClienteRol + ", moduloAtencion=" + moduloAtencion + ", seqAreaF3=" + seqAreaF3 + ", clienteCedulaF1=" + clienteCedulaF1 + ", seqEstadoF4=" + seqEstadoF4 + ", seqRolF2=" + seqRolF2 + '}';
    }

}
