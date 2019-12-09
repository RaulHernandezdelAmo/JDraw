package jdraw;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jdraw.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author r.hernandezdel
 */
public class Prompt {
    
     
    ArrayList<Command> myComs = new ArrayList<>();
    //Esto lo usaremos para guardar los comandos en el txt
    public ArrayList<String> comandosIntroducidos = new ArrayList<>();
    
    
    public void recMessages() throws IOException {

        Context context = new Context();

        myComs.add(new Circle(context));
        myComs.add(new Ellipse(context));
        myComs.add(new Rect(context));
        myComs.add(new Save(context));
        myComs.add(new Undo(context));
        myComs.add(new Clear(context));
        myComs.add(new Line(context));
        myComs.add(new Text(context));
        myComs.add(new PenColor(context));
        myComs.add(new FillColor(context));
        myComs.add(new Width(context));

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
            System.out.println(comandosIntroducidos);
            System.exit(0);
        }else{
            while(!salir){
                
                System.out.println("Entra en el while");
            
                for (Command myCom : myComs) {
                    if(!salir){
                        System.out.println("Entra en el for" + myCom);
                        boolean isYours = myCom.isYours(command);
                        if(isYours){
                            comandosIntroducidos.add(command);
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
