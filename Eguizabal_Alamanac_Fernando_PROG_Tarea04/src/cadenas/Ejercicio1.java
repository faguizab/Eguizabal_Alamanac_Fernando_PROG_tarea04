package cadenas;

import utilidades.Entrada;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Fernando Eguizabal Alamañac
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        //1- Realiza un programa que lea una palabra por teclado 
        String palabra = new String();
        int longitud = 0;
        boolean una_palabra = true;
        
        System.out.print("Por favor, introduce la palabra a examinar: ");
        palabra = Entrada.cadena();
        longitud = palabra.length();
        
        //Comprobamos que solo ha introducido una sola palabra, recorriendo el string
        //y si hay algún espacio entre palabras que no sea el primer o último caracter
        //sabremos que hay más de una palabra
        do{
            if(una_palabra == false){
                System.out.print("Por favor, introdizca solo una palabra: ");
                palabra = Entrada.cadena();
                longitud = palabra.length();
                una_palabra = true;
            }
            for(int i = 0; i<longitud; i++){
                if(palabra.charAt(i)==' ' && i != 0 && i < longitud-1){
                    una_palabra = false;
                }
            }
        }while(una_palabra == false);
        
        //2- Determine si es una palabra panvocálica o no. 
        //Una palabra es panvocálica si contiene al menos las cinco vocales.
        //ponemos todas las letras en minuscula para facilitar la busqueda de las vocales
        palabra = palabra.toLowerCase();
        
        //Creamos nuestra expresión regular para buscar las 5 vocales
        Pattern patron = Pattern.compile("([a]+)([e]+)");
        Matcher comprobacion = patron.matcher(palabra);
        
        if (comprobacion.matches()) {
            System.out.println("La palabra introducida SI es panvocálica");
        }else{
            System.out.println("La palabra introducida NO es panvocálica");
        }
    }
}
