package jdraw.commands;

import jdraw.Command;
import jdraw.Context;

import java.io.IOException;
import java.util.Arrays;

public class Text extends Command {

    public Text(Context context){
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

        // info del codigo html = https://www.w3schools.com/graphics/svg_text.asp
        String html =   " " +
                "<svg height=\"30\" width=\"200\">\n" +
                "  <text x=\"" + commandAux2[1] + "\" y=\"" + commandAux1[1] + "\" fill=\"red\">" + commandAux1[2] + "" +
                "   stroke-width=\"" + w + "\" fill=\"rgb("+ fillrgb +")\" fill-opacity=\""+fo+"\" stroke=\"rgb("+penrgb+")\" stroke-opacity=\""+po+"\" </text>\n" +
                "</svg>  "+
                " ";
        context.addHTMLLine(html);
        context.setPencolor(null);
        context.setFillcolor(null);
        context.setWidth(null);
    }

    @Override
    public boolean isYours(String command){
        this.setCommand("text");
        String[] command1 = command.split(" ");

        return Arrays.asList(command1).contains(this.command);
    }
}
