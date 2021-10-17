/**
 * Clase que modela una persona
 * <p>
 * Tiene cuenta de banco y una lista de suscripciones
 */
public class Persona{
    
    /* Nombre de la persona */
    String nombre;
    /* CuentaBanco Maneja el dinero*/
    CuentaBanco cuenta;

    /**
     * Crea un objeto de la clase persona
     * @param String Nombre de la persona
     * @param int Dinero con el que inicia CuentaBanco
     */
    public Persona(String nombre, int dineroInicial){
	this.nombre = nombre;
	this.cuenta = new CuentaBanco(dineroInicial);
    }

    /**
     * Metodo toString
     * @return String 
     */
    @Override public String toString(){
	return this.nombre + " tiene: $" + this.cuenta.getDinero();
    }
    
    
}
