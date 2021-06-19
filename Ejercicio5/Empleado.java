import java.time.LocalDate;
import java.time.Period;

public class Empleado {

    String nombre;
    String apellido;
    LocalDate fechaNaciminto;
    double salario;
    
    public Empleado(String nombre, String apellido, LocalDate fechaNaciminto, double salario) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNaciminto  = fechaNaciminto;
        this.salario = salario;

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "Nombre: " + this.nombre  + " - Apellido: " + this.apellido + " - Fecha De Ncimiento: " + String.valueOf(this.fechaNaciminto+" - Salario: " + this.salario) ;
    }

    public String getApellido() {
        return apellido;
    }

   

}