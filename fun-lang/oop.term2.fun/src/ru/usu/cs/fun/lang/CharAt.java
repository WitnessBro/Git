package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class CharAt extends UltraOperation{
	
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "charAt";
	}
	protected Term calculate(Term arg[], Scope scope)
	{
		String v1 = ((MyString) arg[0]).value;
		int v2 = (Integer)((AllNumber) arg[1].eval(scope)).value;
		
		return new AllNumber(v1.substring(1, v1.length()-1).codePointAt(v2));
		
	}
}
