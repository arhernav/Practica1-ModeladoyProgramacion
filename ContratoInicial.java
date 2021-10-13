public class ContratoInicial implements ContratoThisney{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(120);
    }

    @Override public int conocerMonto(){
	return 120;
    }
    
}
