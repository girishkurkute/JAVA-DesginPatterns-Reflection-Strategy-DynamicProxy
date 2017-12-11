package genericCheckpointing.xmlStoreRestore;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.GetObject;
import genericCheckpointing.util.SerializableObject;

public class XMLDeserialization implements SerStrategy{

	FileProcessor fobj = null;
	String currLine = "";
	GetObject allTypObj = new GetObject();
	
	public XMLDeserialization(FileProcessor fprObj) {
		
		// TODO Auto-generated constructor stub
		fobj = fprObj;
	}

	@Override
	public void processInput(SerializableObject sObject) {
		// TODO Auto-generated method stub
		
	}

	public Object processFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Object currObj = null;
		ArrayList<String> Filedata = new ArrayList<String>();
		while(!(currLine = fobj.readLine()).equalsIgnoreCase("</DPSerialization>"))
		{
			Filedata.add(currLine);
		}
		
		return currObj = allTypObj.createObject(Filedata);
	}

	
}
