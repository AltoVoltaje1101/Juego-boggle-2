/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesitas;

import java.util.Scanner;

/**
 *
 * @author felix_5bh1a4y
 */
public class BooglePlay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 0;
        int lenguaje = 2;
        String respuesta;
        Scanner lectura = new Scanner(System.in);
        //primero se pregunta el lenguaje deseado y se guarda en la variable lenguaje
        System.out.println("En que idioma deseas jugar?\n1 - Español\n2 - Ingles\n");
        lenguaje = lectura.nextInt();
        lectura.nextLine();
        //con el lenguaje ya obtenido, podemos crear la "caja" qeu contendra todos los dads
        BoogleBox cajita = new BoogleBox(lenguaje);
        ///y una vez creada la caja, podemos obtener las palabras seleccionadas por el program para crear el objeto jugador
        Jugador jugador = new Jugador(cajita.get());

        do {
            //no es necesario usar el metodo de imprimirPalabrasSeleccionadas para jugar, pero es de utilidad para saber como esta
            //funcionando el programa
            cajita.imprimirPalabrasSeleccionadas();
            cajita.imprimirTablero();
            System.out.println("Ingrese su respuesta: \nPara salir, solamente escriba 'sair'\n");
            respuesta = lectura.nextLine();
            jugador.comparacion(respuesta);
            jugador.impresionDatos();
        } while (respuesta.equalsIgnoreCase("salir") == false);

    }

}
