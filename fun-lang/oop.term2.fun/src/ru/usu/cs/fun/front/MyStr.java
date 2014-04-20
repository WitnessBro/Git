package ru.usu.cs.fun.front;

public class MyStr extends AutomatonRecognizer {
	public MyStr() {
		super("string");
		transition(INITIAL_STATE, "kavichka", "abc");
		transition("abc", "#", "abc");
		transition("abc", "slash", "special");
		transition("special", "escape", "abc");
		transition("special", "slash", "abc");
		transition("special", "kavichka", "abc");
		transition("abc", "escape", "abc");
		transition("abc", "kavichka", "finish");
		finalStates("finish");
	}
	
	@Override
	protected String getCharClass(char ch) {
		if (ch == '"') return "kavichka";
		if (ch == 'r' || ch == 't' || ch == 'n') return "escape";
		if (ch == '\\') return "slash";
		return "#";
	}
	@Override
	protected String getValue(String text) 
	{
		StringBuilder result = new StringBuilder();
		char[] escapeChar = new char[256];
		escapeChar['n'] = '\n';
		escapeChar['t'] = '\t';
		escapeChar['r'] = '\r';
		escapeChar['\\'] = '\\';
		
		for (int iterator=0; iterator < text.length(); iterator++) 
		{
			if (text.charAt(iterator) == '\\' && iterator + 1 <= text.length()) 
			{
				result.append(escapeChar[text.charAt(iterator+1)]);
				iterator++;
			}
			else 
			{
				result.append(text.charAt(iterator));
			}
		}
		return result.toString().substring(1, result.length()-1);
	}
}
