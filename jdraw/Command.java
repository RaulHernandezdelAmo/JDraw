package jdraw;

import java.io.IOException;

public abstract class Command {
    
    public String command;
    public Context context = new Context();

    protected Command() throws IOException {
    }

    public abstract boolean isYours(String command);

    public abstract void execute(String command) throws IOException;
    
    public void setCommand(String command){
       this.command = command;
    }
    
    public String getCommand(){
        return this.command;
    }

}
