
public class Main{
    public static void main(String[] args){

	Momazon thisney = new Momazon();
	Persona alicia = new Persona("alicia ", 1000);
	Persona jake = new Persona("jake",  400);
	thisney.agrega(alicia, 2);
	thisney.agrega(jake, 1);
	thisney.mostrarClientesActivos();

	System.out.println();
	System.out.println("mes 1");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);

	
	System.out.println();
	System.out.println("mes 2");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);

	System.out.println();
	System.out.println("mes 3");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);

	System.out.println();
	System.out.println("mes 4");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);

	System.out.println();
	System.out.println("mes 5");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);

	System.out.println();
	System.out.println("mes 6");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	thisney.mostrarExClientes();
	System.out.println(alicia);
	System.out.println(jake);
	
    }
    
}
