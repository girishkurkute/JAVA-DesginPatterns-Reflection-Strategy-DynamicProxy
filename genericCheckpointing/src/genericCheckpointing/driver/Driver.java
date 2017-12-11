package genericCheckpointing.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.GetObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String mode = "";
		int NUM_OF_OBJECTS = 0;
		String fileName = "";
		 ArrayList<SerializableObject> ObjectList = new ArrayList<SerializableObject>();
		try
		{
			if(args.length !=3)
			{			
				throw new RuntimeException("Please provide 3 arguments");
			}
			else
			{
				mode = args[0];
				NUM_OF_OBJECTS = Integer.parseInt(args[1]);
				fileName = args[2];
			}
			
			ProxyCreator pc = new ProxyCreator();
			StoreRestoreHandler hnd = new StoreRestoreHandler();
			StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
					 new Class[] { StoreI.class, RestoreI.class},  hnd);
			
			
			GetObject allTypObj = new GetObject();
			String currLine;
			
			
			
			
			
			MyAllTypesFirst myFirst;
			MyAllTypesSecond  mySecond;
			
			SerializableObject myRecordRet;
			Object temp = null;
			
			if(mode.equalsIgnoreCase("deser"))
			{
				hnd.setFileName(fileName);
				hnd.openFile();
				for (int i=0; i<NUM_OF_OBJECTS; i++) 
				{
					temp = ((RestoreI) cpointRef).readObj("XML");
					myRecordRet = (SerializableObject) temp;
					System.out.println(myRecordRet.toString());
				}
			}
			else if(mode.equalsIgnoreCase("serdeser"))
			{
				for (int i=1; i<=NUM_OF_OBJECTS; i++) 
				{
					int authID = 0;
					 int rand = 0;
					 int myInt;
					 int myOtherInt;
					 long myLong;
					 long myOtherLong;
					 String myString;
					 boolean myBool;
					rand = allTypObj.getRandomNumber(1,100);
					myInt = rand * i;
					rand = allTypObj.getRandomNumber(1,100);
					myOtherInt = rand * i;
					rand = allTypObj.getRandomNumber(1,100);
					myLong = rand * 1000 + rand * i;
					rand = allTypObj.getRandomNumber(1,100);
					myOtherLong = rand * 1000 + rand * i;
					rand = allTypObj.getRandomNumber(1,100);
					myString = "DP" + Integer.toString(rand);
					rand = allTypObj.getRandomNumber(1,9999);
					authID = rand;
					if(i%2 == 0)
					{
						myBool = false;
					}
					else
					{
						myBool = true;
					}
					myFirst = new MyAllTypesFirst(myInt,myOtherInt,myLong,myOtherLong,myString,myBool);
					ObjectList.add(myFirst);
					System.out.println(myFirst.toString());
					((StoreI) cpointRef).writeObj(myFirst,authID, "XML"); 
					
					 double myDoubleT;
					 float myFloatT;
					 short myShortT;
					 char myCharT;
					 double myOtherDoubleT;
					 
					 rand = allTypObj.getRandomNumber(1,9);
					 myDoubleT = rand ;
						rand = allTypObj.getRandomNumber(1,100);
						myFloatT = (float) (rand * i * 2.302);
						rand = allTypObj.getRandomNumber(1,100);
						myShortT = (short) (rand * 10 + rand * i);
						rand = allTypObj.getRandomNumber(97,122);
						myCharT = (char)rand;
						rand = allTypObj.getRandomNumber(1,100);
						myOtherDoubleT = rand * 1000 + rand * i;
						rand = allTypObj.getRandomNumber(1,9999);
						authID = rand;
				   mySecond = new MyAllTypesSecond(myDoubleT,myFloatT,myShortT,myCharT,myOtherDoubleT);
				   ObjectList.add(mySecond);
				   System.out.println(mySecond.toString());
				   ((StoreI) cpointRef).writeObj(mySecond,authID, "XML");
				}
				
				System.out.println("deserialization");
				//deserialization of object
				hnd.setFileName("output.txt");
				hnd.openFile();
				int length = NUM_OF_OBJECTS * 2;
				int mismatchedCounter = 0;
				for (int i=0; i<length; i++) 
				{
					temp = ((RestoreI) cpointRef).readObj("XML");
					myRecordRet = (SerializableObject) temp;
					System.out.println(myRecordRet.toString());
					
				}
				
				
				 
			}
			
			

		}
		catch(FileNotFoundException fileNotFndexp)
		{
			System.err.println("File not found: "+fileNotFndexp);
			System.exit(1);
		}
		catch(IOException ioexp)
		{
			System.err.println("Error in I/O: "+ioexp);
			System.exit(1);
		}
		catch(IndexOutOfBoundsException indexOutExp)
		{
			System.err.println("Input file is empty: "+indexOutExp);
			System.exit(1);
		}
		catch(NullPointerException nullPtrExp)
		{
			System.err.println("Input file is empty: "+nullPtrExp);
			System.exit(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
				
	    
	}

}
