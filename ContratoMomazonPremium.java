public class ContratoMomazonPremium implements ContratoMomazon{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(160);
    }

    @Override public int conocerMonto(){
	return 160;
    }
    
}
