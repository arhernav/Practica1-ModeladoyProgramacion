public class Contrato1Dispositivo implements ContratoMemeflix{

    @Override public void realizarCobro(Persona persona){
	persona.cuenta.retiro(100);
    }

    @Override public int conocerMonto(){
	return 100;
    }
    
}
