/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author chung
 */
public class Users {
   
    ArrayList<String> partidas = new ArrayList<>();
    String usuario, password;
    int puntos;
    boolean activo;
    LocalDate fechaIngreso; 
    
    public void Users(String usuario, String password){
    this.usuario = usuario;
    this.password = password;
    this.puntos = puntos=0;
    this.activo = activo = true;
    this.partidas = partidas = null;
    this.fechaIngreso = fechaIngreso = LocalDate.now();
    }   

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public ArrayList<String> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<String> partidas) {
        this.partidas = partidas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    


    
}
