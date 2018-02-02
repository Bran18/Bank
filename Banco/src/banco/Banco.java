
package banco;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Banco {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static int ptamano = 2;
	static CapaLogica Cl = new CapaLogica(ptamano);

	public static void main(String[] args) throws java.io.IOException {
		int opc;
		boolean noSalir = true;

		do {
			mostrarMenu();
			opc = leerOpcion();
			noSalir = ejecutarAccion(opc);
		} while (noSalir);

		// TODO code application logic here
	}

	static void mostrarMenu() {

		out.println();
		out.println("1.  Crear tamaños");
		out.println("2.  Crear Cliente");
		out.println("3.  Listar Cliente");
		out.println("4.  Buscar Cliente.");
		out.println("5.  Crear  Cuenta.");
		out.println("6.  Listar  Cuenta.");
		out.println("7.  Salir");
		out.println();
	}

	static int leerOpcion() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opción: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	static boolean ejecutarAccion(int popcion) throws java.io.IOException {

		boolean noSalir = true;
		String identificacion;

		String nombre;
		String apellido;

		switch (popcion) {
		
		case 1: tamannoArreglo();
		break;
			
			

		case 2: // Crear la cuenta

			out.println();
			out.println("Ingrese el nombre del cliente ");
			nombre = in.readLine();

			out.println("Ingrese su identificacion ");
			identificacion = in.readLine();

			out.println("Ingrese el apellido del cliente  ");
			apellido = in.readLine();

			Cl.crearCliente(identificacion, nombre, apellido);
			break;

		case 3:// Listar Cliente
			listarCliente();

			break;

		case 4:// Hacer retiro

			buscarCliente();
			break;

		case 5: // Crear cuenta

			crearCuenta();
			break;
		case 6:// listar cuenta
			listarCuenta();

		case 7: // Salir

			noSalir = false;
			break;

		default: // Cualquier otro valor dado por el usuario se considera inválido

			out.println("Opcion inválida");
			out.println();
			break;
		}
		return noSalir;
	}

	public static void tamannoArreglo() throws IOException {

		out.println("Ingrese el tamaño del array");
		int tamano = Integer.parseInt(in.readLine());
		Cl.iniListaSetTamanoCuenta(tamano);
	}

	static void listarCliente() {
		Cliente[] listadoClientes;
		listadoClientes = Cl.devolverClientes();

		for (int i = 0; i < listadoClientes.length; i++) {
			out.println("Los clientes son" + " " + listadoClientes[i].ToString());
		}

	}// fin del metodo listarCliente

	static boolean buscarCliente() throws IOException {
		boolean registrar = false;
		String identificacion;
		out.println("Ingrese el Cliente");
		identificacion = in.readLine();

		Cliente[] listaClientes;
		listaClientes = Cl.devolverClientes();

		for (int i = 0; i < listaClientes.length; i++) {
			if (listaClientes[i].cedula.equals(identificacion)) {
				registrar = true;
				out.println("Cliente" + " " + listaClientes[i].nombre);
			}
		}

		return registrar;
	}

	static void crearCuenta() throws IOException {
		int numeroCuenta;
		double saldo;
		String fecha;

		out.println("Digite el número de cuenta");
		numeroCuenta = Integer.parseInt(in.readLine());

		out.println("Digite el saldo incial");
		saldo = Integer.parseInt(in.readLine());

		out.println("Digite la fecha \"yyyy-MM-dd HH:mm\"");
		fecha = in.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
		String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"

		Cl.crearCuenta(numeroCuenta, saldo, formattedDateTime);

	}// fin del metodo crearCuenta

	static void listarCuenta() {
		Cuenta[] listaCuentas;
		listaCuentas = Cl.devolverCuenta();

		for (int i = 0; i < listaCuentas.length; i++) {
			out.println("Las cuentas son " + " " + listaCuentas[i].ToString());
			try {
				out.println("Las cuentas son " + " " + listaCuentas[i].ToString());
			} catch (Exception ex) {
			}

		}

	}

}