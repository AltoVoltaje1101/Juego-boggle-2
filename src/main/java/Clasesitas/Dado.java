/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesitas;
import java.util.Random;
/**
 *
 * @author felix_5bh1a4y
 */
public class Dado {
    protected int tamano;
    public Dado(int tamano){
        this.tamano = tamano;
    }
    //este metodo regresa un numero aleatorio de entre 0 y 5, el cual correspondera a a alguna de las caras de nuestro
    //dado.
    //este metodo se utiliza mas adelante para obtener al azar una de las caras del dado
    public int lanzar(){
        Random numero = new Random();
        return numero.nextInt(6);
    }
}
