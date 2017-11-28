package cadenas;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import utilidades.Entrada;
/**
 * Ejercicio 2 de la tarea online de la unidad UT04 de Programación 
 * @author FErnando Eguizabal Alamañac
 */
public class Ejercicio2 {

    public static void main(String[] args) {    
        //Pedimos por teclado una matrícula española
        String cadena;
        do{
            System.out.print("Por favor, introduce la matrícula a comprobar: ");
            cadena = Entrada.cadena();
            cadena = cadena.trim();
        }while(cadena.length()<=0 || cadena.length()>7);
        
        //Ponemos las letras en mayusculas
        cadena = cadena.toUpperCase();
        
        //Comprobamos que es correcta la matricula mediante una expresión regular
        Pattern patron = Pattern.compile("([0-9]{4})([[A-Z]&&[^AEIOUÑ]]{3})");
        Matcher comprobacion = patron.matcher(cadena);
        
        if(comprobacion.matches()){
            //Si es correcta mostramos los números por un lado y las letras por otro
            System.out.println("SI es una matricula.");
            System.out.println("los números son: "+comprobacion.group(1)+" y las letras: "+comprobacion.group(2));
        }else{
            //Si no es correcta la matrícula informamos de ello
            System.out.println("La matricula introducida NO tiene un formato correcto.");
        }
    }
}
