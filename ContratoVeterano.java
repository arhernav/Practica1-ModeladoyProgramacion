public class ContratoVeterano implements ContratoThisney{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(150);
    }

    @Override public int conocerMonto(){
	return 150;
    }
    
}
