package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class ReadInt extends UnaryOperation{

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "readInt";
	}

	protected Term calculate(Term arg, Scope scope) {
		Term argument = arg.eval(scope);
		//int result = 0;
		int result = ((Reader)argument).stream.nextInt();

		return new AllNumber(result);
	}

}
