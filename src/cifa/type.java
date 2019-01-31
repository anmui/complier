package cifa;

import java.util.ArrayList;
import java.util.List;

public class type {
	String From;//规约到式子
	String FirstSign;//第一个符号
	String Residual;//剩下的式子
	List<String> first=new ArrayList<String>();
	public type()
	{
		first.add("0");
	}
	String right;//左边
	String left;//右边
	int pop;//要弹出几个
}
