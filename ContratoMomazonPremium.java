/**
 * Contrato premium para Momazon
 */
public class ContratoMomazonPremium implements ContratoMomazon{

    /**
     * Realiza el cobro designado
     * @param Persona Persona a la que se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(160);
    }

    /**
     * Da a conocer el monto  a cobrar
     * @return  int int igual al monto a cobrar
     */
    @Override public int conocerMonto(){
	return 160;
    }
    
}
