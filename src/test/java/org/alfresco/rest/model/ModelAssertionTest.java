package org.alfresco.rest.model;

import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alfresco.rest.core.IRestModel;
import org.alfresco.rest.core.assertion.ModelAssertion;
import org.alfresco.rest.model.RestPersonModel;
import org.junit.Ignore;
import org.testng.annotations.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ModelAssertionTest {

	@Test(groups = "unit")
	public void iCanAssertExistingProperty() throws Exception {
		Person p = new Person();
		p.assertThat().field("id").is("1234");
	}

	@Test(groups = "unit")
	public void iCanAssertExistingPropertyNegative() throws Exception {
		Person p = new Person();
		p.assertThat().field("id").isNot("12342");
		RestPersonModel rp = new RestPersonModel();

		rp.getFirstName();
	}

	@Test(groups = "unit", expectedExceptions = AssertionError.class)
	public void iHaveOneExceptionThrownWithSelfExplanatoryMessageOnMissingField() throws Exception {
		Person p = new Person();
		p.assertThat().field("id2").is("12342");

	}

	@Test(groups = "unit")
	public void iCanTakeTheValueOfFieldsThatDoesntHaveGetters() throws Exception {
		Person p = new Person();

		p.assertThat().field("name").is("test");

	}

	@Test(groups = "unit")
	public void iCanAssertStringIsEmpty() {
		Person p = new Person();

		// Check no exception when field is empty.
		p.assertThat().field("nickname").isEmpty();

		try {
			p.assertThat().field("id").isEmpty();
			fail("Expected exception to be raised.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().contains("is NOT empty"), "Expected exception to be about a field not being empty.");
		}
	}

	@Test(groups = "unit")
	public void iCanAssertStringIsNotEmpty() {
		Person p = new Person();

		// Check no exception when field is not empty.
		p.assertThat().field("id").isNotEmpty();

		try {
			p.assertThat().field("nickname").isNotEmpty();
			fail("Expected exception to be raised.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().contains("is empty"), "Expected exception to be about a field being empty.");
		}
	}

	@Test(groups = "unit")
	public void iCanAssertCollectionIsEmpty() {
		Person p = new Person();

		// Check no exception when field is empty.
		p.assertThat().field("previousNames").isEmpty();

		try {
			p.assertThat().field("legs").isEmpty();
			fail("Expected exception to be raised.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().contains("is NOT empty"), "Expected exception to be about a field not being empty.");
		}
	}

	@Test(groups = "unit")
	public void iCanAssertCollectionIsNotEmpty() {
		Person p = new Person();

		// Check no exception when field is not empty.
		p.assertThat().field("legs").isNotEmpty();

		try {
			p.assertThat().field("previousNames").isNotEmpty();
			fail("Expected exception to be raised.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().contains("is empty"), "Expected exception to be about a field being empty.");
		}
	}

	@Test(groups = "unit")
	public void iCanAssertMapIsEmpty() {
		Person p = new Person();

		// Check no exception when field is empty.
		p.assertThat().field("carrying").isEmpty();

		try {
			p.assertThat().field("clothing").isEmpty();
			fail("Expected exception to be raised.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().contains("is NOT empty"), "Expected exception to be about a field not being empty.");
		}
	}

	@Test(groups = "unit")
	public void iCanAssertMapIsNotEmpty() {
		Person p = new Person();

		// Check no exception when field is not empty.
		p.assertThat().field("clothing").isNotEmpty();

		try {
			p.assertThat().field("carrying").isNotEmpty();
			fail("Expected exception to be raised.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().contains("is empty"), "Expected exception to be about a field being empty.");
		}
	}

	@Test(groups = "unit")
	public void iCanAssertIntIsNotEmpty() {
		Person p = new Person();

		p.assertThat().field("age").isNotEmpty();
	}

	public class Person implements IRestModel<Person> {
		private String id = "1234";
		private String name = "test";
		public String getName() { return name;}
		private String nickname = "";
		private int age = 42;
		private Set<String> legs = newHashSet("left", "right");
		private List<String> previousNames = Collections.emptyList();
		private Map<String, String> clothing = ImmutableMap.of("head", "hat");
		private Map<String, String> carrying = Collections.emptyMap();

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNickname() { return nickname; }
		public int getAge() { return age; }
		public Set<String> getLegs() { return legs; }
		public List<String> getPreviousNames() { return previousNames; }
		public Map<String, String> getClothing() { return clothing; }
		public Map<String, String> getCarrying() { return carrying; }

		@Override
		public ModelAssertion<Person> and() {
			return new ModelAssertion<Person>(this);
		}

		@Override
		public ModelAssertion<Person> assertThat() {
			return new ModelAssertion<Person>(this);
		}

		@Override
		public Person onModel() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
