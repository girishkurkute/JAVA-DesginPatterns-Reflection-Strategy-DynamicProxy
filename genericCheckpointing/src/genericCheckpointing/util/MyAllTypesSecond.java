package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	
	public double myDoubleT;
	public float myFloatT;
	public short myShortT;
	public char myCharT;
	public double myOtherDoubleT;
	
	public MyAllTypesSecond(double myDoubleT2, float myFloatT2,
			short myShortT2, char myCharT2, double myOtherDoubleT2) {
		// TODO Auto-generated constructor stub
		myDoubleT = myDoubleT2;
		myFloatT = myFloatT2;
		myShortT = myShortT2;
		myCharT = myCharT2;
		myOtherDoubleT = myOtherDoubleT2;
	}
	public double getMyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	public float getMyFloatT() {
		return myFloatT;
	}
	public void setMyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	public short getMyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	public char getMyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	@Override
	public String toString() {
		return "MyAllTypesSecond [myDoubleT=" + myDoubleT + ", myFloatT="
				+ myFloatT + ", myShortT=" + myShortT + ", myCharT=" + myCharT
				+ ", myOtherDoubleT=" + myOtherDoubleT + "]";
	}
	


}
