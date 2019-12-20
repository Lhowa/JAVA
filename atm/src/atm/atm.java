package atm;
import java.util.*;
public class atm {



	    static void menu() {
	        String Balance = "Balance";
	        String Deposit = "Deposit";
	        String Withdraw = "Withdraw";
	        String Exit = "Exit";
	        System.out.println("Please Select an option");
	        System.out.printf("1)%s\n2)%s\n3)%s\n4)%s\n", Balance, Deposit, Withdraw, Exit);
	    }
	    public static void main(String[] args) {
	        int accountBalance = 45;
	        Scanner sc = new Scanner(System.in);
	        while (true) {
	            menu();
	            int input1 = sc.nextInt();
	            switch (input1) {
	                case 1: {
	                    System.out.println(accountBalance);
	                }
	                break;
	                case 2: {
	                    System.out.println("How much would you like to Deposit?");
	                    int input2 = sc.nextInt();
	                    accountBalance += input2;
	                    System.out.printf("Your new balance is %d\n", accountBalance);
	                }
	                break;
	                case 3: {
	                    System.out.println("How much would you like to Withdraw?");
	                    int input3 = sc.nextInt();
	                    if (input3 < accountBalance) {
	                    accountBalance -= input3;
	                    System.out.printf("Your new balance is %d\n", accountBalance);
	                    }else {
	                    	System.out.println("You do not have enough in your account. Please try again...");
	                    }
	                }
	                break;
	                case 4: {
	                    System.out.println("Goodbye");
	                    System.exit(0);
	                }
	                break;
	                default: {
	                    System.out.println("Your selection was not valid. Please try again...");
	                }
	            }

	        }
	    }
	}

