package EJ2A;

public class ThreadDeposito implements Runnable {

    private CuentaBanco cuentaBanco;
    private double deposito;
    private int id_client;

    public ThreadDeposito(CuentaBanco vCuentaBanco, double vDeposito, int vID_client) {
		this.cuentaBanco=vCuentaBanco;
		this.deposito=vDeposito;
        this.id_client = vID_client;
		
	}

    @Override
    public void run() {
        this.cuentaBanco.depositar(deposito, id_client);

    }

}
