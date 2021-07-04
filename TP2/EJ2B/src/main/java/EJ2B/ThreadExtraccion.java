package EJ2B;

public class ThreadExtraccion implements Runnable {

	private CuentaBanco cuentaBanco;
	private double extraccion;
	
	public ThreadExtraccion(CuentaBanco vCuentaBanco, double vExtraccion) {
		this.cuentaBanco = vCuentaBanco;
		this.extraccion = vExtraccion;
	}

	@Override
	public void run() {
		synchronized (this.cuentaBanco) {
				this.cuentaBanco.extraer(extraccion);
		}
		
	}

}
