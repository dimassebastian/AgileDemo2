package user;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	static Scanner scan = new Scanner(System.in);
	private static UserRepository userRepository;

	public Login(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void loginMenu() {
		// ... (prompt user for email and password)
		String email, password;

		System.out.print("Masukkan email anda: ");
		email = scan.nextLine();

		System.out.print("Masukkan password: ");
		password = scan.nextLine();
		String output = loginUser(email, password);
		System.out.println(output);
	}

//	public static String loginUser(String email, String password) {
//
//		User user = userRepository.getUser(email);
//		if (user != null && user.getPassword().equals(password)) {
//			return ("Login berhasil!");
//		} else {
//			return ("Password atau email salah!");
//		}

	public static String loginUser(String email, String password) {

		if(email.equals("") && password.equals("")) {
			return ("Tolong isi email dan password anda!");
		} else if (email.equals("")) {
			return ("Tolong isi email anda!");
		} else if (password.equals("")) {
			return ("Tolong isi password anda!");
		}
		if(!email.matches("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*")) {
			return ("Input email anda invalid!");
		}
		User user = userRepository.getUser(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return ("Login berhasil!");
			} else {
				return ("Password salah!");
			}
		} else {
			return ("Email tidak terdaftar!");
		}
	}

}