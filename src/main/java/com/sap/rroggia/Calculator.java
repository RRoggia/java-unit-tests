package com.sap.rroggia;

public class Calculator {

	private static Calculator calculator = new Calculator();

	private Calculator() {
	};

	public static Calculator getInstance() {
		return calculator;
	}

	public int add(int firstValue, int secondValue) {
		return firstValue + secondValue;
	}

	public int multiply(int firstValue, int secondValue) {
		return firstValue * secondValue;
	}

	public int divide(int firstValue, int secondValue) {
		return firstValue / secondValue;
	}

	public int minus(int firstValue, int secondValue) {
		return firstValue - secondValue;
	}

}
