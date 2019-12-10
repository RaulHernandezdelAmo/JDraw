package jdraw;

import java.io.IOException;

public class Jdraw {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        //GitHub del proyecto: https://github.com/RaulHernandezdelAmo/JDraw
        
        //Mostramos el mensaje de bienvenida
        System.out.println("/**************************************/");
        System.out.println("/********* Bienvenido a JDraw *********/");
        
        //LLamamos a prompt para que empiece a leer los mensajes
        Prompt prompt = new Prompt();
        prompt.recMessages("");
        
    }
}
    

