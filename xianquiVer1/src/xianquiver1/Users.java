/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.time.LocalDate;

/**
 *
 * @author chung
 */
public class Users {
    Logs[] logsUsuario = new Logs[100];
    Partidas[] partidasUsuario = new Partidas[100];
    String usuario, password;
    int puntos,partidasGanadas,partidasEmpatadas,partidasPerdidas;
    boolean activo;
    LocalDate fechaIngreso; 
 
    public Users(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.puntos = 0;
        this.partidasUsuario = partidasUsuario;
        this.logsUsuario = logsUsuario;
        this.partidasEmpatadas=0;
        this.partidasGanadas=0;
        this.partidasPerdidas=0;
        this.activo = activo = true;
        this.fechaIngreso = LocalDate.now();
    }

   
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
