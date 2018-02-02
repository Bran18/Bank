package banco;

public class Cuenta {

    int numerocuenta;
    double saldo;
    String fecha;

    public Cuenta() {
    }

//constructor
    public Cuenta(int numeroCuenta, double saldo, String fecha) {
        this.numerocuenta = numeroCuenta;
        this.saldo = saldo;
        this.fecha = fecha;
    }//fin constructor

    public String ToString() {
        String info;
        info = numerocuenta + " " + saldo + " " + fecha;

        return info;
    }

}