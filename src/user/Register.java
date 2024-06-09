package user;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	static Scanner scan = new Scanner(System.in);
	
	
	  private static UserRepository userRepository;

	    public Register(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	    public static void  registerUser() {
		String nama, email, password, passwordconfirm;

        System.out.print("Masukkan nama: ");
         nama = scan.nextLine();
        while (true) {
        System.out.print("Masukkan email: ");
        email = scan.nextLine();

        System.out.print("Masukkan password: ");
         password = scan.nextLine();
        
        System.out.print("confirm password: ");
         passwordconfirm = scan.nextLine();
        
         if (password.equals(passwordconfirm) &&  email.matches("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*") ) {
        	 User newUser = new User(nama, email, password);
             userRepository.createUser(newUser);
             System.out.println("Registrasi berhasil!");
    	        break;
        	
         }
        else {
        
    
        
       
        
        System.out.println("password atau email, mohon ketik ulang!");
  
        }
        }
	}


}
