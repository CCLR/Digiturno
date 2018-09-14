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
@Table(name = "DGT_TIPO_USUARIO")
public class DgtTipoUsuario {

    @Id
    @Column(name = "SEQ_TIPO_USUARIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tipo_usuario")
    @SequenceGenerator(name = "seq_tipo_usuario", sequenceName = "DTS_TIPO_USUARIO")
    private int seqTipoUsuario;

    @Column(name = "NAM_TIPO_USUARIO")
    private String namTipoUsuario;

    @Column(name = "PRIORIDAD")
    private String prioridad;

    public int getSeqTipoUsuario() {
        return seqTipoUsuario;
    }

    public void setSeqTipoUsuario(int seqTipoUsuario) {
        this.seqTipoUsuario = seqTipoUsuario;
    }

    public String getNamTipoUsuario() {
        return namTipoUsuario;
    }

    public void setNamTipoUsuario(String namTipoUsuario) {
        this.namTipoUsuario = namTipoUsuario;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "DgtTipoUsuario{" + "seqTipoUsuario=" + seqTipoUsuario + ", namTipoUsuario=" + namTipoUsuario + ", prioridad=" + prioridad + '}';
    }

}
