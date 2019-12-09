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

/**
 *
 * @author r.hernandezdel
 */
public class Rect extends Command{

    public Rect(Context context){
        this.context = context;
    }
    
    @Override
    public void execute(String command) throws IOException {

        int po, pr, pg, pb;
        String penrgb;
        String pencolorAux = context.getPencolor();
        if (pencolorAux != null){
            String[] pencolor = pencolorAux.split(" ");
            po = Integer.parseInt(pencolor[0]);
            pr = Integer.parseInt(pencolor[1]);
            pg = Integer.parseInt(pencolor[2]);
            pb = Integer.parseInt(pencolor[3]);
            penrgb = pr+", "+pg+", "+pb;
        }else{
            po = 1;
            penrgb = "100, 0, 0, 0";
        }

        int fo, fr, fg, fb;
        String fillrgb;
        String fillcolorAux = context.getFillColor();
        if (fillcolorAux!=null){
            String[] fillcolor = fillcolorAux.split(" ");
            fo = Integer.parseInt(fillcolor[0]);
            fr = Integer.parseInt(fillcolor[1]);
            fg = Integer.parseInt(fillcolor[2]);
            fb = Integer.parseInt(fillcolor[3]);
            fillrgb = fr+", "+fg+", "+fb;
        }else{
            fo = 0;
            fillrgb = "0, 0, 0, 0";
        }

        int w;
        String width = context.getWidth();
        if (width != null){
            w = Integer.parseInt(width);
        }else{
            w = 1;
        }

        String[] commandAux1 = command.split(",");
        String[] commandAux2 = commandAux1[0].split(" ");
        System.out.println("aaa"+ Arrays.toString(commandAux2) + Arrays.toString(commandAux1));
        System.out.println(commandAux2[1]+ commandAux1[1]+ commandAux1[2]);

        // info del codigo html = https://www.w3schools.com/graphics/svg_rect.asp
        String html =   " " +
                "<svg width=\"400\" height=\"110\">\n" +
                "   <rect x=\"" + commandAux2[1] + "\" y=\"" + commandAux1[1] + "\" width=\"" + commandAux1[2] + "\" height=\"" + commandAux1[3] + "\"" +
                "   stroke-width=\"" + w + "\" fill=\"rgb("+ fillrgb +")\" fill-opacity=\""+fo+"\" stroke=\"rgb("+penrgb+")\" stroke-opacity=\""+po+"\" />\n" +
                "</svg> " +
                "";
        context.addHTMLLine(html);
        context.setPencolor(null);
        context.setFillcolor(null);
        context.setWidth(null);
    }
    
    @Override
    public boolean isYours(String command){
        this.setCommand("rect");
        String[] command1 = command.split(" ");
        
        return Arrays.asList(command1).contains(this.command);
    }
}
