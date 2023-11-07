package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java_cup.runtime.*;
//import java_cup.Lexer;
import java.io.*;
//import java_cup.parser;

/**
 *
 * @author Charly Ponce
 */
public class Main {
    public static void main(String argv[]) throws Exception{
        
        //String ruta1 = "C:/Users/jrh_r/Documents/NetBeansProjects/Preproyecto2/src/codigo/lcalc.flex";
        String[] ruta1 = {"C:/Users/Martin/Desktop/Preproyecto/src/codigo/lcalc.flex"}; //C:/Users/jrh_r/Documents/NetBeansProjects/Preproyecto2/src
        String[] rutaS = {"-parser", "Sintax", "C:/Users/Martin/Desktop/Preproyecto/src/codigo/ycalc.cup"};
        generar(ruta1, rutaS);
              
    }
    
    public static void generar(String[] ruta1, String[] rutaS) throws IOException, Exception{
        //File archivo;
        //archivo = new File(ruta1);
        //JFlex.Main.generate(archivo);
        //archivo = new File(ruta2);
        
        JFlex.Main.generate(ruta1);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/Martin/Desktop/Preproyecto/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/Martin/Desktop/Preproyecto/src/codigo/sym.java"), 
                Paths.get("C:/Users/Martin/Desktop/Preproyecto/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/Martin/Desktop/Preproyecto/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/Martin/Desktop/Preproyecto/src/codigo/Sintax.java"), 
                Paths.get("C:/Users/Martin/Desktop/Preproyecto/src/codigo/Sintax.java")
        );
    }
}
