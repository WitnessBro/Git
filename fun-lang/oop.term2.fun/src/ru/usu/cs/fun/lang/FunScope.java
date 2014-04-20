package ru.usu.cs.fun.lang;

import java.util.HashMap;
import java.util.Map;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;

public class FunScope implements Scope {

	private final Map<String, Term> items = new HashMap<String, Term>();

	public void add(String name, Term term) {
		if (find(name) != null)
			throw new RuntimeException("Symbol '" + name + "' has beed already defined");
		items.put(name, term);
	}

	@Override
	public Term get(String name) {
		Term result = find(name);
		if (result == null)
			throw new RuntimeException("Symbol '" + name + "' in undefined");
		return result;
	}

	// can be null
	public Term find(String name) {
		Term result = resolveConstant(name);
		if (result != null)
			return result;
		if (name.equals(">="))
			return new GreaterThanOrEquals();
		if (name.equals("<="))
			return new LessOrEquals();
		if (name.equals("="))
			return new Eq();
		if (name.equals("<"))
			return new Less();
		if (name.equals(">"))
			return new GreaterThan();
		if (name.equals("rem"))
			return new Remove();
		if (name.equals("insert"))
			return new Insert();
		if (name.equals("%"))
			return new Mod();
		if (name.equals("charAt"))
			return new CharAt();
		if (name.equals("console"))
			return new Reader();
		if (name.equals("openReader"))
			return new OpenReader();
		if (name.equals("readInt"))
			return new ReadInt();
		if (name.equals("isEnd"))
			return new IsEnd();
		if (name.equals("openString"))
			return new OpenString();
		if (name.equals("closeReader"))
			return new CloseReader();
		if (name.equals("readLine"))
			return new ReadLine();
		if (name.equals("substr"))
			return new StringSubstr();
		if (name.equals("/"))
			return new Division();
		if (name.equals("*"))
			return new Mult();
		if (name.equals("len"))
			return new Length();
		if (name.equals("+"))
			return new Add();
		if (name.equals("concat"))
			return new Concatenation();
		if (name.equals("-"))
			return new Substr();
		if (name.equals("print"))
			return new Print();
		return items.get(name);
	}
	
	private Term resolveConstant(String name) {
		return resolveBool(name);
	}

	private Term resolveBool(String name) {
		if (name.equals("true"))
			return Bool.TRUE;
		else if (name.equals("false"))
			return Bool.FALSE;
		else
			return null;
	}
}
