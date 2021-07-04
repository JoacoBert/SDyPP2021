package EJ2A;

public class ThreadExtraccion implements Runnable {

	private CuentaBanco cuentaBanco;
	private double extraccion;
	
	public ThreadExtraccion(CuentaBanco vCuentaBanco, double vExtraccion) {
		this.cuentaBanco = vCuentaBanco;
		this.extraccion = vExtraccion;
	}

	@Override
	public void run() {

				this.cuentaBanco.extraer(extraccion);
		
		
	}

}
