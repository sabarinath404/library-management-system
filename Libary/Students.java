import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    String name;
    int password;
    
    public static void welcomestudent(String name) throws IOException{
        System.out.println(" welcome "+name);
         Books b = new Books();

        System.out.println("-----------------------------select options-------------------------------------------------");
        System.out.println("SELECT BOOK ---------1");
        System.out.println("RETURN BOOK ---------2");
        
        Scanner scn = new Scanner(System.in);
        int opt = scn.nextInt();

        // select option
        switch(opt){
            case 1:
           
            b.ViewBooks();
            System.out.println("[------ ENTER BOOK ID TO SELECT ------]");
            int selected_id = scn.nextInt();
            b.searchbook(selected_id);
            System.out.println("--=-=-=-=-=-=-=-=-=-=-=-=-=-=-ENTER CONFORM OR CANCEL=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("ENTER CONFORM---------1");
            System.out.println("ENTER CANCEL----------2");
            int conCan = scn.nextInt();

            if(conCan==1){
                System.out.println("cashiar want to login");
                Driver d = new Driver();
                d.filesreader("cashiarpass.csv",3);
                 b.ifselected(name);
            }else{
                System.out.println("------------------------HOME----------------------------");
                welcomestudent(name);
            }
            
            break;

            case 2:
                System.out.println("cashiar want to login");
                Driver d = new Driver();
                d.filesreader("cashiarpass.csv",3);
               b.ViewBooks();
               System.out.println(" ()() - ENTER BOOK ID TO RETURN -()() ");
               int r = scn.nextInt();
               System.out.println("ENTER BOOK UNIQUE ID : GIVEN IN THE FIRST PAGE");
               System.out.println("                    OR                         ");
               System.out.println("|||||||||||||||| SCAN QR CODE |||||||||||||||||              ");
               int UNIQID = scn.nextInt();
               b.ifreturned(name,r,UNIQID);
            break;
        }
    }
}
