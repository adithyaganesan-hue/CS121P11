HasMenu.class: HasMenu.java
	javac HasMenu.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class HasMenu.class
	javac SavingsAccount.java

User.class: User.java HasMenu.class
	javac User.java

Customer.class: Customer.java User.class HasMenu.class CheckingAccount.class SavingsAccount.class
	javac Customer.java

Admin.class: User.class HasMenu.class
	javac Admin.java
Bank.class: Admin.class Customer.java User.class HasMenu.class CheckingAccount.class SavingsAccount.class
	javac Bank.java
run: Bank.class
	java Bank

clean:
	rm *.class

debug: Customer.class
	jdb Customer