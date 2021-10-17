/**
 * Interface con los metodos para implementar el patron Observer
 */
public interface Sujeto{

    /**
     * Envia notificacion de los cambios a los opbservadores
     */
    public void notifica();

    /**
     * Agrega un nuevo observador
     */
    public void agrega(Persona p, int contrato);

    /**
     * Remueve uno de los observadores
     */
    public void remueve(Persona p);
    
}
