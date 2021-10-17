/**
 * Contrato de dos dispositvos para memeflix
 */
public class Contrato2Dispositivos implements ContratoMemeflix{

    /**
     * Realiza el cobro acordado
     * @param Persona Persona a la cual se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(150);
    }

    /**
     * Da a conocer el monto a cobrar
     * @return int int igual al monto a cobrar
     */
    @Override public int conocerMonto(){
	return 150;
    }
    
}
