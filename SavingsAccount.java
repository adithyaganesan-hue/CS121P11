import java.util.*;
public class SavingsAccount extends CheckingAccount{
    private double interestRate;
    public static void main(String[] args) {
        //java compiler defines a constructor
        SavingsAccount account = new SavingsAccount();
        account.setBalance(1000);
        account.setInterestRate(0.05);
        account.calcInterest();
        account.start();
    }
    public void calcInterest(){
        setBalance(getBalance()+getBalance()*interestRate);
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getInterestRate() {
        return interestRate;
    }
}