/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

/**
 *
 * @author chung
 */
public class manejoLogs implements Almacenamiento<Logs>{
    static Logs[] logs = new Logs[100];
    
    public void resize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crear(Logs log) {
//        [numJugadores] = user;
//            System.out.println("usuario creado:" + user.usuario);
//            numJugadores++;
    }

    public static void agregarLog(Logs log, Users player){
        player.logsUsuario[player.numLogsUser] = log;
        System.out.println("log agregado");
        player.numLogsUser++;
    }
    @Override
    public void borrar(Logs item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resize(Logs[] item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
