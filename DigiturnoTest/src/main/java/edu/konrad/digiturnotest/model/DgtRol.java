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
@Table(name = "DGT_ROL")
public class DgtRol {

    @Id
    @Column(name = "SEQ_ROL")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_rol")
    @SequenceGenerator(name = "seq_rol", sequenceName = "DTS_ROL")
    private int seqRol;

    @Column(name = "NAM_ROL")
    private String namRol;

    public int getSeqRol() {
        return seqRol;
    }

    public void setSeqRol(int seqRol) {
        this.seqRol = seqRol;
    }

    public String getNamRol() {
        return namRol;
    }

    public void setNamRol(String namRol) {
        this.namRol = namRol;
    }

    @Override
    public String toString() {
        return "DgtRol{" + "seqRol=" + seqRol + ", namRol=" + namRol + '}';
    }

}
