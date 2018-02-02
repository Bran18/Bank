

package banco;


public class Cliente {

    String cedula, nombre, apellido;

    public Cliente() {

    }

    public Cliente(String cedula, String nombre, String apellido) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;

    }//fin constructor

    public String ToString() {
        String datos;
        datos = cedula + " " + nombre + " " + apellido;

        return datos;
    }

}