public class Contrato2Dispositivos implements ContratoMemeflix{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(150);
    }
    
    @Override public int conocerMonto(){
	return 150;
    }
    
}
