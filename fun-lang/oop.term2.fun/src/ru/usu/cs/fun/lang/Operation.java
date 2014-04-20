package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;



public abstract class Operation extends Term {
	
	public Term apply(Term arg, Scope scope) {
		return new Continuation(arg);
	}
	protected abstract Term actionWithTwoNumber(int arg1, int arg2);
	protected Term actionWithTwoNumber(double arg1, double arg2)
	{
		return null;
	}
	
	
	protected Term calculate(Term arg1, Term arg2, Scope scope) {
			if (arg1 instanceof AllNumber && arg2 instanceof AllNumber)
			{
				double v1 = ((Number)((AllNumber) arg1).value).doubleValue();
				double v2 = ((Number)((AllNumber) arg2.eval(scope)).value).doubleValue();
				return actionWithTwoNumber(v1, v2);
			}
			else 
			{
				Integer v1 = (Integer)((AllNumber) arg1).value;
				Integer v2 = (Integer)((AllNumber) arg2.eval(scope)).value;
				return actionWithTwoNumber(v1, v2);
			}
			
	}
	
	public class Continuation extends Term {

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
			return this.toString() + ' ' + subst.substitute(arg1);
		}

		
	}
}
