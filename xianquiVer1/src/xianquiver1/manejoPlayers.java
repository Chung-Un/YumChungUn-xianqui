/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.util.*;

/**
 *
 * @author chung
 */
public class manejoPlayers implements Almacenamiento<Users> {
ArrayList<Users> listaPlayers;
    
    @Override
    public void crear(Users user) {
        listaPlayers.add(user);
    }

    @Override
    public void borrar(Users user) {
        listaPlayers.remove(user);
    }
    
}
