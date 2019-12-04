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
public class Ellipse extends Command{
    public void ellipse(String command){
        System.out.println(command);
    }
    
    @Override
    public void execute(String command){
        // info del codigo html = https://www.w3schools.com/graphics/svg_ellipse.asp
        String html =   " <svg height=\"140\" width=\"500\">\n" +
                        "   <ellipse cx=\"200\" cy=\"80\" rx=\"100\" ry=\"50\"\n" +
                        "   style=\"fill:yellow;stroke:purple;stroke-width:2\" />\n" +
                        "</svg> ";
        this.addHTMLLine(html);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("ellipse");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
    
}
