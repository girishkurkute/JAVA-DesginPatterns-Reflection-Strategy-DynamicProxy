package genericCheckpointing.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class GetObject {

	Boolean startFirstFlag = false;
	Boolean startSecondFlag = false;
	
	Object currObj = null;
	
	private String myInt_First;
	private String myOtherInt_First;
	private String myLong_First;
	private String myOtherLong_First;
	private String myString_First;
	private String myBool_First;
	
	private String myDoubleT_Sec;
	private String myFloatT_Sec;
	private String myShortT_Sec;
	private String myCharT_Sec;
	private String myOtherDoubleT_Sec;
	
	
	public Object createObject(ArrayList<String> filedata) {
		// TODO Auto-generated method stub
		currObj = null;
		myInt_First = null;
		 myOtherInt_First = null;
		 myLong_First = null;
		 myOtherLong_First = null;
		 myString_First = null;
		 myBool_First = null;
		
		 myDoubleT_Sec = null;
		 myFloatT_Sec = null;
		 myShortT_Sec = null;
		 myCharT_Sec = null;
		 myOtherDoubleT_Sec = null;
		 
		for(String strCurr : filedata)
		{
			 
			 
			if(strCurr.contains("genericCheckpointing.util.MyAllTypesFirst"))
			{
				startFirstFlag = true;
				continue;
			}
			else if(strCurr.contains("genericCheckpointing.util.MyAllTypesSecond"))
			{
				startSecondFlag = true;
				continue;
			} 
			else if(strCurr.contains("</complexType>"))
			{
				if(startFirstFlag)
				{
					startFirstFlag = false;
					createFirstObj(myInt_First,myOtherInt_First,myLong_First,myOtherLong_First,myString_First,myBool_First);					
					myInt_First = null;
					 myOtherInt_First = null;
					 myLong_First = null;
					 myOtherLong_First = null;
					 myString_First = null;
					 myBool_First = null;
				}
				else if(startSecondFlag)
				{
					startSecondFlag = false;
					createSecObj(myDoubleT_Sec,myFloatT_Sec ,myShortT_Sec ,myCharT_Sec ,myOtherDoubleT_Sec );
					myDoubleT_Sec = null;
					 myFloatT_Sec = null;
					 myShortT_Sec = null;
					 myCharT_Sec = null;
					 myOtherDoubleT_Sec = null;
				}
				
			}
			
			
			if(startFirstFlag)
			{
				if(strCurr.contains("myInt"))
				{				
					 myInt_First = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myOtherInt"))
				{
					 myOtherInt_First = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myLong"))
				{
					 myLong_First = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myOtherLong"))
				{
					 myOtherLong_First = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myString"))
				{
					 myString_First = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myBool"))
				{
					 myBool_First = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
			}
			
			
			
			if(startSecondFlag)
			{
				if(strCurr.contains("myDoubleT"))
				{				
					myDoubleT_Sec = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myFloatT"))
				{				
					myFloatT_Sec = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myShortT"))
				{				
					myShortT_Sec = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myCharT"))
				{				
					myCharT_Sec = strCurr.replaceAll("<.*?>"," ").trim();					
				}
				
				if(strCurr.contains("myOtherDoubleT"))
				{				
					myOtherDoubleT_Sec = strCurr.replaceAll("<.*?>"," ").trim();					
				}
			}
				 
			
		}
		return currObj;
	}

	private void createSecObj(String myDoubleT_Sec2, String myFloatT_Sec2,
			String myShortT_Sec2, String myCharT_Sec2,
			String myOtherDoubleT_Sec2) {
		// TODO Auto-generated method stub
		String clsName = "genericCheckpointing.util.MyAllTypesSecond"; 
		Class cls = null;
		try
		{
			cls = Class.forName(clsName);
		}
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();
			System.exit(1);
		}
		
		Class[] signature = new Class[5]; 
		signature[0] = double.class;
		signature[1] = float.class; 
		signature[2] = short.class;
		signature[3] = char.class; 
		signature[4] = double.class;
		
		String myDoubleTMethod = "set" + "MyDoubleT";
		String myFloatTMethod = "set" + "MyFloatT";
		String myShortTMethod = "set" + "MyShortT";
		String myCharTMethod = "set" + "MyCharT";
		String myOtherDoubleTMethod = "set" + "MyOtherDoubleT";
		
		
		 Method meth_MyDoubleT = null;
		 Method meth_MyFloatT = null;
		 Method meth_MyShortT = null;
		 Method meth_MyCharT = null;
		 Method meth_MyOtherDoubleT = null;
		
		
		 try
		 {
			 meth_MyDoubleT = cls.getMethod(myDoubleTMethod, signature[0]); 
			 meth_MyFloatT = cls.getMethod(myFloatTMethod, signature[1]);
			 meth_MyShortT = cls.getMethod(myShortTMethod, signature[2]); 
			 meth_MyCharT = cls.getMethod(myCharTMethod, signature[3]); 
			 meth_MyOtherDoubleT = cls.getMethod(myOtherDoubleTMethod, signature[4]); 
			 
			 
		 }
		 catch (NoSuchMethodException e)
		 {
			 e.printStackTrace();
			 System.exit(1);
		 }
		 
		 Object obj = null;
		 
		 try
		 {
			 obj = cls.newInstance();
		 }
		 catch (InstantiationException | IllegalAccessException e) 
		 {		
			e.printStackTrace();
			System.exit(1);
		} 
		 
		 Object[] params = new Object[5];
		 
		 try
		 {
			 if(myDoubleT_Sec != null)
			 {
				 params[0] = new Double(Double.parseDouble(myDoubleT_Sec));
			 }
		    		
			 if(myFloatT_Sec != null)
			 {
				 params[1] = new Float(Float.parseFloat(myFloatT_Sec));
			 }
		    		
			 if(myShortT_Sec != null)
			 {
				 params[2] = new Short(Short.parseShort(myShortT_Sec));
			 }
		    		
			 if(myCharT_Sec != null)
			 {
				 params[3] = new Character(myCharT_Sec.charAt(0));
			 }
		    		
			 if(myOtherDoubleT_Sec != null)
			 {
				 params[4] = new Double(Double.parseDouble(myOtherDoubleT_Sec));
			 }
		    		
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				System.exit(1);
		 }
		 
		 
		 Object resultmyDoubleT = null;
		 Object resultmyFloatT = null;
		 Object resultmyShortT = null;
		 Object resultmyCharT = null;
		 Object resultmyOtherDoubleT = null;
		 
		 try
		 {		 			 
			 if(myDoubleT_Sec != null)
			 {
				 resultmyDoubleT = meth_MyDoubleT.invoke(obj, params[0]);
			 }
		    		
			 if(myFloatT_Sec != null)
			 {
				 resultmyFloatT = meth_MyFloatT.invoke(obj, params[1]);
			 }
		    		
			 if(myShortT_Sec != null)
			 {
				 resultmyShortT = meth_MyShortT.invoke(obj, params[2]);
			 }
		    		
			 if(myCharT_Sec != null)
			 {
				 resultmyCharT = meth_MyCharT.invoke(obj, params[3]);
			 }
		    		
			 if(myOtherDoubleT_Sec != null)
			 {
				 resultmyOtherDoubleT = meth_MyOtherDoubleT.invoke(obj, params[4]);
			 }
		    		
			
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				System.exit(1);
		 }
		 
		 currObj = obj;
		 
	}

	private void createFirstObj(String myInt_First2, String myOtherInt_First2,
			String myLong_First2, String myOtherLong_First2,
			String myString_First2, String myBool_First2) {
		// TODO Auto-generated method stub
		String clsName = "genericCheckpointing.util.MyAllTypesFirst"; 
		Class cls = null;
		try
		{
			cls = Class.forName(clsName);
		}
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();
			System.exit(1);
		}
	     
		Class[] signature = new Class[6]; 
		signature[0] = int.class;
		signature[1] = int.class; 
		signature[2] = long.class;
		signature[3] = long.class; 
		signature[4] = String.class;
		signature[5] = boolean.class;
		
		String myIntMethod = "set" + "MyInt";
		String myOtherIntMethod = "set" + "MyOtherInt";
		String myLongMethod = "set" + "MyLong";
		String myOtherLongMethod = "set" + "MyOtherLong";
		String myStringMethod = "set" + "MyString";
		String myBoolMethod = "set" + "MyBool";
		
		 Method meth_myInt = null;
		 Method meth_myOtherInt = null;
		 Method meth_myLong = null;
		 Method meth_myOtherLong = null;
		 Method meth_String = null;
		 Method meth_Bool = null;
		
		 try
		 {
			 meth_myInt = cls.getMethod(myIntMethod, signature[0]); 
			 meth_myOtherInt = cls.getMethod(myOtherIntMethod, signature[1]);
			 meth_myLong = cls.getMethod(myLongMethod, signature[2]); 
			 meth_myOtherLong = cls.getMethod(myOtherLongMethod, signature[3]); 
			 meth_String = cls.getMethod(myStringMethod, signature[4]); 
			 meth_Bool = cls.getMethod(myBoolMethod, signature[5]); 
			 
		 }
		 catch (NoSuchMethodException e)
		 {
			 e.printStackTrace();
			 System.exit(1);
		 }
		 
		 Object obj = null;
		 
		 try
		 {
			 obj = cls.newInstance();
		 }
		 catch (InstantiationException | IllegalAccessException e) 
		 {		
			e.printStackTrace();
			System.exit(1);
		} 
		 
		 Object[] params = new Object[6];
		 
		 try
		 {
			 if(myInt_First != null)
			 {
				 params[0] = new Integer(Integer.parseInt(myInt_First));
			 }
		    		
			 if(myOtherInt_First != null)
			 {
				 params[1] = new Integer(Integer.parseInt(myOtherInt_First));
			 }
		    		
			 if(myLong_First != null)
			 {
				 params[2] = new Long(Long.parseLong(myLong_First));
			 }
		    		
			 if(myOtherLong_First != null)
			 {
				 params[3] = new Long(Long.parseLong(myOtherLong_First));
			 }
		    		
			 if(myString_First != null)
			 {
				 params[4] = new String(myString_First);
			 }
		    		
			 if(myBool_First != null)
			 {
				 params[5] = new Boolean(Boolean.parseBoolean(myBool_First));
			 }
		    		
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				System.exit(1);
		 }
		 
		 Object resultmyInt = null;
		 Object resultmyOtherInt = null;
		 Object resultmyLong = null;
		 Object resultmyOtherLong = null;
		 Object resultString = null;
		 Object resultBool = null;
		 
		 try
		 {		 			 
			 if(myInt_First != null)
			 {
				 resultmyInt = meth_myInt.invoke(obj, params[0]);
			 }
		    		
			 if(myOtherInt_First != null)
			 {
				 resultmyOtherInt = meth_myOtherInt.invoke(obj, params[1]);
			 }
		    		
			 if(myLong_First != null)
			 {
				 resultmyLong = meth_myLong.invoke(obj, params[2]);
			 }
		    		
			 if(myOtherLong_First != null)
			 {
				 resultmyOtherLong = meth_myOtherLong.invoke(obj, params[3]);
			 }
		    		
			 if(myString_First != null)
			 {
				 resultString = meth_String.invoke(obj, params[4]);
			 }
		    		
			 if(myBool_First != null)
			 {
				 resultBool = meth_Bool.invoke(obj, params[5]);
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				System.exit(1);
		 }
		 
		 currObj =  obj;
	}

	
}
