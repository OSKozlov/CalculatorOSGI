package com.muntian.calculator.mathservice;

public class MathOperationMultiplication implements MathOperation {

	@Override
	public double calculateResult(double firstNumber, double secondNumber) {
		return firstNumber*secondNumber;
	}

}
