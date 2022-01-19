import java.util.ArrayList;

public class Vaccine {
	private String Name;
	public int num_of_doses_req;
	public int gap_btwn_doses;
	public Vaccine(String Name,int num_of_doses_req,int gap_btwn_doses)
	{
		this.Name = Name;
		this.num_of_doses_req = num_of_doses_req;
		this.gap_btwn_doses = gap_btwn_doses;
	}
	public Vaccine(String Name,int num_of_doses_req)
	{
		this.Name = Name;
		this.num_of_doses_req = num_of_doses_req;
	}
	public void print()
	{
		System.out.println(this.Name+" "+this.num_of_doses_req+" "+this.gap_btwn_doses);
	}
	public String getname()
		{
			return this.Name;
		}
}
//Add Vaccine:
//Input: Name, Number of total doses required, Gap Between Doses
//Output: Display the added vaccine details
