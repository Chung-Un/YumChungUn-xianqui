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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author chung
 */
public class funcionesGUI extends Gui {
    static manejoPlayers manejoPlayers = new manejoPlayers();

    public static JLabel hacerLabelTitulo(JLabel label, String text){
    
    label.setText(text);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setForeground(new Color(229, 32, 32));
    label.setFont(new Font("Arial" , Font.BOLD, 40));
    
    return label;
    }    
    
    public static JLabel hacerLabel(JLabel label, String text){
    label.setText(text);
    label.setHorizontalAlignment(JLabel.LEFT);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setForeground(new Color(229, 32, 32));
    label.setFont(new Font("Arial", Font.BOLD,30));
      
    return label;
    }
    public static JButton hacerbtn (JButton btn, String text){
    btn.setText(text);
    Dimension dimension = new Dimension(200,250);
    btn.setPreferredSize(dimension);
    btn.setBackground(new Color(229, 32, 32));
    btn.setForeground(Color.WHITE);
    btn.setFont(new Font("Arial", Font.BOLD,28));
    btn.setFocusable(false);
    
    return btn;
    }
    
    
    public static JPanel hacerPanel(JPanel panel,JLabel label, String titulo){    
    panel.setBackground(new Color (249, 203, 67));
    label = hacerLabelTitulo(label, titulo );
    panel.setLayout(new GridBagLayout());
    
    return panel;
    }
    
    public static void posicion(GridBagConstraints posicion,int x, int y){
    posicion.gridx = x;
    posicion.gridy = y;
    
    }
    
    
   public static void mostrarMenuJugar(JFrame frame) {
       JPopupMenu menuJugar = new JPopupMenu();
       JMenuItem nuevaPartida = new JMenuItem("Nueva Partida");
       
       menuJugar.add(nuevaPartida);
       menuJugar.show(frame, 200, 200);
       
       nuevaPartida.addActionListener(e ->{ 
           if(manejoPlayers.players.length <2){
           JOptionPane.showMessageDialog(null, "No hay suficientes jugadores para iniciar una partida", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else{
                panelPrincipal.setVisible(false);
                framePrincipal.add(panelJugar);
                panelJugar.setVisible(true);
           }
           });
       
       
   }
   
   

   public static void mostrarMenuCuenta(JFrame frame) {
       JPopupMenu menuCuenta = new JPopupMenu();
       JMenuItem verInfo = new JMenuItem("Ver mi información");
       JMenuItem cambiarPassword = new JMenuItem("Cambiar Password");
       JMenuItem cerrarCuenta = new JMenuItem("Cerrar mi cuenta");
       
       menuCuenta.add(cambiarPassword);
       menuCuenta.add(cerrarCuenta);
       menuCuenta.add(verInfo);
       menuCuenta.show(frame, 200, 250);
    
       cambiarPassword.addActionListener(e ->{
               String passwordActual = JOptionPane.showInputDialog("Ingrese su password actual: ");
               String passwordNueva = JOptionPane.showInputDialog("Ingrese su password nueva: ");
               
               manejoPlayers.cambiarPassword(XianquiVer1.player1,passwordActual,passwordNueva);
           });
       

       cerrarCuenta.addActionListener(e ->{
               manejoPlayers.eliminarCuenta(XianquiVer1.player1);
               panelPrincipal.setVisible(false);
               frame.add(panelInicio);
               frame.add(panelCrear);
               frame.add(panelLogin);
               panelInicio.setVisible(true);
               frame.revalidate();
               frame.repaint();
           });
       
       verInfo.addActionListener(e ->{
               manejoPlayers.mostrarInformacion(XianquiVer1.player1);
           });
   }

   public static void mostrarMenuReportes(JFrame frame) {
       JPopupMenu menuReportes = new JPopupMenu();
       JMenuItem ranking = new JMenuItem("Ranking jugadores");
       JMenuItem logs = new JMenuItem("Logs de mis últimos juegos");

       menuReportes.add(ranking);
       menuReportes.add(logs);
       menuReportes.show(frame, 200, 300);
       
       ranking.addActionListener(e ->{
               manejoPlayers.ranking();
           });
       
       logs.addActionListener(e ->{
              
           });
   }  

   
   public static void regresar (JButton btnRegresar, JPanel panelActual, JPanel panelVolver){
       
       btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelActual.setVisible(false);
                panelVolver.setVisible(true);
                panelVolver.repaint();
                panelVolver.revalidate();
            }
        });
       
   }
}
