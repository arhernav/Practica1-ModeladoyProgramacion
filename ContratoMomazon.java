/**
 * Interfaz para asegurar un contrato de Momazon
 */
public interface ContratoMomazon{

    /**
     * Realiza el cobro acordado
     * @param Persona Persona a la cual se le realiza el cobro
     */
    public void realizarCobro(Persona persona);

    /**
     * Da a conocer el monto a cobrar
     * @return int int igual al monto a cobrar
     */
    public int conocerMonto();
    
}
