import java.util.ArrayList;

/**
 * Clase que modela una persona
 * 
 * Tiene cuenta de banco y una lista de suscripciones
 */
public class Persona{
    
    /* Nombre de la persona */
    String nombre;
    /* CuentaBanco Maneja el dinero*/
    CuentaBanco cuenta;
    /* Lista de suscripciones*/
    ArrayList<Servicio> suscripciones;

    /**
     * Crea un objeto de la clase persona
     * @param String Nombre de la persona
     * @param int Dinero con el que inicia CuentaBanco
     */
    public Persona(String nombre, int dineroInicial){
	this.nombre = nombre;
	this.cuenta = new CuentaBanco(dineroInicial);
	this.suscripciones = new ArrayList<Servicio>();
    }

    /**
     * Agraga una suscripcion
     * @param Servicio Objeto que herede de la clase abstracta servicio
     */
    protected void suscripcionNueva(Servicio s){
	this.suscripciones.add(s);
    }

    /**
     * Cancela una suscripcion
     * @param Servicio Objeto que herede de la clase abstracta Servicio
     */
    protected void cancelarSuscripcion(Servicio s){
	if(this.suscripciones.contains(s) ) this.suscripciones.remove(s);
	return;
    }

    /**
     * Metodo toString
     * @return String 
     */
    @Override public String toString(){
	return this.nombre + " tiene: $" + this.cuenta.getDinero();
    }
    
    
}
