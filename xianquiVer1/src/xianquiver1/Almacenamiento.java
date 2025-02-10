/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package xianquiver1;

/**
 *
 * @author chung
 * @param <t>
 */
public interface Almacenamiento<t>{
    public void resize(t[] item);
    public void crear(t item);
    public void borrar(t item);
}
