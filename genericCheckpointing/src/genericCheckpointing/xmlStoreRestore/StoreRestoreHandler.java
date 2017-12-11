package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.GetObject;
import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StoreRestoreHandler implements InvocationHandler{

	private String checkpointFile;
	private String currLine;
	FileProcessor fprObj = null;
	Results rlt = new Results("output.txt");
 	XMLSerialization xmlSer = new XMLSerialization(rlt);
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		//write call
		Object currObj = null;
		String name = method.getName();
		if(name.equalsIgnoreCase("readObj"))
		{
			if(args[0].equals("XML"))
			{
				currObj = deserializeData(new XMLDeserialization(fprObj));
				
				//System.out.println(currObj.toString());
				//System.out.println();
			}
		}
		else if(name.equalsIgnoreCase("writeObj"))
		{
			SerStrategy str = new XMLSerialization(rlt);
			if(args[2].equals("XML"))
			{
				serializeData((SerializableObject) args[0] , str);
			}
		}
		
		return currObj;
	}

	private Object deserializeData(XMLDeserialization xmlDeserialization) throws FileNotFoundException 
	{
		
		Object currObj = null;
		
		return currObj = xmlDeserialization.processFile();
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) throws IOException 
	{
		xmlSer.processInput(sObject);
	}

	public void setFileName(String fileNameIn) {
		// TODO Auto-generated method stub
		checkpointFile = fileNameIn;
		
	}
	
	public void openFile() throws Exception {
		
		
		fprObj = new FileProcessor(checkpointFile);
		XMLDeserialization desObj = new XMLDeserialization(fprObj);
	}
}
