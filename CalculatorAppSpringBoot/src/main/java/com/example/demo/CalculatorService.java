package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public double add(double n1, double n2) {
		return n1+n2;
	}
	public double sub(double n1, double n2) {
		return n1-n2;
	}
	public double mul(double n1, double n2) {
		return n1*n2;
	}
	public double div(double n1, double n2) {
		if(n2 == 0) {
			throw new ArithmeticException("Division bt zero is not Allowed");
		}
		return n1/n2;
	}
}
