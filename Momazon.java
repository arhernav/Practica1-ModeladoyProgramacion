import java.util.ArrayList;

/**
 * Clase para Momazon Prime Video
 */
public class Momazon extends Servicio implements Sujeto{

    /**
     * Constructor de la clase
     */
    public Momazon(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
	this.recomendaciones[0] = "El planeta de los changos";
	this.recomendaciones[1] = "Vencible";
	this.recomendaciones[2] = "Los chicos";
	this.recomendaciones[3] = "Bob esponja";
	this.recomendaciones[4] = "Star trek";
    }

    /**
     * Agrega a una persona al servicio
     * Si la persona ya se habia dado de alta en el serviocio, se pasa de exclientes a clientes y  se continua con su informacion previa
     * @param Persona Persona a dar de alta en el servicio
     * @param int Contrato que el cliente esta solicitando
     */
    @Override public void agrega(Persona persona, int contrato){
	if(contrato > 2 || contrato < 1){
	    System.out.println("Numero de contrato invalido Momazon");
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
	    System.out.println("Bienvenido nuevamente a Momazon " + persona.nombre);
	}else{
	    this.clientesActivos.add(clienteNuevo);
	    System.out.println("Bienvenido a Momazon " + persona.nombre);
	}
    }

    /**
     * Da de baja del servicio a la persona en cuestion
     * Si la persona no esta dada de alta en el servicio, el metodo no hace nada
     * @param Persona Persona a la que se da de baja del servicio
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
	    System.out.println("Lamentamos que dejes el  servicio de Momazon Prime " + dadoDeBaja.persona.nombre);
	}
    }

    /**
     * Checa el tipo de contrato que el cliente tiene contratado y devuelve un objeto adecuado que implemente de ContratoMomazon
     * Al definir el tipo de contrato que la persona tiene contratado, este metodo envia un mensaje para recordar a la persona el contrato y su precio
     * @param Cliente Cliente del cual se checa el contrato y al cual se le informa su tipo de contrato
     * @return ContratoMomazon Objeto de alguna clase que implemente ContratoMomazon y defina el tipo de contrato del cliente
     */
    protected ContratoMomazon checarContrato(Cliente cliente){
	ContratoMomazon contrato;
	switch (cliente.contrato){
	case 1: contrato = new ContratoMomazonNormal();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio normal de Momazon");
	    break;
	case 2: contrato = new ContratoMomazonPremium();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio premium de Momazon ");
	    break;
	default: contrato = new ContratoMomazonNormal();
	    System.out.println(cliente.persona.nombre + " paga: "+ contrato.conocerMonto() + " por el servicio normal de Momazon");
	    break;
	}
	return contrato;
    }

    /**
     * Metodo auxiliar que checa el contrato del cliente dado y le hace un cobro acorde a este
     * @param Cliente Cliente del cual se checa el contrato y al cual se le cobra
     */
    @Override protected void cobrar(Cliente cliente){
	ContratoMomazon contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio de Momazon por no poder pagarlo: " + cliente.persona.nombre);
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
	    System.out.println(cliente.persona.nombre + " lleva usando Momazon por: " + cliente.meses);
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }
} 
