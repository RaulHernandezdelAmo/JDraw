/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdraw.commands;

import java.util.Arrays;
import jdraw.Command;

/**
 *
 * @author r.hernandezdel
 */
public class Circle extends Command{
    
    @Override
    public void execute(String command){
        // info del codigo html = https://www.w3schools.com/graphics/svg_circle.asp
        String html =   " <svg height=\"100\" width=\"100\">\n" +
                        "       <circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"black\" stroke-width=\"3\" fill=\"red\" />\n" +
                        " </svg> "
                        + " ";
        context.addHTMLLine(html);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("circle");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
}
