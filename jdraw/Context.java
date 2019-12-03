
package jdraw;

import java.util.ArrayList;

public class Context {
    String penCollor;
    ArrayList<String> htmlLines = new ArrayList<>();
    
    public void setPencollor(String penCollor){
        this.penCollor = penCollor;
    }
    public String getPencollor(){
        return this.penCollor;
    }
    
    public void addHTMLLine(String html){
        //Supongo que aqui añadimos el html al arraylist
        htmlLines.add(html);
    }
    
    public void writeHTMLLine(){
        //TODO
    }
    
}
