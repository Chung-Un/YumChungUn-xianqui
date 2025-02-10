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
static Users[] players  = new Users[100];
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
        for (int index = 0; index < numJugadores; index++) {
            if (players[index] != null && players[index].usuario.equals(user.usuario)) {
                players[index] = players[numJugadores - 1];
                players[numJugadores - 1] = null;
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
    
    public static Users buscarPlayerPorUsuario(String nombreUsuario){
        for (int index=0; index< players.length; index++){
            if(players[index]!=null && players[index].usuario.equals(nombreUsuario) ){
            return players[index];
            }
        }
        return null;
    }
    
    public static  boolean loginPosible(){
    
        if (players[0] == null){
           JOptionPane.showMessageDialog(null,"Aun no existen usuarios, no es posible hacer LogIn", "Error", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        else{
        return true;
        }
    
    }
    public Users verificarLogin(String usuario, String password){
       Users player = buscarPlayerPorUsuario(usuario);
       
       if (player == null){
       return null;
       }
       else{
           boolean passwordCorrecta = verificarPassword(player,password);
           if(passwordCorrecta){
               JOptionPane.showMessageDialog(null, "Bienvenido " + player.usuario, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
               return player;
           }
           else{
               JOptionPane.showMessageDialog(null, "Password Incorrecta, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
               return null;
           }
      }
      }  
    
    public static boolean verificarLongitudPassword(String password){
    
        if (password.length() == 5 ){
        return true;
        }
        else{
        
        return false;
        }      
    }
    
    public static boolean verificarPassword( Users user,String password){
    
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
            if(passwordValida == true){
                player = new Users(usuario,password);
                crear(player);
                return player;
            }
            else if (passwordValida== false){
                player = new Users("FALSOFALSO", "FALSOFALSO");
                return player;
            }
            
        }
        else{
            return player;
        }
    return player;
    }
    
    public static void mostrarInformacion(Users player){
        JOptionPane.showMessageDialog(null, "Nombre de usuario: " + player.usuario + "\nPuntos: " + player.puntos + "\nFecha de ingreso: " + player.fechaIngreso 
           + "\nPartidas ganadas: " + String.valueOf(player.partidasGanadas) + "\nPartidas perdidas: " + String.valueOf(player.partidasPerdidas) + "\nPartidas empatadas: "+
                String.valueOf(player.partidasEmpatadas));
        
    }
    
    public static void cambiarPassword (Users player, String passwordVieja, String passwordNueva){
    
        if(verificarPassword(player,passwordVieja) && verificarLongitudPassword(passwordNueva)){
        player.setPassword(passwordNueva);
        JOptionPane.showMessageDialog(null, "Password cambiada exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!verificarPassword(player,passwordVieja)){
        JOptionPane.showMessageDialog(null, "Password actual incorrecta, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(passwordVieja.equals(passwordNueva)){
        JOptionPane.showMessageDialog(null,"Password nueva y antigua no pueden ser las mismas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }

    public void eliminarCuenta(Users player){
    int confirmacion= JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar su cuenta?", "Confirmacion", JOptionPane.YES_NO_OPTION );
    
    
    
       if(confirmacion == JOptionPane.YES_OPTION){
                String password = JOptionPane.showInputDialog("Ingrese su password actual: ");
                
                if(verificarPassword(player,password)){
                    borrar(player);
                    JOptionPane.showMessageDialog(null, "Cuenta borrada con exito", "Cuenta eliminada", JOptionPane.INFORMATION_MESSAGE);
                }
                }
        
    }
    
    public static void ranking(){}
    
    public static void agregarLog(Logs log, Users player){
        for (int index=0; index<player.logsUsuario.length;index++){
            if (player.logsUsuario[index] ==null){
            player.logsUsuario[index] = log;
            break;
            }
            
        }
    }
    
    private void resizeLogsUsuario(Users user) {
        Logs[] logs = new Logs[user.logsUsuario.length * 2];
        System.arraycopy(user.logsUsuario, 0, logs, 0, user.logsUsuario.length);
        user.logsUsuario = logs;
}
    
    
}

            