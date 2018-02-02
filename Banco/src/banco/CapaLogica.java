package banco;


public class CapaLogica {

    Cuenta nuevaCuenta[];
    Cliente nuevoCliente[];

    static int contador = 0;
    static int contadorCuenta = 0;

    public CapaLogica() {

    }

    public CapaLogica(int tamano) {
        nuevaCuenta = new Cuenta[tamano];
        nuevoCliente = new Cliente[tamano];
    }
    
    public void iniListaSetTamanoCuenta(int _tamano) {
		nuevaCuenta = new Cuenta[_tamano];
		nuevoCliente= new Cliente[_tamano];
	}

    public void crearCliente(String cedula, String nombre, String apellido) {

        Cliente miCliente = new Cliente();

        miCliente.nombre = nombre;
        miCliente.cedula = cedula;
        miCliente.apellido = apellido;

        nuevoCliente[contador] = miCliente;
        contador++;

    }

    public void crearCuenta(int numeroCuenta, double saldo, String formattedDateTime) {

        Cuenta miCuenta = new Cuenta();

        miCuenta.numerocuenta = numeroCuenta;
        miCuenta.saldo = saldo;
        miCuenta.fecha = formattedDateTime;

        nuevaCuenta[contadorCuenta] = miCuenta;
        contadorCuenta++;

    }

    public Cliente[] devolverClientes() {

        return nuevoCliente;
    }

    public Cuenta[] devolverCuenta() {

        return nuevaCuenta;
    }
}