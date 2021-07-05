package EJ2A;

public class ThreadExtraccion implements Runnable {

	private CuentaBanco cuentaBanco;
	private double extraccion;
	private int id_client;
	
	public ThreadExtraccion(CuentaBanco vCuentaBanco, double vExtraccion, int vID_client) {
		this.cuentaBanco = vCuentaBanco;
		this.extraccion = vExtraccion;
		this.id_client = vID_client;

	}

	@Override
	public void run() {

				this.cuentaBanco.extraer(extraccion, id_client);
		
		
	}

}
