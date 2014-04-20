package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public abstract class BinaryOperation extends Term {
	
	@Override
	public abstract String toString(TermsSubstitutor substitutor);
	
	public Term apply(Term arg, Scope scope) {
		return new Continuation(arg);
	}
		
	protected abstract Term calculate(Term arg1, Term arg2, Scope scope);
	
	private class Continuation extends Term {

		private Term arg1;
		private boolean evaluated;

		public Continuation(Term arg1) {
			this.arg1 = arg1;
		}

		@Override
		public Term apply(Term arg2, Scope scope) {
			if (!evaluated) {
				arg1 = arg1.eval(scope);
				evaluated = true;
			}
			return calculate(arg1, arg2, scope);
		}

		@Override
		public String toString(TermsSubstitutor subst) {
			return BinaryOperation.this.toString() + ' ' + subst.substitute(arg1);
		}
	}
	
}
