package com.projetjava.appli;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = AppliApplication.class)
public class AppliApplicationTests {

	TestRestTemplate restTemplate;
	URL base;

	@Before
	public void setUp() throws MalformedURLException {
		restTemplate = new TestRestTemplate("Ludo@test.fr", "ROOT");
		base = new URL("http://localhost:8080");
	}

	@Test
	public void whenLoggedUserRequestsHomePage_ThenSuccess() throws IllegalStateException, IOException {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response
				.getBody()
				.contains("Baeldung"));
	}

	@Test
	public void whenUserWithWrongCredentials_thenUnauthorizedPage() throws IllegalStateException, IOException {
		restTemplate = new TestRestTemplate();
		TestRestTemplate template = restTemplate.withBasicAuth("Ludo@test.fr", "ROOT");
		ResponseEntity<String> response = template.getForEntity(base.toString() + "/liste-civil", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNull(response.getBody());
	}
}
