package EJ2B;

public class ThreadDeposito implements Runnable {

    private CuentaBanco cuentaBanco;
    private double deposito;

    public ThreadDeposito(CuentaBanco vCuentaBanco, double vDeposito) {
		this.cuentaBanco=vCuentaBanco;
		this.deposito=vDeposito;
		
	}

    @Override
    public void run() {

        synchronized (this.cuentaBanco) {
            this.cuentaBanco.depositar(deposito);
        }

    }

}
