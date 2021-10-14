import java.util.ArrayList;
public class Momazon extends Servicio implements Sujeto{

    public Momazon(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
    }

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

    protected ContratoMomazon checarContrato(Cliente cliente){
	ContratoMomazon contrato;
	switch (cliente.contrato){
	case 1: contrato = new ContratoMomazonNormal();
	    break;
	case 2: contrato = new ContratoMomazonPremium();
	    break;
	default: contrato = new ContratoMomazonNormal();
	    break;
	}
	return contrato;
    }

    @Override protected void cobrar(Cliente cliente){
	ContratoMomazon contrato = this.checarContrato(cliente);
	if(cliente.persona.cuenta.dinero - contrato.conocerMonto() < 0){
	    this.exClientes.add(cliente);
	    System.out.println("Lamentamos que hayas dejado  el serivicio, pobre: " + cliente.persona.nombre);
	}else{
	    contrato.realizarCobro(cliente.persona);
	}
    }
    
    @Override public void notifica(){
	this.actualizaMesesClientes();
	//Para cada cliente, si puede hacer el cobro, lo realiza, si no, lo agrega a exclientes
	for(Cliente cliente: this.clientesActivos){
	    this.cobrar(cliente);
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }
} 