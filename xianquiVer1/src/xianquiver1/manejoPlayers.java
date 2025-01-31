/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;


/**
 *
 * @author chung
 */
public class manejoPlayers implements Almacenamiento<Users> {
Users[] players  = new Users[100];
int numJugadores=0;

    @Override
    public void crear(Users user) {
        if (numJugadores>=players.length){
            resize();}
        else{
            players[numJugadores++] = user;
        }
    }

    @Override
    public void borrar(Users user) {
        for(int index=0; index< players.length; index++){
            if(players[index]!= null && players[index].usuario.equals(user.usuario)){
                players[index] = players[numJugadores-1];
                numJugadores--;
                break;
            }
        }
    }
    
    public void resize(){
        Users[] playersResized = new Users[players.length*2];
        System.arraycopy(players, 0, playersResized, 0, players.length);
        players = playersResized;
    }
    
    public Users buscarPlayerPorUsuario(String nombreUsuario){
        for (int index=0; index< players.length; index++){
            if(players[index]!=null && players[index].usuario.equals(nombreUsuario) ){
            return players[index];
            }
        }
        return null;
    }
    
}
