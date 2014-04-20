package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Length extends UnaryOperation {
	
	
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "len";
	}
	
	public Term calculate(Term arg1, Scope scope) {
		String v1 = ((MyString) arg1).value;
		return new AllNumber(v1.length());
		
	}

	
}
