package jdraw.commands;

import java.io.IOException;
import java.util.Arrays;
import jdraw.Command;
import jdraw.Context;

public class Undo extends Command{

    public Undo(Context context) throws IOException {
        this.context = context;
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("undo");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }

    @Override
    public void execute(String command) throws IOException {
        //vamos a coger el ultimo elemento del arraylist
        if (context.htmlLines.size() > 0){
            String last = context.htmlLines.get(context.htmlLines.size() - 1);
            context.htmlLines.remove(last);
            context.addHTMLLine("");
        }
    }
}
