import java.io.FileReader;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Datos {

    public static void main(String[] args) {


        // Crando  lista "empleados".
        List<String> empleados = new ArrayList<>();

        // Funcio que lee el archivo "txt" por linea y lo guarda en una lista. Pasa por parametros la "ruta" y la lista "empleados"

        System.out.println("------------------------------------cargarLista------------------------------------------------------------");
        cargarLista(empleados);

        System.out.println("----------------------------------------crearEmpleado--------------------------------------------------------");

        // Funcion que separa la cadena de texto de la lista "empleados" y lo guarda en su formato correspondiente, para luego crear los objetos "empleado".
        crearEmpleado(empleados);

    

        System.out.println("----------------------------------------devolverEmpleadosSegun--------------------------------------------------------");

        String letra= "M";
        devolverEmpleadosSegun(letra, empleados);

        System.out.println("---------------------------------------- getEmpleadoMasJovenYMasViejo--------------------------------------------------------");

        getEmpleadoMasJovenYMasViejo(empleados);

        System.out.println("-----------------------------------------getEmpleadoQueMasGanaYElQueMenos-------------------------------------------------------");

        getEmpleadoQueMasGanaYElQueMenos(empleados);


       

    }


    // -------------------- --------------------------- FUNCIONES ---------------------------------------------


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
   
    

    private static void crearEmpleado(List<String> empleados) {
        // Creando un array "empleado" para luego asignarlos en el bucle "for"
        int sise = empleados.size();
        Empleado[] empleado = new Empleado[sise];

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
            cont += 1;

            System.out.println();
            
        }
        System.out.println("Ya se han creado todos los objetos.");
        System.out.println();
        System.out.println("Mostrando lista de empleados creados.");
        for (Empleado empl: empleado) {

            System.out.println(empl.toString());
            
        }

        System.out.println("Proceso terminado.");
        System.out.println();
    }



    private static void getEmpleadoQueMasGanaYElQueMenos(List<String> empleados) {

        System.out.println();
        List<Double> salarios = new ArrayList<>();
        Map<Double, String> empleadosSalarios= new HashMap<>();

        for (String empl : empleados) {

            double salario =  Double.parseDouble(empl.split(",")[3]);

            salarios.add(salario);

            empleadosSalarios.put(salario, empl.split(",")[0]);
            
        }

        Collections.sort(salarios);

        int ult = salarios.size()-1;

        for ( Map.Entry<Double, String> registro: empleadosSalarios.entrySet()) {


            if ( registro.getKey().equals(salarios.get(0))){
                System.out.println("El que menos gana es: "+ registro.getValue() + ". Con "+registro.getKey()+ "$.");

            }
            if (registro.getKey().equals(salarios.get(ult))){
                System.out.println("El que mas gana es: "+ registro.getValue() + ". Con "+registro.getKey()+ "$.");
            }
            
            
        }

    }




    private static void getEmpleadoMasJovenYMasViejo(List<String> empleados) {

        System.out.println();
        List<Integer> edades = new ArrayList<>();
        Map<Integer, String> empleadosEdades= new HashMap<>();

        for (String empl : empleados) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNaciminto =  LocalDate.parse(empl.split(",")[2], formato);

            LocalDate fechaActual = LocalDate.now();

            Period edad = Period.between(fechaNaciminto, fechaActual);
            System.out.println();
            int edadInt = edad.getYears();

            edades.add(edadInt);

            empleadosEdades.put(edadInt, empl.split(",")[0]);
    
            
        }

        Collections.sort(edades);
        
        
        int ult = edades.size()-1;
        for ( Map.Entry<Integer, String> registro: empleadosEdades.entrySet()) {

            if (edades.get(0)== registro.getKey()){
                System.out.println("El mas joven es: "+ registro.getValue() + ". Con "+registro.getKey()+ " Años.");

            }
            if (edades.get(ult)== registro.getKey()){
                System.out.println("El mas viejo es: "+ registro.getValue() + ". Con "+registro.getKey()+ " Años.");
            }
            
            
        }


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




    



}
