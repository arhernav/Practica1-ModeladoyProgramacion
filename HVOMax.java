/**
 * Clase para HVO Max
 * <p>
 * Extiende de Servicio e implementa Sujeto
 */
import java.util.ArrayList;
public class HVOMax extends Servicio implements Sujeto{

    /**
     * Constructor de la clase
     */
    public HVOMax(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
	this.recomendaciones[0] = "Hora de aventura";
	this.recomendaciones[1] = "Ben 10";
	this.recomendaciones[2] = "Space jam";
	this.recomendaciones[3] = "El conjuro";
	this.recomendaciones[4] = "Hora deaventura, por favor mira hora de aventura";
    }

    /**
     * Da de alta a una persona en el servicio
     * Si la persona ya habia estado suscrita en el servicio, actualiza su contrato y continua con su informacion previa
     * Si la persona ya esta dada de alta, el metodo no hace nada
     * @param Persona Persona a dar de alta en el servicio
     * @param int Contrato que la persona solicita
     */
    @Override public void agrega(Persona persona, int contrato){
	if(contrato > 3 || contrato < 1){
	    System.out.println("Numero de contrato invalido HVOMax");
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
	    System.out.println("Bienvenido nuevamente a HVO Max " + persona.nombre);
	}else{
	    this.clientesActivos.add(clienteNuevo);
	    System.out.println("Bienvenido a HVO Max " + persona.nombre);
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
	    System.out.println("Lamentamos que dejes el  servicio de HVO Max " + dadoDeBaja.persona.nombre);
	}
    }

    /**
     * Checa el contrato de la persona en cuestio para saber la  manera adecuada  de cobrarle
     * @param Cliente Cliente del cual se checa el contrato
     * @return Objeto de alguna clase que herede de ContrtoHVOMax
     */
    protected ContratoHVOMax checarContrato(Cliente cliente){
	ContratoHVOMax contrato;
	if(cliente.meses <= 3){
	    contrato = new ContratoHVOPrueba();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por la prueba de HVO Max");
	    return contrato;
	}
	contrato = new ContratoHVO();
	System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio de HVO Max");
	return contrato;
    }
    
    /**
     * Cobra al cliente en cuestion  segun  su tipo de contrato
     * Si el cliente no es capaz de pagar, este es agregado a los exclientes
     * @param Cliente cliente al  cual se le cobra
     */
    @Override protected void cobrar(Cliente cliente){
	ContratoHVOMax contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio de HVO Max por no poder pagarlo: " + cliente.persona.nombre);
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
	    System.out.println(cliente.persona.nombre + " lleva usando HVO Max por: " + cliente.meses);
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }
	
    
}
