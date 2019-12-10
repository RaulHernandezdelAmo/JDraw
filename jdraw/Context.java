package jdraw;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.util.ArrayList;

public class Context{


    private File file = File.createTempFile("jdraw_tmp_file", ".html");
    String fileName = file.getAbsolutePath();

    private String penColor = null;
    private String fillColor = null;
    private String width = null;

    public ArrayList<String> htmlLines = new ArrayList<>();

    public Context() throws IOException {
    }

    public void addHTMLLine(String html) throws IOException {
        //Aqui añadimos el html al arraylist

        this.htmlLines.add(html);
        this.writeHTMLLine(this.htmlLines);
    }
    
    private void writeHTMLLine(ArrayList<String> htmlLines) throws IOException {


        String htmlHeading = "" +
                " <html>\n" +
                "   <head>\n" +
                "       <meta charset = \"UTF-8\"/>\n" +
                "       <meta http-equiv = \"refresh\" content = \"2\"/>\n" +
                "   </head>\n" +
                "\n" +
                "   <body>\n" +
                "       <svg height=\"1024\" width=\"1024\">\n" ;

        String htmlEnd = "" +
                "       </svg>\n" +
                "   </body>\n" +
                "</html>\n";

        RandomAccessFile rfile = new RandomAccessFile(file, "rw");
        rfile.writeChars(htmlHeading);

        for (String htmlLine : htmlLines) {
            rfile.writeChars(htmlLine);
        }

        rfile.writeChars(htmlEnd);
        rfile.close();

        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));

    }

    public String getPencolor(){
        return this.penColor;
    }

    public void setPencolor(String penColor){
        if (penColor == null){
            this.penColor = null;
        }else{
            String[] penColorAux1 = penColor.split(",");
            String[] penColorAux2 = penColorAux1[0].split(" ");
            this.penColor = penColorAux2[1] + penColorAux1[1] + penColorAux1[2] + penColorAux1[3];
        }
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
            this.width = widthAux1[1];
        }
    }
}
