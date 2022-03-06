package ga.mmbh.cfgs.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ga.mmbh.cfgs.utils.AppUtils;

// Francisco Silva Martín

@DisplayName("Tests de AppUtils")
@Tag("TestAppUtils")
public class AppUtilsTest {

	private String font;

	@Test
	@DisplayName("Get the font 1")
	public void getNetflixFontTest() {
		font = String.valueOf(AppUtils.getNetflixFont("Medium", 1));
		assertTrue(font.contains("Netflix Sans Medium"));
	}

	@Test
	@DisplayName("Get the font 2")
	public void getNetflixFontTest2() {
		font = String.valueOf(AppUtils.getNetflixFont("Light", 1));
		assertTrue(font.contains("Netflix Sans Light"));
	}

	@Test
	@DisplayName("Get the font 3")
	public void getNetflixFontTest3() {
		assertEquals("java.awt.Font[family=Netflix Sans,name=Netflix Sans Medium,style=bold,size=1]",
				String.valueOf(AppUtils.getNetflixFont("Medium", 1)));
	}

	@Test
	@DisplayName("Get the font 4")
	public void getNetflixFontTest4() {
		font = String.valueOf(AppUtils.getNetflixFont("Medium", 1));
		assertFalse(font.contains("dasdasdsa"));
	}

	@Test
	@DisplayName("Get the font 5")
	public void getNetflixFontTest5() {
		font = String.valueOf(AppUtils.getNetflixFont("Light", 1));
		assertFalse(font.contains("Medium"));
	}
}
