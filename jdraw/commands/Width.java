package jdraw.commands;

import java.io.IOException;
import java.util.Arrays;
import jdraw.Command;
import jdraw.Context;

public class Width extends Command{

    public Width(Context context) throws IOException {
        this.context = context;
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("width");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }

    @Override
    public void execute(String command) {
        context.setWidth(command);
    }
}
