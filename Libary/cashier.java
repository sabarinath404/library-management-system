import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class cashier {
      
   
    String str="";
    String count="";
    int i;

    LocalDate today = LocalDate. now();
    String formattedDate = today. format(DateTimeFormatter. ofPattern("dd-MMM-yy"));
  

    public void writeintoBook(int Uid,String name) throws IOException{
        File logbook = new File("logbook.csv");
        
        BufferedWriter buf = new BufferedWriter(new FileWriter("logbook.csv",true));

       buf.append(Uid+":"+name+" : DATE - "+formattedDate+":\n");
       buf.close();


    }
    public void returned(int UniqBookId,String name) throws IOException{
        File f = new File("logbook.csv");
        BufferedReader bufReader = new BufferedReader(new FileReader("logbook.csv"));
         File Fil = new File("temp2.csv");
          PrintWriter pw = new PrintWriter(new FileWriter("temp2.csv"));
          
       
     
          String line = " ";
          String c ="";
          String S_id = Integer.toString(UniqBookId);
       try {
         
    
          while(( line = bufReader.readLine()) != null){
             line = line.trim();
            
    
             if(line.startsWith(S_id) || line.isEmpty()){
                continue;
             }
             for( int i =0 ;i< line.length();i++ ){
                if(Character.isWhitespace(line.charAt(i))){
                  break;
                }
                c+=line.charAt(i);
             }
             c+="\n";
             
          }
          pw.write(c);
          bufReader.close();
          pw.close();
       } catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          System.out.println("error");
       }
    
       BufferedReader b = new BufferedReader(new FileReader("temp2.csv"));
       PrintWriter w = new PrintWriter(new FileWriter("logbook.csv"));
       while((str=b.readLine() ) !=null){
         
          str.trim();
          line+=str;
          line+="\n";
          System.out.println(line);
          
         
          System.out.println(line);
    
          line.trim();
          System.out.println(line);
    
    
       }
       System.out.println(line);
      System.out.println(line.substring(4));
       String linele =line.substring(4);
         
         
          w.write(linele);
         
          w.close();
          b.close();

    }
}
