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
	ContratoThisney contrato;
	if(cliente.meses <= 3 ){
	    contrato = this.checarContrato(1);
	    contrato.realizarCobro(cliente.persona);
	    return;
	}else{
	    contrato = checarContrato(2);
	    contrato.realizarCobro(cliente.persona);
	}
    }

    protected ContratoThisney checarContrato(int i){
	ContratoThisney contrato;
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
	if(this.clientesActivos.contains(clienteNuevo)) return;
	if(this.exClientes.contains(clienteNuevo)){
	    int indice = this.exClientes.indexOf(clienteNuevo);
	    Cliente excliente = this.exClientes.get(indice);
	    this.exClientes.remove(excliente);
	    this.clientesActivos.add(excliente);
	}else{
	    this.clientesActivos.add(clienteNuevo);
	}
    }

    @Override public void remueve(Persona persona){
	Cliente dadoDeBaja = null;
	for(Cliente cliente : this.clientesActivos){
	    if(cliente.persona.equals(persona)){
		dadoDeBaja = cliente;
		break;
	    }
	}
	if(dadoDeBaja != null){
	    this.clientesActivos.remove(dadoDeBaja);
	    this.exClientes.add(dadoDeBaja);
	}
    }

    
    

    
}
