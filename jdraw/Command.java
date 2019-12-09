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
public abstract class Command {
    
    public String command;
    public Context context = new Context();
    
    public abstract boolean isYours(String command);
    
    //Supongo que aqui vamos a comprobar que comando ha introducido el usuario y
    //dependiendo llamamos a la clase que sea ¿¿¿???
    public abstract void execute(String command) throws IOException;
    
    public void setCommand(String command){
       this.command = command;
    }
    
    public String getCommand(){
        return this.command;
    }

}
