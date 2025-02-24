/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class Gui {
    
    public static manejoPlayers manejoPlayers = new manejoPlayers();
    public static manejoPartidas manejoPartidas = new manejoPartidas();

    public static void pantallaInicio(){
        frameInicio.getContentPane().removeAll();
        
        frameInicio.setTitle("Xianqui");
        frameInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameInicio.setSize(500,500);
        frameInicio.setLocationRelativeTo(null);
        
        panelInicio = funcionesGUI.hacerPanel(panelInicio, labelInicio, "Menu de inicio");
        posicion.insets = new Insets(20, 20, 20, 20);
        frameInicio.add(panelInicio);
        
        funcionesGUI.posicion(posicion, 0, 0);
        posicion.gridwidth = 2;
        posicion.fill = GridBagConstraints.HORIZONTAL;
        panelInicio.add(labelInicio, posicion);
       
        btnLogin = funcionesGUI.hacerbtn(btnLogin,"Login");
        funcionesGUI.posicion(posicion, 0, 1);
        panelInicio.add(btnLogin, posicion);

        btnCrear = funcionesGUI.hacerbtn(btnCrear, "Crear player");
        funcionesGUI.posicion(posicion, 0, 2);
        panelInicio.add(btnCrear, posicion);


        //LOGIN
          panelLogin = funcionesGUI.hacerPanel(panelLogin, labelLogin, "Login");
          
          labelUsuarioLogin = funcionesGUI.hacerLabel(labelUsuarioLogin, "Usuario: ");
          
          fieldUsuarioLogin = new JTextField(10);
         
          labelPasswordLogin = funcionesGUI.hacerLabel(labelPasswordLogin,"Password: ");
          
          fieldPasswordLogin = new JPasswordField(10);
         
          btnLoginPlayer = funcionesGUI.hacerbtn(btnLoginPlayer,"Ok");
          
          btnRegresar = funcionesGUI.hacerbtn(btnRegresar, "Regresar");

          
          btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               funcionesGUI.configurarPanelLogin();

                boolean loginPosible = manejoPlayers.loginPosible();
                
                if(loginPosible){
                panelInicio.setVisible(false);
                frameInicio.add(panelLogin);
                panelLogin.setVisible(true);
                frameInicio.revalidate();
                frameInicio.repaint();
            }else{
                    
                    
                }}
        });
          
          if (btnLoginPlayer.getActionListeners().length > 0) {
        btnLoginPlayer.removeActionListener(btnLoginPlayer.getActionListeners()[0]);
        }    
          btnLoginPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioBase = fieldUsuarioLogin.getText();
                String usuarioDelimeter[] = usuarioBase.split(" ");
                
                String usuario = usuarioDelimeter[0];
                String password = new String(fieldPasswordLogin.getPassword());
                
                Users loginExitoso= manejoPlayers.verificarLogin(usuario, password);
                
                if (loginExitoso==null){
                JOptionPane.showMessageDialog(null, "Usuario no existe, intente de nuevo.","Error",JOptionPane.ERROR_MESSAGE);
                return;
                }

                XianquiVer1.player1 = loginExitoso;
                JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
                panelLogin.removeAll();
                frameInicio.setVisible(false);
                menuPrincipal();
            }
        });
        
        //CREAR PLAYER
        panelCrear = funcionesGUI.hacerPanel(panelCrear, labelCrear, "Crear Player");
        
        labelUsuario = funcionesGUI.hacerLabel(labelUsuario, "Usuario:");
        
        panelCrear.add(labelPassword, posicion);
        
        btnCrearPlayer = funcionesGUI.hacerbtn(btnCrearPlayer, "Ok");
        
        fieldUser = new JTextField(10);
       
        fieldPassword= new JPasswordField(10);
        
        btnRegresarCrear = funcionesGUI.hacerbtn(btnRegresarCrear, "Regresar");
        
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionesGUI.posicion(posicion, 0, 0);
                posicion.gridwidth = 2;
                posicion.anchor = GridBagConstraints.CENTER;
                panelCrear.add(labelCrear, posicion);

                funcionesGUI.posicion(posicion, 0, 1);
                posicion.gridwidth = 1;
                panelCrear.add(labelUsuario, posicion);

                labelPassword = funcionesGUI.hacerLabel(labelPassword, "Password: ");
                funcionesGUI.posicion(posicion, 0, 2);
                posicion.gridwidth = 1;

                funcionesGUI.posicion(posicion, 0, 3);
                panelCrear.add(btnCrearPlayer, posicion);

                funcionesGUI.posicion(posicion, 1, 1);
                posicion.fill = GridBagConstraints.HORIZONTAL;
                posicion.weightx = 1.0;
                panelCrear.add(fieldUser, posicion);

                funcionesGUI.posicion(posicion, 1, 2);
                posicion.fill = GridBagConstraints.HORIZONTAL;
                posicion.weightx = 1.0;
                panelCrear.add(fieldPassword, posicion);
        
                funcionesGUI.posicion(posicion, 1,3);
                posicion.fill = GridBagConstraints.HORIZONTAL;
                posicion.weightx = 1.0;
                panelCrear.add(btnRegresarCrear,posicion);
                funcionesGUI.regresar(btnRegresarCrear, panelCrear, panelInicio);
                btnCrearPlayer.setEnabled(true);
        
                panelInicio.setVisible(false);
                frameInicio.add(panelCrear);
                panelCrear.setVisible(true);
                frameInicio.revalidate();
                frameInicio.repaint();
            }
        });
         
    if (btnCrearPlayer.getActionListeners().length > 0) {
    btnCrearPlayer.removeActionListener(btnCrearPlayer.getActionListeners()[0]);
    }    
    btnCrearPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioBase = fieldUser.getText();
                String usuarioDelimeter[] = usuarioBase.split(" ");
                
                String usuario = usuarioDelimeter[0];
                String password = new String(fieldPassword.getPassword());

                XianquiVer1.player1 = manejoPlayers.verificarCrearPlayer(usuario, password);

                if (XianquiVer1.player1 != null) {
                    if(usuario.equals("")){
                    JOptionPane.showMessageDialog(null, "Llene las casillas indicadas", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(XianquiVer1.player1.usuario.equals("FALSOFALSO")) {
                    }
                    else{
                        
                    JOptionPane.showMessageDialog(null, "Creacion de perfil exitosa", "Nuevo jugador", JOptionPane.INFORMATION_MESSAGE);
                    panelCrear.removeAll();
                    panelCrear.remove(btnCrearPlayer);
                    frameInicio.setVisible(false);
                    menuPrincipal();
                    return;
                } }
                
                else {JOptionPane.showMessageDialog(null, "Usuario ya existe, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);}
                
            }
        });


        
       
       
        //SALIR
        btnSalir = funcionesGUI.hacerbtn(btnSalir,"Salir");
        funcionesGUI.posicion(posicion, 0, 4);
        panelInicio.add(btnSalir, posicion);
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelInicio.setVisible(true);
        frameInicio.setVisible(true);
    }
    
    public static void menuPrincipal(){
        
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
        
        panelJugar = funcionesGUI.hacerPanel(panelJugar, labelJugar, "Jugar contra:");
       
        fieldJugadorContra = new JTextField(10);
        
        btnRegresarJugar = funcionesGUI.hacerbtn(btnRegresarJugar, "Regresar");
        
        btnJugarListo = funcionesGUI.hacerbtn(btnJugarListo, "Jugar");
       
         btnJugarListo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioBase = fieldJugadorContra.getText();
                String usuarioDelimeter[] = usuarioBase.split(" ");
                
                String usuarioJugadorContra = usuarioDelimeter[0];
                
                Users playerContra= manejoPlayers.buscarPlayerPorUsuario(usuarioJugadorContra);
                if(playerContra == null){
                JOptionPane.showMessageDialog(null,"Jugador no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(playerContra.usuario.equals(XianquiVer1.player1.usuario)){
                JOptionPane.showMessageDialog(null, "No puede jugar contra usted mismo","Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(XianquiVer1.player2 == null){
                        XianquiVer1.player2 = playerContra;
                        JOptionPane.showMessageDialog(null, "Jugador seleccionado: " + XianquiVer1.player2.usuario, "Contrincante", JOptionPane.INFORMATION_MESSAGE);
                        XianquiVer1.partidaActual = new Partidas(XianquiVer1.player1,XianquiVer1.player2);
                        manejoPartidas.crear(XianquiVer1.partidaActual);
                        panelJugar.removeAll();
                        panelJugar.setVisible(false);
                        framePrincipal.setVisible(false);
                        Tablero.mostrarTablero();
                        return;
                    }
                }
                
            }
        });

        
        btnCuenta = funcionesGUI.hacerbtn(btnCuenta, "Mi cuenta");
        funcionesGUI.posicion(posicion, 0, 2);
        panelPrincipal.add(btnCuenta, posicion);
        
        btnCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionesGUI.mostrarMenuCuenta(framePrincipal);
                
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
        XianquiVer1.player1 = null;
        XianquiVer1.player2 = null;
        XianquiVer1.partidaActual = null; 
        
        framePrincipal.setVisible(false);  
        panelCrear.removeAll();  
        panelLogin.removeAll();  
        
        pantallaInicio();  
        panelCrear.setVisible(false);
        panelLogin.setVisible(false);
        panelInicio.setVisible(true);  
    }
});

        
        
       
       framePrincipal.setVisible(true);
    
    }
    static GridBagConstraints posicion = new GridBagConstraints();
    static JTextField fieldJugadorContra = new JTextField();
    static JButton btnRegresarJugar= new JButton();
    static JButton btnRegresarCrear= new JButton();
    static JPasswordField fieldPasswordLogin = new JPasswordField();
    static JTextField fieldUsuarioLogin= new JTextField();
    static JLabel labelPasswordLogin = new JLabel();
    static JLabel labelUsuarioLogin = new JLabel();
    static JButton btnJugarListo = new JButton();
    static JLabel labelJugar = new JLabel();
    static JComboBox cajaJugadores = new JComboBox();
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
    static JButton btnLoginPlayer = new JButton();
    static JButton btnCrearPlayer = new JButton();
    static JTextField fieldUser = new JTextField();
    static JPasswordField fieldPassword = new JPasswordField();
}
