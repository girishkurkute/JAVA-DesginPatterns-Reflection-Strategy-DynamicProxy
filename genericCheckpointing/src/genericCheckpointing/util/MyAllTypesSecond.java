package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private double myOtherDoubleT;
	
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
