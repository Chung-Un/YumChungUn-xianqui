/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;


/**
 *
 * @author chung
 */
public class Gui {
   
    public void pantallaInicio(){
    frame.setTitle("Xianqui");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(500,500);
    frame.setLocationRelativeTo(null);

    panelInicio.setLayout(new GridBagLayout());
    GridBagConstraints posicion = new GridBagConstraints();
    posicion.insets = new Insets(20,20,20,20);
    
    panelInicio.setBackground(new Color (248, 64, 0));
    frame.add(panelInicio);
    
    labelInicio = funcionesGUI.hacerLabelTitulo(labelInicio,"Menu de Inicio");
    posicion.gridx=0;
    posicion.gridy=0;
    posicion.fill = GridBagConstraints.VERTICAL;
    panelInicio.add(labelInicio,posicion);
    
    btnLogin = funcionesGUI.hacerbtn(btnLogin,"Login");
    funcionesGUI.posicion(posicion, 0, 1);
    panelInicio.add(btnLogin, posicion);
    
   btnLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            panelInicio.setVisible(false);
            frame.add(panelLogin);
            
        }
    });
   
   btnCrear = funcionesGUI.hacerbtn(btnCrear, "Crear player");
   funcionesGUI.posicion(posicion, 0, 2);
   panelInicio.add(btnCrear,posicion);
   
   btnCrear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        panelInicio.setVisible(false);
        frame.add(panelCrear);
        }
    });
   
   //LOGIN
    
    panelLogin = funcionesGUI.hacerPanel(panelLogin, labelLogin, "Login");
    funcionesGUI.posicion(posicion, 0, 0);
    posicion.fill = GridBagConstraints.VERTICAL;   
    posicion.gridwidth=2;
    posicion.anchor = GridBagConstraints.CENTER;
    panelLogin.add(labelLogin,posicion);

    
    labelUsuario = funcionesGUI.hacerLabel(labelUsuario, "Usuario: ");
    funcionesGUI.posicion(posicion, 0, 1);
    posicion.gridwidth=1;
    panelLogin.add(labelUsuario,posicion);
    
    labelPassword = funcionesGUI.hacerLabel(labelPassword, "Password:");
    funcionesGUI.posicion(posicion, 0, 2);
    posicion.gridwidth = 1;
    panelLogin.add(labelPassword,posicion);
  
    btnOk = funcionesGUI.hacerbtn(btnOk, "Ok");
    funcionesGUI.posicion(posicion, 0, 3);
    posicion.anchor = GridBagConstraints.CENTER;
    posicion.gridwidth = 2;
    panelLogin.add(btnOk, posicion);
    
    funcionesGUI.posicion(posicion,1,1);
    posicion.fill = GridBagConstraints.HORIZONTAL;
    posicion.weightx=1.0;
    panelLogin.add(fieldUser,posicion);
    
    funcionesGUI.posicion(posicion,1,2);
    posicion.fill = GridBagConstraints.HORIZONTAL;
    posicion.weightx=1.0;
    panelLogin.add(fieldPassword,posicion);
    
    
    btnOk.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String usuario= fieldUser.getText();
          String password = fieldPassword.toString();
         
        }
    });
    
   
   //CREAR PLAYER
   
    panelCrear = funcionesGUI.hacerPanel(panelCrear, labelCrear, "Crear Player");
    funcionesGUI.posicion(posicion, 0, 0);
    posicion.fill = GridBagConstraints.VERTICAL;   
    posicion.gridwidth=2;
    posicion.anchor = GridBagConstraints.CENTER;
    panelCrear.add(labelCrear,posicion);
   
   
    funcionesGUI.posicion(posicion, 0, 1);
    posicion.gridwidth=1;
    panelCrear.add(labelUsuario,posicion);
    
    funcionesGUI.posicion(posicion, 0, 2);
    posicion.gridwidth = 1;
    panelCrear.add(labelPassword,posicion);
  
    funcionesGUI.posicion(posicion, 0, 3);
    posicion.anchor = GridBagConstraints.CENTER;
    posicion.gridwidth = 2;
    panelLogin.add(btnOk, posicion);
    
    funcionesGUI.posicion(posicion,1,1);
    posicion.fill = GridBagConstraints.HORIZONTAL;
    posicion.weightx=1.0;
    panelLogin.add(fieldUser,posicion);
    
    funcionesGUI.posicion(posicion,1,2);
    posicion.fill = GridBagConstraints.HORIZONTAL;
    posicion.weightx=1.0;
    panelLogin.add(fieldPassword,posicion);
    
    
    btnOk.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String usuario= fieldUser.getText();
          String password = fieldPassword.toString();
         
        }
    });
    
   
   
   
    //SALIR
    btnSalir = funcionesGUI.hacerbtn(btnSalir,"Salir");
    funcionesGUI.posicion(posicion,0,3);
    panelInicio.add(btnSalir,posicion);
    
    btnSalir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();  
        }
    });
    
    panelCrear= funcionesGUI.hacerPanel(panelCrear,labelCrear, "Crear Player");
    
    
    
    frame.setVisible(true);

    }
    
    JFrame frame = new JFrame();
    JPanel panelInicio = new JPanel();
    JPanel panelLogin = new JPanel();
    JLabel labelInicio = new JLabel();
    JButton btnLogin = new JButton();
    JButton btnSalir = new JButton();
    JButton btnCrear = new JButton();
    JLabel labelLogin = new JLabel();
    JLabel labelCrear = new JLabel();
    JPanel panelCrear = new JPanel();
    JLabel labelUsuario = new JLabel();
    JLabel labelPassword = new JLabel();
    JButton btnOk = new JButton();
    JTextField fieldUser = new JTextField();
    JPasswordField fieldPassword = new JPasswordField();
    
}
