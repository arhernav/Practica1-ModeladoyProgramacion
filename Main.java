public class Main{
    public static void main(String[] args){
	Memeflix memeflix = new Memeflix();
	Momazon momazon = new Momazon();
	HVOMax hvo = new HVOMax();
	Twitsh twitsh = new Twitsh();
	ThisneyPlus thisney = new ThisneyPlus();

	Persona alicia = new Persona("Alicia", 12000);
	Persona bob  = new Persona("Bob", 700);
	Persona cesar = new Persona("Cesar", 5000);
	Persona diego = new Persona("Diego", 7000);
	Persona erika = new Persona("Erika", 9000);

	//Mes 1
	System.out.println("Mes 1");
	//Alicia
	memeflix.agrega(alicia, 3);
	momazon.agrega(alicia, 2);
	hvo.agrega(alicia, 1);
	twitsh.agrega(alicia, 2);
	thisney.agrega(alicia, 1);
	System.out.println();
	//Bob
	memeflix.agrega(bob, 3);
	momazon.agrega(bob, 2);
	hvo.agrega(bob, 1);
	twitsh.agrega(bob, 2);
	thisney.agrega(bob, 1);
	System.out.println();
	//Cesar
	thisney.agrega(cesar, 1);
	hvo.agrega(cesar, 1);
	System.out.println();
	//Diego
	memeflix.agrega(diego, 2);
	momazon.agrega(diego, 2);
	System.out.println();
	//Erika
	memeflix.agrega(erika, 3);
	twitsh.agrega(erika, 1);
	hvo.agrega(erika, 1);
	System.out.println();

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 1
	
	//Mes 2
	System.out.println("Mes 2");

	//Diego
	twitsh.agrega(diego, 1);
	
	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 2
	
	//Mes 3
	System.out.println("Mes 3");
	//Diego
	thisney.agrega(diego, 1);
	memeflix.remueve(diego);

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 3
	
	//Mes 4
	System.out.println("Mes 4");
	memeflix.agrega(diego, 3);

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 4
	
	//Mes 5
	System.out.println("Mes 5");
	memeflix.remueve(erika);
	momazon.agrega(erika, 2);
	twitsh.remueve(erika);
	twitsh.agrega(erika, 2);

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 5
	
	//Mes 6
	System.out.println("Mes 6");

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 6
	//Mes 7
	System.out.println("Mes 7");

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 7
	
	//Mes 8
	System.out.println("Mes 8");
	memeflix.remueve(erika);
	twitsh.remueve(erika);
	hvo.remueve(erika);
	momazon.remueve(erika);

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 8
	
	//Mes 9
	System.out.println("Mes 9");

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 9
	
	//Mes 10
	System.out.println("Mes 10");
	thisney.agrega(erika, 1);
	
	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 10
	
	//Mes 11
	System.out.println("Mes 11");
	
System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 11
	
	//Mes 12
	System.out.println("Mes 12");

	System.out.println();
	memeflix.notifica();
	System.out.println();
	momazon.notifica();
	System.out.println();
	hvo.notifica();
	System.out.println();
	twitsh.notifica();
	System.out.println();
	thisney.notifica();
	System.out.println();
	System.out.println();
	//Fin de mes 12
    }
    
}
