import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Ejercicio4EscribirArchivo {

    public static void main(String[] args) {
        
        File f = new File("empleado.txt");

        Ejercicio4Empleado e1 = new Ejercicio4Empleado("Jose", "2547", "1945");
        Ejercicio4Empleado e2 = new Ejercicio4Empleado( "Carlos", "6574", "1954");

        escrbirElArchivo(f, e1.toString());
        escrbirElArchivo(f, e2.toString());
        


    }

    public static void escrbirElArchivo(File f, String empleado){

        try {

            if ( !f.exists()){

                    f.createNewFile();
            }

            BufferedWriter archivoEscribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), "utf-8"));

            archivoEscribe.write(empleado + "\r\n");

            archivoEscribe.close();



            
        } catch (Exception e) {
            //TODO: handle exception
        }


    }

    
}
