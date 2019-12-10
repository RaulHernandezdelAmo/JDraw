package jdraw;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

/**
 *
 * @author r.hernandezdel
 */
public class Jdraw {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //Mostramos el mensaje de bienvenida
        System.out.println("/**************************************/");
        System.out.println("/********* Bienvenido a JDraw *********/");
        
        //Aquí habría que abrir el html temporal para lugo ir guardando los comandos.
        
        //LLamamos a prompt para que empiece a leer los mensajes
        Prompt prompt = new Prompt();
        prompt.recMessages();
        
    }
}
    

