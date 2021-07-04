package EJ2A;

public class ThreadDeposito implements Runnable {

    private CuentaBanco cuentaBanco;
    private double deposito;

    public ThreadDeposito(CuentaBanco vCuentaBanco, double vDeposito) {
		this.cuentaBanco=vCuentaBanco;
		this.deposito=vDeposito;
		
	}

    @Override
    public void run() {

        this.cuentaBanco.depositar(deposito);

    }

}
