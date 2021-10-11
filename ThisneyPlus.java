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
	ContratoThisney contratoAUsar;
	if(cliente.meses <= 3 ){
	    contratoAUsar = checarContrato(1);
	    contratoAUSar.realizarCobro(cliente.persona);
	    return;
	}else{
	    contratoAUsar = checarContrato(2);
	    contratoAUsar.realizarCobro(cliente.persona);
	}
    }

    protected ContratoThisney checarContrato(int i){
	contratoThisney contrato;
	switch(i){
	case 1: contrato = new ContratoInicial();
	    break;
	case 2: contrato = new ContratoVeterano();
	    break;
	default: contrato = new ContratoVeterano();
	    break;
	}
	return contrato;
	
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
