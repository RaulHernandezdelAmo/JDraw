/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.commands;

import java.util.Arrays;
import jdraw.Command;
import jdraw.Context;

public class FillColor extends Command{

    public FillColor(Context context) {
        this.context = context;
    }

    @Override
    public void execute(String command){
        context.setFillcolor(command);
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("fillcolor");
        String[] command1 = command.split(" ");

        return Arrays.asList(command1).contains(this.command);
    }

}
