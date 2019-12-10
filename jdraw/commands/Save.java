package jdraw.commands;

import jdraw.Command;
import jdraw.Context;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static jdraw.Prompt.comandosIntroducidos;

public class Save extends Command{


    public Save(Context context) throws IOException{
        this.context = context;
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("save");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }

    @Override
    public void execute(String command) throws IOException {
        String[] commandAux = command.split(" ");
        String file;
        if (commandAux.length > 1){
            file = commandAux[1];
        }else{
            file = "Commands.txt";
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String comando : comandosIntroducidos) {
                String[] comandoAux = comando.split(" ");
                if (!comandoAux[0].equals("save") && !comandoAux[0].equals("load")){
                    bw.write(comando);
                    bw.newLine();
                }
            }
        }
        catch (IOException e) {
            System.out.println("No se ha podido guardar en fichero.");
        }
    }
    
}
