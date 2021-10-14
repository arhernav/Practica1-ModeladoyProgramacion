import java.util.ArrayList;

/**
 * Clase que provee el servicio Thisney+
 * 
 * Extiende de Servicio e implementa Sujeto
 */
public class ThisneyPlus extends Servicio implements Sujeto{

    /*Recomendaciones */
    String[] recomendaciones = {"Los increibles", "Gravity falls", "Star Wars", "Los Vengadores", "¿Algo con princesas y esas cosas?"};

    public ThisneyPlus(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
    }

    /**
     * Metodo que realiza el cobro del servicio a un cliente dado.
     * Este metodo recibe un cliente al que se le va a cobra, checa el tipo de contrato que tiene y lo utiliza para realizar el cobro en si
     * @param Cliente Cliente al que se le hace el cobro
     */
    @Override protected void cobrar(Cliente cliente){
	ContratoThisney contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio, pobre: " + cliente.persona.nombre);
	}else{
	    contrato.realizarCobro(cliente.persona);
	}	
    }

    protected ContratoThisney checarContrato(Cliente cliente){
	if(cliente.meses <= 3) return new ContratoInicial();
	return new ContratoVeterano();
	
    }

    ////////////////////////////////////////////////////////////////////////////
    /////////////////////Falta implementar parte del metodo/////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Realiza el cobro de su contrato a todos los clientes suscritos y envia una recomendacion de pelicula/serie a cada uno de ellos
     */
    @Override public void notifica(){
	this.actualizaMesesClientes();
	//Para cada cliente, si puede hacer el cobro, lo realiza, si no, lo agrega a exclientes
	for(Cliente cliente: this.clientesActivos){
	    this.cobrar(cliente);
	    this.recomendar();
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }

    protected void recomendar(){
	System.out.println(this.recomendaciones[1]);
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
	    System.out.println("Lamentamos que dejes el  servicio" + dadoDeBaja.persona.nombre);
	}
    }

    
    

    
}
