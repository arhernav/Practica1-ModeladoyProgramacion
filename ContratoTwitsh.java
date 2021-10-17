/**
 * Interfaz para asegurar el contrato de Twitsh
 */
public interface ContratoTwitsh{

    /**
     * Realiza el cobro designado
     * @param Persona Persona a la que se le realiza el cobro
     */
    public void realizarCobro(Persona persona);

    /**
     * Da a conocer el monto a cobrar
     * @return int int igual al monto a cobrar
     */
    public int conocerMonto();
    
}
