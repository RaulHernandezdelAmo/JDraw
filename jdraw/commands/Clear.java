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
public class Clear extends Command{
    
    @Override
    public void execute(String command){
        //TODO: hacer que borre todo
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("clear");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
}
