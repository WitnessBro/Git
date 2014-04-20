package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class IsEnd extends UnaryOperation{

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "isEnd";
	}

	@Override
	protected Term calculate(Term arg1, Scope scope) {
		Term arg = arg1.eval(scope);
		if (!((Reader)arg).stream.hasNext())
			return Bool.TRUE;
		else return Bool.FALSE;
	}
}
