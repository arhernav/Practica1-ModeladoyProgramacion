import java.util.ArrayList;

/**
 * Clase que provee el servicio Thisney+
 * <p>
 * Implementa la  interfaz <code>sujeto<code> y extiende de la superclase <code>Servicio<code> 
 */
public class ThisneyPlus extends Servicio implements Sujeto{

    /**
     * Constructor de la clase
     */
    public ThisneyPlus(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
	this.recomendaciones[0] = "Los increibles";
	this.recomendaciones[1] = "Lo que sea con princesas";
	this.recomendaciones[2] = "Star Wars";
	this.recomendaciones[3] = "Los vengadores";
	this.recomendaciones[4] = "Frozen";
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
	    System.out.println("Lamentamos que hayas dejado  el serivicio de Thisney por no poder pagarlo: " + cliente.persona.nombre);
	}else{
	    contrato.realizarCobro(cliente.persona);
	}	
    }

    /**
     * Checa el tipo de contrato de un cliente dado y devuelve un objeto de alguna clase que immplemente la interfaz <code>ContratoThisney<code>
     * Envia un mensaje notificando al cliente del tipo de contrato que tiene
     * Ya que Thisney cobra en base al numero de meses, Thisney no utiliza el atributo <code>contrato<code> del cliente
     * @param Cliente Cliente del cual se checa el contrato
     * @return ContratoThisney Objeto de alguna clase que implemente la interfaz <code>ContratoThisney<code>
     */
    protected ContratoThisney checarContrato(Cliente cliente){
	ContratoThisney contrato;
	if(cliente.meses <= 3){
	    contrato = new ContratoInicial();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio inical de Thisney");
	    return contrato;
	}
	contrato = new ContratoVeterano(); 
	System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio normal de Momazon");
	return contrato;
	
    }

    /**
     * Metodo que envia notificacion a todos los observadores
     * La notificacion constiste de una recomendacion general para todos los clientes, una actualizacion del numero de meses de suscripcion de cada cliente y 
     * el cobro del monto especifico para cada cliente
     * Si un cliente no es capaz de pagar, este es dado de baja del servicio y notificado de esto
     */
    @Override public void notifica(){
	this.realizarRecomendacion();
	this.actualizaMesesClientes();
	//Para cada cliente, si puede hacer el cobro, lo realiza, si no, lo agrega a exclientes
	for(Cliente cliente: this.clientesActivos){
	    this.cobrar(cliente);
	    System.out.println(cliente.persona.nombre + " lleva usando Thisney Plus por: " + cliente.meses);
	    
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }

    /**
     * Agrega a una persona a la lista de clientes activos. 
     * Si la persona ya habia sido inscrita y se dio de baja, saca a la persona de exclientes y continua con su informacion previa
     * @param Persona Persona a agregar al servicio
     * @param int Entero que maneja el tipo de contrato que la persona solicita
     */
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
	    this.setContrato(excliente, contrato);
	    System.out.println("Bienvenido nuevamente a Thisney Plus, ahora tu tambien eres parte de nuestras pertenencias " + persona.nombre + " y no podras volver a escapar");
	}else{
	    this.clientesActivos.add(clienteNuevo);
	    System.out.println("Bienvenido a Thisney Plus " + persona.nombre + ", el servicio del monopolio menos obvio del planeta");
	}
    }

    /**
     * Da de baja del servicio a la persona
     * @param Persona Persona a dar de baja del  servicio
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
	    System.out.println("Lamentamos que dejes el servicio de Thisney " + dadoDeBaja.persona.nombre);
	}
    }
    

    
}
