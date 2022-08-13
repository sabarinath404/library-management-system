import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.View;


public class Admin {
    String name;
    String password;
    Books b = new Books();

   public  void welcomeAdmin() throws IOException{
    System.out.println("welcome admin");

    System.out.println("-----------------------------------select options ------------------------------------------");
    System.out.println("add new books------1");
    System.out.println("delete a book------2");
    System.out.println("view book  --------3");

    Scanner scn = new Scanner(System.in);
    int opt = scn.nextInt();
    switch(opt){
        
    case 1:
        System.out.println("book id");
        int id = scn.nextInt();
        System.out.println("enter name of the book");
        String name = scn.next();
        System.out.println("enter author'name");
        String author = scn.next();
        System.out.println("enter total count of the book");
        int count = scn.nextInt();

       
       
        
        b.addbook(id,name,author,count);

    break;
    case 2:
        b.ViewBooks();
        System.out.println("enter book id");
        int bookId = scn.nextInt();
        b.removeBook(bookId);
    break;
    case 3:
        b.ViewBooks();
    break;
    default:
    System.out.println("wrong input");
    }


   }

}
