
package arrays;

/**
 * Clase para crear los triangulos a aprtir de los puntos
 * @author fagui
 */
public class Triangulo {
    //Creamos los atributos de los tres puntos del triangulo
    private Punto punto1;
    private Punto punto2;
    private Punto punto3;
    
    //Creo el construstor del triangulo por los parametros de los tres vertices
    public Triangulo(Punto punto1, Punto punto2, Punto punto3){
        //creamos los tres puntos del triangulo
        this.punto1 = new Punto(punto1.getX(),punto1.getY());
        this.punto2 = new Punto(punto2.getX(),punto2.getY());
        this.punto3 = new Punto(punto3.getX(),punto3.getY());
    }
    
    //Creo los métodos GET para cada uno de los triángulos
    public Punto getPunto1 (){
        return this.punto1;
    }
    public Punto getPunto2 (){
        return this.punto2;
    }
    public Punto getPunto3 (){
        return this.punto3;
    }
}
