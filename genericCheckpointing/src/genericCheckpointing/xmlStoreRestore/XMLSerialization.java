package genericCheckpointing.xmlStoreRestore;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

public class XMLSerialization implements SerStrategy{

	Results rObj = null;
	public XMLSerialization(Results rlt) {
		// TODO Auto-generated constructor stub
		rObj = rlt;
	}

	@Override
	public void processInput(SerializableObject sObject) throws IOException {
		// TODO Auto-generated method stub
		 ArrayList<String> serializedDataList = new ArrayList<String>();
		String classTypeStr = "";
		String tempcls = "";
		String fullClassName = "";
		
		String DPSerStart = "<DPSerialization>";
		serializedDataList.add(DPSerStart);
		System.out.println(DPSerStart);
		
		
		Class className = sObject.getClass();
		classTypeStr =  className.toString();
		String[] temp = classTypeStr.split(" ");
		tempcls = "<complexType xsi:type=\"" + temp[1];
		fullClassName = tempcls +"\">";
		serializedDataList.add(fullClassName);
		System.out.println(fullClassName);
				
		Field[] fldList = className.getDeclaredFields();
		
		int len = fldList.length;
		for(int i =0; i<len ; i++)
		{
			String fldName = fldList[i].getName();
			String fieldStart = "<"+fldName + " "+"xsi:type=\"xsd:";
			
			String fldType = fldList[i].getType().toString();
			fieldStart = fieldStart + fldType+"\">";
			
			try
			{
				String val = fldList[i].get(sObject).toString();
				String fullFieldStr = fieldStart + val + "</"+fldName+">";
				serializedDataList.add(fullFieldStr);
				System.out.println(fullFieldStr);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		String classEnd = "</complexType>";
		serializedDataList.add(classEnd);
		System.out.println(classEnd);
		String DPSerEnd = "</DPSerialization>";
		serializedDataList.add(DPSerEnd);
		System.out.println(DPSerEnd);
		
		rObj.writeToFile(serializedDataList);
	}

}
