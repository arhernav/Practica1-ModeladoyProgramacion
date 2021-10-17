/**
 * Contrato de prueba de HVO Max
 */
public class ContratoHVOPrueba implements ContratoHVOMax{

    /**
     * Realiza el cobro acordado
     * @param Persona Persona a la cual se le realiza el cobro
     */
    @Override public void realizarCobro(Persona persona){
	return;
    }

    /**
     * Da a conocer el monto a  cobrar
     * @return int int igaul al  monto a cobrar
     */
    @Override public int conocerMonto(){
	return 0;
    }
    
}
