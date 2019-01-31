package main;
import java.io.*;
import lexer.*;
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		String path="C:\\\\Users\\\\Mac\\\\Desktop\\\\123.txt";
		new FileWriter(path);
		Lexer lex=new Lexer();
        lex.scan(path);
	}		
}