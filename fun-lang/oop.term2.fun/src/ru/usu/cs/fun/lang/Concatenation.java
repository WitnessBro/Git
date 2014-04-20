package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Concatenation extends BinaryOperation{
	
	
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "concat";
	}
	protected Term calculate(Term arg1, Term arg2, Scope scope)
	{
		String v1 = ((MyString) arg1).value;
		String v2 = ((MyString) arg2.eval(scope)).value;
		
		return new MyString(v1+v2);
	}
	
	
}
