
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keloc
 */
public class OOS extends ObjectOutputStream{
    
    public OOS() throws IOException {
        super();
    }
    public OOS(FileOutputStream fileOutputStream)throws IOException{
        super(fileOutputStream);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
        //nada
    }
    
}
