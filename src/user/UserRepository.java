package user;

import java.util.ArrayList;

public class UserRepository {
	
	 private ArrayList<User> users;

	    public UserRepository() {
	        this.users = new ArrayList<>();
	    }

	    public void createUser(User user) {
	        // Add validation logic here if needed (e.g., check for duplicate emails)
	        users.add(user);
	    }

	    public User getUser(String email) {
	        for (User user : users) {
	            if (user.getEmail().equals(email)) {
	                return user;
	            }
	        }
	        return null; // User not found
	    }

	    public ArrayList<User> getAllUsers() {
	        return new ArrayList<>(users); // Return a copy to avoid modification of internal list
	    }
}
