package com.java.csv;

public class CsvData

{

	private float operand1, operand2;

	private String operator;

	public CsvData(int operand1, int operand2, String operator) {

		this.operand1 = operand1;

		this.operand2 = operand2;

		this.operator = operator;

	}

	public float getOperand1() {

		return operand1;
	}

	public float getOperand2() {

		return operand2;
	}

	public String getOperator() {

		return operator;
	}

	public float getResult() {

		float result = 0;

		if ("+".equals(getOperator())) {

			result = operand1 + operand2;

		} else if ("-".equals(getOperator())) {

			result = operand1 - operand2;

		} else if ("/".equals(getOperator())) {

			result = operand1 / operand2;

		} else if ("*".equals(getOperator())) {

			result = operand1 * operand2;

		} else if ("%".equals(getOperator())) {

			result = operand1 % operand2;

		}
		return result;
	}

}
