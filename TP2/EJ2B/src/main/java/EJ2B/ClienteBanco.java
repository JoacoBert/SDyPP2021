package EJ2B;

public class ClienteBanco implements Runnable {

    private int id_client;
    private double extraccion;
    private double deposito;
    private CuentaBanco cuentaBanco;

    public ClienteBanco(int id_client, double vExtraccion, double vDeposito, CuentaBanco vCuentaBanco ) {
		super();
		this.id_client = id_client;
		this.extraccion = vExtraccion;
		this.deposito = vDeposito;
		this.cuentaBanco = vCuentaBanco;
	}

    public String clienteToString() {
        return ("Cliente: " + id_client + ", Extraccion: " + extraccion + ", Deposito:" + deposito);
    }

    public double diferencia() {
        return deposito - extraccion;
    }

    @Override
    public void run() {
        ThreadDeposito threadDeposit = new ThreadDeposito(cuentaBanco, deposito);
        ThreadExtraccion threadExtract = new ThreadExtraccion(cuentaBanco, extraccion);
        Thread tThreadDeposit = new Thread(threadDeposit);
        Thread tThreadExtract = new Thread(threadExtract);
        tThreadDeposit.start();
        tThreadExtract.start();
    }

}
