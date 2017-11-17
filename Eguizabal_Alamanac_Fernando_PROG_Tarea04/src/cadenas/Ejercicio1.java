package cadenas;

import utilidades.Entrada;

/**
 *
 * @author Fernando Eguizabal Alamañac
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        //1- Realiza un programa que lea una palabra por teclado 
        String palabra = new String();
        int longitud = 0;
        boolean unaPalabra = true;
        
        System.out.print("Por favor, introduce la palabra a examinar: ");
        palabra = Entrada.cadena();
        //eliminamos los posibles espacios en blanco al principio y final de la cadena
        palabra = palabra.trim();
        longitud = palabra.length();
        
        //Comprobamos que solo ha introducido una sola palabra, recorriendo el string
        //y si hay algún espacio entre palabras que no sea el primer o último caracter
        //sabremos que hay más de una palabra
        do{
            if(unaPalabra == false){
                System.out.print("Por favor, introdizca solo una palabra: ");
                palabra = Entrada.cadena();
                longitud = palabra.length();
                unaPalabra = true;
            }
            for(int i = 0; i<longitud; i++){
                //SI encontramos un espacio en la cadena es una separación de palabras
                if(palabra.charAt(i)==' '){
                    unaPalabra = false;
                }
            }
        }while(unaPalabra == false);
        
        //2- Determine si es una palabra panvocálica o no. 
        //Una palabra es panvocálica si contiene al menos las cinco vocales.
        //ponemos todas las letras en minuscula para facilitar la busqueda de las vocales
        palabra = palabra.toLowerCase();
        
        //Quito todos los tipos de acentuación que puedan haber en las vocales
        //Cadena de caracteres original a sustituir.
        String original = "áàäéèëíìïóòöúù";
        //Cadena de caracteres ASCII que reemplazarán los originales.
        String sinTildes = "aaaeeeiiiooouu";
        
        for (int i=0; i<longitud; i++) {
            if(original.indexOf(palabra.charAt(i))!= -1){
                int posicionCaracter = original.indexOf(palabra.charAt(i));
                palabra = palabra.replace(palabra.charAt(i), sinTildes.charAt(posicionCaracter));
            }
        }
        
        //contamos las apariciones de las vocales en la palabra. Para ello inicializamos
        //las variables necesarias
        int numA = 0, numE = 0, numI = 0, numO = 0, numU = 0;
        boolean esPanvocalica = false;
        
        System.out.println(palabra);
        for(int i = 0; i < longitud; i++){
            switch (palabra.charAt(i)){
                case 'a':   //Contamos una a
                            numA += 1;
                            break;
                case 'e':   //Contamos una e
                            numE += 1;
                            break;
                case 'i':   //Contamos una i
                            numI += 1;
                            break;
                case 'o':   //Contamos una o
                            numO += 1;
                            break;
                case 'u':   //Contamos una u
                            numU += 1;
                            break;
                default:    break;
            }
        }
        if (numA > 0 && numE > 0 && numI > 0 && numO > 0 && numU > 0) {
            System.out.println("La palabra introducida SI es panvocálica");
        }else{
            System.out.println("La palabra introducida NO es panvocálica");
        }
    }
}
