import java.util.*;
public class Customer extends User{
    protected CheckingAccount checking = new CheckingAccount();
    protected SavingsAccount savings = new SavingsAccount();

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.start();
    }

    public Customer(){
        setUserName("Alice");
        setPIN("0000");
    }
    public Customer(String userName, String PIN){
        setUserName(userName);
        setPIN(PIN);
    }
    public void changePIN(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("New PIN: ");
        setPIN(scanner.next());
    }  
    @Override
    public String menu() {
        System.out.println("Customer Menu");
        Scanner scanner  = new Scanner(System.in);
        System.out.println("0) quit\n1) manage checking account\n2) manage savings account \n3) change PIN\n");
        String input = scanner.next();
        return input;
    }
    @Override 
    public void start(){
            boolean keepGoing = true;
            while(keepGoing){
                String userInput = menu();
                switch (userInput){
                    case "0":
                        keepGoing = false;
                        break;
                    case "1":
                        checking.start();
                        break;
                    case "2":
                        savings.start();
                        break;
                    case "3":
                        changePIN();
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
    }
    //unsure as to what the functionality of getReport needed to be
    @Override
    String getReport() {
        return getUserName() + ", " + getPIN() + "\nchecking balance: " + checking.getBalanceString() + "\nsavings balance: " + savings.getBalanceString();
    }
}