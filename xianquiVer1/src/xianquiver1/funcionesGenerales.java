/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiver1;

import javax.swing.JButton;

/**
 *
 * @author chung
 */
public class funcionesGenerales {
    
    public static void colocarPieza(JButton btn, int row, int col){
    
        switch (row) {
            case 1:
                if(col ==1 || col == 9){
                    //carro de guerra negro
                }
                else if(col ==2 || col == 8){
                    //caballo negro
                }
                else if(col == 3 ||col == 7){
                    //elefante negro
                }
                else if(col ==5){
                    //general negro
                }
                else if(col == 4 || col == 6){
                    //oficial negro
                }   break;
            case 3:
                if(col ==2 || col ==8){
                    //canon negro
                }   break;
            case 4:
                if(col == 1 || col == 3 || col == 5 || col == 7 || col == 9){
                    //soldado negro
                }   break;
                
            case 8:
                if(col ==1 || col ==3 || col == 5 || col == 7 || col == 9){
                //soldado rojo
                } break;
                
            case 9:
                if(col == 2 || col == 8){
                //canon rojo
                } break;
                
            case 11:
                if(col == 1 || col == 9){
                //carroGuerra rojo
                }
                else if(col == 2 || col == 8){
                //caballo rojo
                }
                
                else if(col == 3 || col == 7){
                //elefante rojo
                }
                else if(col == 4|| col == 6){
                //oficial rojo
                }
                else if(col == 5){
                //general rojo
                }break;
                
            default:
                break;
        }
    
    }
    
}
