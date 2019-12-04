/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.commands;

import java.util.Arrays;
import jdraw.Command;

/**
 *
 * @author r.hernandezdel
 */
public class Width extends Command{
    public void setWidth(String command){
        System.out.println(command);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("width");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }

    @Override
    public void execute(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
