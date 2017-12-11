package genericCheckpointing.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Results {
	public ArrayList<String> oriTreeDataList = new ArrayList<String>();
	private String outputFileName;
	FileWriter FWrt = null;
	
	/**
	 * constructor to initialize the output file name
	 * @param outputfile a name of output file
	 * @throws IOException 
	 */
	public Results(String outputfile) {
		// TODO Auto-generated constructor stub
		
		this.outputFileName=outputfile;
		File f = new File(outputFileName);
		try {
			FWrt = new FileWriter(this.outputFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * writeToFile method used to write a result into output file
	 * @param arrList a datastructure which stores all the tress values
	 * @throws IOException 
	 * @returns nothing
	 */
	public void writeToFile(ArrayList<String> arrList) throws IOException {
		// TODO Auto-generated method stub
		//FileWriter FWrt = null;
		try
		{
			FWrt = new FileWriter(this.outputFileName,true);
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		
		for(String currentLine : arrList)
		{
			if(!currentLine.isEmpty())
			{
				if(currentLine.length() != 0)
				{
				FWrt.write(currentLine);
				FWrt.write("\r\n");
				}
			}
			
		}
		FWrt.close();
	}
}
