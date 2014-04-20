package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class StringSubstr extends UltraOperation{
	
	
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "substr";
	}

	@Override
	protected Term calculate(Term arg[], Scope scope) {
		String v1 = ((MyString) arg[0]).value;
		int v2 = (Integer)((AllNumber) arg[1]).value;
		int v3 = (Integer)((AllNumber) arg[2]).value;
		return new MyString(v1.substring(1, v1.length()-1).substring(v2, (v2+v3)));
	}

}
