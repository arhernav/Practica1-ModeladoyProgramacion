/**
 * Contrato de 4 dispositivos para memeflix
 */
public class Contrato4Dispositivos implements ContratoMemeflix{

    /**
     * Realiza el cobro acordado
     * @param Persona Persona a la cual se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(180);
    }

    /**
     * Da a conocer el monto  a cobrar
     * @return int int igual al monto a cobrar
     */
    @Override public int conocerMonto(){
	return 180;
    }
    
}
