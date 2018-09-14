/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturnotest.model;

import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "DGT_TURNO")
public class DgtTurno {

    @Id
    @Basic(optional = false)
    @Column(name = "SEQ_TURNO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_turno")
    @SequenceGenerator(name = "seq_turno", sequenceName = "DTS_TURNO")
    private int seqTurno;

    @Column(name = "NUMERO_TURNO")
    private String numeroTurno;

    @Column(name = "HORA_SOLICITUD")
    private Date horaSolicitud;

    @Column(name = "HORA_ATENCION")
    private Date horaAtencion;

    @Column(name = "HORA_FINALIZACION")
    private Date horaFinalizacion;

    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "IDENTIFICACION_USUARIO")
    private Long identificacionUsuario;

    @Column(name = "PROGRAMA_USUARIO")
    private String programaUsuario;

    @Column(name = "FACULTAD_USUARIO")
    private String facultadUsuario;

    @Column(name = "SEMESTRE_ACTUAL_USUARIO")
    private String semestreActualUsuario;

    @Column(name = "SERVICIO_SELECCIONADO")
    private String servicioSeleccionado;

    @Column(name = "SEQ_AGENTE_SERVICIO_F1")
    private int seqAgenteServicioF1;

    @Column(name = "SEQ_TIPO_USUARIO_SERVICIO_F2")

    private DgtTipoUsuarioServicio seqTipoUsuarioServicioF2;

    public int getSeqTurno() {
        return seqTurno;
    }

    public void setSeqTurno(int seqTurno) {
        this.seqTurno = seqTurno;
    }

    public String getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(String numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public Date getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(Date horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public Date getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(Date horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public Date getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(Date horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(Long identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getProgramaUsuario() {
        return programaUsuario;
    }

    public void setProgramaUsuario(String programaUsuario) {
        this.programaUsuario = programaUsuario;
    }

    public String getFacultadUsuario() {
        return facultadUsuario;
    }

    public void setFacultadUsuario(String facultadUsuario) {
        this.facultadUsuario = facultadUsuario;
    }

    public String getSemestreActualUsuario() {
        return semestreActualUsuario;
    }

    public void setSemestreActualUsuario(String semestreActualUsuario) {
        this.semestreActualUsuario = semestreActualUsuario;
    }

    public String getServicioSeleccionado() {
        return servicioSeleccionado;
    }

    public void setServicioSeleccionado(String servicioSeleccionado) {
        this.servicioSeleccionado = servicioSeleccionado;
    }

    public int getSeqAgenteServicioF1() {
        return seqAgenteServicioF1;
    }

    public void setSeqAgenteServicioF1(int seqAgenteServicioF1) {
        this.seqAgenteServicioF1 = seqAgenteServicioF1;
    }

    public DgtTipoUsuarioServicio getSeqTipoUsuarioServicioF2() {
        return seqTipoUsuarioServicioF2;
    }

    public void setSeqTipoUsuarioServicioF2(DgtTipoUsuarioServicio seqTipoUsuarioServicioF2) {
        this.seqTipoUsuarioServicioF2 = seqTipoUsuarioServicioF2;
    }

    @Override
    public String toString() {
        return "DgtTurno{" + "seqTurno=" + seqTurno + ", numeroTurno=" + numeroTurno + ", horaSolicitud=" + horaSolicitud + ", horaAtencion=" + horaAtencion + ", horaFinalizacion=" + horaFinalizacion + ", nombreUsuario=" + nombreUsuario + ", identificacionUsuario=" + identificacionUsuario + ", programaUsuario=" + programaUsuario + ", facultadUsuario=" + facultadUsuario + ", semestreActualUsuario=" + semestreActualUsuario + ", servicioSeleccionado=" + servicioSeleccionado + ", seqAgenteServicioF1=" + seqAgenteServicioF1 + ", seqTipoUsuarioServicioF2=" + seqTipoUsuarioServicioF2 + '}';
    }

}
