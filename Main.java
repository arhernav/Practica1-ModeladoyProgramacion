public class Main{
    public static void main(String[] args){
        Memeflix memeflix = new Memeflix();
	Persona alicia = new Persona("alicia", 10000);
	memeflix.agrega(alicia, 1);

	System.out.println(alicia);
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();
	memeflix.notifica();
	memeflix.notifica();

	memeflix.remueve(alicia);
	System.out.println(alicia);
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();
	System.out.println();

	memeflix.agrega(alicia, 2);
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();
	System.out.println(alicia);

	
    }
    
}
