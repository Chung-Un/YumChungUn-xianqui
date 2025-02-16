/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import javax.swing.JList;
import javax.swing.JOptionPane;


/**
 *
 * @author chung
 */
public class manejoPlayers implements Almacenamiento<Users> {
static Users[] players  = new Users[100];
static int numJugadores=0;

    @Override
    public void crear(Users user) {
        if (numJugadores>=players.length){
            resize(players);}
        else{
            players[numJugadores] = user;
            System.out.println("usuario creado:" + user.usuario);
            numJugadores++;
        }
    }

    @Override
    public void borrar(Users user) {
        for (int index = 0; index < numJugadores; index++) {
            if (players[index] != null && players[index].usuario.equals(user.usuario)) {
                players[index] = players[numJugadores - 1];
                players[numJugadores - 1] = null;
                numJugadores--;
                System.out.println("jugador eliminado: " + user.usuario);
            break;
        }
    }
}
    
    public static Users buscarPlayerPorUsuario(String nombreUsuario){
        return buscarPlayerPorUsuario(nombreUsuario,0);
    }
    
    private static Users buscarPlayerPorUsuario(String nombreUsuario, int index){//funcion recursiva
        if(index>= numJugadores){
            return null;//caso base
        }
        if (players[index] != null && players[index].usuario.equals(nombreUsuario)) {
        System.out.println("usuario encontrado: " + nombreUsuario);
        return players[index]; 
    }

    return buscarPlayerPorUsuario(nombreUsuario, index + 1); 
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
       
       boolean passwordCorrecta = verificarPassword(player, password);
       return passwordCorrecta ? player : null; 
      
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
    
    public static void mostrarLogs(){
    StringBuilder logsTexto = new StringBuilder();
           for (int i = 0; i < XianquiVer1.player1.numLogsFinalesUser; i++) {
           logsTexto.append(XianquiVer1.player1.logsFinalesUsuario[i].toString()).append("\n");
           }
            JOptionPane.showMessageDialog(null, logsTexto.toString(), "Historial de Logs", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void jugadoresPorPuntos(int n) { //funcion recursiva
        if (n <= 1) {
            return; //caso base
        }

        jugadoresPorPuntos(n - 1);

        Users temp = players[n - 1];
        int j = n - 2;

        while (j >= 0 && players[j].puntos < temp.puntos) {
            players[j + 1] = players[j];
            j--;
        }
        players[j + 1] = temp;
    }

    public static void ranking(){
     jugadoresPorPuntos(numJugadores);
     StringBuilder ranking = new StringBuilder("Xianqui Ranking");
        for (int i = 0; i < numJugadores; i++) {
            String ind ="\n" + (i + 1) + ". " + players[i].usuario + " - Puntos: " + players[i].puntos;
            ranking.append(ind );
        }
        JOptionPane.showMessageDialog(null, ranking, "Ranking",JOptionPane.INFORMATION_MESSAGE);

    }
    
    

    @Override
    public void resize(Users[] item) {
    Users[] playersResized = new Users[players.length*2];
        System.arraycopy(players, 0, playersResized, 0, players.length);
        players = playersResized;   
    }
    

 
    
    
}

            