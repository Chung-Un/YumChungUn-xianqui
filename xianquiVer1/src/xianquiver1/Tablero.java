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
    
    panelContenedor.removeAll();
    
    panelContenedor.setLayout(new BorderLayout());
    panelContenedor.setBackground(Color.WHITE);
    
    panelLetras.setLayout(new GridLayout(1,10));
    panelLetras.setPreferredSize(new Dimension(700,30));
    panelLetras.add(new JLabel(" "));
    
    manejoTablero.agregarLetras();
    
    panelNumeros.setLayout(new GridLayout(10,1));
    panelNumeros.setPreferredSize(new Dimension(30,800));
    
    manejoTablero.agregarNumeros();
    
    panelTablero.setBackground(new Color(249, 203, 67));
    panelTablero.setSize(700,800);
    panelTablero.setLayout(new GridLayout(11,9));
    manejoTablero.hacerBotones();

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
    
    labelTurnos = funcionesGUI.hacerLabel(labelTurnos, "Turno de: " + XianquiVer1.player1.usuario);
    labelTurnos.setHorizontalAlignment(JLabel.CENTER);
    labelTurnos.setForeground(new Color(249, 203, 67));
    panelGestionJuego.add(labelTurnos);
    
    labelUser1 = funcionesGUI.hacerLabel(labelUser1,XianquiVer1.player1.usuario);
    labelUser1.setHorizontalAlignment(JLabel.CENTER);
    labelUser1.setForeground(new Color(249, 203, 67));
    
    panelGestionJuego.add(labelUser1);
    
    fieldUser1.setEditable(false);
    fieldUser1.setBackground(new Color(229, 32, 32));
    fieldUser2.setBackground(new Color(229,32,32));
    fieldUser2.setEditable(false);
    
    panelGestionJuego.add(fieldUser1);
    fieldUser1.setText("");
    fieldUser1.setForeground(Color.WHITE);
    
    labelUser2 = funcionesGUI.hacerLabel(labelUser2, XianquiVer1.player2.usuario);
    labelUser2.setHorizontalAlignment(JLabel.CENTER);
    labelUser2.setForeground(new Color(249, 203, 67));
    
    panelGestionJuego.add(labelUser2);
    panelGestionJuego.add(fieldUser2);
    
    fieldUser2.setText("");
    fieldUser2.setForeground(Color.WHITE);
    
    btnRetirar = funcionesGUI.hacerbtn(btnRetirar, "Retirarse");
    btnRetirar.setBackground(new Color(168, 156, 41));
    panelGestionJuego.add(btnRetirar);
    
    frameTablero.revalidate();
    frameTablero.repaint();
    frameTablero.setVisible(true);
}    
    
static Pieza piezaSeleccionada;
static JButton[][] botonesTablero = new JButton[11][9];
static int filaOrigen=-1, columnaOrigen=-1;
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


