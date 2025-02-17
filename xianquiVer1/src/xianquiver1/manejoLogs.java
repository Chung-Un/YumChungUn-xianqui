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
    int numLogs=0;
    
   
    @Override
    public void crear(Logs log) {
        if (numLogs>=logs.length){
            resize(logs);}
        else{
            logs[numLogs] = log;
            numLogs++;
        }
       
    }

    public static void agregarLog(Logs log, Users player){
        player.logsUsuario[player.numLogsUser] = log;
        player.numLogsUser++;
    }
    
    public static void agregarLogFinal(Logs log,Users player){
        player.logsFinalesUsuario[player.numLogsFinalesUser] = log;
        player.numLogsFinalesUser++;
    }
    

    @Override
    public void resize(Logs[] item) {
    Logs[] logsResized = new Logs[logs.length*2];
        System.arraycopy(logs, 0, logsResized, 0, logs.length);
        logs = logsResized;      }
    
   
    
}
