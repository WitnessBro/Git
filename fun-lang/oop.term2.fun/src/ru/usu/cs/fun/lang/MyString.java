package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class MyString extends Term {
	public final String value;
	
	

	public MyString(String text) {
		super();
		this.value = text;
		
	}

	@Override
	public String toString(TermsSubstitutor subst) {
		return value + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof MyString) {
			return value == ((MyString) obj).value;
		}
		return false;
	}


	@Override
	public Term substitute(String name, Term value) {
		return this;
	}
}
