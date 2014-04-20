package ru.usu.cs.fun.lang;

import java.util.Scanner;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class OpenString extends UnaryOperation {
	
	@Override
	public String toString(TermsSubstitutor substitutor) {
		
		return "openString";
	}
	
	protected Term calculate(Term arg, Scope scope) {
		MyString v1 = ((MyString)arg);
		return new Reader(new Scanner(v1.value));
	}
	
}
