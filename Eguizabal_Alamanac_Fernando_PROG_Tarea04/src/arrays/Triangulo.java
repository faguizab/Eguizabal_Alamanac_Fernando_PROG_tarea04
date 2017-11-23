
package arrays;

/**
 * 
 * @author fagui
 */
public class Triangulo {
    /**
     * Clase que contendrá el constructor así como todos los métodos de los triángulos
     */
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
    
    //Creo el método toString que devolverá una cadena con la representación
    // del triángulo en formato A(x,y)B(x,y)C(x,y)
    public String toString (){
        String cadena = "A"+this.punto1.toString()+"B"+this.punto2.toString()+"C"+this.punto3.toString();
        return cadena;
    }
    
    //Creo el método perímetro del triángulo
    public double perimetro (){
        //Dadas las operaciones creo la variable y devolveré un double
        double perimetro = 0;
        
        perimetro = this.punto1.distancia(this.punto2);
        perimetro += this.punto1.distancia(this.punto3);
        perimetro += this.punto2.distancia(this.punto3);
        
        return perimetro;
    }
}
