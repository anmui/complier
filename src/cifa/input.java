package cifa;

import java.util.Scanner;

public class input {
       public static String getinput()
       {
    	   String sen;;
    	   StringBuffer str=new StringBuffer();
    	   Scanner input=new Scanner(System.in);
    	   System.out.println("ÇëÊäÈë´úÂë£º");
    	   int j=0;
    	   while(true)
    	   {
    	   sen=input.next();//ÊäÈë×Ö·û´®
    	   for(int i=0;i<sen.length();i++)
    	   {
    		   if(sen.charAt(i)!=' '&&sen.charAt(i)!='\r'&&sen.charAt(i)!='\n'&&sen.charAt(i)!='\t')
    		   {
    			   str.append(sen.charAt(i));
    		   }
    		   if(sen.charAt(i)=='$')
    		   {
    			   j=1;
    			   break;
    		   }
    	   }
    	   if(j==1)
    	   {
    		   break;
    	   }
    	   }
    	   return str.toString();
       }
}
