package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mode = "deser";
		int N = 1;
		String opFile = "Output.txt";
		
		ProxyCreator pc = new ProxyCreator();
		//StoreRestoreHandler hnd = new StoreRestoreHandler();
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
				 new Class[] { StoreI.class, RestoreI.class},  new StoreRestoreHandler());
		
		
		
		
		MyAllTypesFirst myFirst;
		MyAllTypesSecond  mySecond;
		
	}

}
