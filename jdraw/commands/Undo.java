/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.commands;

import java.util.Arrays;
import jdraw.Command;
import jdraw.Context;

/**
 *
 * @author r.hernandezdel
 */
public class Undo extends Command{

    public Undo(Context context) {
        this.context = context;
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("undo");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }

    @Override
    public void execute(String command) {
        //vamos a coger el ultimo elemento del arraylist
        if (context.htmlLines.size() > 0){
            String last = context.htmlLines.get(context.htmlLines.size() - 1);
            context.htmlLines.remove(last);
        }
    }
}
