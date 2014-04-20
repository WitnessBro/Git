package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class CloseReader extends UnaryOperation{

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "closeReader";
	}

	@Override
	protected Term calculate(Term arg1, Scope scope) {
		Term arg = arg1.eval(scope);
		((Reader)arg).stream.close();
		return arg;
	}

}
