package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class OpenReader extends BinaryOperation{

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "openReader";
	}

	@Override
	protected Term calculate(Term arg1, Term arg2, Scope scope) {
		MyString v1 =  ((MyString) arg1);
		MyString v2 = ((MyString) arg2.eval(scope));
		return new Reader(v1,v2);
	}

}
