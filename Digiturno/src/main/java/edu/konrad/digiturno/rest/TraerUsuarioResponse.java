/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.digiturno.rest;

import edu.konrad.digiturno.rest.Turno;
import java.util.ArrayList;

public class TraerUsuarioResponse {

    private int identificacionUsuario;
    private String nombreUsuario;
    private ArrayList<String> rol;

    public TraerUsuarioResponse(Turno turnoBase) {
        setIdentificacionUsuario(turnoBase.getIdentificacion_usuario());
        setNombreUsuario(turnoBase.getNombre_usuario());
        setRol(turnoBase.getRol());
    }

    public int getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(int identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<String> getRol() {
        return rol;
    }

    public void setRol(ArrayList<String> rol) {
        this.rol = rol;
    }
}