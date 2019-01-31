package cifa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import lexer.Word;

public class cifa2 {
	static Stack<Integer> stack=new Stack<>();//状态栈
	static Stack<String> stack1=new Stack<>();//符号栈
	static List<String> NFinal=new ArrayList<String>();//非终结符
	static List<String> Final=new ArrayList<String>();//终结符
	static Map<Integer,Map<String,String>> Maction=new HashMap<>();//LRaction表
	static Map<Integer,Map<String,String>> Mgoto=new HashMap<>();//LRgoto表
	static Map<Integer,type> rule=new HashMap<>();//规则
	
	public static void getActionMap()//初始化action
	{
		
		Map<String,String> map=new HashMap<>();
		map.put("{", "s4");
		Maction.put(1, map);
		map=new HashMap<>();
		map.put("$","acc");
		Maction.put(2, map);
		map=new HashMap<>();
		map.put("$","r1");
		Maction.put(3, map);
		map=new HashMap<>();
		map.put("{","s4");
		map.put("id","s7");
		map.put("if","s8");
		map.put("while","s9");
		map.put("do","s10");
		map.put("break","s11");
		Maction.put(4, map);
		map=new HashMap<>();
		map.put("}", "s13");
		Maction.put(5, map);
		map=new HashMap<>();
		map.put("{","s4");
		map.put("}","r25");
		map.put("id","s7");
		map.put("if","s8");
		map.put("while","s9");
		map.put("do","s10");
		map.put("break","s11");
		Maction.put(6, map);
		map=new HashMap<>();
		map.put("=","s15");
		Maction.put(7, map);
		map=new HashMap<>();
		map.put("(","s33");
		Maction.put(8, map);
		map=new HashMap<>();
		map.put("(","s52");
		Maction.put(9, map);
		map=new HashMap<>();
		map.put("{","s4");
		map.put("id","s7");
		map.put("if","s8");
		map.put("while","s9");
		map.put("do","s10");
		map.put("break","s11");
		Maction.put(10, map);
		map=new HashMap<>();
		map.put(";","s51");
		Maction.put(11, map);
		map=new HashMap<>();
		map.put("{","r10");
		map.put("}","r10");
		map.put("id","r10");
		map.put("if","r10");
		map.put("while","r10");
		map.put("do","r10");
		map.put("break","r10");
		Maction.put(12, map);
		map=new HashMap<>();
		map.put("{","r2");
		map.put("}","r2");
		map.put("id","r2");
		map.put("if","r2");
		map.put("while","r2");
		map.put("do","r2");
		map.put("break","r2");
		map.put("$","r2");
		Maction.put(13, map);
		map=new HashMap<>();
		map.put("}","r3");
		Maction.put(14, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("(","s22");
		map.put("num","s24");
		Maction.put(15, map);
		map=new HashMap<>();
		map.put(";","s57");
		map.put("+","s17");
		map.put("-","s31");
		Maction.put(16, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("(","s22");
		map.put("num","s24");
		Maction.put(17, map);
		map=new HashMap<>();
		//map.put("{","r16");
		//map.put("}","r16");
		//map.put("id","r16");
		//map.put("if","r16");
		map.put(")","r16");
		map.put(";","r16");
		//map.put("while","r16");
		//map.put("do","r16");
		//map.put("break","r16");
		map.put("<","r16");
		map.put(">","r16");
		map.put("+","r16");
		map.put("-","r16");
		map.put("*","s19");
		map.put("/","s20");
		Maction.put(18, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("(","s22");
		map.put("num","s24");
		Maction.put(19, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("(","s22");
		map.put("num","s24");
		Maction.put(20, map);
		map=new HashMap<>();
		map.put(";","r21");
		//map.put("}","r21");
		//map.put("id","r21");
		//map.put("if","r21");
		map.put(")","r21");
		//map.put("while","r21");
		//map.put("do","r21");
		//map.put("break","r21");
		map.put("<","r21");
		map.put(">","r21");
		map.put("+","r21");
		map.put("-","r21");
	    //map.put("=","r21");
		map.put("*","r21");
		map.put("/","r21");
		Maction.put(21, map);
		map=new HashMap<>();
		Maction.put(22, map);
		map=new HashMap<>();
		map.put(";","r23");
		//map.put("}","r23");
		//map.put("id","r23");
		//map.put("if","r23");
		map.put(")","r23");
		//map.put("while","r23");
		//map.put("do","r23");
		//map.put("break","r23");
		map.put("<","r23");
		map.put(">","r23");
		map.put("+","r23");
		//map.put("=","r23");
		map.put("-","r23");
		map.put("*","r23");
		map.put("/","r23");
		Maction.put(23, map);
		map=new HashMap<>();
		//map.put(";","r24");
		//map.put("}","r24");
		//map.put("id","r24");
		//map.put("if","r24");
		map.put(")","r24");
		//map.put("while","r24");
		//map.put("do","r24");
		//map.put("break","r24");
		map.put("<","r24");
		map.put(">","r24");
		map.put(";","r24");
		map.put("+","r24");
		map.put("-","r24");
		map.put("*","r24");
		map.put("/","r24");
		Maction.put(24, map);
		map=new HashMap<>();
		map.put(";","r19");
		//map.put("}","r19");
		//map.put("id","r19");
		//map.put("if","r19");
		map.put(")","r19");
		//map.put("while","r19");
		//map.put("do","r19");
		//map.put("break","r19");
		map.put("<","r19");
		map.put(">","r19");
		map.put("+","r19");
		map.put("-","r19");
		map.put("*","r19");
		map.put("/","r19");
		Maction.put(25, map);
		map=new HashMap<>();
		//map.put("{","r20");
		//map.put("}","r20");
		//map.put("id","r20");
		//map.put("if","r20");
		map.put(")","r20");
		map.put(";","r20");
		//map.put("while","r20");
		//map.put("do","r20");
		//map.put("break","r20");
		map.put("<","r20");
		map.put(">","r20");
		map.put("+","r20");
		map.put("-","r20");
		map.put("*","r20");
		map.put("/","r20");
		Maction.put(26, map);
		map=new HashMap<>();
		//map.put("{","r18");
		map.put(";","r18");
		//map.put("}","r18");
		//map.put("id","r18");
		//map.put("if","r18");
		//map.put("while","r18");
		//map.put("do","r18");
		//map.put("break","r18");
		map.put("+","r18");
		map.put("-","r18");
		map.put(")","r18");
		map.put("*","s19");
		map.put("/","s20");
		Maction.put(27, map);
		map=new HashMap<>();
		map.put(")","s29");
		map.put("+","s17");
		map.put("-","s31");
		Maction.put(28, map);
		map=new HashMap<>();
		map.put("{","r22");
		map.put("}","r22");
		map.put("id","r22");
		map.put("if","r22");
		map.put(")","r22");
		map.put("while","r22");
		map.put("do","r22");
		map.put("break","r22");
		map.put("<","r22");
		map.put(">","r22");
		map.put("+","r22");
		map.put("-","r22");
		map.put("*","r22");
		map.put("/","r22");
		Maction.put(29, map);
		map=new HashMap<>();
		map.put("+","r18");
		map.put("-","r18");
		map.put(")","r18");
		Maction.put(30, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("num","s24");
		map.put("(","s22");
		Maction.put(31, map);
		map=new HashMap<>();
		//map.put("{","r17");
		//map.put("}","r17");
		map.put(";","r17");
		//map.put("id","r17");
		//map.put("if","r17");
		map.put(")","r17");
		//map.put("while","r17");
		//map.put("do","r17");
		//map.put("break","r17");
		map.put("<","r17");
		map.put(">","r17");
		map.put("+","r17");
		map.put("-","r17");
		map.put("*","s19");
		map.put("/","s20");
		Maction.put(32, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("num","s24");
		map.put("(","s22");
		Maction.put(33, map);
		map=new HashMap<>();
		map.put(")","r15");
		map.put(">","s39");
		map.put("<","s35");
		map.put("+","s17");
		map.put("-","s31");
		Maction.put(34, map);
		map=new HashMap<>();
		map.put("=","s37");
		map.put("id","s23");
		map.put("num","s24");
		map.put("(","s22");
		Maction.put(35, map);
		map=new HashMap<>();
		map.put(")","r11");
		map.put("+","s17");
		map.put("-","s31");
		Maction.put(36, map);
		map=new HashMap<>();
		map.put("+","s17");
		map.put("-","s31");
		Maction.put(37, map);
		map=new HashMap<>();
		map.put(")","r12");
		Maction.put(38, map);
		map=new HashMap<>();
		map.put("+","s17");
		map.put("-","s31");
		map.put("num","s24");
		map.put("id","s23");
		map.put("(","s22");
		Maction.put(39, map);
		map=new HashMap<>();
		map.put("<","r18");
		map.put(")","r18");
		map.put(">","r18");
		map.put("+","r18");
		map.put("-","r18");
		map.put("*","s19");
		map.put("/","s20");
		Maction.put(40, map);
		map=new HashMap<>();
		map.put(")","s42");
		Maction.put(41, map);
		map=new HashMap<>();
		map.put("{","s4");
		map.put("id","s7");
		map.put("if","s8");
		map.put("else","s44");
		map.put("while","s9");
		map.put("do","s10");
		map.put("break","s11");
		Maction.put(42, map);
		map=new HashMap<>();
		map.put("{","r5");
		map.put("}","r5");
		map.put("id","r5");
		map.put("if","r5");
		map.put("while","r5");
		map.put("do","r5");
		map.put("break","r5");
		Maction.put(43, map);
		map=new HashMap<>();
		map.put("{","s4");
		map.put("id","s7");
		map.put("if","s8");
		map.put("else","s44");
		map.put("while","s9");
		map.put("do","s10");
		map.put("break","s11");
		Maction.put(44, map);
		map=new HashMap<>();
		map.put("{","r6");
		map.put("}","r6");
		map.put("id","r6");
		map.put("if","r6");
		map.put("while","r6");
		map.put("do","r6");
		map.put("break","r6");
		Maction.put(45, map);
		map=new HashMap<>();
		map.put("(","s47");
		Maction.put(46, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("num","s24");
		map.put("(","s22");
		Maction.put(47, map);
		map=new HashMap<>();
		map.put(")","s49");
		Maction.put(48, map);
		map=new HashMap<>();
		map.put(";","s50");
		Maction.put(49, map);
		map=new HashMap<>();
		map.put("{","r8");
		map.put("}","r8");
		map.put("id","r8");
		map.put("if","r8");
		map.put("while","r8");
		map.put("do","r8");
		map.put("break","r8");
		Maction.put(50, map);
		map=new HashMap<>();
		map.put("{","r9");
		map.put("}","r9");
		map.put("id","r9");
		map.put("if","r9");
		map.put("while","r9");
		map.put("do","r9");
		map.put("break","r9");
		Maction.put(51, map);
		map=new HashMap<>();
		map.put("id","s23");
		map.put("num","s24");
		map.put("(","s22");
		Maction.put(52, map);
		map=new HashMap<>();
		map.put(")","s54");
		Maction.put(53, map);
		map=new HashMap<>();
		map.put("{","s4");
		map.put("id","s7");
		map.put("if","s8");
		map.put("else","s44");
		map.put("while","s9");
		map.put("do","s10");
		map.put("break","s11");
		Maction.put(54, map);
		map=new HashMap<>();
		map.put("{","r7");
		map.put("}","r7");
		map.put("id","r7");
		map.put("if","r7");
		map.put("while","r7");
		map.put("do","r7");
		map.put("break","r7");
		Maction.put(55, map);
		map=new HashMap<>();
		map.put("while","s46");
		Maction.put(56, map);
		map=new HashMap<>();
		map.put("{","r4");
	    map.put("}","r4");
		map.put("id","r4");
		map.put("if","r4");
		map.put("while","r4");
		map.put("do","r4");
		map.put("break","r4");
		Maction.put(57, map);
		map=new HashMap<>();
		map.put(")","r13");
		Maction.put(58, map);
	}
	public static void newtype(String right,String left,int pop,int key)
	{
		type type=new type();
		type.right=right;
		type.left=left;
		type.pop=pop;
		rule.put(key, type);
	}
	
	static int num=1;//t+num
	static int Lnum=1;//L+num
	static Stack<Integer> stacknum=new Stack<Integer>();
	static List<String> listop=new ArrayList<String>();
	static Stack<List> bool=new Stack<List>();
	public static void print23()
	{
		String s1="t"+num+"=id";
		//System.out.println(s1);
		listop.add(s1);
		stacknum.add(num);
		num++;
	}
	public static void print24()
	{
		String s1="t"+num+"=num";
		//System.out.println(s1);
		listop.add(s1);
		stacknum.add(num);
		num++;
	}
	public static void print19()
	{
		String s1="t"+num+"=t"+stacknum.pop()+"*t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		num++;
	}
	public static void print20()
	{
		String s1="t"+num+"=t"+stacknum.pop()+"/t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		num++;
	}
	public static void print16()
	{
		String s1="t"+num+"=t"+stacknum.pop()+"+t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		num++;
	}
	public static void print17()
	{
		String s1="t"+num+"=t"+stacknum.pop()+"-t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		num++;
	}
	public static void print15()
	{
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
	}
	public static void print4()
	{
		int s=num-1;
		String s1="id=t"+stacknum.pop();
		//System.out.println(s1);
		listop.add(s1);
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
	}
	public static void print5()
	{
		List<String>list1=bool.pop();
		List<String>list2=bool.pop();
		listop.addAll(list2);
		int l=stacknum.pop();
		String s1="if t"+l+" ture goto L"+Lnum;
		int Lnum2=Lnum+1;
		String s2="if t"+l+" false goto L"+Lnum2;
		listop.add(s1);
		listop.add(s2);
		listop.add("L"+Lnum);
		listop.addAll(list1);
		listop.add("L"+Lnum2);
		List<String> list3=new ArrayList<String>();
		list3.addAll(listop);
		bool.add(list3);
		listop.clear();
		Lnum+=2;
	}
	public static void print13()
	{
		String s1="t"+num+"=t"+stacknum.pop()+">t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
		num++;
	}
	public static void print7()
	{
		List<String>list1=bool.pop();
		List<String>list2=bool.pop();
		listop.add("L"+Lnum);
		int Lnum1=Lnum+1;
		int i2=stacknum.pop();
		listop.addAll(list2);
		String s1="if t"+i2+" ture goto L"+Lnum1;
		int Lnum2=Lnum+2;
		String s2="if t"+i2+" false goto L"+Lnum2;
		listop.add(s1);
		listop.add(s2);
		listop.add("L"+Lnum1);
		listop.addAll(list1);
		listop.add("goto L"+Lnum);
		listop.add("L"+Lnum2);
		List<String> list3=new ArrayList<String>();
		list3.addAll(listop);
		bool.add(list3);
		listop.clear();
		Lnum+=3;
	}
	public static void print8()
	{
		List<String>list1=bool.pop();
		List<String>list2=bool.pop();
		listop.add("L"+Lnum);
		int Lnum1=Lnum+1;
		int i2=stacknum.pop();
		listop.addAll(list1);
		String s1="if t"+i2+" ture goto L"+Lnum1;
		int Lnum2=Lnum+2;
		String s2="if t"+i2+" false goto L"+Lnum2;
		listop.add(s1);
		listop.add(s2);
		listop.add("L"+Lnum1);
		listop.addAll(list2);
		listop.add("goto L"+Lnum);
		listop.add("L"+Lnum2);
		List<String> list3=new ArrayList<String>();
		list3.addAll(listop);
		bool.add(list3);
		listop.clear();
		Lnum+=3;
	}
	public static void print12()
	{
		String s1="t"+num+"=t"+stacknum.pop()+"<=t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
		num++;
	}
	public static void print11()
	{
		String s1="t"+num+"=t"+stacknum.pop()+"<t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
		num++;
	}
	public static void print14()
	{
		String s1="t"+num+"=t"+stacknum.pop()+">=t"+stacknum.pop();
		stacknum.add(num);
		listop.add(s1);
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
		num++;
	}
	public static void print9()
	{
		int Lnum1=Lnum+2;
		String s1="goto L"+Lnum1;
		listop.add(s1);
		List<String> list1=new ArrayList<String>();
		list1.addAll(listop);
		bool.add(list1);
		listop.clear();
	}
	public static void newrule()//初始化规则
	{
		newtype("program","block",1,1);
		newtype("block","{stst}",3,2);
		newtype("stst","stmtstst",2,3);
		newtype("stmt","id=expr;",4,4);
		newtype("stmt","if(bool)stmt",5,5);
		newtype("stmt","if(bool)elsestmt",6,6);
		newtype("stmt","while(bool)stmt",5,7);
		newtype("stmt","dostmtwhile(bool);",7,8);
		newtype("stmt","break;",2,9);
		newtype("stmt","block",1,10);
		newtype("bool","expr<expr",3,11);
		newtype("bool","expr<=expr",4,12);
		newtype("bool","expr>expr",3,13);
		newtype("bool","expr>=expr",4,14);
		newtype("bool","expr",1,15);
		newtype("expr","expr+term",3,16);
		newtype("expr","expr-term",3,17);
		newtype("expr","term",1,18);
		newtype("term","term*term",3,19);
		newtype("term","term/term",3,20);
		newtype("term","factor",1,21);
		newtype("factor","(expr)",3,22);
		newtype("factor","id",1,23);
		newtype("factor","num",1,24);
		newtype("stst","stmt",1,25);
	}
	public static void getGotoMap()//初始化goto
	{
		Map<String,String> map=new HashMap<>();
		map.put("program","2");
		map.put("block","2");
		Mgoto.put(1, map);
		map=new HashMap<>();
		map.put("block","12");
		map.put("stst","5");
		map.put("stmt","6");
		Mgoto.put(4, map);
        map=new HashMap<>();
        map.put("block","12");
		map.put("stst","14");
		map.put("stmt","6");
		Mgoto.put(6, map);
		map=new HashMap<>();
		map.put("stmt","56");
		map.put("block", "12");
		Mgoto.put(10, map);
		map=new HashMap<>();
		map.put("expr","16");
		map.put("term","27");
		map.put("factor","21");
		Mgoto.put(15, map);
		map=new HashMap<>();
		map.put("term","18");
		map.put("factor","21");
		Mgoto.put(17, map);
		map=new HashMap<>();
		map.put("factor","25");
		Mgoto.put(19, map);
		map=new HashMap<>();
		map.put("factor","26");
		Mgoto.put(20, map);
		map=new HashMap<>();
		map.put("expr","28");
		map.put("term","30");
		Mgoto.put(22, map);
		map=new HashMap<>();
		map.put("factor","21");
		map.put("term","32");
		Mgoto.put(31, map);
		map=new HashMap<>();
		map.put("bool","41");
		map.put("term","40");
		map.put("factor","21");
		map.put("expr","34");
		Mgoto.put(33, map);
		map=new HashMap<>();
		map.put("expr","36");
		map.put("term","27");
		map.put("factor","21");
		Mgoto.put(35, map);
		map=new HashMap<>();
		map.put("expr","38");
		Mgoto.put(37, map);
		map=new HashMap<>();
		map.put("expr","58");
		map.put("term","40");
		map.put("factor","21");
		Mgoto.put(39, map);
		map=new HashMap<>();
		map.put("stmt","43");
		map.put("block","12");
		Mgoto.put(42, map);
		map=new HashMap<>();
		map.put("stmt","12");
		map.put("block","45");
		Mgoto.put(44, map);
		map=new HashMap<>();
		map.put("bool","48");
		map.put("term","40");
		map.put("factor","21");
		map.put("expr","34");
		Mgoto.put(47, map);
		map=new HashMap<>();
		map.put("bool","53");
		map.put("term","40");
		map.put("factor","21");
		map.put("expr","34");
		Mgoto.put(52, map);
		map=new HashMap<>();
		map.put("stmt","55");
		map.put("block","12");
		Mgoto.put(54, map);
	}
	public static String isFinal(String a)//查找终结符
	{
		//找出first
		StringBuffer a1=new StringBuffer();
		boolean flag=false;
		String a2=null;
		for(int i=0;i<a.length();i++)
		{
		a1.append(a.charAt(i));
		if(Final.contains(a1.toString()))
		{
			flag=true;
			a2=a1.toString();
			break;
		}
		}
		if(flag)
		return a2;
		else
		return null;
	}
	public static String isNFinal(String a)//得到非终结符
	{
		StringBuffer a1=new StringBuffer();
		boolean flag=false;
		String a2=null;
		for(int i=0;i<a.length();i++)
		{
		a1.append(a.charAt(i));
		if(NFinal.contains(a1.toString()))
		{
			flag=true;
			a2=a1.toString();
			break;
		}
		}
		if(flag)
		return a2;
		else
		return null;
	}
	public static void getTag()//初始化各种符号
	{
		Final.add("{");
		Final.add("}");
		Final.add("id");
		Final.add("=");
		Final.add("if");
		Final.add("(");
		Final.add(")");
		Final.add("else");
		Final.add("while");
		Final.add("do");
		Final.add(";");
		Final.add("break");
		Final.add("<");
		Final.add(">");
		Final.add("+");
		Final.add("-");
		Final.add("*");
		Final.add("/");
		Final.add("num");
		Final.add("$");
		NFinal.add("program");
		NFinal.add("block");
		NFinal.add("bool");
		NFinal.add("stst");
		NFinal.add("stmt");
		NFinal.add("expr");
		NFinal.add("term");
		NFinal.add("factor");
	}
	public static void cifa(String s1) throws IOException//开始语法分析
	{
		stack.push(1);
		stack1.push("$");
		System.out.println("步骤\t"+"状态栈\t"+"符号栈\t输入串\t"+"action\t"+"goto\t");
		int step=1;
		int top=1;
		while(s1!=null)
		{
		if(isFinal(s1)!=null)//查找action表
		{
			Map<String,String> map1=new HashMap<>();
			map1=Maction.get(top);//gai
			if(map1!=null)
			{
			if(map1.containsKey(isFinal(s1)))//终结符action
			{
			String s2=map1.get(isFinal(s1));//操作
			if(s2.charAt(0)=='r')//规约
			{
				String s3=s2.substring(1);
				int i=Integer.parseInt(s3);//按照第几条规则规约
				if(i==24)print24();
				if(i==19)print19();
				if(i==15)print15();
				if(i==5)print5();
				if(i==4)print4();
				if(i==7)print7();
				if(i==13)print13();
				if(i==11)print11();
				if(i==12)print12();
				if(i==14)print14();
				if(i==16)print16();
				if(i==17)print17();
				if(i==20)print20();
				if(i==23)print23();
				if(i==9)print9();
				if(i==8)print8();
				type type=new type();
				type=rule.get(i);
				int popnum=type.pop;//要弹出几条
				print(step,stack.toString(),stack1.toString(),s1,"按照"+type.right+"->"+type.left+"的规则进行规约",0);
				for(int flag=0;flag<popnum;flag++)
				{
				stack.pop();//状态栈弹出
				stack1.pop();//符号栈弹出
				}
				top=stack.peek();//顶端
				stack1.push(type.right);
				Map<String,String> map2=new HashMap<>();
				map2=Mgoto.get(top);//非终结符用goto
			    if(map2.containsKey(type.right))
			    {
			    	stack.push(Integer.parseInt(map2.get(type.right)));
			    	top=Integer.parseInt(map2.get(type.right));
			    	
			    }
			    else
			    {
			    	System.out.println("error sen!");
			    	p.write(("\r\n语法错误!\r\n当前状态 ："+top+"\r\n无法解析符号 ："+s1).getBytes());
			    	break;
			    }
			}
			else if(s2.charAt(0)=='s')//移入
			{
				String s3=s2.substring(1);
				print(step, stack.toString(), stack1.toString(),s1, s2, 1);
				stack.push(Integer.parseInt(s3));
				top=Integer.parseInt(s3);//现在那个状态
				stack1.push(isFinal(s1));
				s1=s1.substring(isFinal(s1).length());
			}
			else if(s2.equals("acc"))
			{
				//归约成功
				print(step, stack.toString(),stack1.toString(), s1, s2, 1);
				p.write(("success!").getBytes());
				System.out.println("\r\nsuccess!");
				break;
			}
			}
			else
			{
				//没有这个操作，出错
				System.out.println("error");
				p.write(("\r\n语法错误!\r\n当前状态 : "+top+"\r\n无法解析符号 ："+s1+"\r\n").getBytes());
				break;
			}
			}
			else
			{
				p.write(("\r\n语法错误!\r\n当前状态 : "+top+"\r\n无法解析符号 ："+s1+"\r\n").getBytes());
				break;
			}
		}
		else if (isNFinal(s1)!=null)//查找goto表
		{
			Map<String,String> map2=new HashMap<>();
			map2=Mgoto.get(top);//非终结符用goto
			if(map2!=null)
			{
			if(map2.containsKey(isNFinal(s1)))//非终结符有跳转
			{
			String s2=map2.get(isNFinal(s1));//跳转到哪
			print(step,stack.toString(),stack1.toString(),s1,s2,0);
			top=Integer.parseInt(s2);
			stack.push(Integer.parseInt(s2));
			s1=s1.substring(isNFinal(s1).length());
			}
			else
			{
				p.write(("\r\n语法错误！\r\n当前状态 ："+top+"\r\n无法解析符号 ："+s1+"\r\n").getBytes());
				System.out.println("error sentence!");
				break;
			}
			}
			else
			{
				p.write(("\r\n语法错误！\r\n当前状态 ："+top+"\r\n无法解析符号 ："+s1+"\r\n").getBytes());
				break;
			}
		}
		else 
		{
			System.out.println("error!can not identify the word!");
			p.write(("\r\n语法错误！\r\n当前状态 ："+top+"\r\n无法解析符号 ："+s1+"\r\n").getBytes());
			break;
		}
		step+=1;//步骤加一
		}
	}
	public static void print(int step,String stack,String stack1,String s1,String AorG,int i) throws IOException
	{
		if(i==1)//action操作
		{
	    p.write((step+"\t状态栈 "+stack.toString()+"\t\t符号栈 "+stack1.toString()+"\t\t\t输入串 "+s1+"\t\t\taction:  "+AorG+"\r\n").getBytes());
		//System.out.println(step+"\t\t状态栈 "+stack.toString()+"\t\t\t\t符号栈 "+stack1.toString()+"\t\t\t\t\t\t\t输入串 "+s1+"\t\t\t\t\t\t\taction:  "+AorG);
		}
		else
		{
			p.write((step+"\t状态栈 "+stack.toString()+"\t\t符号栈 "+stack1.toString()+"\t\t\t输入串 "+s1+"\t\t\tgoto:  "+AorG+"\r\n").getBytes());
			//System.out.println(step+"\t\t状态栈 "+stack.toString()+"\t\t\t\t符号栈 "+stack1.toString()+"\t\t\t\t\t\t\t输入串 "+s1+"\t\t\t\t\t\t\tgoto:  "+AorG);
		}
	}
	static OutputStream p=null;
	public static void fanyi() throws IOException
	{
		int j=bool.size();
    	Stack<List> bool1=new Stack<List>();
    	for(int i=0;i<j;i++)
    	{
    		bool1.add(bool.pop());
    	}
    	int add=0;
    	for(int i=0;i<j;i++)
    	{
    		List<String> list1=bool1.pop();
    		for(int z=0;z<list1.size();z++)
    		{
    			String s3=(String) list1.get(z);
    			if(s3.charAt(0)!='L')
    			{
    			p.write((add+" ").getBytes());
    			p.write((list1.get(z)+"\r\n").getBytes());
    			add++;
    			}
    			else
    			{
    			p.write((list1.get(z)+"\r\n").getBytes());	
    			}
    		}
    	}
	}
    public static void main(String []arg) throws IOException
    {
    	
    	getActionMap();
    	getGotoMap();
    	newrule();
    	getTag();
    	p=new FileOutputStream(new File("C:\\Users\\Mac\\Desktop\\result.txt"));
    	String str=input.getinput();
    	p.write(("分析代码\r\n"+str+"\r\n\r\n").getBytes());
    	String s1="{if(id){id=id/num+num;while(id)break;}}$";
    	String s2="{whilebool}$";
    	cifa(str);
    	p.write(("\r\n\r\n语法分析\r\n").getBytes());
    	fanyi();
    	p.close();
    }
}
