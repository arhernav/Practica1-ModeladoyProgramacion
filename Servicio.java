import java.util.ArrayList;
import java.util.Random;

/**
 *  Clase abstracta base para manejar diferentes tipos de servicios<p>
 * <p>
 *  Maneja la clase interna cliente y mantiene el registro de clientes y exclientes por medio de arrayList
 *  Asegura la implementacion de cobro y el  tiempo de suscripcion de los usuarios
 *  Provee metodos para recomendar series y peliculas asi como imprimir informacion importante
 */
public abstract class Servicio{

    /**
     * Clase interna cliente
     * <p>
     * Ayuda a llevar el registro de las personas suscritas al servicio, el numero de meses que llevan suscritas al servicio y el tipo de contrato que solicictaron
     */
    protected class Cliente{

	/* Persona que contrato el servicio*/
	Persona persona;
	/* Meses que lleva suscrito */
	int meses;
	/* Tipo de contrato solicitado */
	int contrato;

	/**
	 * Constructor de la clase
	 */
	public Cliente(Persona p, int contrato){
	    this.persona = p;
	    this.meses = 0;
	    this.contrato = contrato;
	}
	

	/**
	 * Aumenta un mes al numero de meses
	 */
	protected void aumentaMes(){
	    this.meses++;
	}

	/**
	 * Revisa si la persona recibida es la misma persona que el cliente
	 * @param Persona Persona con la que se compara la persona del cliente
	 * @return boolean <code>true<code> si es la misma persona, <code>false<code> en otro caso
	 */
	protected boolean esLaPersona(Persona p){
	    if(this.persona.equals(p) ) return true;
	    return false;
	}
	
	/**
	 * Regresa una representacion en cadena del cliente con el formato (persona, contrato, meses)
	 * @return String Representacion en String del cliente
	 */
	@Override public String toString(){
	    return "(" + this.persona.nombre + ", Contrato:" + this.contrato + ", Meses:" + this.meses + ")"; 
	}
	
	/**
	 * Compara el cliente con un objeto recibido
	 * @param Object Objeto  a comparar el cliente
	 * @return boolean Regresa <code>true<code> si es un objeto de la clase cliente y ambos tienen a la misma  persona, <code>false<code> en otro caso
	 */
	@Override public boolean equals(Object objeto){
	    if (objeto == null || getClass() != objeto.getClass())
		return false;
	    @SuppressWarnings("unchecked") Cliente c = (Cliente)objeto;
	    return this.persona.equals(c.persona);
	}
	
	
    }// Fin de cliente
    
    /* Lista de clientes activos */
    ArrayList<Cliente> clientesActivos;
    /* Lista de exclientes que se dieron de baja del  servicio */
    ArrayList<Cliente> exClientes;
    /* Array de recomendaciones para los clientes */
    String[] recomendaciones = new String[5];
    /* Generador de numeros aleatorios para las recomendaciones */
    Random random = new Random();

    /**
     * Actualiza el numero de meses de suscripcion de todos los clientes
     */
    protected void actualizaMesesClientes(){
	if( this.clientesActivos.isEmpty() ) return;
	for(Cliente c : this.clientesActivos){
	    c.aumentaMes();
	}
    }

    /**
     * Imprime la lista de clientes activos
     */
    private void mostrarClientesActivos(){
	System.out.println(this.clientesActivos);
    }

    /**
     * Imprime la list de exclientes
     */
    public void mostrarExClientes(){
	System.out.println(this.exClientes);
    }

    /**
     * Metodo abstracto para cobrar en las subclases
     */
    protected abstract void cobrar(Cliente c);
    
    /**
     * Define un tipo de contrato especifico para el cliente
     * @param Cliente Cliente al  cual se le asigna el contrato
     * @param int Tipo de contrato asignado al cliente
     */
    protected void setContrato(Cliente c, int contrato){
	c.contrato = contrato;
    }
    /**
     * Imprime una recomendacion realizada con el metodo generarRecomendacion()
     */
    protected void realizarRecomendacion(){
	System.out.println(this.generarRecomendacion());
    }

    /**
     * Genera una recomendacion usando un String aleatorio del array recomendaciones
     */
    protected String generarRecomendacion(){
	return "La recomendacion para nuestros clientes este mes es: " + this.recomendaciones[random.nextInt(5)];
    }
    

    
}
