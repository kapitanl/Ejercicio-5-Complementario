public class Ejercicio4Empleado {

    String nombre;
    String dni;
    String fechaNacimiento;

    public Ejercicio4Empleado(String nombre, String dni, String fechaNaciminto){

        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNaciminto;

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.nombre + " - " + this.dni + " - " + this.fechaNacimiento;
    }
    
}
