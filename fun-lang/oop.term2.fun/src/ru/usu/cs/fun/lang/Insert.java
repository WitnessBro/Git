package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Insert extends UltraOperation{

	

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "insert";
	}

	@Override
	protected Term calculate(Term arg[], Scope scope) {
		String v1 = ((MyString) arg[0]).value;
		String v2 = ((MyString) arg[1]).value;
		int v3 = (Integer)((AllNumber) arg[2]).value;
		v1 = v1.substring(1, v1.length()-1);
		v2 = v2.substring(1, v2.length()-1);
		return new MyString(v1.substring(0, v3) + v2 + v1.substring(v3, v1.length()));
	}
	

}
