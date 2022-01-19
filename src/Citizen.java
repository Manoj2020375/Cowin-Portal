
public class Citizen {
	private String Name;
	private int Age;
	private long Unique_ID;
	String vaccination_status;
	String vaccine_taken;
	int num_of_doses;
	int next_due_date;
	public Citizen(String Name,int Age,long uid)
	{
		this.Name = Name;
		this.Age = Age;
		this.Unique_ID = uid;
	}
	public String getName()
	{
		return this.Name;
	}
	public int getAge()
	{
		return this.Age;
	}
	public long getUID()
	{
		return this.Unique_ID;
	}
}
