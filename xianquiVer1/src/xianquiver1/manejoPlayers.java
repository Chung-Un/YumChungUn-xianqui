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
    
    public boolean loginPosible(){
    
        if (players[0] == null){
           JOptionPane.showMessageDialog(null,"Aun no existen usuarios, no es posible hacer LogIn", "Error", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        else{
        return true;
        }
    
    }
    public boolean verificarLogin(String usuario, String password){
       Users player = buscarPlayerPorUsuario(usuario);
       
       if (player == null){
            JOptionPane.showMessageDialog(null, "Usuario no existe, intente de nuevo.","Error",JOptionPane.ERROR_MESSAGE);
       return false;
       }
       else{
           boolean passwordCorrecta = verificarPassword(player,password);
           if(passwordCorrecta){
               JOptionPane.showMessageDialog(null, "Bienvenido " + player.usuario, "Bienvenido", JOptionPane.PLAIN_MESSAGE);
               return true;
           }
           else{
               JOptionPane.showMessageDialog(null, "Password Incorrecta, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
               return false;
           }
      }
      }  
    
    public boolean verificarLongitudPassword(String password){
    
        if (password.length() == 5 ){
        return true;
        }
        else{
        JOptionPane.showMessageDialog(null, "Password no cumple con la restriccion de caracteres (5), intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }      
    }
    
    public boolean verificarPassword( Users user,String password){
    
        if(user.password.equals(password)){
        return true;
        }
        else{
        return false;
        }
    }
    public Users verificarCrearPlayer(String usuario, String password){
        Users player = buscarPlayerPorUsuario(usuario);
        
        if (player == null){
            boolean passwordValida = verificarLongitudPassword(password);
                if(passwordValida){
                player = new Users(usuario,password);
                crear(player);
                return player;
                }
                else{
                return null;
                }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario ya existe, intente de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public String mostrarInformacion(Users player){
        String informacion = "Nombre de usuario: " + player.usuario + "\nPuntos: " + player.puntos + "\nFecha de ingreso: " + player.fechaIngreso 
           + "Partidas ganadas: " + String.valueOf(player.partidasGanadas) + "Partidas perdidas: " + String.valueOf(player.partidasPerdidas) + "Partidas empatadas: "+
                String.valueOf(player.partidasEmpatadas);
        
        return informacion;
    }
    
    public void cambiarPassword (Users player, String passwordVieja, String passwordNueva){
    
        if(verificarPassword(player,passwordVieja) && verificarLongitudPassword(passwordNueva)){
        player.setPassword(passwordNueva);
        JOptionPane.showMessageDialog(null, "Password cambiada exitosamente", "Exito", JOptionPane.PLAIN_MESSAGE);
        }
        else if(!verificarPassword(player,passwordVieja)){
        JOptionPane.showMessageDialog(null, "Password actual incorrecta, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }

    public void eliminarCuenta(Users player){
    int confirmacion= JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar su cuenta?", "Confirmacion", JOptionPane.YES_NO_OPTION );
    
    switch(confirmacion){
    
        case JOptionPane.YES_OPTION:
                String password = JOptionPane.showInputDialog("Ingrese su password actual: ");
                
                if(verificarPassword(player,password)){
                    
                }

    }
    }
}

            