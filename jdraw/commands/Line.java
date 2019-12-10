package jdraw.commands;

import jdraw.Command;
import jdraw.Context;

import java.io.IOException;
import java.util.Arrays;

public class Line extends Command {


    public Line(Context context){
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

        // info del codigo html = https://www.w3schools.com/graphics/svg_line.asp
        String html =   " " +
                " <svg height=\"210\" width=\"500\">\n" +
                "   <line x1=\"" + commandAux2[1] + "\" y1=\"" + commandAux1[1] + "\" x2=\"" + commandAux1[2] + "\" y2=\"" + commandAux1[3] + "\" " +
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
        this.setCommand("line");
        String[] command1 = command.split(" ");

        return Arrays.asList(command1).contains(this.command);
    }
}
