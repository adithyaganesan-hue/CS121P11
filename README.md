# CS121P10

## UML

```mermaid
classDiagram

    class HasMenu {
        <<interface>>
        +menu() String
        +start() void
    }

    class CheckingAccount {
        -balance: double
        +CheckingAccount()
        +CheckingAccount(balance)
        +main() void
        +menu() String
        +start() String
        +getBalance() double
        +getBalanceString() String
        +setBalance(balance) void
        +checkBalance() void
        -getDouble() double
        +makeDeposit() void
        +makeWithdrawal() void
    }

    class SavingsAccount {
        -interestRate: double
        +main()
        +calcInterest() void
        +setInterestRate() void
        +getInterestRate() void
    }

    class User {
        <<abstract>>
        -userName: String
        -PIN: String
        +login(): boolean
        +login(userName, PIN) boolean
        +setUserName(userName) void
        +getUserName() String
        +setPIN(PIN) void
        +getPIN() String
        +getReport() String*
    }

    class Customer {
        -checking: CheckingAccount
        -savings: SavingsAccount
        +main() void
        +Customer()
        +Customer(userName,PIN)
        +start() void
        +menu() String
        +changePIN() void
        +getReport() String
    }
    class Admin{
        +Admin()
        +menu() String
        +start() String
        +getReport() String
    }
    class Bank{
        -admin Admin
        -customers ArrayList
        +Bank()
        +main() void
        +loadSampleCustomers() void
        +loadCustomers() void
        +saveCustomers() void
        +addUser() void
        +applyInterest() void
        +loginAsCustomer() void
        +menu() void
        +start() void
        +startAdmin() void
    }

    Bank ..|> HasMenu : Implements
    CheckingAccount ..|> HasMenu : Implements
    User ..|> HasMenu : Implements
    SavingsAccount --|> CheckingAccount : Extends
    Customer --|> User : Extends
    Admin --|> User : Extends
    Bank o-- Admin
    Bank o-- Customer
```

### Algorithm
#### public void CheckingAccount.getBalanceString()
```
return String.format("$" + "%.02f)
```
#### private double CheckingAccount.getDouble();
```
create scanner object
try{
    double value = scanner.nextDouble()
    return value
} catch{
    print(invalid amount)
}
return 0

```
#### public void CheckingAccount.makeWithdrawal(), makeDeposit();
same functionality, just flipped signs
```
double amount = getDouble()
balance = balance +/- amount
print(new balance)
```
#### public void SavingsAccount.calcInterest();
```
setBalance(balance + interest*balance)
```

