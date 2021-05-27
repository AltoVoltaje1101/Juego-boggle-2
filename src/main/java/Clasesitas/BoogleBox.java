/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesitas;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author felix_5bh1a4y
 */
public class BoogleBox {

    private DadoChido[][] dados;
    private HashSet<String> palabrasSeleccionadas;
    
    //nuestro constructor recibe una variable entera que sera la que nos dira el lenguaje en que
    //mostrara el tablero, seguido de esto, se procede a utilizar un bucle for con el fin de llenar
    //una matriz de 25 espacios con dados
    public BoogleBox(int lenguaje) {
        int a = 0;
        this.palabrasSeleccionadas = new HashSet<>();
        dados = new DadoChido[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dados[i][j] = new DadoChido(6, a, lenguaje);
                a++;
            }
        }
        //una vez que la matriz este llena de dados, esta matriz se vuelve a repasar y se utiliza el metodo
        //chooseCara() el cual se usa para asignar una cara aleatoria a cada uno de los dados.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dados[i][j].chooseCara();
            }
        }
        if(lenguaje ==1) creadorPalabrasEspañol();
        else creadorPalabrasIngles();
        imprimirTablero();
    }
    /*El metodo creadorPalabrasEspañol, tal como su nombre lo indica, se encarga de dibujar las palabras
    en el tablero en caso de que el usuario haya elegido jugar con el idioma español
    
    El metodo tiene 4 posibles plantillas diferentes, cada una con la posibilidad de tener 3 palabras distintas.
    estas 3 palabras se elgien aleatoriamente entre un conjunto de 6 palabras por cada uno de las plantillas.
   
    */
    public void creadorPalabrasEspañol() {
        Random numero = new Random();
        int caso = numero.nextInt(3);
        /* el metodo utiliza un hsashset en donde se van almacenando las paabras que el programa va escogiendo,
        esto con el fin de usar este mismo hashset para verificar la veracidad de la respuesta que brinde el usuario
        */
        HashSet<Integer> palabras = new HashSet<>();
        switch (caso) {
            //template
            case 0:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    //para evitar que el programacaiga en el mismo caso mas de una vez, se utilizo un hsashset que contiene
                    //numeros enteros, cada vez que el programa elige alguno de los casos, este numero se almacena 
                    //en el hashset con el fin de evitar caer nuevamente en el mismo caso.
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                //palabras posibles de los dados propuestos
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //fina
                                        this.dados[0][3].cambio(3);
                                        this.dados[1][3].cambio(3);
                                        dados[2][3].cambio(5);
                                        dados[3][3].cambio(4);
                                        this.palabrasSeleccionadas.add("fina");
                                        break;
                                    case 1:
                                        //rara
                                        dados[0][3].cambio(5);
                                        dados[1][3].cambio(0);
                                        dados[2][3].cambio(2);
                                        dados[3][3].cambio(4);
                                        this.palabrasSeleccionadas.add("rara");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //torre
                                        dados[0][1].cambio(0);
                                        dados[0][2].cambio(0);
                                        dados[1][2].cambio(3);
                                        dados[2][2].cambio(0);
                                        dados[3][2].cambio(0);
                                        this.palabrasSeleccionadas.add("torre");
                                        break;
                                    case 1:
                                        //oro
                                        dados[0][1].cambio(1);
                                        dados[0][2].cambio(3);
                                        dados[1][2].cambio(4);
                                        this.palabrasSeleccionadas.add("oro");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //pise
                                        dados[4][1].cambio(3);
                                        dados[3][1].cambio(3);
                                        dados[2][1].cambio(0);
                                        dados[2][0].cambio(1);
                                        this.palabrasSeleccionadas.add("pise");
                                        break;
                                    case 1:
                                        //res
                                        dados[2][1].cambio(0);
                                        dados[3][1].cambio(4);
                                        dados[4][1].cambio(5);
                                        this.palabrasSeleccionadas.add("res");
                                        break;
                                }
                                break;

                        }
                    } else i--;

                }
                break;
            //segundo template
            case 1:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                //palabras posibles de los dados propuestos
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //feo
                                        this.dados[4][1].cambio(2);
                                        this.dados[4][0].cambio(1);
                                        dados[3][0].cambio(2);
                                        this.palabrasSeleccionadas.add("feo");
                                        break;
                                    case 1:
                                        //lote
                                        dados[0][0].cambio(5);
                                        dados[1][0].cambio(5);
                                        dados[2][0].cambio(0);
                                        dados[3][0].cambio(4);
                                        this.palabrasSeleccionadas.add("lote");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //anis
                                        dados[4][2].cambio(5);
                                        dados[3][2].cambio(5);
                                        dados[2][2].cambio(1);
                                        dados[2][1].cambio(0);
                                        this.palabrasSeleccionadas.add("anis");
                                        break;
                                    case 1:
                                        //gris
                                        dados[3][3].cambio(5);
                                        dados[2][3].cambio(2);
                                        dados[2][2].cambio(1);
                                        dados[2][1].cambio(0);
                                        this.palabrasSeleccionadas.add("gris");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //gas
                                        dados[0][2].cambio(4);
                                        dados[1][3].cambio(0);
                                        dados[2][4].cambio(4);
                                        this.palabrasSeleccionadas.add("gas");
                                        break;
                                    case 1:
                                        //taco
                                        dados[2][4].cambio(5);
                                        dados[1][3].cambio(0);
                                        dados[0][2].cambio(2);
                                        dados[0][1].cambio(1);
                                        this.palabrasSeleccionadas.add("taco");
                                        break;
                                }
                                break;

                        }
                    } else i--;

                }
                break;
            //template 3
            case 2:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                //palabras posibles de los dados propuestos
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //risa
                                        this.dados[2][3].cambio(2);//r
                                        this.dados[2][2].cambio(1);//i
                                        dados[3][1].cambio(0);//s
                                        dados[4][0].cambio(0);//a
                                        this.palabrasSeleccionadas.add("risa");
                                        break;
                                    case 1:
                                        //dice
                                        dados[2][3].cambio(0);
                                        dados[2][2].cambio(1);
                                        dados[3][1].cambio(1);
                                        dados[4][0].cambio(0);
                                        this.palabrasSeleccionadas.add("dice");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //lonas
                                        
                                        dados[1][0].cambio(2);
                                        dados[1][1].cambio(5);
                                        dados[1][2].cambio(2);
                                        dados[1][3].cambio(0);
                                        dados[1][4].cambio(4);
                                        this.palabrasSeleccionadas.add("lonas");
                                        break;
                                    case 1:
                                        //santo
                                        dados[1][4].cambio(4);
                                        dados[1][3].cambio(0);
                                        dados[1][2].cambio(2);
                                        dados[1][1].cambio(3);
                                        dados[1][0].cambio(5);
                                        this.palabrasSeleccionadas.add("santo");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //mes
                                        dados[4][2].cambio(4);
                                        dados[3][3].cambio(3);
                                        dados[2][4].cambio(4);
                                        this.palabrasSeleccionadas.add("mes");
                                        break;
                                    case 1:
                                        //mas
                                        dados[4][2].cambio(4);
                                        dados[4][3].cambio(3);
                                        dados[2][4].cambio(4);
                                        this.palabrasSeleccionadas.add("mas");
                                        break;
                                }
                                break;
                        }
                    } else i--;

                }
                break;
                //template 4
            case 3:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //tarea
                                        this.dados[3][0].cambio(0);//t
                                        this.dados[4][0].cambio(0);//a
                                        dados[4][1].cambio(5);//r
                                        dados[4][2].cambio(0);//e
                                        dados[4][3].cambio(2);//a
                                        this.palabrasSeleccionadas.add("tarea");
                                        break;
                                    case 1:
                                        //tapa
                                        dados[4][0].cambio(0);//t
                                        dados[4][1].cambio(3);//a
                                        dados[4][2].cambio(5);//p
                                        dados[4][3].cambio(1);//a
                                        this.palabrasSeleccionadas.add("tapa");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //caro
                                        dados[4][4].cambio(5);
                                        dados[3][3].cambio(4);
                                        dados[2][2].cambio(4);
                                        dados[1][1].cambio(5);
                                        this.palabrasSeleccionadas.add("caro");
                                        break;
                                    case 1:
                                        //negro
                                        dados[3][4].cambio(5);
                                        dados[4][4].cambio(0);
                                        dados[3][3].cambio(5);
                                        dados[2][2].cambio(4);
                                        dados[1][1].cambio(5);
                                        this.palabrasSeleccionadas.add("negro");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //rama
                                        dados[0][2].cambio(5);
                                        dados[0][3].cambio(0);
                                        dados[0][4].cambio(2);
                                        dados[1][4].cambio(3);
                                        this.palabrasSeleccionadas.add("rama");
                                        break;
                                    case 1:
                                        //cama
                                        dados[0][2].cambio(2);
                                        dados[0][3].cambio(0);
                                        dados[0][4].cambio(2);
                                        dados[1][4].cambio(3);
                                        this.palabrasSeleccionadas.add("cama");
                                        break;
                                }
                                break;
                        }
                    } else i--;

                }
                break;

        }
     
    }
    /*el metodo CreadorPalabrasIngles funciona exactamente de la misma manera que el metodo
    para crear palabras en español, la unica diferencia es el idioma en el que estan escritas las palabras
    */
     public void creadorPalabrasIngles() {
        Random numero = new Random();
        int caso = numero.nextInt(3);
        HashSet<Integer> palabras = new HashSet<>();
        int a = 0;
        switch (caso) {
            //template
            case 0:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                //palabras posibles de los dados propuestos
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //mart
                                        dados[0][4].cambio(2);//m
                                        dados[0][3].cambio(0);//a
                                        dados[0][2].cambio(3);//r
                                        dados[0][1].cambio(0);//t
                                        this.palabrasSeleccionadas.add("mart");
                                        break;
                                    case 1:
                                        //bow
                                        dados[0][0].cambio(1);
                                        dados[0][1].cambio(1);
                                        dados[0][2].cambio(2);
                                        this.palabrasSeleccionadas.add("bow");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //ten
                                        dados[3][0].cambio(0);
                                        dados[2][0].cambio(1);
                                        dados[2][1].cambio(2);
                                        this.palabrasSeleccionadas.add("ten");
                                        break;
                                    case 1:
                                        //rupee
                                        dados[2][2].cambio(0);
                                        dados[2][1].cambio(5);
                                        dados[2][0].cambio(3);
                                        dados[3][0].cambio(4);
                                        dados[4][0].cambio(1);
                                        this.palabrasSeleccionadas.add("rupee");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //flay
                                        dados[1][4].cambio(2);
                                        dados[2][3].cambio(4);
                                        dados[3][2].cambio(1);
                                        dados[4][1].cambio(0);
                                        this.palabrasSeleccionadas.add("flay");
                                        break;
                                    case 1:
                                        //rods
                                        dados[1][4].cambio(5);
                                        dados[2][3].cambio(1);
                                        dados[3][2].cambio(3);
                                        dados[4][1].cambio(4);
                                        this.palabrasSeleccionadas.add("rods");
                                        break;
                                }
                                break;

                        }
                    } else i--;

                }
                break;
            //segundo template
            case 1:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                //palabras posibles de los dados propuestos
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //trim
                                        this.dados[1][1].cambio(3);
                                        this.dados[1][2].cambio(3);
                                        dados[1][3].cambio(3);
                                        dados[0][4].cambio(2);
                                        this.palabrasSeleccionadas.add("trim");
                                        break;
                                    case 1:
                                        //lote
                                        this.dados[1][1].cambio(3);
                                        this.dados[1][2].cambio(4);
                                        dados[1][3].cambio(5);
                                        dados[0][4].cambio(3);
                                        this.palabrasSeleccionadas.add("tore");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //lime
                                        dados[2][0].cambio(2);
                                        dados[3][1].cambio(3);
                                        dados[4][2].cambio(4);
                                        dados[4][3].cambio(5);
                                        this.palabrasSeleccionadas.add("lime");
                                        break;
                                    case 1:
                                        //time
                                        dados[2][0].cambio(0);
                                        dados[3][1].cambio(3);
                                        dados[4][2].cambio(4);
                                        dados[4][3].cambio(5);
                                        this.palabrasSeleccionadas.add("time");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //town
                                        dados[4][4].cambio(1);
                                        dados[3][4].cambio(1);
                                        dados[2][4].cambio(2);
                                        dados[2][3].cambio(5);
                                        this.palabrasSeleccionadas.add("town");
                                        break;
                                    case 1:
                                        //cow
                                        dados[4][4].cambio(5);
                                        dados[3][4].cambio(1);
                                        dados[2][4].cambio(2);
                                        this.palabrasSeleccionadas.add("cow");
                                        break;
                                }
                                break;

                        }
                    } else i--;

                }
                break;
            //template 3
            case 2:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                //palabras posibles de los dados propuestos
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //born
                                        dados[0][0].cambio(1);//b
                                        dados[1][1].cambio(5);//o
                                        dados[2][2].cambio(4);//r
                                        dados[3][3].cambio(1);//n
                                        this.palabrasSeleccionadas.add("born");
                                        break;
                                    case 1:
                                        //join
                                        dados[0][0].cambio(3);//j
                                        dados[1][1].cambio(5);//o
                                        dados[2][2].cambio(1);//i
                                        dados[3][3].cambio(1);//n
                                        this.palabrasSeleccionadas.add("join");
                                        break;
                                }
                                break;
                            case 1:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //man
                                        
                                        dados[0][4].cambio(2);
                                        dados[1][4].cambio(3);
                                        dados[2][4].cambio(3);
                                        this.palabrasSeleccionadas.add("man");
                                        break;
                                    case 1:
                                        //gas
                                        dados[0][4].cambio(5);
                                        dados[1][4].cambio(3);
                                        dados[2][4].cambio(4);
                                        this.palabrasSeleccionadas.add("gas");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //pet
                                        dados[4][1].cambio(3);
                                        dados[4][2].cambio(0);
                                        dados[4][3].cambio(1);
                                        this.palabrasSeleccionadas.add("pet");
                                        break;
                                    case 1:
                                        //set
                                        dados[4][1].cambio(4);
                                        dados[4][2].cambio(0);
                                        dados[4][3].cambio(1);
                                        this.palabrasSeleccionadas.add("set");
                                        break;
                                }
                                break;
                        }
                    } else i--;

                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    caso = numero.nextInt(3);
                    if (palabras.contains(caso) == false) {
                        palabras.add(caso);
                        switch (caso) {
                            case 0:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //tour
                                        dados[0][1].cambio(0);//
                                        dados[1][1].cambio(5);//
                                        dados[2][1].cambio(5);//
                                        dados[2][2].cambio(0);//
                                        this.palabrasSeleccionadas.add("tour");
                                        break;
                                    case 1:
                                        //dust
                                        dados[1][1].cambio(2);//
                                        dados[2][1].cambio(5);//
                                        dados[3][1].cambio(0);//
                                        dados[3][0].cambio(0);//
                                        this.palabrasSeleccionadas.add("dust");
                                        break;
                                }
                                break;
                            case 1:
                                
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //caro
                                        dados[1][4].cambio(3);
                                        dados[2][4].cambio(3);
                                        dados[3][4].cambio(2);
                                        this.palabrasSeleccionadas.add("ant");
                                        break;
                                    case 1:
                                        //negro
                                        dados[0][4].cambio(5);
                                        dados[1][4].cambio(1);
                                        dados[2][4].cambio(4);
                                        dados[3][4].cambio(2);
                                        this.palabrasSeleccionadas.add("gist");
                                        break;
                                }
                                break;
                            case 2:
                                switch (numero.nextInt(2)) {
                                    case 0:
                                        //eye
                                        dados[4][0].cambio(1);
                                        dados[4][1].cambio(0);
                                        dados[3][2].cambio(0);
                                        this.palabrasSeleccionadas.add("eye");
                                        break;
                                    case 1:
                                        //ran
                                        dados[4][1].cambio(5);
                                        dados[3][2].cambio(1);
                                        dados[2][3].cambio(2);
                                        this.palabrasSeleccionadas.add("ran");
                                        break;
                                }
                                break;
                        }
                    } else i--;

                }
                break;

        }
     
    }
       public void imprimirTablero(){
            for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(dados[i][j].mostrarCara() + "\t");
            }
            System.out.println();
        }
        }
       public HashSet<String> get(){
           return this.palabrasSeleccionadas;
       }
       public void imprimirPalabrasSeleccionadas(){
           System.out.println(palabrasSeleccionadas);
       }
}
