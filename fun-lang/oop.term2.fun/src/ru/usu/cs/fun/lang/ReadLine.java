package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class ReadLine extends UnaryOperation{


	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "readLine";
	}

	protected Term calculate(Term arg, Scope scope) {
		Term argument = arg.eval(scope);
		//int result = 0;
		String result = ((Reader)argument).stream.nextLine();

		return new MyString(result);
	}

}
