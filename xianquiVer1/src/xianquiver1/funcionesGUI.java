/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;


/**
 *
 * @author chung
 */
public class funcionesGUI {
    public static JLabel hacerLabelTitulo(JLabel label, String text){
    
    label.setText(text);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setForeground(Color.white);
    label.setFont(new Font("Arial" , Font.BOLD, 40));
    
    return label;
    }    
    
    public static JLabel hacerLabel(JLabel label, String text){
    label.setText(text);
    label.setHorizontalAlignment(JLabel.LEFT);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setForeground(new Color(2, 175, 67));
    label.setFont(new Font("Arial", Font.BOLD,30));
      
    return label;
    }
    public static JButton hacerbtn (JButton btn, String text){
    btn.setText(text);
    Dimension dimension = new Dimension(200,250);
    btn.setPreferredSize(dimension);
    btn.setBackground(Color.WHITE);
    btn.setForeground(new Color(248,64,0));
    btn.setFont(new Font("Arial", Font.PLAIN,28));
    btn.setFocusable(false);
    
    return btn;
    }
    
    
    public static JPanel hacerPanel(JPanel panel,JLabel label, String titulo){
    panel.setBackground(new Color (248,64,0));
    label = hacerLabelTitulo(label, titulo );
    panel.setLayout(new GridBagLayout());
    
    return panel;
    }
    
    public static void posicion(GridBagConstraints posicion,int x, int y){
    posicion.gridx = x;
    posicion.gridy = y;
    
    }
}
