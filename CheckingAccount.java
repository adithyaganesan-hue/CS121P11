import java.util.Scanner;

public class CheckingAccount implements HasMenu{
    private double balance;

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.start();
    }

    public CheckingAccount(){
        balance = 0;
    }
    public CheckingAccount(double balance){
        this.balance = balance;
    }

    @Override
    public String menu() {
        System.out.println("Account Menu");
        Scanner scanner  = new Scanner(System.in);
        System.out.println("0) quit\n1) check balance\n2) make a deposit\n3) make a withdrawal\n");
        String input = scanner.next();
        return input;
    }
    @Override
    public void start() {
        boolean keepGoing = true;
        while(keepGoing){
            String userInput = menu();
            switch (userInput){
                case "0":
                    keepGoing = false;
                    break;
                case "1":
                    checkBalance();
                    break;
                case "2":
                    makeDeposit();
                    break;
                case "3":
                    makeWithdrawal();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public double getBalance(){
        return balance;
    }
    public String getBalanceString(){
        return String.format("$"+"%.2f", balance);
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void checkBalance(){
        System.out.println(getBalanceString());
    } 
    private double getDouble(){
        Scanner scanner = new Scanner(System.in);
        try {
            double value = scanner.nextDouble();
            return value;
        } catch (Exception e) {
            System.out.print("Not a valid amount!");
        }
        return 0;
    }

    public void makeDeposit(){
        System.out.println("Making a deposit...");
        System.out.println("How much would you like to deposit?");
        double amount = getDouble();
        balance += amount;
        System.out.println("New Balance:"+getBalanceString());
    }
    public void makeWithdrawal(){
        System.out.println("Making a withdrawal...");
        System.out.println("How much would you like to withdraw?");
        double amount = getDouble();
        balance -= amount;
        System.out.println("New Balance:"+getBalanceString());
    }
}