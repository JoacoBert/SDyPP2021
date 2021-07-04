package EJ2B;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class CuentaBanco {
    
	//private final static Logger log = LoggerFactory.getLogger(CuentaBanco.class);
	private double balance;
	
	public CuentaBanco(double balance) {
		this.balance=balance;
		//log.info("La cuenta bancaria fue creada");
		System.out.println("La cuenta bancaria fue creada");
    }
	
	public double getBalance() {
		return this.balance;
	}
	
	public void depositar(double dineroDeposito) {
		try {
			Thread.sleep(80);
			this.balance += dineroDeposito;
			System.out.println("Deposito exitoso");
			//log.info("Deposito exitoso");
			System.out.println("Su balance es de " + balance);
		} catch (InterruptedException e) {
			System.err.println("Error - " + e.getMessage());
			//log.error("Error - " + e.getMessage());
		}
		
	}
	
	public void extraer(double dineroExtraccion) {
		try {
			Thread.sleep(60);
				if (balance>=dineroExtraccion) {
					balance -= dineroExtraccion;
					System.out.println("Extraccion exitosa");
					//log.info("Extraccion exitosa");
        			System.out.println("Su balance es de " + balance);
				}else {
					System.out.println("Su balance es insuficiente para realizar esta accion");
				}
		} catch (InterruptedException e) {
			System.out.println("Error - " + e.getMessage());
			//log.error("Error - " + e.getMessage());
		}
	}
}
