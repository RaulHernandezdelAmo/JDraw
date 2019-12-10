package jdraw;

import jdraw.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {
    
    //Arraylist para recorrer todos los comandos en el for del recMessages
    ArrayList<Command> myComs = new ArrayList<>();
    //Este arrayList sirve para guardar en el fichero los diferentes comandos introducidos
    public ArrayList<String> comandosIntroducidos = new ArrayList<>();
    
    
    public void recMessages() throws IOException {

        Context context = new Context();

        //Metemos en el arrayList todos los comandos para recorrerlos con el for
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
        
        boolean salir = false;
        this.welcomeMessage();
        Scanner S = new Scanner(System.in);
        String command = S.nextLine();

        if(command.equals("salir")){
            System.out.println("¿Desea salir de la aplicación? Y/N");
            String terminarPrograma = S.nextLine();
            if(terminarPrograma.equals("Y")){
                //System.out.println(comandosIntroducidos);
                System.exit(0);
            }else{  
                this.recMessages();
            }
        }else{
            while(!salir){
                for (Command myCom : myComs) {
                    if(!salir){
                        boolean isYours = myCom.isYours(command);
                        if(isYours){
                            comandosIntroducidos.add(command);
                            salir = true;
                            myCom.execute(command);
                        }
                    }
                }
                salir = true;
            }
        }
        //Hacemos que se llame recursivamente hasta que el usuario introduzca el comando salir
        this.recMessages();
    }
    
    public void welcomeMessage(){
        System.out.println("/**************************************/");
        System.out.println("Introduzca el comando: ");
    }
    
}
