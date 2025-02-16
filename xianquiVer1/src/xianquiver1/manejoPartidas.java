/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import javax.swing.JOptionPane;

/**
 *
 * @author chung
 */
public class manejoPartidas implements Almacenamiento<Partidas>{
    static Partidas[] partidas =new Partidas[100];
    int numPartidas;
    Users playerGanador;

    static Gui gui = new Gui();
    
    @Override
    public void crear(Partidas partidaActual) {
       if (numPartidas > partidas.length){
       resize();
       }
       else{
       partidas[numPartidas++] = partidaActual;
       }
    }

    @Override
    public void borrar(Partidas partidas) {
    }

    public void resize() {
        Partidas[] partidasResized= new Partidas[partidas.length*2];
        System.arraycopy(partidas, 0, partidasResized, 0, partidas.length);
        partidas= partidasResized;
    }

    @Override
    public void resize(Partidas[] item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void cambiarTurnos(Partidas partidaActual){
        if(partidaActual.turno == true){
            partidaActual.turno =false;
            Tablero.labelTurnos.setText("Turno de: " + XianquiVer1.player2.usuario);
        }
        else{
            partidaActual.turno = true;
            Tablero.labelTurnos.setText("Turno de: " + XianquiVer1.player1.usuario);
        }
    }
    
    public static Users getPlayerEnTurno(){
        if(XianquiVer1.partidaActual.turno ==true){
            return XianquiVer1.player1;
        }
        else{
            return XianquiVer1.player2;
        }
    }
    
    public static Users getPlayerNoEnTurno (){
        if(XianquiVer1.partidaActual.turno ==true){
            return XianquiVer1.player2;
        }
        else{
            return XianquiVer1.player1;
        }
        
    }
    
    public static boolean ganar(Pieza pieza, Pieza piezaComida){
        boolean ganar = piezaComida.getTipoPieza().equals("general");
        Users playerEnTurno = manejoPartidas.getPlayerEnTurno();
        Users playerNoEnTurno = manejoPartidas.getPlayerNoEnTurno();
        
        if(ganar){
            JOptionPane.showMessageDialog(null, playerEnTurno.usuario +  " VENCIO A " + playerNoEnTurno.usuario + " FELICIDADES HAS GANADO 3 PUNTOS!!!",
                    "**Fin de Partida**", JOptionPane.INFORMATION_MESSAGE);
            playerEnTurno.logUsuarioActual.log = "->" + playerEnTurno.usuario + " ha ganado porque su " + pieza.getTipoPieza() + " se comio al general de " + 
            playerNoEnTurno.usuario;
            manejoLogs.agregarLogFinal(playerEnTurno.logUsuarioActual, playerEnTurno);
            
            playerNoEnTurno.logUsuarioActual.log = "->" + playerNoEnTurno.usuario + " ha sido vencido porque " + playerEnTurno.usuario + " se comio su general ";
            manejoLogs.agregarLogFinal(playerNoEnTurno.logUsuarioActual, playerNoEnTurno);
            
            if(playerEnTurno.usuario.equals(XianquiVer1.player1.usuario)){
            manejoLogs.agregarLog(playerEnTurno.logUsuarioActual, XianquiVer1.player1);
            XianquiVer1.player1.puntos+= 3;
            XianquiVer1.player1.partidasGanadas+=1;
            
            XianquiVer1.player2.partidasPerdidas+=1;
            }
            else{
            manejoLogs.agregarLog(playerEnTurno.logUsuarioActual, XianquiVer1.player2);
            XianquiVer1.player2.puntos+= 3;
            XianquiVer1.player2.partidasGanadas+=1;
            
            XianquiVer1.player1.partidasPerdidas+=1;
            XianquiVer1.player2=null;
            }
        }
        return ganar;
    }
 
    public static void retirar(){
        Users playerEnTurno = manejoPartidas.getPlayerEnTurno();
        Users playerNoEnTurno = manejoPartidas.getPlayerNoEnTurno();
        
        JOptionPane.showMessageDialog(null, playerEnTurno.usuario +  " SE HA RETIRADO, FELICIDADES " + playerNoEnTurno.usuario + " HAS GANADO 3 PUNTOS!!!",
                    "**Fin de Partida**", JOptionPane.INFORMATION_MESSAGE);
        
        playerEnTurno.logUsuarioActual.log = "->" + playerEnTurno.usuario + " ha perdido contra " + playerNoEnTurno.usuario + " al retirarse";
        manejoLogs.agregarLogFinal(playerEnTurno.logUsuarioActual, playerEnTurno);
        playerEnTurno.partidasPerdidas+=1;

        playerNoEnTurno.logUsuarioActual.log = "->" + playerNoEnTurno.usuario + " ha ganado porque " + playerEnTurno.usuario + " se retiro de la partida ";
        manejoLogs.agregarLogFinal(playerNoEnTurno.logUsuarioActual, playerNoEnTurno);
        playerNoEnTurno.partidasGanadas+=1;
        playerNoEnTurno.puntos+=3;
        
        XianquiVer1.player2 =null;
        
        Tablero.panelContenedor.removeAll();
        Tablero.panelGestionJuego.removeAll();
        Tablero.panelJuego.removeAll();
        Tablero.panelLetras.removeAll();
        Tablero.panelNumeros.removeAll();
        Tablero.panelTablero.removeAll();
        Tablero.frameTablero.setVisible(false);
        gui.menuPrincipal();
        Gui.panelPrincipal.setVisible(true);
            
    }
    }
    

