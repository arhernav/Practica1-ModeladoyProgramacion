public class ContratoHVO implements ContratoHVOMax{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(130);
    }

    @Override public int conocerMonto(){
	return 130;
    }
    
}
