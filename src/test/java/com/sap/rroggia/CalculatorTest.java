package com.sap.rroggia;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	private static Calculator calculator;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Executed once before tests, when initializing the class.");
		calculator = Calculator.getInstance();
	}

	@Before
	public void setup() {
		System.out.println("Executed before each test.");
	}

	@Test
	public void shouldAddTwoValues() {
		assertThat(calculator.add(10, 20), is(30));
	}

	@Test
	public void shouldMultiplyTwoValues() {
		assertThat(calculator.multiply(10, 20), is(200));
	}

	@Test(expected = ArithmeticException.class)
	public void shouldNotAllowDivisionByZero() {
		calculator.divide(10, 0);
	}

	@Test
	public void shouldReturnTheSameInstance() {
		assertThat(Calculator.getInstance(), sameInstance(calculator));
	}

	@After
	public void tearDown() {
		System.out.println("Executed after each test.");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Executed once after tests, when destructing the class.");
	}

}
