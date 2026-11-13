import java.io.*;
import java.util.Scanner;
public class Admin extends User{
    public Admin(){
        setUserName("admin");
        setPIN("0000");
    }
    @Override
    public String menu(){
        System.out.println("Admin Menu");
        Scanner scanner  = new Scanner(System.in);
        System.out.println("0) quit\n1) full customer report\n2) add user\n3) apply interest to savings accounts\n");
        String input = scanner.next();
        return input;
    }
    @Override 
    public void start(){

    }
    @Override
    public String getReport(){
        return getUserName() + ", " + getPIN();
    }

}
