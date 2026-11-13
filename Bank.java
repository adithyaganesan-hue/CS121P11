import java.util.*;
import java.io.*;
public class Bank implements HasMenu{
    private Admin admin;
    private ArrayList<Customer> customers;
    public static void main(String[] args){
        new Bank();
    }
    public Bank(){
        admin = new Admin();
        customers = new ArrayList<>();

        this.loadSampleCustomers();
        this.saveCustomers();

        this.loadCustomers();
        this.start();
        this.saveCustomers();
    }
    public void loadSampleCustomers(){
        customers.add(new Customer());
    }
    @Override
    public String menu(){
        System.out.println("Admin Menu");
        Scanner scanner  = new Scanner(System.in);
        System.out.println("0) quit\n1) enter admin account\n2) enter customer account\n");
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
                    startAdmin();
                    break;
                case "2":
                    loginAsCustomer();
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
                String userInput = admin.menu();
                switch(userInput){
                    case "0":
                        keepGoing = false;
                        break;
                    case "1":
                        for(Customer c : customers){
                            System.out.println(c.getReport());
                        }
                        break;
                    case "2": 
                        addUser();
                        break;
                    case "3":
                        applyInterest();
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        }
    }
    public void addUser(){
        System.out.println("Add User");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("PIN: ");
        String PIN = scanner.next();

        customers.add(new Customer(name,PIN));
    }
    public void applyInterest(){
        System.out.println("Applying Interest");
        for(Customer c : customers){
            c.savings.calcInterest();
        }
    }
    public void loginAsCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("PIN: ");
        String PIN = scanner.next();
        for(Customer c : customers){
            if(c.login(name,PIN)){
                c.start();
            }
        }
    }
    public void loadCustomers(){
        try (FileInputStream fileIn = new FileInputStream("customers.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            customers = (ArrayList<Customer>) in.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveCustomers(){
        try (FileOutputStream fileOut = new FileOutputStream("customers.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(customers);
            System.out.println("ArrayList saved successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}