package de.yveskaufmann.restspawn.api;

import de.yveskaufmann.restspawn.model.Repository;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Yves Kaufmann
 * @since 16.06.2016
 */
public class TemplateApiTest {

	@Test
	public void testFetchObject() {
		TemplateApi api = new TemplateApi();
		Repository repository = api.fetchObject("https://api.github.com/repositories/1", Repository.class);
		System.out.println(repository);
		assertNotNull(repository);
	}

}
