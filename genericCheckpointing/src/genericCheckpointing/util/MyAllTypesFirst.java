package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{

	public int myInt;
	public int myOtherInt;
	public long myLong;
	public long myOtherLong;
	public String myString;
	public boolean myBool;
	
	public MyAllTypesFirst(int myInt2, int myOtherInt2, long myLong2,
			long myOtherLong2, String myString2, boolean myBool2) {
		// TODO Auto-generated constructor stub
		myInt = myInt2;
		myOtherInt = myOtherInt2;
		myLong = myLong2;
		myOtherLong = myOtherLong2;
		myString = myString2;
		myBool = myBool2;
	}
	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public int getMyOtherInt() {
		return myOtherInt;
	}
	public void setMyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public long getMyOtherLong() {
		return myOtherLong;
	}
	public void setMyOtherLong(long myOtherLong) {
		this.myOtherLong = myOtherLong;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public boolean isMyBool() {
		return myBool;
	}
	public void setMyBool(boolean myBool) {
		this.myBool = myBool;
	}
	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myOtherInt=" + myOtherInt
				+ ", myLong=" + myLong + ", myOtherLong=" + myOtherLong
				+ ", myString=" + myString + ", myBool=" + myBool + "]";
	}
	
	
	
}
