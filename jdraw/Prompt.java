/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw;

import jdraw.commands.PenCollor;
import jdraw.commands.Width;
import jdraw.commands.Ellipse;
import jdraw.commands.Clear;
import jdraw.commands.Rectangle;
import jdraw.commands.Save;
import jdraw.commands.Undo;
import jdraw.commands.Circle;
import java.util.ArrayList;
import java.util.Iterator;
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
        
        
        this.welcomeMessage();
        Scanner S = new Scanner(System.in);
        String command = S.nextLine();
        
        //Ahora tenemos guardados los comandos
        System.out.println("Ha introducido: " + command);
        
        System.out.println("heeee" + myComs);
        for (Command myCom : myComs) {
            System.out.println("entra for 1");
            System.out.println(myCom);
            boolean isYours = false;
            while(!isYours){
                isYours = myCom.isYours(command);
                System.out.println(isYours);
            }
        }
        
        for(Command obj:myComs){
            System.out.println("entra for 2");
            boolean isYours = false;
            while(!isYours){
                
                //isYours = circle.isYours(command);
            }  
        }
        
            System.out.println("Sale");
    }
    
    public void welcomeMessage(){
        
        System.out.println("Bienvenido a JDraw"); 
        System.out.println("Introduzca los comandos: ");
    }
    
    public void writeHtml(){
        
    }
}
