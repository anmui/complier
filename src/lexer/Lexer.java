package lexer;
import java.io.*;
import java.util.*;
import symbols.*;
public class Lexer {
	public static int line = 1;
	public static int x=0;
	int flag=281;

	public int size;
	char peek=' ';
	String mu;
	Scanner sc=new Scanner(System.in);
	
	Hashtable<String, Word> words=new Hashtable<String, Word>();
	//����word������hash����
	void reserve(Word w) {
		words.put(w.lexme, w);
	}
	
    public Lexer() throws IOException
	{
			reserve(new Word("if", Tag.IF));
			reserve(new Word("else", Tag.ELSE));
			reserve(new Word("while", Tag.WHILE));
			reserve(new Word("do", Tag.DO));
			reserve(new Word("break", Tag.BREAK));
			reserve(new Word("swtich", Tag.SWTICH));
			reserve(new Word("case", Tag.CASE));
			reserve(new Word("return", Tag.RETURN));
			reserve(new Word("void", Tag.VOID));
			reserve(Word.True);
			reserve(Word.False);
			reserve(Type.INT);
			reserve(Type.Float);
			reserve(Type.Char);
			reserve(Type.Bool);
			System.out.print("����������Ҫ�����Ĵ����ļ��ľ���·����");
			mu=sc.next();
	}
    void readch() throws IOException {
    	RandomAccessFile file=new RandomAccessFile(mu,"r");
    	file.seek(x);
    	peek=(char)file.read();
    	file.close();
    	x=x+1;
    	}
    boolean readch(char c) throws IOException
    {
    	readch();
    	if(peek!=c) return false;
    	peek=' ';
    	return true;
    }
   
    
    public void scan(String path) throws IOException
    {
    	RandomAccessFile p=new RandomAccessFile(path,"rw");
    	readch();
    	while(peek!=65535)
    	{
    		//�����ո�
    		while(peek==' '||peek=='\r'||peek=='\n'||peek=='\b'||peek=='\t')
    		{
    			if(peek==65535)break;
    			readch();
    		}
    		
    		//�ж��������ָ���
    		if(peek!='\r'&&peek!='\n'&&peek!='\b'&&peek!='\t'&&peek!='\f'&&peek!=65535&&peek!=' ')
    		{
    		if(!Character.isDigit(peek)&&!Character.isLetter(peek))
    		{
    		switch(peek)
    		{
        	case '&':
        		if(readch('&')) 
        		{
        			//����&&
        			p.write(("<"+Word.and+" , "+"relop , "+Word.and.tag+">\r\n").getBytes());break;
        		} 
        		else 
        		{
        		//һ��&
        		
        		p.write(("<& , "+"relop>\r\n").getBytes());
        		break;
        		}
        	case '|':
        		if(readch('|')) {p.write(("<"+Word.or+" , "+"relop , "+Word.or.tag+">\r\n").getBytes());break;} else {new Token('|');p.write(("<| , "+"relop>\r\n").getBytes());break;}
        	case '=':
        		if(readch('=')) {p.write(("<"+Word.eq+" , "+"relop , "+Word.eq.tag+">\r\n").getBytes());break;} else {new Token('=');p.write(("<= , "+"��ֵ>\r\n").getBytes());break;}
        	case '!':
        		if(readch('='))//!= 
        		{p.write(("<"+Word.ne+" , "+"relop , "+Word.ne.tag+">\r\n").getBytes());break;} 
        		else 
        		{new Token('!');p.write(("<! , "+"relop>\r\n").getBytes());break;}
        	case '<':
        		if(readch('=')) 
        		{p.write(("<"+Word.le+" , "+"relop , "+Word.le.tag+">\r\n").getBytes());break;} 
        		else 
        		{new Token('<');p.write(("<< , "+"relop>\r\n").getBytes());break;}
        	case '>':
        		if(readch('=')) 
        		{p.write(("<"+Word.ge+" , "+"relop , "+Word.ge.tag+">\r\n").getBytes());break;} else {new Token('>');p.write(("<> , "+"relop>\r\n").getBytes());break;}
        	case '+':
        		if(readch('+')) {p.write(("<++ , ����>\r\n").getBytes());break;} else {new Token('+');p.write(("<+ , relop>\r\n").getBytes());break;}
        	case '-':
        		if(readch('-')) {p.write(("<-- , ����>\r\n").getBytes());break;} else {new Token('-');p.write(("<- , relop>\r\n").getBytes());break;}
        	case '*':
        		readch();new Token('*');p.write(("<* , relop>\r\n").getBytes());break;
        	case '/':
        		readch();
        		new Token('/');
        		if(Character.isDigit(peek)) 
        		{p.write(("<- , relop>\r\n").getBytes());break;}
        		else
        		{
        		p.write(("</,"+"relop>\r\n").getBytes());
        		break;
        		}
        	case ':':
        		readch();new Token(':');p.write(("<: , relop>\r\n").getBytes());break;
        	case '(':
        		readch();new Token('(');p.write(("<( , ���>\r\n").getBytes());break;
        	case ')':
        		readch();new Token(')');p.write(("<) , ���>\r\n").getBytes());break;
        	case '[':
        		readch();new Token('[');p.write(("<[ , ���>\r\n").getBytes());break;
        	case ']':
        		readch();new Token(']');p.write(("<] , ���>\r\n").getBytes());break;
        	case '{':
        		readch();new Token('{');p.write(("<{ , ���>\r\n").getBytes());break;
        	case '}':
        		readch();new Token('}');p.write(("<} , ���>\r\n").getBytes());break;
        	case ';':
        		readch();new Token(';');p.write(("<; , ���>\r\n").getBytes());break;
        	case ',':
        		readch();new Token(',');p.write(("<, , ���>\r\n").getBytes());break;
        	case '"':
        		readch();new Token('"');p.write(("<\" , ���>\r\n").getBytes());break;
        	case '\'':
        		readch();
        		new Token('\'');p.write(("<' , ���>\r\n").getBytes());break;
        	case '\\':
        		readch();
        		if(peek=='\\')
        		{
        			while(true)
        			{
        			readch();
        			if(peek=='\r'||peek=='\n'||peek==65535)
        			{
        				break;
        			}
        			}
        			break;
        			
        		}
        		else p.write(("Error\r\n").getBytes());break;
        	default:
        		readch();
        		p.write(("Error\r\n").getBytes());break;
        	}
    		}
    		//�ж�����
    		if(Character.isDigit(peek))
        	{
        		int v=0;
        		do
        		{
        			//����
        			v=v*10+Character.digit(peek, 10);readch();
        		}while(Character.isDigit(peek));
        		if(peek!='.') {p.write(("<"+v+" , Num"+">\r\n").getBytes());;continue;}
        		else {
        			//������
        		float x=v; float d=10;
        		for(;;)
        		{
        			readch();
        			if(!Character.isDigit(peek)) break;
        			x=x+Character.digit(peek, 10)/d;d=d*10;
        		}
        		p.write(("<"+x+" , Num"+">\r\n").getBytes());
        		}
        	}
    		//�жϱ����ֻ��ʶ��
    		if(Character.isLetter(peek))
        	{
        		StringBuffer b=new StringBuffer();
        		do
        		{
        			b.append(peek);readch();
        		}while(Character.isLetter(peek) || Character.isDigit(peek));
        		String s=b.toString();
        		Word w=(Word) words.get(s);
        		if(w!=null) {
        			if(w.tag<=280)
        			{
        			p.write(("<"+s+" , REWS , "+w.tag+">\r\n").getBytes());
        			}
        			else
        			{
        			p.write(("<"+s+" , ID , "+w.tag+">\r\n").getBytes());
        			}
        			continue;
        			}
        		else
        		{
        		reserve(new Word(s, flag));
        		p.write(("<"+s+" , ID , "+flag+">\r\n").getBytes());
        		flag++;
        		}
        	}
    		
    	}
    }
    p.close();
    System.out.println("���ط������");
    
    }
}
