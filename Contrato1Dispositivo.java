/**
 * Contrato de un dispositivo para Memeflix
 */
public class Contrato1Dispositivo implements ContratoMemeflix{

    /**
     * Realiza un cobro de 100 a la persona dada
     * @param Persona Persona a la que se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(100);
    }

    /**
     * Da a conocer el monto que cobra el contrato
     * @return int Entero igual al monto a cobrar
     */
    @Override public int conocerMonto(){
	return 100;
    }
    
}
