package jdraw;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class Context{

    private String penColor = null;
    private String fillColor = null;
    private String width = null;

    public ArrayList<String> htmlLines = new ArrayList<>();

    public void addHTMLLine(String html) throws IOException {
        //Aqui añadimos el html al arraylist

        if (html.equals("save")){
            this.writeHTMLLine(this.htmlLines);
        }
        htmlLines.add(html);
        System.out.println(this.htmlLines);
    }
    
    private void writeHTMLLine(ArrayList<String> htmlLines) throws IOException {

        System.out.println("Entra en writeHTML");
        System.out.println("htmlLines: ");
/*
        String htmlHeading = "" +
                " <html>" +
                "   <head>" +
                "       <meta charset = \"UTF-8\"/>" +
                "       <meta http-equiv = \"refresh\" content = \"2\"/>                            " +
                "   </head>" +
                "" +
                "   <body>" ;

        File file = File.createTempFile("jdraw_tmp_file", "html");
        String fileName = file.getAbsolutePath();

        RandomAccessFile rfile = new RandomAccessFile(file, "rw");
        rfile.writeChars("");
        rfile.close();

        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));
*/
    }

    public void setPencolor(String penColor){
        if (penColor == null){
            this.penColor = null;
        }else{
            String[] penColorAux1 = penColor.split(",");
            String[] penColorAux2 = penColorAux1[0].split(" ");
            System.out.println("El pencolor es:  "+penColorAux2[1] + penColorAux1[1] + penColorAux1[2] + penColorAux1[3]);
            this.penColor = penColorAux2[1] + penColorAux1[1] + penColorAux1[2] + penColorAux1[3];
        }
    }

    public String getPencolor(){
        return this.penColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillcolor(String fillColor){
        if (fillColor == null){
            this.fillColor = null;
        }else{
            String[] fillColorAux1 = fillColor.split(",");
            String[] fillColorAux2 = fillColorAux1[0].split(" ");
            System.out.println("El fillcolor es:  "+fillColorAux2[1] + fillColorAux1[1] + fillColorAux1[2] + fillColorAux1[3]);
            this.fillColor = fillColorAux2[1] + fillColorAux1[1] + fillColorAux1[2] + fillColorAux1[3];
        }
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        if (width == null){
            this.width = null;
        }else{
            String[] widthAux1 = width.split(" ");
            System.out.println("El width es:  "+ widthAux1[1]);
            this.width = widthAux1[1];
        }
    }
}
