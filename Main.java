public class Main{
    public static void main(String[] args){
	Memeflix memeflix = new Memeflix();
	Momazon momazon = new Momazon();
	HVOMax hvo = new HVOMax();
	Twitsh titsh = new Twitsh();
	ThisneyPlus thisney = new ThisneyPlus();

	Persona alicia = new Persona("Alicia", 100);
	Persona bob  = new Persona("Bob", 700);
	Persona cesar = new Persona("Cesar", 5000);
	Persona diego = new Persona("Diego", 7000);
	Persona erika = new Persona("Erika", 9000);

	//Mes 1
	memeflix.agrega(alicia, 1);
	memeflix.notifica();
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();

	memeflix.mostrarClientesActivos();
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();

	memeflix.notifica();
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();
	memeflix.notifica();
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();
	memeflix.notifica();
	memeflix.mostrarClientesActivos();
	memeflix.mostrarExClientes();
	memeflix.notifica();
	
    }
    
}
