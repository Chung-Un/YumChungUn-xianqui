/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {
    
    manejoPlayers manejoPlayers = new manejoPlayers();
    public Users player1;

    public void pantallaInicio(){
        frameInicio.setTitle("Xianqui");
        frameInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameInicio.setSize(500,500);
        frameInicio.setLocationRelativeTo(null);
        
        panelInicio = funcionesGUI.hacerPanel(panelInicio, labelInicio, "Menu de inicio");
        GridBagConstraints posicion = new GridBagConstraints();
        posicion.insets = new Insets(20, 20, 20, 20);
        frameInicio.add(panelInicio);
        
        funcionesGUI.posicion(posicion, 0, 0);
        posicion.gridwidth = 2;
        posicion.fill = GridBagConstraints.HORIZONTAL;
        panelInicio.add(labelInicio, posicion);
        
       
        btnLogin = funcionesGUI.hacerbtn(btnLogin,"Login");
        funcionesGUI.posicion(posicion, 0, 1);
        panelInicio.add(btnLogin, posicion);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean loginPosible = manejoPlayers.loginPosible();
                
                if(loginPosible){
                panelInicio.setVisible(false);
                frameInicio.add(panelLogin);
                frameInicio.revalidate();
                frameInicio.repaint();
            }else{
                    
                    
                }}
        });

        btnCrear = funcionesGUI.hacerbtn(btnCrear, "Crear player");
        funcionesGUI.posicion(posicion, 0, 2);
        panelInicio.add(btnCrear, posicion);

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInicio.setVisible(false);
                frameInicio.add(panelCrear);
                frameInicio.revalidate();
                frameInicio.repaint();
            }
        });

        //LOGIN
        
        panelLogin = funcionesGUI.hacerPanel(panelLogin, labelLogin, "Login");
        funcionesGUI.posicion(posicion, 0, 0);
        posicion.gridwidth = 2;
        posicion.anchor = GridBagConstraints.CENTER;
        panelLogin.add(labelLogin, posicion);
        
        labelUsuario = funcionesGUI.hacerLabel(labelUsuario, "Usuario: ");
        funcionesGUI.posicion(posicion, 0, 1);
        posicion.gridwidth = 1;
        panelLogin.add(labelUsuario, posicion);
        
        fieldUser = new JTextField(10);
        funcionesGUI.posicion(posicion, 1, 1);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx = 1.0;
        panelLogin.add(fieldUser, posicion);
        
        labelPassword = funcionesGUI.hacerLabel(labelPassword, "Password: ");
        funcionesGUI.posicion(posicion, 0, 2);
        posicion.gridwidth = 1;
        panelLogin.add(labelPassword,posicion);
        
        fieldPassword = new JPasswordField(10);
        funcionesGUI.posicion(posicion, 1, 2);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx = 1.0;
        panelLogin.add(fieldPassword, posicion);
       
        btnOkLogin = funcionesGUI.hacerbtn(btnOkLogin, "Ok");
        funcionesGUI.posicion(posicion, 0, 3);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx =1.0;
        panelLogin.add(btnOkLogin, posicion);
        
        
        btnOkLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = fieldUser.getText();
                String password = new String(fieldPassword.getPassword());
                
                Users loginExitoso= manejoPlayers.verificarLogin(usuario, password);
                
                if(loginExitoso !=null){
                player1 = loginExitoso;
                frameInicio.setVisible(false);
                }
            }
        });
        
        btnRegresar = funcionesGUI.hacerbtn(btnRegresar, "Regresar");
        funcionesGUI.posicion(posicion, 1,3);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx = 1.0;
        panelLogin.add(btnRegresar,posicion);
        funcionesGUI.regresar(btnRegresar, panelLogin, panelInicio);
        
        //CREAR PLAYER
        panelCrear = funcionesGUI.hacerPanel(panelCrear, labelCrear, "Crear Player");
        funcionesGUI.posicion(posicion, 0, 0);
        posicion.gridwidth = 2;
        posicion.anchor = GridBagConstraints.CENTER;
        panelCrear.add(labelCrear, posicion);
        
        funcionesGUI.posicion(posicion, 0, 1);
        posicion.gridwidth = 1;
        panelCrear.add(labelUsuario, posicion);
        
        funcionesGUI.posicion(posicion, 0, 2);
        posicion.gridwidth = 1;
        panelCrear.add(labelPassword, posicion);
        
        btnOkCrear = funcionesGUI.hacerbtn(btnOkCrear, "Ok");
        funcionesGUI.posicion(posicion, 0, 3);
        panelCrear.add(btnOkCrear, posicion);
        
        funcionesGUI.posicion(posicion, 1, 1);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx = 1.0;
        panelCrear.add(fieldUser, posicion);
        
        funcionesGUI.posicion(posicion, 1, 2);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx = 1.0;
        panelCrear.add(fieldPassword, posicion);
        
        btnOkCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = fieldUser.getText();
                String password = new String(fieldPassword.getPassword());
                
                Users creacionExitosa= manejoPlayers.verificarCrearPlayer(usuario, password);
                
                if(creacionExitosa!=null){
                player1 = creacionExitosa;
                JOptionPane.showMessageDialog(null, "Creacion de perfil exitosa", "Nuevo jugador", JOptionPane.PLAIN_MESSAGE);
                frameInicio.setVisible(false);
                menuPrincipal();
                }
            }
        });
        
        funcionesGUI.posicion(posicion, 1,3);
        posicion.fill = GridBagConstraints.HORIZONTAL;
        posicion.weightx = 1.0;
        panelCrear.add(btnRegresar,posicion);
        funcionesGUI.regresar(btnRegresar, panelCrear, panelInicio);
        
        //SALIR
        btnSalir = funcionesGUI.hacerbtn(btnSalir,"Salir");
        funcionesGUI.posicion(posicion, 0, 4);
        panelInicio.add(btnSalir, posicion);
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInicio.dispose();  
            }
        });

        frameInicio.setVisible(true);
    }
    
    public void menuPrincipal(){
        
        framePrincipal.setTitle("Xianqui");
        framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePrincipal.setSize(500,500);
        framePrincipal.setLocationRelativeTo(null);
        
        panelPrincipal = funcionesGUI.hacerPanel(panelPrincipal, labelPrincipal, "Menu Principal");
        GridBagConstraints posicion = new GridBagConstraints();
        posicion.insets = new Insets (20,20,20,20);
        framePrincipal.add(panelPrincipal);
        
        funcionesGUI.posicion(posicion, 0, 0);
        panelPrincipal.add(labelPrincipal);
        
        btnJugar = funcionesGUI.hacerbtn(btnJugar,"Jugar Xianqui");
        funcionesGUI.posicion(posicion, 0, 1);
        panelPrincipal.add(btnJugar, posicion);
        
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               funcionesGUI.mostrarMenuJugar(framePrincipal);
            }
        });
        
        btnCuenta = funcionesGUI.hacerbtn(btnCuenta, "Mi cuenta");
        funcionesGUI.posicion(posicion, 0, 2);
        panelPrincipal.add(btnCuenta, posicion);
        
        btnCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionesGUI.mostrarMenuCuenta(framePrincipal, player1);
                
            }
        });
        
        btnReportes = funcionesGUI.hacerbtn(btnReportes, "Reportes");
        funcionesGUI.posicion(posicion, 0, 3);
        panelPrincipal.add(btnReportes, posicion);
        
        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionesGUI.mostrarMenuReportes(framePrincipal);
            }
        });
        
        btnLogout = funcionesGUI.hacerbtn(btnLogout, "Log Out");
        funcionesGUI.posicion(posicion, 0, 4);
        panelPrincipal.add(btnLogout, posicion);
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              player1 = null;
              framePrincipal.setVisible(false);
              pantallaInicio();
              panelCrear.setVisible(false);
              panelInicio.setVisible(true);
            }
        });
        
        
       
       framePrincipal.setVisible(true);
    
    }
   
    
    static JButton btnRegresar = new JButton();
    static JPanel panelRanking = new JPanel();
    static JPanel panelLogs = new JPanel();
    static JPanel panelJugar = new JPanel();
    static JButton btnJugar = new JButton();
    static JButton btnLogout= new JButton();
    static JButton btnReportes = new JButton();
    static JButton btnCuenta = new JButton();
    static JLabel labelPrincipal = new JLabel();
    static JPanel panelPrincipal= new JPanel();
    static JFrame framePrincipal = new JFrame();
    static JFrame frameInicio = new JFrame();
    static JPanel panelInicio = new JPanel();
    static JPanel panelLogin = new JPanel();
    static JLabel labelInicio = new JLabel();
    static JButton btnLogin = new JButton();
    static JButton btnSalir = new JButton();
    static JButton btnCrear = new JButton();
    static JLabel labelLogin = new JLabel();
    static JLabel labelCrear = new JLabel();
    static JPanel panelCrear = new JPanel();
    static JLabel labelUsuario = new JLabel();
    static JLabel labelPassword = new JLabel();
    static JButton btnOkLogin = new JButton();
    static JButton btnOkCrear = new JButton();
    static JTextField fieldUser = new JTextField();
    static JPasswordField fieldPassword = new JPasswordField();
}
