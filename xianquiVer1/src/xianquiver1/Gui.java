/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chung
 */
public class Gui {
    
    JFrame frameInicio = new JFrame();
    JPanel panelInicio = new JPanel();
    JLabel labelInicio = new JLabel();
    JButton btnLogin = new JButton();
    JButton btnSalir = new JButton();
    
    public void pantallaInicio(){
    frameInicio.setTitle("Xianqui");
    frameInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frameInicio.setSize(1000,1080);
    frameInicio.setLocationRelativeTo(null);
    

    
    panelInicio = new JPanel(new GridLayout(4,1,30,30));
    panelInicio.setBackground(new Color (248, 64, 0));
    frameInicio.add(panelInicio);
    
    labelInicio.setText("Menu de Inicio");
    labelInicio.setHorizontalTextPosition(JLabel.CENTER);
    labelInicio.setVerticalTextPosition(JLabel.CENTER);
    labelInicio.setForeground(Color.white);
    labelInicio.setFont(new Font ("Arkibal Mono", Font.BOLD,40));
    panelInicio.add(labelInicio);
    
    btnLogin.setText("Login");
    btnLogin.setBackground(new Color(248,64,0));
    btnLogin.setForeground(Color.white);
    btnLogin.setFont(new Font("Arkibal Mono", Font.PLAIN,28));
    btnLogin.setFocusable(false);
    panelInicio.add(btnLogin);
    
    btnSalir.setText("Salir");
    btnSalir.setBackground(new Color (248,64,0));
    btnSalir.setForeground(Color.white);
    btnSalir.setFont(new Font("Monospaced", Font.PLAIN,28));
    btnSalir.setFocusable(false);
    panelInicio.add(btnSalir);
    
    frameInicio.setVisible(true);
    
    
    }
}
