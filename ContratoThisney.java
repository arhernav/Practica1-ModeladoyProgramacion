/**
 * Interfaz para asegurar el contrato Thisney
 */
public interface ContratoThisney{

    /**
     * Realiza el cobro designado
     * @param Persona Persona a la que se le realiza el cobro
     */
    public void realizarCobro(Persona persona);

    /**
     * Da a conocer  el monto a cobrar
     * @return int int igual al monto a cobrar
     */
    public int conocerMonto();
    
}
