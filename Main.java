
public class Main{
    public static void main(String[] args){

	ThisneyPlus thisney = new ThisneyPlus();
	Persona alicia = new Persona("alicia ", 1000);
	System.out.println(alicia);
	thisney.agrega(alicia, 1);
	thisney.mostrarClientesActivos();
	thisney.remueve(alicia);
	thisney.mostrarExClientes();
	
    }
    
}
