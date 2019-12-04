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
public class Rectangle extends Command{
    public void rectangle(String command){
        System.out.println(command);
    }
    
    @Override
    public void execute(String command){
        System.out.println(htmlLines);
        // info del codigo html = https://www.w3schools.com/graphics/svg_rect.asp
        String html =   " <svg width=\"400\" height=\"110\">\n" +
                        "       <rect width=\"300\" height=\"100\" style=\"fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)\" />\n" +
                        "</svg> ";
        this.addHTMLLine(html);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("rectangle");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
}
