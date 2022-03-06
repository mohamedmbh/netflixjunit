package ga.mmbh.cfgs.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ga.mmbh.cfgs.managers.MovieManager;
import ga.mmbh.cfgs.models.Genre;
import ga.mmbh.cfgs.models.Movie;

// Francisco Silva Martín

@DisplayName("Tests de movieManager")
@Tag("TestMovieManager")
public class MovieManagerTest {

	private Movie movie;
	private MovieManager moviemanager;
	private String name;
	private boolean result;

	@BeforeEach
	@Test
	@DisplayName("Create Movie Manager")
	public void beforeTest() {
		moviemanager = new MovieManager();
	}

	@Test
	@DisplayName("Add Movie 1")
	public void addMovieTest() {
		movie = new Movie(1, "Scary Movie", 18, "Brendan Eich", Genre.DRAMA, 124,
				"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2020/10/scary-movie-2000-2113037.jpg");
		result = moviemanager.addMovie(movie);
		assertTrue(result);
	}

	@Test
	@DisplayName("Add Movie 2")
	public void addMovieTest2() {
		result = moviemanager.addMovie(null);
		assertTrue(result);
	}

	@Test
	@DisplayName("Remove Movie 1")
	public void removeMovieTest() {
		result = moviemanager.removeMovie(moviemanager.getMovies().get(0));
		assertTrue(result);
	}

	@Test
	@DisplayName("Remove Movie 2")
	public void removeMovieTest2() {
		moviemanager.removeMovie(moviemanager.getMovies().get(0));

		assertThrows(IndexOutOfBoundsException.class, () -> {
			moviemanager.removeMovie(moviemanager.getMovies().get(0));
		});
	}

	@Test
	@DisplayName("Check if you can see it according to age")
	public void isAllAudienceMovieTest() {
		movie = new Movie(2, "Scary Movie3", 3, "Brendan Eich", Genre.DRAMA, 124,
				"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2020/10/scary-movie-2000-2113037.jpg");
		result = moviemanager.isAllAudienceMovie(movie);
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if you can see it according to age 2")
	public void isAllAudienceMovieTest2() {
		movie = new Movie(2, "Scary Movie3", 18, "Brendan Eich", Genre.DRAMA, 124,
				"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2020/10/scary-movie-2000-2113037.jpg");
		result = moviemanager.isAllAudienceMovie(movie);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if you can see it according to age 3")
	public void isAllAudienceMovieTest3() {
		assertThrows(NullPointerException.class, () -> {
			moviemanager.isAllAudienceMovie(null);
		});
	}

	@Test
	@DisplayName("Check if it is for an adult audience")
	public void isAdultMovieTest() {
		movie = new Movie(2, "Scary Movie3", 3, "Brendan Eich", Genre.DRAMA, 124,
				"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2020/10/scary-movie-2000-2113037.jpg");
		result = moviemanager.isAdultMovie(movie);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check if it is for an adult audience 2")
	public void isAdultMovieTest2() {
		movie = new Movie(2, "Scary Movie3", 18, "Brendan Eich", Genre.DRAMA, 124,
				"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2020/10/scary-movie-2000-2113037.jpg");
		result = moviemanager.isAdultMovie(movie);
		assertTrue(result);
	}

	@Test
	@DisplayName("Check if it is for an adult audience 3")
	public void isAdultMovieTest3() {
		assertThrows(NullPointerException.class, () -> {
			moviemanager.isAdultMovie(null);
		});
	}

	@Test
	@DisplayName("is Valid Genre")
	public void isValidGenreTest() {
		result = moviemanager.isValidGenre("ACTION");
		assertTrue(result);
	}

	@Test
	@DisplayName("is Valid Genre 2")
	public void isValidGenreTest2() {
		result = moviemanager.isValidGenre("ACT");
		assertFalse(result);
	}

	@Test
	@DisplayName("is Valid Genre 3")
	public void isValidGenreTest3() {
		result = moviemanager.isValidGenre(null);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check name length")
	public void checkMovieNameLengthTest() {
		name = "PELICULA";
		result = moviemanager.checkMovieNameLength(name);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check name length 2")
	public void checkMovieNameLengthTest2() {
		name = "PELICULASUPERLARGANUMERO23123123123";
		result = moviemanager.checkMovieNameLength(name);
		assertTrue(result);
	}

	@Test
	@DisplayName("Check name length 3")
	public void checkMovieNameLengthTest3() {
		name = "";
		result = moviemanager.checkMovieNameLength(name);
		assertFalse(result);
	}

	@Test
	@DisplayName("Check name length 4")
	public void checkMovieNameLengthTest4() {
		name = null;
		assertThrows(NullPointerException.class, () -> {
			moviemanager.checkMovieNameLength(name);
		});
	}

	@Test
	@DisplayName("If the name exists")
	public void existsMovieNameTest() {
		name = "Scary Movie";
		result = moviemanager.existsMovieName(name);
		assertTrue(result);
	}

	@Test
	@DisplayName("If the name exists 2")
	public void existsMovieNameTest2() {
		name = "Scary";
		result = moviemanager.existsMovieName(name);
		assertFalse(result);
	}

	@Test
	@DisplayName("If the name exists 3")
	public void existsMovieNameTest3() {
		result = moviemanager.existsMovieName(null);
		assertFalse(result);
	}

	@Test
	@DisplayName("If the ID exists")
	public void existsMovieIdTest() {
		result = moviemanager.existsMovieId(0);
		assertTrue(result);
	}

	@Test
	@DisplayName("If the ID exists 2")
	public void existsMovieIdTest2() {
		result = moviemanager.existsMovieId(1);
		assertFalse(result);
	}

}
