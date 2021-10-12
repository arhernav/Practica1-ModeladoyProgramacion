
public class Main{
    public static void main(String[] args){

	ThisneyPlus thisney = new ThisneyPlus();
	Persona alicia = new Persona("alicia ", 1000);
	System.out.println(alicia);
	thisney.agrega(alicia, 1);
	thisney.actualizaMesesClientes();
	thisney.actualizaMesesClientes();
	thisney.actualizaMesesClientes();
	System.out.println("Clientes activos antes de eliminar");
	thisney.mostrarClientesActivos();
	System.out.println();
	System.out.println("exclientes antes de eliminar");
	thisney.mostrarExClientes();
	System.out.println();
	System.out.println();
	thisney.agrega(alicia, 1);
	System.out.println("Clientes activos tras tratar de agregar otra vez");
	thisney.mostrarClientesActivos();
	System.out.println("exClientes activos tras tratar de agregar otra vez");
	thisney.mostrarExClientes();
	System.out.println();
	System.out.println();
	thisney.remueve(alicia);
	System.out.println("Clientes activos despues de eliminar");
	thisney.mostrarClientesActivos();
	System.out.println("exclientes despues de eliminar");
	thisney.mostrarExClientes();
	System.out.println();
	System.out.println();
	thisney.agrega(alicia, 1);
	System.out.println("Clientes activos tras tratar de agregar otra vez");
	thisney.mostrarClientesActivos();
	System.out.println("exClientes activos tras tratar de agregar otra vez");
	thisney.mostrarExClientes();
	
    }
    
}
