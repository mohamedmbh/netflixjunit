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
	/**
	 * Comprobación de iniciar sesión
	 */
	public void loginTest() {
		usermanager.register(user.getUsername(), user.getPassword());
		result = usermanager.login(user.getUsername(), user.getPassword());
		assertTrue(result);

		result = usermanager.login(user.getUsername(), user.getPassword());
		assertTrue(result);

		assertFalse(usermanager.login(null, null));
	}

	@Test
	@DisplayName("Check if a user can be registered")
	/**
	 * Comprobación de registrar un usuario
	 */
	public void registerUserTest() {
		result = usermanager.register(user.getUsername(), user.getPassword());
		assertTrue(result);

		result = usermanager.register("test", "test");
		assertFalse(result);

		result = usermanager.register(null, null);
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if the user exists")
	/**
	 * Comprobar si el usuario existe
	 */
	public void existsTest() {
		result = usermanager.exists(user.getUsername());
		assertFalse(result);

		result = usermanager.exists(null);
		assertFalse(result);

		result = usermanager.exists(user.getUsername(), user.getPassword());
		assertFalse(result);

		result = usermanager.exists(null, null);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check password length")
	/**
	 * Comprueba si el tamaño de la contraseña
	 */
	public void isValidLengthTest() {
		result = usermanager.isValidLength("contra");
		assertFalse(result);

		result = usermanager.isValidLength("contraseña");
		assertTrue(result);

		result = usermanager.isValidLength("contraseña123454");
		assertFalse(result);

		result = usermanager.isValidLength("");
		assertFalse(result);

		assertThrows(NullPointerException.class, () -> {
			usermanager.isValidLength(null);
		});
	}

	@Test
	@DisplayName("Check if the email is valid")
	/**
	 * Comprueba si es un email valido
	 */
	public void isUsernameEmailTest() {
		result = usermanager.isUsernameEmail("fransilvamartin@gmail.com");
		assertTrue(result);

		result = usermanager.isUsernameEmail("fransilvamartingmail.com");
		assertFalse(result);

		result = usermanager.isUsernameEmail("");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if the password is valid")
	/**
	 * Comprueba si es una contraseña valida
	 */
	public void isValidPasswordTest() {
		result = usermanager.isValidPassword("contraseña1234A@");
		assertTrue(result);

		result = usermanager.isValidPassword("contraseña1234@");
		assertFalse(result);

		result = usermanager.isValidPassword("contraseña@A");
		assertFalse(result);

		result = usermanager.isValidPassword("contra@A");
		assertFalse(result);

		result = usermanager.isValidPassword("contra12@AAAA");
		assertTrue(result);

		result = usermanager.isValidPassword("estoesunacontraseña");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains uppercase letters")
	/**
	 * Comprueba si contiene una mayúsculas
	 */
	public void hasUpperCaseTest() {
		result = usermanager.hasUpperCase("cOntra");
		assertTrue(result);

		result = usermanager.hasUpperCase("contra");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains lowercase letters")
	/**
	 * Compreba si contiene una minúscula
	 */
	public void hasLowerCaseTest() {
		result = usermanager.hasLowerCase("cOntra");
		assertTrue(result);

		result = usermanager.hasLowerCase("CONTRA");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains numbers")
	/**
	 * Comprueba si contiene un número
	 */
	public void hasNumberTest() {
		result = usermanager.hasNumber("CONTRA231");
		assertTrue(result);

		result = usermanager.hasNumber("CONTRA");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it contains special characters")
	/**
	 * Comprueba si contiene un carácter especial
	 */
	public void hasSpecialCharacterTest() {
		result = usermanager.hasSpecialCharacter("co-@NTRA231");
		assertTrue(result);

		result = usermanager.hasSpecialCharacter("co@NTRA231");
		assertTrue(result);

		result = usermanager.hasSpecialCharacter("co#NTRA231");
		assertTrue(result);

		result = usermanager.hasSpecialCharacter("co$NTRA231");
		assertTrue(result);

		result = usermanager.hasSpecialCharacter("CONTRA");
		assertFalse(result);
	}

}
