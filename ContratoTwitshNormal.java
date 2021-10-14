public class ContratoTwitshNormal implements ContratoTwitsh{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(60);
    }

    @Override public int conocerMonto(){
	return 60;
    }
    
}
