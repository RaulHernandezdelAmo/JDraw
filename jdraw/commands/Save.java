/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.commands;

import java.io.IOException;
import java.util.Arrays;
import jdraw.Command;
import jdraw.Context;
import jdraw.Prompt;

/**
 *
 * @author r.hernandezdel
 */
public class Save extends Command{


    public Save(Context context) {
        this.context = context;
        //System.out.println(command);  //Esto hay que borrarlo despues
        //Aqui habra que guardar en el fichero
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("save");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }

    @Override
    public void execute(String command) throws IOException {
        String html = "save";
        context.addHTMLLine(html);
    }
    
}
