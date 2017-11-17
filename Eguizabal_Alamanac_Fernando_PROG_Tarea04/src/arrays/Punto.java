
package arrays;

/**
 * Clase Punto del Ejercicio 3 de la Tarea Online 4
 * @author Fernando Eguizabal Alamañac
 */
public class Punto {
    //Creamos los dos atributos como privados
    private double x;
    private double y;
    
    //Creamos el constructor del punto
    public Punto (double x, double y){
        this.x = x;
        this.y = y;
    }
    
    //Creamos los métodos GET para los dos atributos
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    
    //Creo el método toString para devolver la representación del punto
    public String toString (){
        String representacion = "("+this.x+","+this.y+")";
        return representacion;
    }
    
    //Creo el método para saber la distancia entre este punto y otro
    public double distancia (Punto punto2){
        double distancia = 0;
        
        //calculamos la distancia entre este punto y el pasado por parametros
        distancia = Math.sqrt(Math.pow((punto2.x-this.x),2)+Math.pow((punto2.y+-this.y),2));
        
        return distancia;
    }
}
