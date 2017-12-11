package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	
	public double myDoubleT;
	public float myFloatT;
	public short myShortT;
	public char myCharT;
	public double myOtherDoubleT;
	
	public MyAllTypesSecond()
	{
		
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myShortT;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT)
			return false;
		if (Double.doubleToLongBits(myDoubleT) != Double
				.doubleToLongBits(other.myDoubleT))
			return false;
		if (Float.floatToIntBits(myFloatT) != Float
				.floatToIntBits(other.myFloatT))
			return false;
		if (Double.doubleToLongBits(myOtherDoubleT) != Double
				.doubleToLongBits(other.myOtherDoubleT))
			return false;
		if (myShortT != other.myShortT)
			return false;
		return true;
	}
	


}
