package user;

import java.util.ArrayList;

public class User {
	
	private String nama;
    private String email;
    private String password;
   
	    public User(String nama, String email, String password) {
		super();
		this.nama = nama;
		this.email = email;
		this.password = password;
		
	    }
	    

	
		public String getNama() {
			return nama;
		}

		public void setNama(String nama) {
			this.nama = nama;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    
		

	 
	
}

	