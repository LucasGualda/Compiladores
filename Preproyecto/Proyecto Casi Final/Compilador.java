package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java_cup.runtime.*;
import java.io.*;

/**
 *
 * @author Charly Ponce
 */
public class Compilador {
    public static void main(String argv[]) throws Exception{
           
    try {
      Sintax p = new Sintax(new Lexer(new FileReader("C:/Users/Martin/Desktop/Preproyecto/src/codigo/test.txt")));
      Object result = p.parse().value;      
      System.out.println("Parser finished successfully."); 
      System.out.println(result);
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      System.out.println("NO CREADO 1."); 
      e.printStackTrace();
     
     // e.printStackTrace();
    }
    catch (Error e) {
      /* do cleanup here -- possibly rethrow e */
     System.out.println("NO CREADO 2.");
     e.printStackTrace();
    }
    
 
        
    }
}
