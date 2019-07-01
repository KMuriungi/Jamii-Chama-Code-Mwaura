package jamii_chama;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Deletemembersrecord {
    String file;

    public void deletefile(ArrayList<String> list, String search, String file1){
        file = file1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(search)){
                list.remove(i);
            }
            
           WriteTofile(list);
        }
    }
    public void WriteTofile(ArrayList<String> list){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(String x:list){
                writer.write(x);
                writer.newLine();
            }
            writer.close();
            
        }catch(Exception e){
            e.getStackTrace();
        }
    }



}