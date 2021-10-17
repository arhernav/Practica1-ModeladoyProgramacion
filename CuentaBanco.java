/**
 * Clase para manejar el dinero de una persona
 */
public class CuentaBanco{
    /* Cantidad de dinero que tienen */
    public int dinero;
    
    /**
     * Crea un objeto de la clase CuentaBanco
     * @param int Cantidad de dinero con la que se crea la cuenta de banco
     */
    protected CuentaBanco(int dineroInicial){
	this.dinero = dineroInicial;
    }

    /**
     * Resta dinero de la cuenta
     * @param int Cantidad a restar de la cuenta
     */
    protected void retiro(int cantidadRetirada){
	if(this.dinero - cantidadRetirada <= 0){
	    this.dinero = 0;
	}else{
	    this.dinero = this.dinero - cantidadRetirada;
	}
    }

    /**
     * Devuelve la cantidad de dinero de la cuenta
     * @return  int Cantidad de dinero de la cuenta
     */
    public int getDinero(){
	return this.dinero;
    }
    
}
