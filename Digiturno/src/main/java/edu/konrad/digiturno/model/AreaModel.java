



















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

/**
 *
 * @author Cristian Lopez
 */
@Entity
@Table(name = "DGT_AREA")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class AreaModel {
     @Id
    @Column(name = "SEC_AREA")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_area")
    @SequenceGenerator(name = "seq_area", sequenceName = "DTS_AREA")
    private long seqArea;

    @Column(name = "NAM_AREA")
    private String namArea;

    public long getSeqArea() {
        return seqArea;
    }

    public void setSeqArea(long seqArea) {
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

    public AreaModel(long seqArea, String namArea) {
        this.seqArea = seqArea;
        this.namArea = namArea;
    }

    public AreaModel() {
    }
    
    
}
