/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

/**
 *
 * @author chung
 */
public final class Partidas{
    Logs[] logsPartida = new Logs[100];
    Users player1,player2;
    Users ganador;
    Users perdedor;
    Boolean turno;
    
    public Partidas(Users player1, Users player2){
    this.player1 = player1;
    this.player2 = player2;
    logsPartida = logsPartida;
    ganador = ganador;
    perdedor = perdedor;
    turno = true; //turno rojo
    }

   
}
