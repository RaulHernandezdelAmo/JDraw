package jdraw.commands;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import jdraw.Command;
import jdraw.Context;

import static jdraw.Prompt.comandosIntroducidos;

public class Clear extends Command{

    public Clear(Context context) throws IOException {
        this.context = context;
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("clear");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
    
    @Override
    public void execute(String command) throws IOException {
        context.htmlLines.clear();
        comandosIntroducidos.clear();
        context.addHTMLLine("");
    }
}
