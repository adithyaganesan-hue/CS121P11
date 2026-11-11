import java.util.*;
public class Bank implements HasMenu{
    private Admin admin;
    private ArrayList<Customer> customers;
    public static void main(String[] args){

    }
    public Bank(){
        
    }
    public loadSampleCustomers(){
        customers.add(new Customer());
    }
    @Override
    public String menu(){
        System.out.println("Customer Menu");
        Scanner scanner  = new Scanner(System.in);
        System.out.println("0) quit\n1) enter admin account\n2) enter customer account\n");
        String input = scanner.next();
        return input;
    }
    @Override
    public String start(){
        boolean keepGoing = true;
        while(keepGoing){
            String userInput = menu();
            switch (userInput){
                case "0":
                    keepGoing = false;
                    break;
                case "1":
                    admin.menu();
                    break;
                case "2":
                    savings.start();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    public void startAdmin(){
        if(admin.login()){
            boolean keepGoing = true;
            while(keepGoing){
                
            }
        }
    }
}