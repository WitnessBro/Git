package ru.usu.cs.fun.lang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;


import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import java.util.Scanner;

public class Reader extends Term {

	public String file;
	public InputStream file2;
	public String encoding;
	public Scanner stream;
	

	public Reader(MyString filename, MyString encoding) {
		this.file = filename.value;
		this.encoding = encoding.value;
		try 
		{
			this.stream = new Scanner(new File(file),this.encoding);
		} 
		catch (FileNotFoundException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public Reader(Scanner scanner) {
		this.file = "Read from that string";
		this.stream = scanner;
	}
	public Reader(){
		super();
		this.stream = new Scanner(System.in);
	}
	
	
	
	@Override
	public Term substitute(String name, Term value) {
		return this;
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return file + " " + encoding;
	}

}