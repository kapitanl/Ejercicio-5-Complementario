import java.io.FileReader;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Datos {

    public static void main(String[] args) {

        // Crando  lista "empleados".
        List<String> empleados = new ArrayList<>();

        // Funcio que lee el archivo "txt" por linea y lo guarda en una lista. Pasa por parametros la "ruta" y la lista "empleados"
        cargarLista(empleados);

        // Funcion que separa la cadena de texto de la lista "empleados" y lo guarda en su formato correspondiente, para luego crear los objetos "empleado".
        crearEmpleado(empleados);

        String letra= "M";
        devolverEmpleadosSegun(letra, empleados);

        getEmpleadoMasJovenYMasViejo(empleados);

        getEmpleadoQueMasGanaYElQueMenos(empleados);


       

    }


    // -------------------- --------------------------- FUNCIONES ---------------------------------------------




    private static void getEmpleadoQueMasGanaYElQueMenos(List<String> empleados) {

        System.out.println();
        List<Double> salarios = new ArrayList<>();

        for (String empl : empleados) {

            double salario =  Double.parseDouble(empl.split(",")[3]);

            salarios.add(salario);
            
        }

        Collections.sort(salarios);

        int ult = salarios.size()-1;
        System.out.println("El que mas gana: $"+ salarios.get(ult));

        System.out.println("El que menos gana: $"+ salarios.get(0));

    }




    private static void getEmpleadoMasJovenYMasViejo(List<String> empleados) {

        System.out.println();
        List<Integer> edades = new ArrayList<>();

        for (String empl : empleados) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNaciminto =  LocalDate.parse(empl.split(",")[2], formato);

            LocalDate fechaActual = LocalDate.now();

            Period edad = Period.between(fechaNaciminto, fechaActual);
            System.out.println();
            int edadString = edad.getYears();

            edades.add(edadString);
    
            
        }

        Collections.sort(edades);
        System.out.println(edades);
        
        System.out.println("El mas joven tiene: "+ edades.get(0));
        int ult = edades.size()-1;
        System.out.println("El mas viejo tiene: "+ edades.get(ult));

    }




    private static void devolverEmpleadosSegun(String letra, List<String> empleados) {
        System.out.println("Los empleados que segun su Apellido empice con la letra: " + letra + " son: "  );
        for (String empl : empleados) {

            String ap = empl.split(",")[1];

            char le = letra.charAt(0);
            
            if ( le == ap.charAt(0)){
                System.out.println("Empleado: " + empl);
            }
        

        }
        System.out.println();
    }




    private static void crearEmpleado(List<String> empleados) {
        // Creando un array "empleado" para luego asignarlos en el bucle "for"
        int sise = empleados.size();
        Empleado empleado[] = new Empleado[sise];

        int cont = 0;

        // Recorre la lista empleados
        for (String empl : empleados) {

            System.out.println("Separando los datos de la lista...");
            // Separa la cadena de texto de la lista empleado segun su formato
            String nombre = empl.split(",")[0];
            System.out.println("....");

            String apellido = empl.split(",")[1];
            System.out.println("....");

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNaciminto =  LocalDate.parse(empl.split(",")[2], formato);
            System.out.println("....");

            double salario =  Double.parseDouble(empl.split(",")[3]);

            System.out.println("Datos separados.");

            // Creando empleado
            System.out.println("Creando y cargando los datos al objeto emplado...");
            empleado[cont] = new Empleado(nombre, apellido, fechaNaciminto, salario);
             System.out.println("Objeto empleado creado");
            System.out.println("Emplado " + cont + " - " + empleado[cont].toString());
            cont += 1;
            
        }

        System.out.println("Proceso terminado.");
        System.out.println();
    }




    private static void cargarLista(List<String> empleados) {

        // Ruta del archivo, se guarda en una variable "ruta".
        String ruta= "empleados.txt";
        try {
            
            String contenido;

            FileReader archivo = new FileReader(ruta);
            BufferedReader b = new BufferedReader(archivo);
            
            System.out.println("Lellendo archivo.....");
            while ( (contenido = b.readLine() ) != null) {

                System.out.println("Cargando datos a la lista...");
                empleados.add(contenido);
                
            }

            b.close();

            System.out.println("Datos cargado.");  
           
        }catch (IOException e){

            e.printStackTrace();
        }

        System.out.println();

    }
   
    
}
