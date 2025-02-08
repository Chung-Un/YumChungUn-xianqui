/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tablero {
 
    
public static void mostrarTablero(){

    frameTablero.setTitle("Xianqui - Partida");
    frameTablero.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frameTablero.setSize(1000,800);
    frameTablero.setLocationRelativeTo(null);
    
    panelJuego.setLayout(new BorderLayout());
    frameTablero.add(panelJuego);
    
    panelContenedor.setLayout(new BorderLayout());
    panelContenedor.setBackground(Color.WHITE);
    
    panelLetras.setLayout(new GridLayout(1,10));
    panelLetras.setPreferredSize(new Dimension(700,30));
    panelLetras.add(new JLabel(" "));
    
    agregarLetras();
    
    panelNumeros.setLayout(new GridLayout(10,1));
    panelNumeros.setPreferredSize(new Dimension(30,800));
    
    agregarNumeros();
    
    panelTablero.setBackground(new Color(249, 203, 67));
    panelTablero.setSize(700,800);
    panelTablero.setLayout(new GridLayout(11,9));
    hacerBotones();
    
    panelContenedor.add(panelTablero,BorderLayout.CENTER);
    panelContenedor.add(panelNumeros,BorderLayout.WEST);
    panelContenedor.add(panelLetras,BorderLayout.NORTH);
    
    panelJuego.add(panelContenedor,BorderLayout.CENTER);
    
    panelGestionJuego.setBackground(new Color(229, 32, 32));
    panelGestionJuego.setPreferredSize(new Dimension (300,800));
    panelGestionJuego.setLayout(new GridLayout(7,1));
    panelJuego.add(panelGestionJuego,BorderLayout.EAST);
    
    labelTitulo = funcionesGUI.hacerLabelTitulo(labelTitulo, "Xianqui");
    labelTitulo.setForeground(new Color(249, 203, 67));
    panelGestionJuego.add(labelTitulo);
    
    labelTurnos = funcionesGUI.hacerLabel(labelTurnos, "Turno de: ");
    labelTurnos.setHorizontalAlignment(JLabel.CENTER);
    labelTurnos.setForeground(new Color(249, 203, 67));
    panelGestionJuego.add(labelTurnos);
    
    labelUser1 = funcionesGUI.hacerLabel(labelUser1, "User 1");
    labelUser1.setHorizontalAlignment(JLabel.CENTER);
    labelUser1.setForeground(new Color(249, 203, 67));
    
    panelGestionJuego.add(labelUser1);
    
    fieldUser1.setEditable(false);
    fieldUser1.setBackground(new Color(229, 32, 32));
    fieldUser2.setBackground(new Color(229,32,32));
    fieldUser2.setEditable(false);
    
    panelGestionJuego.add(fieldUser1);
    
    labelUser2 = funcionesGUI.hacerLabel(labelUser2, "User 2");
    labelUser2.setHorizontalAlignment(JLabel.CENTER);
    labelUser2.setForeground(new Color(249, 203, 67));
    
    panelGestionJuego.add(labelUser2);
    panelGestionJuego.add(fieldUser2);
    
    btnRetirar = funcionesGUI.hacerbtn(btnRetirar, "Retirarse");
    btnRetirar.setBackground(new Color(168, 156, 41));
    panelGestionJuego.add(btnRetirar);
    
    frameTablero.revalidate();
    frameTablero.repaint();
    frameTablero.setVisible(true);
}    
    

public static void hacerBotones(){

for (int filas=1;filas<=11;filas++){ 
    for(int columnas=1;columnas<=9; columnas++){
        if (filas==6){
        JLabel labelRio = new JLabel("");
        labelRio.setOpaque(true);
        labelRio.setBackground(new Color(71,197,209));
        panelTablero.add(labelRio);
        }
        else{
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(60,60));
         if((filas+columnas)%2 ==0){
            if(esPalacio(filas,columnas)){
                btn.setBackground(new Color(212,169,51));
            }
            else{
                btn.setBackground(new Color(251, 165, 24));
            }
        }
         else{
             if(esPalacio(filas,columnas))
                 btn.setBackground(new Color(161,34,36));
             else{
                 btn.setBackground(new Color(249, 203, 67));
             }
        }
        btn.setFocusable(false);
        panelTablero.add(btn);
        } 
        
         }
    }
    }   


public static boolean esPalacio (int filas, int columnas){

if(filas==11 || filas ==10 || filas == 9 || filas ==1 || filas == 2 || filas ==3){
    if (columnas==4 || columnas ==6 ||columnas ==5 ){
    return true;
    }
    else
    return false;
    
    }
return false;   
    }

public static void agregarLetras(){
String[] letras = {"a","b","c","d","e","f","g","h","i"};

for (int index=0;index<letras.length;index++){
JLabel labelLetras = new JLabel(letras[index]);
labelLetras.setFont(new Font("Arial",Font.PLAIN,16));
labelLetras.setForeground(new Color(251, 165, 24));
panelLetras.add(labelLetras);
}}

public static void agregarNumeros(){
for (int index=1; index<=10; index++){
JLabel labelNumeros = new JLabel(String.valueOf(index));
labelNumeros.setFont(new Font("Arial", Font.PLAIN,16));
labelNumeros.setForeground(new Color(251,165,24));
panelNumeros.add(labelNumeros);
}

}
static JLabel labelTurnos = new JLabel();
static JButton btnRetirar = new JButton();
static JTextField fieldUser1 = new JTextField();
static JTextField fieldUser2 = new JTextField();
static JLabel labelUser1 = new JLabel();
static JLabel labelUser2 = new JLabel();
static JLabel labelTitulo = new JLabel();
static JPanel panelNumeros = new JPanel();
static JPanel panelLetras = new JPanel();
static JPanel panelContenedor = new JPanel();
static JFrame frameTablero = new JFrame();
static JPanel panelJuego = new JPanel();
static JPanel panelGestionJuego = new JPanel();
static JPanel panelTablero = new JPanel();
}


