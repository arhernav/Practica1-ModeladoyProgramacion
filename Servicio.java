import java.util.ArrayList;

/**
 * <p> Clase abstracta para manejar diferentes tipos de servicios<p>
 * 
 * <p> Maneja la clase interna cliente y mantiene el registro de clientes y exclientes por medio de arrayList
 * <p> Asegura la implementacion de cobro y el  tiempo de suscripcion de los usuarios
 */
public abstract class Servicio{

    /**
     * Clase interna cliente
     * 
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
	 * Construye un objeto de la  clase cliente
	 */
	public Cliente(Persona p, int contrato){
	    this.persona = p;
	    this.meses = 0;
	    this.contrato = contrato;
	}
	
	/**
	 * Establece el tipo de contrato usado
	 * @param int Indica el tipo de contrato solicitado
	 */
	protected void setContrato(int i){
	    this.contrato = i;
	}

	/**
	 * Aumenta un mes al numero de meses
	 */
	protected void aumentaMes(){
	    this.meses++;
	}

	@Override public String toString(){
	    return "(" + this.persona.nombre + ", Contrato:" + this.contrato + ", Meses:" + this.meses + ")"; 
	}
	
	
    }// Fin de cliente

    /* Lista de clientes activos */
    ArrayList<Cliente> clientesActivos;
    ArrayList<Cliente> exClientes;

    protected void actualizaMesesClientes(){
	if( this.clientesActivos.isEmpty() ) return;
	for(Cliente c : this.clientesActivos){
	    c.aumentaMes();
	}
    }

    @Override public boolean equals(Object objeto){
	if (objeto == null || getClass() != objeto.getClass())
            return false;
        @SuppressWarnings("unchecked") Servicio s = (Servicio)objeto;
	return this.toString().equals(s.toString());
    }

    public void mostrarClientesActivos(){
	System.out.println(this.clientesActivos);
    }

    public void mostrarExClientes(){
	System.out.println(this.exClientes);
    }

    protected abstract void cobrar(Cliente c);


    
}
