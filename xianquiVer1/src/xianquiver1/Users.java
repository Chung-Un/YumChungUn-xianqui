/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author chung
 */
public class Users {
    Partidas[] partidasUsuario = new Partidas[100];
    String usuario, password;
    Logs[] logsUsuario = new Logs[100];
    Logs logUsuarioActual;
    Logs logsFinalesUsuario[] = new Logs[100];
    int puntos,partidasGanadas,partidasEmpatadas,partidasPerdidas;
    boolean activo;
    Calendar fecha;
    Date fechaIngreso;
    int numLogsUser,numLogsFinalesUser;

 
    public Users(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.puntos = 0;
        this.logUsuarioActual = new Logs("");
        this.partidasEmpatadas=0;
        this.partidasGanadas=0;
        this.partidasPerdidas=0;
        activo= true;
        fecha = Calendar.getInstance();
        fechaIngreso = fecha.getTime();
        this.numLogsUser=0;
        this.numLogsFinalesUser=0;
    }

   
    
    public Date getFechaIngreso() {
        return fechaIngreso;
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
