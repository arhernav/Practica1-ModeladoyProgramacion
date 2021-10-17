import java.util.ArrayList;

/**
 * Clase para Memeflix
 * <p>
 * Implementa la  interfaz <code>sujeto<code> y extiende de la superclase <code>Servicio<code> 
 */
public class Memeflix extends Servicio implements Sujeto{

    /**
     * Constructor de la clase Memeflix
     */
    public Memeflix(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
	this.recomendaciones[0] = "El juego del pulpo";
	this.recomendaciones[1] = "Los juegos del hambre";
	this.recomendaciones[2] = "El señor de los anillos";
	this.recomendaciones[3] = "El stand de los besos";
	this.recomendaciones[4] = "Orgullo y prejuicio";
    }
    
    /**
     * Agrega a una persona a la lista de clientes activos. 
     * Si la persona ya habia sido inscrita y se dio de baja, saca a la persona de exclientes y continua con su informacion previa
     * @param Persona Persona a agregar al servicio
     * @param int Entero que maneja el tipo de contrato que la persona solicita
     */
    @Override public void agrega(Persona persona, int contrato){
	if(contrato > 3 || contrato < 1){
	    System.out.println("Numero de contrato invalido Memeflix");
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
	    System.out.println("Bienvenido nuevamente a Memeflix " + persona.nombre);
	}else{
	    this.clientesActivos.add(clienteNuevo);
	    System.out.println("Bienvenido a memeflix " + persona.nombre);
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
	    System.out.println("Lamentamos que dejes el  servicio" + dadoDeBaja.persona.nombre);
	}
    }

    /**
     * Checa el tipo de contrato que el cliente tiene contratado y devuelve un objeto adecuado que implemente de ContratoMemeflix
     * Al definir el tipo de contrato que la persona tiene contratado, este metodo envia un mensaje para recordar a la persona el contrato y su precio
     * @param Cliente Cliente del cual se checa el contrato y al cual se le informa su tipo de contrato
     * @return ContratoMemeflix Objeto de alguna clase que implemente ContratoMemeflix y defina el tipo de contrato del cliente
     */
    protected ContratoMemeflix checarContrato(Cliente cliente){
	ContratoMemeflix contrato;
	switch (cliente.contrato){
	case 1: contrato = new Contrato1Dispositivo();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio de Memeflix para 1 dispositivo");
	    break;
	case 2: contrato = new Contrato2Dispositivos();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio de Memeflix para 2 dispositivo");
	    break;
	case 3: contrato = new Contrato4Dispositivos();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio de Memeflix para 4 dispositivo");
	    break;
	default: contrato = new Contrato1Dispositivo();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio de Memeflix para 1 dispositivo");
	    break;
	}
	return contrato;
    }

    /**
     * Metodo auxiliar que checa el contrato del cliente dado y le hace un cobro acorde a este
     * @param Cliente Cliente del cual se checa el contrato y al cual se le cobra
     */
    @Override private void cobrar(Cliente cliente){
	ContratoMemeflix contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio de memeflix, pobre: " + cliente.persona.nombre);
	}else{
	    contrato.realizarCobro(cliente.persona);
	}
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
	    System.out.println(cliente.persona.nombre + " lleva usando memeflix por: " + cliente.meses + " meses" );
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }
	
    
}
