import java.util.ArrayList;
import java.util.Random;
public class Hospital {
	private String Name;
	private int pincode;
	private int uid= 123456;
	public ArrayList<Slots> vaccine_slots= new ArrayList<>();
	Random  r = new Random();
	public Hospital(String Name,int pincode)
	{
		this.Name = Name;
		this.pincode = pincode;
		this.uid = this.uid+r.nextInt(100);
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
//2. Register Hospital:
//Input: Name, Pincode
//Output: Display the added hospital details along with the generated unique hospital
//ID (A 6 digit number)