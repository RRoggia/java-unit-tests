package com.sap.rroggia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	private static Calculator calculator;
	private static final int firstValue = 10;
	private static final int secondValue = 20;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Executed once before tests, when initializing the class.");
		calculator = new Calculator();
	}

	@Before
	public void setup() {
		System.out.println("Executed before each test.");
	}

	@Test
	public void shouldAddTwoValues() {
		int expectedValue = 30;

		int returningValue = calculator.add(firstValue, secondValue);

		assertEquals("The returning value should be the sum of both values", expectedValue, returningValue);
	}

	@Test
	public void shouldMultiplyTwoValues() {
		int expectedValue = 200;

		int returningValue = calculator.multiply(firstValue, secondValue);

		assertEquals(expectedValue, returningValue);
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
