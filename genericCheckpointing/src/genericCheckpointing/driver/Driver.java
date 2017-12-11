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
		 ArrayList<Object> ObjectList = new ArrayList<Object>();
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
			
			
			
			String currLine;
			
			hnd.setFileName(fileName);
			hnd.openFile();
			
			
			MyAllTypesFirst myFirst;
			MyAllTypesSecond  mySecond;
			
			SerializableObject myRecordRet;
			Object temp = null;
			
			if(mode.equalsIgnoreCase("deser"))
			{
				
				for (int i=0; i<NUM_OF_OBJECTS; i++) 
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
