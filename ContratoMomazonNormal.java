/**
 * Contrato normal para Momazon
 */
public class ContratoMomazonNormal implements ContratoMomazon{

    /**
     * Realiza el cobro designado
     * @param Persona Persona a la que se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(120);
    }

    /**
     * Da a conocer el monto a cobrar
     * @return int int igual  al  cobro designado
     */
    @Override public int conocerMonto(){
	return 120;
    }
    
}
