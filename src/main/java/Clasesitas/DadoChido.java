/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesitas;

import java.util.Arrays;

/**
 *
 * @author felix_5bh1a4y
 *
 * Esta clase modela el funcionamiento de un dado.
 * Este tendra 6 caras posibles pero solamente 1 de ellas es la que se tomara como la "cara principal"
 * que sera aquella que se encuentre en el atributo 'letra';
*/
public class DadoChido extends Dado {

    private String[] letras;
    private String letra;
    private int numeroDado;
    private int lenguaje;
    /*En el constructor ingresamos como parametro el tamano del dado, el numero de dado que es y el lenguaje en el que esta el
    juego
    */
    public DadoChido(int tamano, int numeroDado, int lenguaje) {
        super(tamano);
        letras = new String[6];
        this.numeroDado = numeroDado;
        this.lenguaje=lenguaje;

    }

    //este metodo se utiliza para elegir una cara principal
    //es decir, se utiliza para "lanzar el dado" y asignarle una letra/cara;
    public void chooseCara() {
        letrasDisponibles(this.numeroDado);
        int a = lanzar();
        this.letra=this.letras[a];
    }

    public void letrasDisponibles(int numDado) {
        String[] opcionesPosibles = conjuntos(numDado).split(",");
        //la variable letras es un arreglo de strings que posee todas las diferentes letras que puede 
        ///mostrar este dado
        this.letras = opcionesPosibles;

    }
    /* Este metodo regresa una cadena que corresponde a alguno de los dados
    Es decir, si estamos hablando del dado numero 0 y el juego esta en espa;ol, regresara la primera cadena de 
    la variable opcionesPosibles[], que corresponde a las letras "Q,B,Z,J,X,L,".
    De esta manera podemos obtener todas las caras que puede llegar a tener el dado numero 0
    */
    public String conjuntos(int numeroConjunto) {
        if(this.lenguaje==1){
            //espa;ol
        String[] opcionesPosibles = {"Q,B,Z,J,X,L,", "T,O,U,O,T,O,", "O,V,C,R,G,R,", "A,A,A,F,S,R,", "A,U,M,E,E,O,",
            "E,H,L,R,D,O,", "N,H,D,T,H,O,", "L,H,N,R,O,D,", "A,D,A,I,S,R,", "U,I,F,A,S,R,", "T,E,L,P,C,I,", "S,S,N,S,E,U,",
            "R,I,Y,P,R,H,", "D,O,R,D,L,N,", "C,C,Ñ,N,S,T,", "T,T,O,T,E,M,", "S,C,T,I,E,P,", "E,A,N,D,N,N,", "M,N,N,E,A,G,",
            "U,O,T,O,Ñ,N,", "A,E,A,E,E,H,", "Y,I,F,P,S,R,", "E,E,E,E,M,A,", "I,T,A,T,I,E", "E,T,I,L,A,C,"};
                return opcionesPosibles[numeroConjunto];
        }
        //ingles
        else{String[] opcionesPosibles1={"Q,B,Z,J,X,L,", "T,O,U,O,T,O,", "O,V,W,R,G,R,", "A,A,A,F,S,R,", "A,U,M,E,E,G,",
            "H,H,L,R,D,O,", "N,H,D,T,H,O,", "L,H,N,R,O,D,", "A,F,A,I,S,R,", "Y,I,F,A,S,R,", "T,E,L,P,C,I,", "S,S,N,S,E,U,",
            "R,I,Y,P,R,H,", "D,O,R,D,L,N,", "C,C,W,N,S,T,", "T,T,O,T,E,M,", "S,C,T,I,E,P,", "E,A,N,D,N,N,", "M,N,N,E,A,G,",
            "U,O,T,O,W,N,", "A,E,A,E,E,E,", "Y,I,F,P,S,R,", "E,E,E,E,M,A,", "I,T,I,T,I,E", "E,T,I,L,I,C,"};
                return opcionesPosibles1[numeroConjunto];
        }

    }

    public void creacionDados() {

    }

    public String mostrarCara() {
        return this.letra;
    }
    public void cambio(int letra){
        this.letra= letras[letra];
    }


}
