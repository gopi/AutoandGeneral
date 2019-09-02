package com.autogeneral.model;

public class BalanceTestResult {

	String input;
	Boolean isBalanced;

	public BalanceTestResult(String input, Boolean isBalanced) {
		this.input = input;
		this.isBalanced = isBalanced;
	}

	public BalanceTestResult() {
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Boolean getIsBalanced() {
		return isBalanced;
	}

	public void setIsBalanced(Boolean balanced) {
		isBalanced = balanced;
	}
}
