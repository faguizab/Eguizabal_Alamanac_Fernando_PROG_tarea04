
package arrays;


import utilidades.Entrada;
/**
 * Clase principal para resolver el Ejercicio 3 de la Tarea Online 4 de Programación
 * @author fagui
 */
public class Principal {
    //Main principal de nuestra aplicación
    public static void main(String[] args) {
        //Pedimos al usuario cuantos triángulos quiere crear y validamos
        int numTriangulos = 0;
        do{
            System.out.print("Por favor, introduce el número de triángulos a crear: ");
            numTriangulos = Entrada.entero();
        }while (numTriangulos < 1);
        
        //Creamos un array para contener los triangulos
        Triangulo[] arrayTriangulos = new Triangulo[numTriangulos];
        
        //Generamos todos los vertices para los triángulos y luego creamos el triangulo
        for(int i = 0; i < numTriangulos; i++){
            //Nos aseguramos que las coordenadas de los puntos son distintas para no tener problemas
            //al calcular las distancias
            double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
            
            //Nos aseguramos que la X y Y del primer punto son distintas
            do{
                x1 = Math.random()*10;
                y1 = Math.random()*10;
            }while(x1 == y1);
            //Asignamos ese punto
            Punto punto1 = new Punto(x1,y1);
         
            //Ahora nos aseguramos la X e Y del segundo punto son distintas y además
            // X o Y son distintas a las del primero (Para no crear puntos iguales)
            do{
                x2 = Math.random()*10;
                y2 = Math.random()*10;
            }while((x2 == y2)||((x2==x1)&&(y2==y1)));
            //Asignamos ese punto
            Punto punto2 = new Punto(x2,y2);
            
            //Ahora nos aseguramos la X e Y del tercer punto son distintas y además
            // X o Y son distintas a las del primero y del segundo (Para no crear puntos iguales)
            do{
                x3 = Math.random()*10;
                y3 = Math.random()*10;
            }while((x3 == y3)||((x3==x1)&&(y3==y1))||((x3==x2)&&(y3==y2)));
            //Asignamos ese punto
            Punto punto3 = new Punto(x3,y3);
            
            arrayTriangulos[i] = new Triangulo(punto1, punto2, punto3);
        }
    }
}
