import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public class Driver {
   public static void main(String [] arg){
    LocalDate mydate = LocalDate.now();  
    LocalTime mytime = LocalTime.now();
    Scanner scn = new Scanner(System.in);
   
    System.out.println(" ");
    System.out.println(" date -"+mydate+"                                                 time -"+mytime); 
    System.out.println(" ");
    System.out.println("|------------------------------------------------------------------------------|");
    System.out.println("|-------------------------college library management---------------------------|");
    System.out.println("|------------------------------------------------------------------------------|");
    System.out.println();
   
    
    System.out.println(" welcome :- \n");
    System.out.println("admin   -1");
    System.out.println("student -2");
    System.out.println("cashiar -3");
    System.out.println("=======================ENTER NUMBER TO SELECT=============================");
    int logopt = scn.nextInt();
    switch(logopt){
        case 1: 

        login_sighin("adminpass.csv",logopt);
        break;

        case 2: 
        login_sighin("studentpass.csv",logopt);
        break;

        case 3: 
        login_sighin("cashiarpass.csv",logopt);
        break;

        default:
        System.out.println("wrong input");

        break; 

    }
   }

   public static void login_sighin(String file,int a){

              System.out.println("login----------- 1");
              System.out.println("creat account----2");
              Scanner scn = new Scanner(System.in);
              int logorcre = scn.nextInt();
              
              switch(logorcre){
                case 1 :
                filesreader(file,a);
                
                break;

                case 2:

                System.out.println("// CREATE ACCOUNT //");
                register(file,a);

                break;
              }
   }

    public static void filesreader(String file,int a){
      
        Scanner scn = new Scanner(System.in);
        System.out.println("ENTER USERNAME - ");
                String uname = scn.next();
                System.out.println("ENTER PASSWORD - ");
                String pass = scn.next();


        HashMap<String, String> map = new HashMap<>();
        String line =  null;
        

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
        
        while((line=br.readLine())!=null){
            String str[] = line.split(",");
        for(int i=0;i<str.length;i++){
            String arr[] = str[i].split(":");
            map.put(arr[0], arr[1]);
        }
        }

       //-----------------------
        
       if(map.containsKey(uname)){
          
          if (map.get(uname).equals(pass)) {
              System.out.println("----------------------------------------------------------------------");
            // -------------------------
            switch(a){
                case 1:
                Admin A = new Admin();
                A.welcomeAdmin();

                break;
                
                case 2:
                Students s = new Students();
                s.welcomestudent(uname);
                break;

                case 3:
                break;

            }
              

             } else {
                 System.out.println("Incorrect password");
             }
        }
       
       
        br.close();
        }catch(IOException e){
            System.out.println("error in login");
        }

    }
     public static void register(String file,int a){
        try {

            
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            Scanner scn = new Scanner(System.in);
            System.out.println("== ENTER USERNAME == ");
            String newuser = scn.next();
            System.out.println("== ENTER PASSWORD == ");
            String pass1 = scn.next();
            
                out.append("\n"+newuser+":"+pass1+ ",");
                out.close();
                filesreader(file ,a);

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

     }
}
