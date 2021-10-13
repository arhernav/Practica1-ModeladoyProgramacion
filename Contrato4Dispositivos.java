public class Contrato4Dispositivos implements ContratoMemeflix{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(180);
    }

    @Override public int conocerMonto(){
	return 180;
    }
    
}
