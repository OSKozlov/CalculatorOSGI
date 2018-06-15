package com.muntian.calculator.mathservice;

public class MathOperationAdd implements MathOperation {

	@Override
	public double calculateResult(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

}
