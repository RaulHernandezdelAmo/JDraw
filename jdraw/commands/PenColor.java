package jdraw.commands;

import java.io.IOException;
import java.util.Arrays;
import jdraw.Command;
import jdraw.Context;

public class PenColor extends Command{

    public PenColor(Context context) throws IOException {
        this.context = context;
    }

    @Override
    public void execute(String command){
        context.setPencolor(command);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("pencolor");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
            
}
