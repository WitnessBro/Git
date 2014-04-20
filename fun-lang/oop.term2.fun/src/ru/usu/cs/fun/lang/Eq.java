package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Eq extends Operation {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "=";
	}
	
	protected Term actionWithTwoNumber(int arg1,int arg2) {
		return (arg1 == arg2) ? Bool.TRUE : Bool.FALSE ;
	}

	protected Term actionWithTwoNumber(double arg1, double arg2) {
		return arg1 == arg2 ? Bool.TRUE : Bool.FALSE ;
	}
}
