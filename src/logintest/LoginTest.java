package logintest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import user.Login;
import user.User;
import user.UserRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class LoginTest {
    private UserRepository userRepository;
    private Login login;
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        login = new Login(userRepository);
    }

    
//    @Test
//    public void myTest() {
//        //Login.loginUser();
//
//        assertTrue(true  );
//    }
    @Test
    public void testLoginUser_EmptyLogin() {
        // Arrange
        String email = "";
        String password = "";

        String output = Login.loginUser(email,password);

        // Assert
        assertTrue(output.contains("Tolong isi email dan password anda!"), "Expected 'Tolong isi email dan password anda!' but got: " + output);
    }
    @Test
    public void testLoginUser_EmptyEmailLogin() {
        // Arrange
        String email = "";
        String password = "password123";

        String output = Login.loginUser(email,password);

        // Assert
        assertTrue(output.contains("Tolong isi email anda!"), "Expected 'Tolong isi email anda!' but got: " + output);
    }
    @Test
    public void testLoginUser_EmptyPasswordLogin() {
        // Arrange
        String email = "test@example.com";
        String password = "";

        String output = Login.loginUser(email,password);

        // Assert
        assertTrue(output.contains("Tolong isi password anda!"), "Expected 'Tolong isi password anda!' but got: " + output);
    }
    
    @Test
    public void testLoginUser_SuccessfulLogin() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        User user = new User("Test User", email, password);
        userRepository.createUser(user);

        String output = Login.loginUser(email,password);

        // Assert
        assertTrue(output.contains("Login berhasil!"), "Expected 'Login berhasil!' but got: " + output);
    }

    @Test
    public void testLoginUser_UnsuccessfulLogin_WrongPassword() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        User user = new User("Test User", email, password);
        userRepository.createUser(user);
        String output = Login.loginUser(email, "wrongpassword");

        // Assert
        assertTrue(output.contains("Password salah!"), "Expected 'Password salah!' but got: " + output);
    }
//
	@Test
	public void testLoginUser_UnsuccessfulLogin_UserNotFound() {
		// Arrange
		String email = "test@example.com";
		String password = "password123";
		String output = Login.loginUser(email,password);
		// Assert
		assertTrue(output.contains("Email tidak terdaftar!"),
				"Expected 'Email tidak terdaftar!' but got: " + output);
	}

	@Test
	public void testLoginUser_UnsuccessfulLogin_InvalidEmailFormat() {
	// Arrange
	String email = "testexample";
	String password = "password123";
	String output = Login.loginUser(email,password);
	// Assert
	assertTrue(output.contains("Input email anda invalid!"),
			"Expected 'Input email anda invalid!' but got: " + output);
	}
}
