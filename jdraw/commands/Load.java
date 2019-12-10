package jdraw.commands;

import jdraw.Command;
import jdraw.Context;
import jdraw.Prompt;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Load extends Command {


    public Load(Context context) throws IOException {
        this.context = context;
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("load");
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
        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            Prompt prompt = new Prompt();
            String comando;
            while ((comando = br.readLine()) != null) {
                String[] comandoAux = comando.split(" ");
                if (!comandoAux[0].equals("save") && !comandoAux[0].equals("load")){
                    prompt.recMessages(comando);
                }
            }
        }

        catch (IOException e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }

}
