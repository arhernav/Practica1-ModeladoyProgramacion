public class ContratoMomazonNormal implements ContratoMomazon{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(120);
    }

    @Override public int conocerMonto(){
	return 120;
    }
    
}
