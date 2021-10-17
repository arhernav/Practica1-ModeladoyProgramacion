/**
 * Contrato de para Twitsh
 */
public class ContratoTwitshNormal implements ContratoTwitsh{

    /**
     * Realiza el cobro designado
     * @param Persona Persona a la que se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(60);
    }

    /**
     * Da a conocer el monto a cobrar
     * @return int int igual al monto a cobrar
     */
    @Override public int conocerMonto(){
	return 60;
    }
    
}
