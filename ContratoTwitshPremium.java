public class ContratoTwitshPremium implements ContratoTwitsh{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(90);
    }

    @Override public int conocerMonto(){
	return 90;
    }
    
}
