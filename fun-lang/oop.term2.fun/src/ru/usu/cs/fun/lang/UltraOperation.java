package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public abstract class UltraOperation extends Term {

	

	public Term apply(Term arg[], Scope scope) {
		return new Continuation(arg);
	}

	protected abstract Term calculate(Term arg[], Scope scope);

	private class Continuation extends Term {

		private Term arg[];
		private boolean evaluated;

		public Continuation(Term arg[]) {
			this.arg = arg;
		}

		public Term apply(Term arg2, Scope scope) {
			int index = evaluatedArgs.length - numberOfNotEvaluatedArgs;
			if (!evaluated) {
				evaluatedArgs[index] = evaluatedArgs[index].eval(scope);
				evaluated = true;
			}

			numberOfNotEvaluatedArgs--;

			if (numberOfNotEvaluatedArgs > 1) {
				evaluatedArgs[index + 1] = arg2;
				return new Continuation(evaluatedArgs, numberOfNotEvaluatedArgs);
			} else {
				evaluatedArgs[index + 1] = arg2.eval(scope);
				return calculate(evaluatedArgs);
			}
		}

		@Override
		public String toString(TermsSubstitutor subst) {
			return UltraOperation.this.toString() + ' '
					+ subst.substitute(arg[0]);
		}
	}

	@Override
	public abstract String toString(TermsSubstitutor substitutor);

}
