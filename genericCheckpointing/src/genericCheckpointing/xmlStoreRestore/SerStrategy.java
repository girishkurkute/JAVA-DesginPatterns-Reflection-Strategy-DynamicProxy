package genericCheckpointing.xmlStoreRestore;

import java.io.IOException;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategy {
	void processInput(SerializableObject sObject) throws IOException;
}
