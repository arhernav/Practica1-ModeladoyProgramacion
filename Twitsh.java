import java.util.ArrayList;
public class Twitsh extends Servicio implements Sujeto{
    
    public Twitsh(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
	this.recomendaciones[0] = "Tyler1";
	this.recomendaciones[1] = "League of legends";
	this.recomendaciones[2] = "Michel reeeeeeeeeeeves";
	this.recomendaciones[3] = "Amogus";
	this.recomendaciones[4] = "Super Smash bros";
    }

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
    
    protected ContratoTwitsh checarContrato(Cliente cliente){
	ContratoTwitsh contrato;
	switch (cliente.contrato){
	case 1: contrato = new ContratoTwitshNormal();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio de Twitsh");
	    break;
	case 2: contrato = new ContratoTwitshPremium();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio premium de Twitsh");
	    break;
	default: contrato = new ContratoTwitshPremium();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.conocerMonto() + "por el servicio premium de Twitsh");
	    break;
	}
	return contrato;
    }
    
    @Override protected void cobrar(Cliente cliente){
	ContratoTwitsh contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio, pobre: " + cliente.persona.nombre);
	}else{
	    contrato.realizarCobro(cliente.persona);
	}
    }

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
