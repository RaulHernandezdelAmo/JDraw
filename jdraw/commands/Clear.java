/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.commands;

import java.util.Arrays;
import java.util.Iterator;
import jdraw.Command;
import jdraw.Context;

/**
 *
 * @author r.hernandezdel
 */
public class Clear extends Command{

    public Clear(Context context) {
        this.context = context;
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("clear");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
    
    @Override
    public void execute(String command){
        context.htmlLines.clear();
        System.out.println(context.htmlLines);
    }
}
