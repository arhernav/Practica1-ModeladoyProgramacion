
public class Main{
    public static void main(String[] args){

	ThisneyPlus thisney = new ThisneyPlus();
	Persona alicia = new Persona("alicia ", 1000);
	thisney.agrega(alicia, 1);
	thisney.mostrarClientesActivos();

	System.out.println();
	System.out.println("mes 1");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);

	System.out.println();
	System.out.println("mes 2");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);

	System.out.println();
	System.out.println("mes 3");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);

	System.out.println();
	System.out.println("mes 4");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);
	thisney.notifica();
	System.out.println("realizamos el cobro");
	thisney.mostrarClientesActivos();
	System.out.println(alicia);
    }
    
}
