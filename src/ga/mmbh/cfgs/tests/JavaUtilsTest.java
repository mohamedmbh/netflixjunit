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

	@Test
	@DisplayName("Check if it is type Float")
	public void isFloatTest() {
		boolean resultado = JavaUtils.isFloat("88.77");
		assertTrue(resultado);
	}	

	@Test
	@DisplayName("Check if it is type Float 2")
	public void isFloatTest2() {
		boolean resultado = JavaUtils.isFloat("88,3");
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Float 3")
	public void isFloatTest3() {
		boolean resultado = JavaUtils.isFloat("88m");
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Float 4")
	public void isFloatTest4() {
		boolean resultado = JavaUtils.isFloat("");
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Integer")
	public void isIntegerTest() {
		boolean resultado = JavaUtils.isInteger("1");
		assertTrue(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Integer 2")
	public void isIntegerTest2() {
		boolean resultado = JavaUtils.isInteger("0");
		assertTrue(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Integer 3")
	public void isIntegerTest3() {
		boolean resultado = JavaUtils.isInteger("2.3");
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Integer 4")
	public void isIntegerTest4() {
		boolean resultado = JavaUtils.isInteger("3,2");
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type Integer 5")
	public void isIntegerTest5() {
		boolean resultado = JavaUtils.isInteger("");
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type String")
	public void isStringTest() {
		boolean resultado = JavaUtils.isString("A");
		assertTrue(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type String 2")
	public void isStringTest2() {
		boolean resultado = JavaUtils.isString(0);
		assertTrue(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type String 3")
	public void isStringTest3() {
		boolean resultado = JavaUtils.isString(0.2);
		assertTrue(resultado);
	}
	
	@Test
	@DisplayName("Check if it is type String 4")
	public void isStringTest4() {
		boolean resultado = JavaUtils.isString("");
		assertTrue(resultado);
	}
}
