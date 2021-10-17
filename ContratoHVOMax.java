/**
 * Interfaz para asegurar los contratos de HVO Max
 */
public interface ContratoHVOMax{

    /**
     * Realiza el cobro acordado
     * @param Persona Persona a la cual se le realiza el cobro
     */
    public void realizarCobro(Persona persona);

    /**
     * Da a conocer el monto a cobrar
     * int int igual al monto a cobrar
     */
    public int conocerMonto();
    
}
