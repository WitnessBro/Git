package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class AllNumber extends Term {
	public final Number value;

	public AllNumber(Number value) {
		super();
		this.value = value;
	}

	@Override
	public String toString(TermsSubstitutor subst) {
		return value + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof AllNumber) {
			return value == ((AllNumber) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public Term substitute(String name, Term value) {
		return this;
	}

}
