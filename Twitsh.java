import java.util.ArrayList;

/**
 * Clase para Twitsh
 * <p>
 * Extiende de servicio e implementa sujeto
 */
public class Twitsh extends Servicio implements Sujeto{

    /**
     * Constructor de la clase
     */
    public Twitsh(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
	this.recomendaciones[0] = "Tyler1";
	this.recomendaciones[1] = "League of legends";
	this.recomendaciones[2] = "Michel reeeeeeeeeeeves";
	this.recomendaciones[3] = "Amogus";
	this.recomendaciones[4] = "Super Smash bros";
    }

    /**
     * Da de alta a una persona en el servicio
     * Si la persona ya habia estado suscrita en el servicio, actualiza su contrato y continua con su informacion previa
     * Si la persona ya esta dada de alta, el metodo no hace nada
     * @param Persona Persona a dar de alta en el servicio
     * @param int Contrato que la persona solicita
     */
    @Override public void agrega(Persona persona, int contrato){
	if(contrato > 2 || contrato < 1){
	    System.out.println("Numero de contrato invalido Twitsh");
	    return;
	}
	Cliente clienteNuevo = new Cliente(persona, contrato);
	if(this.clientesActivos.contains(clienteNuevo)) return ;
	if(this.exClientes.contains(clienteNuevo)){
	    int indice = this.exClientes.indexOf(clienteNuevo);
	    Cliente excliente = this.exClientes.get(indice);
	    this.exClientes.remove(excliente);
	    this.clientesActivos.add(excliente);
	    this.setContrato(excliente, contrato);
	    System.out.println("Bienvenido nuevamente a Twitsh " + persona.nombre);
	}else{
	    this.clientesActivos.add(clienteNuevo);
	    System.out.println("Bienvenido a Twitsh " + persona.nombre);
	}
    }

    /**
     * Da de baja del servicio a la persona en cuestion
     * @param Persona persona a la que se da de baja
     */
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
	    System.out.println("Lamentamos que dejes el  servicio de Twitsh " + dadoDeBaja.persona.nombre);
	}
    }

    /**
     * Checa el contrato de la persona en cuestio para saber la  manera adecuada  de cobrarle
     * @param Cliente Cliente del cual se checa el contrato
     * @return Objeto de alguna clase que herede de ContratoTwitsh
     */

    protected ContratoTwitsh checarContrato(Cliente cliente){
	ContratoTwitsh contrato;
	switch (cliente.contrato){
	case 1: contrato = new ContratoTwitshNormal();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio de Twitsh");
	    break;
	case 2: contrato = new ContratoTwitshPremium();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio premium de Twitsh");
	    break;
	default: contrato = new ContratoTwitshPremium();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio premium de Twitsh");
	    break;
	}
	return contrato;
    }

    /**
     * Cobra al cliente en cuestion  segun  su tipo de contrato
     * Si el cliente no es capaz de pagar, este es agregado a los exclientes
     * @param Cliente cliente al  cual se le cobra
     */
    @Override protected void cobrar(Cliente cliente){
	ContratoTwitsh contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio de twitsh por no poder pagarlo: " + cliente.persona.nombre);
	}else{
	    contrato.realizarCobro(cliente.persona);
	}
    }

    /**
     * Genera y anuncia una recomendacion generalizada para todos los clientes
     * Actualiza los meses de suscripcion de todos los clintes
     * Realiza el cobro adecuado a todos los clientes
     * Da de baja a los clientes que no puedan pagar
     */
    @Override public void notifica(){
	this.realizarRecomendacion();
	this.actualizaMesesClientes();
	//Para cada cliente, si puede hacer el cobro, lo realiza, si no, lo agrega a exclientes
	for(Cliente cliente: this.clientesActivos){
	    this.cobrar(cliente);
	    System.out.println(cliente.persona.nombre + " lleva usando Twitsh por: " + cliente.meses);
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }
    
}
