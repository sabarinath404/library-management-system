import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

 public class Books{

   
   String str="";
   String count="";
   int i;
   ArrayList<String> list= new ArrayList<String>(); 
  
  public void addbook(int id,String name,String author,int count) throws IOException{
   try{
      BufferedWriter write = new BufferedWriter(new FileWriter("books.csv", true));
      write.append("\n"+id+":"+name+":"+author+":"+count+"||");

      write.close();
      System.out.println("Successfully wrote to the file.");

   }  catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
  public   void removeBook( int id) throws IOException{
   File f = new File("Books.csv");
    BufferedReader bufReader = new BufferedReader(new FileReader("Books.csv"));
     File Fil = new File("temp.csv");
      PrintWriter pw = new PrintWriter(new FileWriter("temp.csv"));
      
   
 
      String line = " ";
      String c ="";
      String S_id = Integer.toString(id);
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

   BufferedReader b = new BufferedReader(new FileReader("temp.csv"));
   PrintWriter w = new PrintWriter(new FileWriter("Books.csv"));
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
     
      w.close();//++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      b.close();
      
    // f.delete();
     
     //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      //Fil.renameTo(f);
}

public static void ViewBooks() throws FileNotFoundException{
   
String line = "";
   BufferedReader bfr= new BufferedReader(new FileReader("Books.csv"));
    System.out.println(" BOOK ID - BOOK NAME - BOOK AUTHOR - TOTAL BOOK COUNT ");
  try {
    
     while((line = bfr.readLine()) != null){
        System.out.println(line);
     }
      
   } catch (Exception e) {
      //TODO: handle exception
   }
}


public   void searchbook( int id) throws IOException{
   File f = new File("Books.csv");
    BufferedReader bufReader = new BufferedReader(new FileReader("Books.csv"));
    
      
   
 
      String line = "";
      String c ="";
      String S_id = Integer.toString(id);
      String nll ="";
      String temp ="";
   try {
     

      while(( line = bufReader.readLine()) != null){
         line = line.trim();
        

         if(line.startsWith(S_id)){
            for( int i =0 ;i< line.length();i++ ){
              
               char cha =line.charAt(i);
               String s = Character.toString(cha);
               if(s.equals(":") || s.equals("|")){
                 
                  list.add(c);
                  
                  c=nll;
                 continue;

               }
               c+=s;
            }
            
         }
      
      }
    
   
    

   } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("error");
   }
     bufReader.close();
     
}
public void ifselected(String name) throws IOException{
   Scanner Scanner = new Scanner(System.in);
   cashier Nc = new cashier();
   count = list.get(3);
  
   int i=Integer.parseInt(count); 
  
   i=i-1;
  
   String s=String.valueOf(i);
   list.set(3,s);
   int id=Integer.parseInt(list.get(0));
   removeBook(id);
   addbook(id,list.get(1),list.get(2),i);
   System.out.println("ENTER BOOK UNIQUE ID : GIVEN IN THE FIRST PAGE");
   System.out.println("                    OR                         ");
   System.out.println("               SCAN QR CODE                          ");
   int uniqueId = Scanner.nextInt();
   Nc.writeintoBook(uniqueId, name);

}
public void ifreturned(String name,int bookid,int uniqid) throws IOException{
   searchbook(bookid);
   cashier NewCashier = new cashier();
   count = list.get(3);
   System.out.println("count --------- string"+count);
   int i=Integer.parseInt(count); 
   

   i=i+1;
   
   String s=String.valueOf(i);
   list.set(3,s);
   int id=Integer.parseInt(list.get(0));
   removeBook(id);

   
   addbook(id,list.get(1),list.get(2),i);
   System.out.println("returned  the book written in book");
   
   NewCashier.returned(uniqid, name);

  
   

}
 }