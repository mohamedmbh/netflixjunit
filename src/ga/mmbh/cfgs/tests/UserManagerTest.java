package ga.mmbh.cfgs.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ga.mmbh.cfgs.NetflixApp;
import ga.mmbh.cfgs.managers.UserManager;
import ga.mmbh.cfgs.models.User;

// Francisco Silva Martín

@DisplayName("Tests de userManager")
@Tag("TestUserManager")
public class UserManagerTest {

	private NetflixApp netflixApp;
	private UserManager usermanager;
	private User user;
	private boolean result;

	@BeforeEach
	@Test
	@DisplayName("Create Movie Manager")
	public void beforeTest() {
		usermanager = new UserManager(netflixApp);
		user = new User("fran", "1234");
	}

	@Test
	@DisplayName("Check if the user can login")
	public void loginTest() {
		usermanager.register(user.getUsername(), user.getPassword());
		result = usermanager.login(user.getUsername(), user.getPassword());
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if the user can login 2")
	public void loginTest2() {
		usermanager.register(user.getUsername(), "3123123");
		result = usermanager.login(user.getUsername(), user.getPassword());
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the user can login 3")
	public void loginTest3() {
		assertFalse(usermanager.login(null, null));
	}

	@Test
	@DisplayName("Check if a user can be registered")
	public void registerUserTest() {
		result = usermanager.register(user.getUsername(), user.getPassword());
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if a user can be registered 2")
	public void registerUserTest2() {
		result = usermanager.register("test", "test");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if a user can be registered 3")
	public void registerUserTest3() {
		result = usermanager.register(null, null);
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if the user exists")
	public void existsTest() {
		result = usermanager.exists(user.getUsername());
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the user exists 2")
	public void existsTest2() {
		result = usermanager.exists(null);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the user exists 3")
	public void existsTest3() {
		result = usermanager.exists(user.getUsername(), user.getPassword());
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the user exists 4")
	public void existsTest4() {
		result = usermanager.exists(null, null);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check password length")
	public void isValidLengthTest() {
		result = usermanager.isValidLength("contra");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check password length 2")
	public void isValidLengthTest2() {
		result = usermanager.isValidLength("contraseña");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check password length 3")
	public void isValidLengthTest3() {
		result = usermanager.isValidLength("contraseña123454");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check password length 4")
	public void isValidLengthTest4() {
		result = usermanager.isValidLength("");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check password length 5")
	public void isValidLengthTest5() {
		assertThrows(NullPointerException.class, () -> {
			usermanager.isValidLength(null);
		});
	}

	@Test
	@DisplayName("Check if the email is valid")
	public void isUsernameEmailTest() {
		result = usermanager.isUsernameEmail("fransilvamartin@gmail.com");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if the email is valid 2")
	public void isUsernameEmailTest2() {
		result = usermanager.isUsernameEmail("fransilvamartingmail.com");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the email is valid 3")
	public void isUsernameEmailTest3() {
		result = usermanager.isUsernameEmail("");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the password is valid")
	public void isValidPasswordTest() {
		result = usermanager.isValidPassword("contraseña1234A@");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if the password is valid 2")
	public void isValidPasswordTest2() {
		result = usermanager.isValidPassword("contraseña1234@");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the password is valid 3")
	public void isValidPasswordTest3() {
		result = usermanager.isValidPassword("contraseña@A");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the password is valid 4")
	public void isValidPasswordTest4() {
		result = usermanager.isValidPassword("contra@A");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the password is valid 5")
	public void isValidPasswordTest5() {
		result = usermanager.isValidPassword("contra12@AAAA");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if the password is valid 6")
	public void isValidPasswordTest6() {
		result = usermanager.isValidPassword("estoesunacontraseña");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains uppercase letters")
	public void hasUpperCaseTest() {
		result = usermanager.hasUpperCase("cOntra");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains uppercase letters 2")
	public void hasUpperCaseTest2() {
		result = usermanager.hasUpperCase("contra");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains lowercase letters")
	public void hasLowerCaseTest() {
		result = usermanager.hasUpperCase("cOntra");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains lowercase letters 2")
	public void hasLowerCaseTest2() {
		result = usermanager.hasLowerCase("CONTRA");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains numbers")
	public void hasNumberTest() {
		result = usermanager.hasNumber("CONTRA231");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains numbers 2")
	public void hasNumberTest2() {
		result = usermanager.hasNumber("CONTRA");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains special characters")
	public void hasSpecialCharacterTest() {
		result = usermanager.hasNumber("co-@NTRA231");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains special characters 2")
	public void hasSpecialCharacterTest2() {
		result = usermanager.hasNumber("co**NTRA231");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains special characters 3")
	public void hasSpecialCharacterTest3() {
		result = usermanager.hasNumber("co#NTRA231");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains special characters 4")
	public void hasSpecialCharacterTest4() {
		result = usermanager.hasNumber("co$NTRA231");
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it contains special characters 5")
	public void hasSpecialCharacterTest5() {
		result = usermanager.hasNumber("CONTRA");
		assertFalse(result);
	}

}
