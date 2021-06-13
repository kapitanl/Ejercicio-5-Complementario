import java.io.*;
import java.nio.file.*;

public class Ejercicio3ImprimirTexto {

    public static void main(String[] args) {

        Path path = Paths.get("alumnos.txt");
      
        try {
            String content = Files.readString(path);
            System.out.println(content);
        }catch (IOException e){
            e.printStackTrace();
        }

        }
}