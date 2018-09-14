/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Cristian Lopez
 */
@Entity
@Table(name = "DGT_AUDITORIA_TURNO")
public class DgtAuditoriaTurno {

    @Column(name = "NUMERO_TURNO")
    
    private int numeroTurno;
    @Id
    @Column(name = "HORA_AUDITORIA")    
    private Date horaAuditoria;

    @Column(name = "SEQ_AGENTE")
    private int seqAgente;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public Date getHoraAuditoria() {
        return horaAuditoria;
    }

    public void setHoraAuditoria(Date horaAuditoria) {
        this.horaAuditoria = horaAuditoria;
    }

    public int getSeqAgente() {
        return seqAgente;
    }

    public void setSeqAgente(int seqAgente) {
        this.seqAgente = seqAgente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "DgtAuditoriaTurno{" + "numeroTurno=" + numeroTurno + ", horaAuditoria=" + horaAuditoria + ", seqAgente=" + seqAgente + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }

}
