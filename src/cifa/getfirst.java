package cifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class getfirst {
	static List<String> NfinalTag=new ArrayList<String>();//���ս������
	
	static List<String> finalTag=new ArrayList<String>();//�ս������
	
	static List<String> Empty=new ArrayList<String>();//���ս�����У����˳��մ���
	
	static Map<String,List<String>> pro=new HashMap<String,List<String>>();//ÿ�����ս����һ�����ʽ
	static Map<String,List<String>> numfinal=new HashMap<String,List<String>>();//�ս����first��
    
	public static String isFtag(String a)//�����ս��
	{
		//�ҳ�first
		StringBuffer a1=new StringBuffer();
		boolean flag=false;
		String a2=null;
		for(int i=0;i<a.length();i++)
		{
		a1.append(a.charAt(i));
		if(finalTag.contains(a1.toString()))
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
	public static String isNFtag(String a)//���ҷ��ս��
	{
		//�ҳ�first
		StringBuffer a1=new StringBuffer();
		boolean flag=false;
		String a2=null;
		for(int i=0;i<a.length();i++)
		{
		a1.append(a.charAt(i));
		if(NfinalTag.contains(a1.toString()))
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
	
	public static void getfirst()
	{
	NfinalTag.add("H");
	NfinalTag.add("S");
	NfinalTag.add("M");
	finalTag.add("a");
    finalTag.add("b");
    finalTag.add("c");
    Empty.add("S");
    Empty.add("M");
	List<String> s1=new ArrayList<String>();
	s1.add("SM");
	s1.add("M");
	pro.put("H", s1);
	List<String> s3=new ArrayList<String>();
	s3.add("b");
	pro.put("S", s3);
	List<String> s5=new ArrayList<String>();
	
	s5.add("Sc");
	
	pro.put("M", s5);
	int Nfl=NfinalTag.size();
	for(int i=0;i<Nfl;i++)
	{
		List<String> s4=new ArrayList<String>();//���ս�������
		s4=pro.get(NfinalTag.get(i));//�õ�һ�����ʽ
		List<String> Nflist=new ArrayList<String>();//ÿ�����ս���ķ��ս������
		List<String> Final=new ArrayList<String>();//�ս������
		if(Empty.contains(NfinalTag.get(i)))//�մ�
		{
			Final.add("0");
		}
		Queue<String> queue = new LinkedList<String>();//����
		queue.add(NfinalTag.get(i));
		Nflist.add(NfinalTag.get(i));
		for(int j=0;j<s4.size();j++)
		{
			
	        /*
			String a=isNFtag(s4.get(j));
			//if(a!=null)
				if(!Nflist.contains(a))
				{
				Nflist.add(a);
				queue.add(a);
				if(Empty.contains(a))
				{
					a=s4.get(j).substring(a.length());
					String a1=isNFtag(a);
					if(a1!=null&&!Nflist.contains(a1))
					{
						Nflist.add(a1);
						queue.add(a1);
					}
					else
					{
						a1=isFtag(a);
						if(a1!=null&&!Final.contains(a1))
						{
							Final.add(a1);
						}
					}
				}*/
				//System.out.println(queue.size());
				for(int z=queue.size();z>0;)//�ұ�������ķ��ս�
				{
				String a=queue.poll();//ȡ��һ�����ս��
				//System.out.println(queue.size());
				List<String> ls=new ArrayList<String>();
				ls=pro.get(a);
				//System.out.println(a+"  "+ls);
				for(int c=0;c<ls.size();c++)
				{
					String a1;//�õ����ս��
					a1=isNFtag(ls.get(c));
					//System.out.println(ls.get(c));
					if(a1!=null)//��һ���Ƿ��ս��
					{
					if(!Nflist.contains(a1)&&a1!=null)
					{
						//System.out.println(a);
						Nflist.add(a1);
						queue.add(a1);						
					}
					String a3=ls.get(c);//��һ�������Ƴ��մ�
					
					//a=isNFtag(a3);
					while(Empty.contains(a1)&&a1!=null)//Ϊ��
					{
						System.out.println("111"+a1);
						a3=a3.substring(a1.length());
						//System.out.println("11111"+a3);
						if(a3.length()==0)
						{
							//System.out.println("11111"+a3);
							Empty.add(a);
							if(!Final.contains("0"))
							Final.add("0");
							break;
						}
						a1=isNFtag(a3);//�մ��ұ�
						if(a1!=null)
						{
							if(!Nflist.contains(a1))
							{
							Nflist.add(a1);
							queue.add(a1);
							}
							//a3=a3.substring(a1.length());
							//a1=isNFtag(a3);
						}
					}
					a1=isFtag(a3);//�ս��
					//System.out.println(a1);
					if(a1!=null&&!Final.contains(a1))
					{
						Final.add(a1);
					}
					//System.out.println("222"+a3);
					}
				}
				z=queue.size();
				//System.out.println(ls.size());
				}
				
			
			/*if(NfinalTag.contains(s4.get(j)))//�����߰������ս��
				{
				List<String> s5=new ArrayList<String>();//����߷��ս�������
			    s5=pro.get(s4.get(j));
			    for(int z=0;z<s5.size();z++)//����ÿһ����߷��ս�������
			    {
			    	String a1=s5.get(z);
			    	if(isFtag(a1)!=null)//���aΪ�ս��
			    	{
			    		System.out.println(a1);
			    	}
			    	
			    }
			    //System.out.println(s5);
				}*/
		}
		System.out.println(Nflist);
		for(int j=0;j<Nflist.size();j++)
		{
			List<String> s2=new ArrayList<String>();
			s2=pro.get(Nflist.get(j));//�õ����ս�������
			for(int z=0;z<s2.size();z++)
			{
			String a2=isNFtag(s2.get(z));
			if(Empty.contains(a2)&&a2!=null)
			{
				a2=s2.get(z).substring(a2.length());
				String a1=isNFtag(a2);
				if(a1!=null&&!Nflist.contains(a1))
				{
					a2=a2.substring(a1.length());
				}
				else
				{
					a1=isFtag(a2);
					if(a1!=null&&!Final.contains(a1))
					{
						Final.add(a1);
					}
				}
			}
			String a1=isFtag(s2.get(z));
			if(a1!=null&&!Final.contains(a1))
			{
				Final.add(a1);//�����ս��
			}
			}
		}
		numfinal.put(NfinalTag.get(i), Final);
	}
	System.out.println(numfinal);
	}
	public static void addNfinal()
	{
		Queue<String> queue = new LinkedList<String>();
		List<String> queue1=new ArrayList<String>();//�Ѿ�������ս��
		Map<String,List<String>> map= new HashMap<String,List<String>>();
		queue1.add("H");
		queue.add("H");
		while(queue!=null)
		{
			String a=queue.poll();//ȡ�����ս��
			List<String> ls=new ArrayList<String>();
			ls=pro.get(a);
			System.out.println(ls.size());
			for(int i=0;i<ls.size();i++)
			{
				type type=new type();
				type.From=ls.get(i);
				type.Residual=ls.get(i);
				String s1=isNFtag(ls.get(i));
				if(s1!=null)
				{
					if(!queue1.contains(s1))
					{
					String s2=ls.get(i).substring(s1.length());//ʣ�µĲ���
					if(isNFtag(s2)!=null)//���ս��
					{
						List<String> lists=new ArrayList<String>();
						lists=numfinal.get(isNFtag(s2));//first����
						if(lists.contains("0"));
						lists.addAll(type.first);
						if(map.containsKey(s1))
						{
							List<String> list2=new ArrayList<String>();
							list2=map.get(s1);
							list2.addAll(lists);
							map.put(s1, list2);
						}
						else
						{
							map.put(s1, lists);
						}
					}
					else
					{
						if(isFtag(s2)!=null)//�ս��
						{
							List<String> list2=new ArrayList<String>();
							if(map.containsKey(s1))
							{
								list2=map.get(s1);
								list2.add(isFtag(s2));
								map.put(s1, list2);
							}
							else
							{
								list2.add(isFtag(s2));
								map.put(s1, list2);
							}
						}
					}
					queue.add(s1);
					queue1.add(s1);
					type.FirstSign=s1;
					}
					else
					{
						List<String> list2=new ArrayList<String>();
						list2=map.get(s1);//Ҫѭ����map���Ѿ�����
						String s2=ls.get(i).substring(s1.length());//ʣ�µĲ���
						List<String> list1=new ArrayList<String>();
						if(isNFtag(s2)!=null)
						{
							list1=numfinal.get(isNFtag(s2));
						}
						else
						{
							if(isFtag(s2)!=null)
							{
								list1.add(isFtag(s2));
							}
							else
							{
								System.out.println("error");
								break;
							}
						}
						list2.addAll(list1);
						map.put(s1, list2);
						type.FirstSign=s1;
					}
				}
				else 
				{
					s1=isFtag(ls.get(i));
					if(s1==null)
					{
						System.out.println("error");//�������
						break;
					}
					else
						type.FirstSign=s1;
				}
				//List<String> first=new ArrayList<String>();
				//first.add("-1");//��ǰ��
				type.first=map.get(s1);
				System.out.println(type.first);
			}
		}
	}
	public static void main(String[]arg)
	{
		getfirst();
		addNfinal();
		
		
	}
}
