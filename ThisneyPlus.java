import java.util.ArrayList;

/**
 * Clase que provee el servicio Thisney+
 * 
 * Extiende de Servicio e implementa Sujeto
 */
public class ThisneyPlus extends Servicio implements Sujeto{


    public ThisneyPlus(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
    }

    ///////////////////////////////////////////////
    ////FALTA IMPLEMENTAR//////////////////////////
    ///////////////////////////////////////////////
    @Override protected void cobrar(Cliente cliente){
	return;
    }

    ///////////////////////////////////////////////
    ////FALTA IMPLEMENTAR//////////////////////////
    ///////////////////////////////////////////////
    @Override public void notifica(){
	return;
    }
    
    @Override public void agrega(Persona persona, int contrato){
	if(contrato > 2 || contrato < 1){
	    System.out.println("Numero de contrato invalido Thisney");
	    return;
	}
	Cliente clienteNuevo = new Cliente(persona, contrato);
	this.clientesActivos.add(clienteNuevo);
    }

    @Override public void remueve(Persona persona){
	for(Cliente cliente : this.clientesActivos){
	    if(cliente.persona == persona){
		this.exClientes.add(cliente);
		this.clientesActivos.remove(cliente);
	    }
	}
    }

    

    
}
