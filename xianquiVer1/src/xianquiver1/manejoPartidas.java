/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

/**
 *
 * @author chung
 */
public class manejoPartidas implements Almacenamiento<Partidas>{
    
    static Partidas[] partidas =new Partidas[100];
    int numPartidas;

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
    
    
}
