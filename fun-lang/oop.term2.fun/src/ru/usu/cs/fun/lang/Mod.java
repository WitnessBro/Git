package ru.usu.cs.fun.lang;


import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Mod extends Operation {
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "%";
	}
	
	public Term actionWithTwoNumber(int arg1, int arg2) {
		return new AllNumber(arg1 % arg2);
	}
	public Term actionWithTwoNumber(double arg1, double arg2) {
		return new AllNumber(arg1 % arg2);
		
	}
}
