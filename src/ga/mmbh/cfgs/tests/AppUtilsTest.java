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
	@DisplayName("Get the font")
	/**
	 * Comprueba si la fuente existe
	 */
	public void getNetflixFontTest() {
		font = String.valueOf(AppUtils.getNetflixFont("Medium", 1));
		assertTrue(font.contains("Netflix Sans Medium"));

		assertFalse(font.contains("dasdasdsa"));

		assertEquals("java.awt.Font[family=Netflix Sans,name=Netflix Sans Medium,style=bold,size=1]",
				String.valueOf(AppUtils.getNetflixFont("Medium", 1)));

		font = String.valueOf(AppUtils.getNetflixFont("Light", 1));
		assertTrue(font.contains("Netflix Sans Light"));

		font = String.valueOf(AppUtils.getNetflixFont("Light", 1));
		assertFalse(font.contains("Medium"));
	}
}
