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
@Table(name = "DGT_TIPO_USUARIO_SERVICIO")
public class DgtTipoUsuarioServicio {

    @Id
    @Column(name = "SEQ_TIPO_USUARIO_SERVICIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tipo_usuario_servicio")
    @SequenceGenerator(name = "seq_tipo_usuario_servicio", sequenceName = "DTS_TIPO_USUARIO_SERVICIO")
    private int seqTipoUsuarioServicio;

    @Column(name = "SEQ_SERVICIO_F1")
    private int seqServicioF1;

    @Column(name = "SEQ_TIPO_USUARIO_F2")
    private int seqTipoUsuarioF2;

    public int getSeqTipoUsuarioServicio() {
        return seqTipoUsuarioServicio;
    }

    public void setSeqTipoUsuarioServicio(int seqTipoUsuarioServicio) {
        this.seqTipoUsuarioServicio = seqTipoUsuarioServicio;
    }

    public int getSeqServicioF1() {
        return seqServicioF1;
    }

    public void setSeqServicioF1(int seqServicioF1) {
        this.seqServicioF1 = seqServicioF1;
    }

    public int getSeqTipoUsuarioF2() {
        return seqTipoUsuarioF2;
    }

    public void setSeqTipoUsuarioF2(int seqTipoUsuarioF2) {
        this.seqTipoUsuarioF2 = seqTipoUsuarioF2;
    }

    @Override
    public String toString() {
        return "DgtTipoUsuarioServicio{" + "seqTipoUsuarioServicio=" + seqTipoUsuarioServicio + ", seqServicioF1=" + seqServicioF1 + ", seqTipoUsuarioF2=" + seqTipoUsuarioF2 + '}';
    }

}
