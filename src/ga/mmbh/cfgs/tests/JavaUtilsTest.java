package ga.mmbh.cfgs.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ga.mmbh.cfgs.utils.JavaUtils;

// Francisco Silva Martín

@DisplayName("Tests de JavaUtils")
@Tag("TestJavaUtils")
public class JavaUtilsTest {

	private boolean result;

	@Test
	@DisplayName("Check if it is type Float")
	/**
	 * Comprueba si es un float
	 */
	public void isFloatTest() {
		result = JavaUtils.isFloat("88.77");
		assertTrue(result);

		result = JavaUtils.isFloat("88,3");
		assertFalse(result);

		result = JavaUtils.isFloat("88m");
		assertFalse(result);

		result = JavaUtils.isFloat("");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it is type Integer")
	/**
	 * Comprueba si es un Integer
	 */
	public void isIntegerTest() {
		result = JavaUtils.isInteger("1");
		assertTrue(result);

		result = JavaUtils.isInteger("0");
		assertTrue(result);

		result = JavaUtils.isInteger("2.3");
		assertFalse(result);

		result = JavaUtils.isInteger("2.3");
		assertFalse(result);

		result = JavaUtils.isInteger("3,2");
		assertFalse(result);

		result = JavaUtils.isInteger("");
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it is type String")
	/**
	 * Comprueba si es una String
	 */
	public void isStringTest() {
		result = JavaUtils.isString("A");
		assertTrue(result);

		result = JavaUtils.isString(0);
		assertTrue(result);

		result = JavaUtils.isString(0.2);
		assertTrue(result);

		result = JavaUtils.isString("");
		assertTrue(result);
	}

}
