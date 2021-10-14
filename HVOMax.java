import java.util.ArrayList;
public class HVOMax extends Servicio implements Sujeto{

    public HVOMax(){
	this.clientesActivos = new ArrayList<Cliente>();
	this.exClientes = new ArrayList<Cliente>();
    }

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
	    System.out.println("Bienvenido a HVO Max " + persona.nombre);
	}else{
	    this.clientesActivos.add(clienteNuevo);
	    System.out.println("Bienvenido nuevamente a HVO max " + persona.nombre);
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
    
    protected ContratoHVOMax checarContrato(Cliente cliente){
	ContratoHVOMax contrato;
	if(cliente.meses <= 3){
	    contrato = new ContratoHVOPrueba();
	    System.out.println(cliente.persona.nombre + "paga: "+ contrato.getMonto + "por la prueba de HVO Max");
	    return  Contrato;
	}
	contrato = new ContratoHVO();
	System.out.println(cliente.persona.nombre + "paga: "+ contrato.getMonto + "por el servicio de HVO Max");
	return contrato;
    }
    
    @Override protected void cobrar(Cliente cliente){
	ContratoHVOMax contrato = this.checarContrato(cliente);
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
	    System.out.println(cliente.persona.nombre + " lleva usando HVO Max por: " + cliente.meses);
	}
	for(Cliente cliente: this.exClientes){
	    if(this.clientesActivos.contains(cliente)) this.clientesActivos.remove(cliente);
	}
    }
	
    
}
