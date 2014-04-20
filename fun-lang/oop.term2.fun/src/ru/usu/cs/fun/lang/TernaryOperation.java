package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;


public abstract class TernaryOperation extends Term{
	@Override
	public abstract String toString(TermsSubstitutor substitutor);
	
	public Term apply(Term arg, Scope scope) {
		return new Continuation(arg);
	}
		
	protected abstract Term calculate(Term arg1, Term arg2, Term arg3, Scope scope);
	
	private class Continuation extends Term 
	{
		private Term arg1;
		//private boolean evaluated;

		public Continuation(Term arg1) {
			this.arg1 = arg1;
		}


		@Override
		public Term apply(Term arg2, Scope scope) {
			return new Continuation2(arg1, arg2);
		}

		@Override
		public String toString(TermsSubstitutor subst) {
			return this.toString() + ' ' + subst.substitute(arg1);
		}

		private class Continuation2 extends Term 
		{
	
			private Term arg2;
			private Term arg1;
			private boolean evaluated;
	
			public Continuation2(Term arg1, Term arg2) {
				this.arg1 = arg1;
				this.arg2 = arg2;
			}
	
			@Override
			public Term apply(Term arg3, Scope scope) {
				if (!evaluated) {
					arg2 = arg2.eval(scope);
					evaluated = true;
				}
				return calculate(arg1.eval(scope), arg2.eval(scope), arg3.eval(scope), scope);
			}
	
			@Override
			public String toString(TermsSubstitutor subst) {
				return this.toString() + ' ' + subst.substitute(arg2);
			}
	
		}
	}
}
