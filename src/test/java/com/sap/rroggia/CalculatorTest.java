package com.sap.rroggia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void shouldAddTwoValues() {
		int firstValue = 10;
		int secondValue = 20;
		int expectedValue = 30;

		int returningValue = new Calculator().add(firstValue, secondValue);

		assertEquals("The returning value should be the sum of both values", expectedValue, returningValue);
	}

	@Test
	public void shouldMultiplyTwoValues() {
		int firstValue = 10;
		int secondValue = 20;
		int expectedValue = 30;

		int returningValue = new Calculator().multiply(firstValue, secondValue);

		assertEquals(expectedValue, returningValue);
	}

}
