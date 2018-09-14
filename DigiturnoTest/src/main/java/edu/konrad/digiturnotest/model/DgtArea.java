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
@Table(name = "DGT_AREA")
public class DgtArea {

    @Id
    @Column(name = "SEQ_AREA")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_area")
    @SequenceGenerator(name = "seq_area", sequenceName = "DTS_AREA")
    private int seqArea;

    @Column(name = "NAM_AREA")
    private String namArea;

    public int getSeqArea() {
        return seqArea;
    }

    public void setSeqArea(int seqArea) {
        this.seqArea = seqArea;
    }

    public String getNamArea() {
        return namArea;
    }

    public void setNamArea(String namArea) {
        this.namArea = namArea;
    }

    @Override
    public String toString() {
        return "{" + seqArea + ", " + namArea + '}';
    }
    

}
