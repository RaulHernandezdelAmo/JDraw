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
public class PenCollor extends Command{
    
    @Override
    public void execute(String command){
        //TODO: hacer que borre todo
        this.setPencollor(command);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("penCollor");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
            
}