public class ContratoVeterano implements ContratoThisney{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(150);
    }
    
}
