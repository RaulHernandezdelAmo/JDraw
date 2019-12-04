/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw;

import jdraw.commands.Ellipse;
import jdraw.commands.Rectangle;
import jdraw.commands.Circle;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author r.hernandezdel
 */
public class Prompt {
    
     
    ArrayList<Command> myComs = new ArrayList<>();
    ArrayList<String> htmlLines = new ArrayList<>();
    
   
    
    
    public void recMessages(){
        
        
        myComs.add(new Circle());
        myComs.add(new Ellipse());
        myComs.add(new Rectangle());
    
        //myComs.add(save);
        //myComs.size()
        //myComs.get(i)

        boolean salir = false;
        this.welcomeMessage();
        Scanner S = new Scanner(System.in);
        String command = S.nextLine();
        System.out.println("/**************************************/");
        System.out.println("Ha introducido: " + command);
        System.out.println("/**************************************/");

        if(command.equals("salir")){
            System.exit(0);
        }else{
            while(!salir){
                
                System.out.println("Entra en el while");
            
                for (Command myCom : myComs) {
                    if(!salir){
                    System.out.println("Entra en el for" + myCom);
                    boolean isYours = myCom.isYours(command);
                    if(isYours){
                        salir = true;
                        myCom.execute(command);
                    }
                        
                    }
                }
                System.out.println("Slae del for ");
                salir = true;
            }
        }
        this.recMessages();
    }
    
    public void welcomeMessage(){
        
        System.out.println("/**************************************/");
        System.out.println("Bienvenido a JDraw"); 
        System.out.println("Introduzca los comandos: ");
        System.out.println("/**************************************/");
    }
    
    public void writeHtml(){
        
    }
}
