/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesitas;

import java.util.HashSet;

/**
 *
 * @author felix_5bh1a4y
 */
public class Jugador {

    private HashSet<String> palabrasUsadas;
    private HashSet<String> palabrasDisponibles;
    private String[] palabras;
    private int[] puntaje;
    private int numero;

    /* Al momento de crear un objeto llamado jugador, se pide que ingresemos un hashset de palabras
    Dicho HashSet es el mismo que se creo en cajita, el cual contiene todas las palabras que apareceran en el
    tablero
     */
    public Jugador(HashSet<String> palabrasDisponibles) {
        //el hashset propio se igual al hashset proporcionado
        this.palabrasDisponibles = palabrasDisponibles;
        this.palabrasUsadas = new HashSet<String>();
        palabras = new String[3];
        puntaje = new int[3];
        numero = 0;

    }

    /* En este metodo, se utiliza como parametro una variable de tipo String, la cual contiene
    la respuesta que le usuario ingreso en el programa
     */
    public void comparacion(String palabra) {
        //primero verificamos que la palabra si sea una palabra valida, es
        //decir, que si este dentro de la matriz
        if (palabrasDisponibles.contains(palabra) == true) {
            //si se comprobo que esta dentro de la matriz, ahora debemos 
            //asegurarnos que esta palabra no haya sido ingresada
            //anteriormente, para esto usamos el HashSet de palabrasUsadas,
            //que tal como su nombre indica, almacena las palabras
            //que el usuario ya utilizo.
            if (palabrasUsadas.contains(palabra) == false) {
                palabrasUsadas.add(palabra);
                palabras[numero] = palabra;
                //el puntaje de cada palabra se asigna dependiendo de la longitud que 
                //tenga la respuesta encontrada
                puntaje[numero] = palabra.length();
                numero++;
            } else {
                System.out.println("Esta palabra ya ha sido ingresada anteriormente");
            }
        } else if (palabra.equalsIgnoreCase("salir") == false) {
            System.out.println("No se ha encontrado la palabra requerida");
        } else {
            System.out.println("el juego ha terminado, vuelva pronto!");
        }
    }

    //este metodo se utiliza unicamente para la impresion de los resultados que va teniendo el jugador
    public void impresionDatos() {
        System.out.println("Palabras encontradas\tPuntos por palabra");
        int total = 0, numero = 0;
        for (int i = 0; i < 3; i++) {

            if (puntaje[i] != 0) {
                System.out.println(palabras[i] + "\t" + puntaje[i]);
                total += puntaje[i];
                numero = i + 1;
            }

        }
        System.out.println("Total de puntos obtenidos: " + total + "\nPalabras encontradas: " + numero);
    }
}
