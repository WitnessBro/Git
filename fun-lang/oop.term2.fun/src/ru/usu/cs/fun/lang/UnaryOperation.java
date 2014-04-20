package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;


public abstract class UnaryOperation extends Term {
	
	private boolean evaluated;
	@Override
	public abstract String toString(TermsSubstitutor substitutor);
	
	public Term apply(Term arg1, Scope scope) {
		if (!evaluated) {
			arg1 = arg1.eval(scope);
			evaluated = true;
		}
		return calculate(arg1, scope);
	}
		
	protected abstract Term calculate(Term arg1, Scope scope);
	
	
}