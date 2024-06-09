package main;

import java.util.ArrayList;

import java.util.Scanner;

import user.Login;
import user.Register;
import user.User;
import user.UserRepository;

public class main {
	static Scanner scan = new Scanner(System.in);
	
	 public static void menu(Register register, Login login) {
	        int opt = 0;
	        while (true) {
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. Exit");
	            System.out.print(">> ");
	            opt = scan.nextInt();
	            scan.nextLine();

	            if (opt == 1) {
	                register.registerUser();
	            } else if (opt == 2) {
	                login.loginMenu();
	            } else if (opt == 3) {
	                break;
	            }
	        }
	    }
	
	
	  public static void main(String[] args) {
		  	UserRepository userRepository = new UserRepository(); // Create UserRepository instance
	        Register register = new Register(userRepository);
	        Login login = new Login(userRepository);// Inject UserRepository
			menu(register, login);
	    }
	  

}


	

