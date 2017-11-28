
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
            //LA variable auxiliar la usaré para poder controlar el número de decimales que quiero en los puntos
            int auxiliar = 0;
            
            //Creamos el primer punto del triángulo
            auxiliar = (int)(Math.random()*10000);
            x1 = (double)auxiliar/1000;
            auxiliar = (int)(Math.random()*10000);
            y1 = (double)auxiliar/1000;
            //Asignamos ese punto
            Punto punto1 = new Punto(x1,y1);
         
            //Ahora creamos el segundo punto y además comprobamos que la 
            // X o Y son distintas a las del primero (Para no crear puntos iguales)
            do{
                auxiliar = (int)(Math.random()*10000);
                x2 = (double)auxiliar/1000;
                auxiliar = (int)(Math.random()*10000);
                y2 = (double)auxiliar/1000;
            }while((x2==x1)&&(y2==y1));
            //Asignamos ese punto
            Punto punto2 = new Punto(x2,y2);
            
            //Ahora nos aseguramos la X e Y del tercer punto son distintas 
            //a las del primero y del segundo (Para no crear puntos iguales)
            do{
                auxiliar = (int)(Math.random()*10000);
                x3 = (double)auxiliar/1000;
                auxiliar = (int)(Math.random()*10000);
                y3 = (double)auxiliar/1000;
            }while(((x3==x1)&&(y3==y1))||((x3==x2)&&(y3==y2)));
            //Asignamos ese punto
            Punto punto3 = new Punto(x3,y3);
            
            arrayTriangulos[i] = new Triangulo(punto1, punto2, punto3);
        }
        
        //Calculamos el perímetro medio de todos los triángulos
        double sumaPerimetros = 0, mediaPerimetros = 0;
                
        //recorremos todo el array de triángulos
        for (int i = 0; i < numTriangulos; i++){
            //sumamos los perímetros
            sumaPerimetros += arrayTriangulos[i].perimetro();
        }
        mediaPerimetros = sumaPerimetros / numTriangulos;
        
        //para saber cual es el tríangulos con mejor y mayor perímetro, así como 
        //cuantos hay por debajo y por encima de la media creo las siguientes variables
        int numTriMenorPerimetro = 0, numTriMayorPerimetro = 0;
        
        //Como para crear un triangulo tendremos tres puntos, en el eje XY creo los
        //puntos de los extremos
        Punto mayorPunto = new Punto (10.00, 10.00);
        Punto medioPunto = new Punto (10.00,0.00);
        Punto menorPunto = new Punto (0.00, 0.00);
        
        /* Los triangulos para comparar los inicializamos al reves, es decir, el menor 
        lo inicializamos a lo mas grande que puede ser y el mayor al reves.
        
        EL triangulo menor lo hago lo más grande posible pasandole los puntos de los extremos*/
        Triangulo trianguloMenor = new Triangulo(mayorPunto, medioPunto, menorPunto);
        
        //EL triángulo mayor lo inicializo a lo más pequeño posible
        Triangulo trianguloMayor = new Triangulo(menorPunto, menorPunto, menorPunto);
        
        //Volvemos a recorrer el array para saber cual es el mayor, el menor y contar
        //aquellos que estén por debajo del perimetro y por encima
        for(int i = 0; i < numTriangulos; i++){
            //comprobamos si el triangulo en el que estamos es mayor o menos a la media
            if(arrayTriangulos[i].perimetro() < mediaPerimetros){
                numTriMenorPerimetro += 1;
                //como sabemos que es de los pequeños, comprobamos si es el menor y lo guardamos
                if(arrayTriangulos[i].perimetro() < trianguloMenor.perimetro()){
                    //el triangulo actual es menor que el guardado y lo guardamos
                    trianguloMenor = arrayTriangulos[i];
                }
            }else{
                //EL triángulo es mayor o igual a la media de los perímetros
                numTriMayorPerimetro += 1;
                //como sabemos que es de los grandes, comprobamos con el mayor guardado
                if(arrayTriangulos[i].perimetro() > trianguloMayor.perimetro()){
                    //el triángulo actual es mayor que el mayor hasta ahora y lo guardamos
                    trianguloMayor = arrayTriangulos[i];
                }
            }
        }
        //Comprobamos si hemos encontrado el Menor Triángulo 
        //(Solo ocurrirá si solo hemos pedido crear 1 triángulo)
        if(numTriMenorPerimetro == 0){
            trianguloMenor = trianguloMayor;
        }
        //Mostramos al usuario el perímetro medio de los triangulos
        System.out.println("El perímetro medio de los triángulos generados es: "+mediaPerimetros);
        
        //Mostramos la información acerca de los triángulos
        System.out.println("Se generaron un total de "+numTriangulos+" triángulos, de los cuales:");
        System.out.println("    - "+numTriMenorPerimetro+" tienen un perímetro MENOR a la media");
        System.out.println("    - "+numTriMayorPerimetro+" tienen un perímetro MAYOR o IGUAL a la media");
        System.out.println("");
        System.out.println("De estos triángulos el más PEQUEÑO es: ");
        System.out.println("- El representado por los puntos "+trianguloMenor.toString());
        System.out.println("- Con un perímetro de "+trianguloMenor.perimetro());
        System.out.println("Y por último el triángulo más GRANDE es: ");
        System.out.println("- El representado por los puntos "+trianguloMayor.toString());
        System.out.println("- Con un perímetro de "+trianguloMayor.perimetro());
    }
}
