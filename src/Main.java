import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Vaccine> vaccine_coll = new ArrayList<>();
		ArrayList<Citizen> citizen_coll = new ArrayList<>();
		ArrayList<Hospital> hospital = new ArrayList<>();
		while(true)
		{
			System.out.println("CoWin Portal initialized....\r\n"
					+ "---------------------------------\r\n"
					+ "1. Add Vaccine\r\n"
					+ "2. Register Hospital\r\n"
					+ "3. Register Citizen\r\n"
					+ "4. Add Slot for Vaccination\r\n"
					+ "5. Book Slot for Vaccination\r\n"
					+ "6. List all slots for a hospital\r\n"
					+ "7. Check Vaccination Status\r\n"
					+ "8. Exit\r\n"
					+ "---------------------------------\r\n"
					+ "");
				int option = s.nextInt();
				if(option == 1)
				{
					System.out.println("Vaccine Name: ");
					String name = s.next();
					System.out.println("Number of Doses: ");
					int num_of_doses = s.nextInt();
					if(num_of_doses>=2)
					{
						System.out.println("Gap_between_Doses: ");
						int Gap_between_Doses = s.nextInt();
						System.out.println("Vaccine Name: "+name+", Number of Doses: "+num_of_doses+", Gap Between Doses: "+Gap_between_Doses);
						Vaccine v1 = new Vaccine(name, num_of_doses, Gap_between_Doses);
						vaccine_coll.add(v1);
					}
					else
					{
						System.out.println("Vaccine Name: "+name+", Number of Doses: "+num_of_doses+", Gap Between Doses: "+0);
						Vaccine v1 = new Vaccine(name, num_of_doses);
						vaccine_coll.add(v1);
					}
					
				}
				if(option == 2)
				{
					System.out.println("Hospital Name: ");
					String name= s.next();
					System.out.println("PinCode: ");
					int Pincode= s.nextInt();
					Hospital h1 = new Hospital(name, Pincode);
					hospital.add(h1);
					System.out.println("Hospital Name: "+h1.getName()+", PinCode: "+h1.getPincode()+", Unique ID: "+ h1.getUid());
				}
				
				if(option == 3)
				{	
					System.out.println("Citizen Name: ");
					String Name = s.next();
					System.out.println();
					System.out.println("Age: ");
					int Age = s.nextInt();
					System.out.println("Unique ID: ");
					long uid = s.nextLong();
					if(Age>=18)
					{
						Citizen c = new Citizen(Name,Age,uid);
						citizen_coll.add(c);
						c.vaccination_status = "registered";
						System.out.println("Citizen Name: "+Name+", Age: "+Age+", Unique ID: "+uid);
					}
					else
					{
						System.out.println("Only above 18 are allowed");
					}
					
				}
				if(option == 4)
				{
					System.out.println("Enter Hospital ID: ");
					int h_id = s.nextInt();
					for(int i = 0;i<hospital.size();i++)
					{
						if(hospital.get(i).getUid()==h_id)
						{
							System.out.println("Enter number of Slots to be added: ");
							int num_of_slots = s.nextInt();
							hospital.get(i).vaccine_slots = new ArrayList<>(num_of_slots);
							
							for(int k = 0;k<num_of_slots;k++)
							{
								Slots obj1 = new Slots();
								System.out.println("Enter Day Number: ");
								int day_num = s.nextInt();
								System.out.println("Enter Quantity: ");
								int quant = s.nextInt();
								obj1.setquantity(quant);
								System.out.println("Select Vaccine");
								for(int j = 0;j<vaccine_coll.size();j++)
								{
									Vaccine temp = vaccine_coll.get(j);
									System.out.println(j+". "+temp.getname());
								}
								int choice = s.nextInt();
								obj1.getname = vaccine_coll.get(choice).getname();
								hospital.get(i).vaccine_slots.add(obj1);
//								Slot added by Hospital 123456 for Day: 2, Available Quantity: 5 of Vaccine Cov
								System.out.println("Slot added by Hospital "+hospital.get(i).getUid()+" for Day: "+day_num+", Available Quantity: "+quant+" of Vaccine "+obj1.getname);
							}
							
						}
					}

				}
				if(option==5)
				{
					System.out.println("Enter paitient Unique ID: ");
					long paitient_id = s.nextLong();
					System.out.println("1. Search by area ");
					System.out.println("2. Search by Vaccine");
					System.out.println("3. Exit");
					System.out.println("Enter option: ");
					int choose_option = s.nextInt();
					if(choose_option==1)
					{
						System.out.println("Enter pincode: ");
						int pincode = s.nextInt();
						for(int i = 0;i<hospital.size();i++)
						{
							if(hospital.get(i).getPincode()==pincode)
							{
								System.out.println(hospital.get(i).getUid()+" "+hospital.get(i).getName());
							}
						}
						System.out.println("Enter Hospital ID: ");
						int h_id = s.nextInt();
						for(int i = 0;i<hospital.size();i++)
						{
							if(hospital.get(i).getUid()==h_id)
							{
								if(hospital.get(i).vaccine_slots.size()==0)
								{
									System.out.println("No slots are available");
								}
								for(int j = 0;j<hospital.get(i).vaccine_slots.size();j++)
								{
									System.out.println(j+"-> Day:"+(j+1)+"Available Qty: "+hospital.get(i).vaccine_slots.get(j).getquantity()+" Vaccine: "+hospital.get(i).vaccine_slots.get(j).getname);
								}
							}
						}
						
						System.out.println("Choose Slot: ");
						int slot_selected = s.nextInt();
						if(hospital.get(slot_selected).vaccine_slots.size()>0)
						{
							for(int k = 0;k<citizen_coll.size();k++)
							{
								if(citizen_coll.get(k).getUID()==paitient_id)
								{
									citizen_coll.get(k).vaccination_status = "Partially Vaccinated";
									for(int i = 0;i<hospital.size();i++)
									{
										if(hospital.get(i).getUid()==h_id)
										{
											citizen_coll.get(k).vaccine_taken = hospital.get(i).vaccine_slots.get(k).getname;
											for(int l = 0;l<vaccine_coll.size();l++)
											{
												if(vaccine_coll.get(l).getname().equals(hospital.get(i).vaccine_slots.get(k).getname))
												{
													citizen_coll.get(k).num_of_doses = vaccine_coll.get(l).num_of_doses_req;
													citizen_coll.get(k).next_due_date = vaccine_coll.get(l).gap_btwn_doses;
													System.out.println(citizen_coll.get(k).getName()+" Vaccinated with "+citizen_coll.get(k).vaccine_taken);
												}
											}
											
										}
										
									}
									
								}
							}
						}
						
						
					}
					if(choose_option==2)
					{
						System.out.println("Enter Vaccine name: ");
						String vac_name = s.next();
						for(int i = 0;i<hospital.size();i++)
						{
							for(int j = 0;j<hospital.get(i).vaccine_slots.size();j++)
							{
								if(hospital.get(i).vaccine_slots.get(j).getname.equals(vac_name))
								{
									System.out.println(i+" -> Day: "+(j+1)+"Available Qty: "+hospital.get(i).vaccine_slots.get(j).getquantity()+" Vaccine :"+hospital.get(i).vaccine_slots.get(j).getname);
								}
							}
						}
						int choose_slot = s.nextInt();
						
					}
					if(choose_option==3)
					{
						continue;
					}
				}
				if(option==6)
				{
					System.out.println("Enter Hospital Id: ");
					int id = s.nextInt();
					for(int i = 0;i<hospital.size();i++)
					{
						if(hospital.get(i).getUid()==id)
						{
							for(int j = 0;j<hospital.get(i).vaccine_slots.size();j++)
							{
//								Day: 1 Vaccine: Covax Available Qty: 4
								System.out.println("Day: "+(j+1)+" Vaccine: "+hospital.get(i).vaccine_slots.get(j).getname+" Available Qty: "+hospital.get(i).vaccine_slots.get(j).getquantity());
							}
						}
					}
				}
				if(option==7)
				{
					System.out.println("Enter Patient ID: ");
					long id = s.nextLong();
					for(int i =0;i<citizen_coll.size();i++)
					{
						if(citizen_coll.get(i).getUID()==id)
						{
							System.out.println("Vaccination Status "+citizen_coll.get(i).vaccination_status);
							System.out.println("Vaccine Given "+citizen_coll.get(i).vaccine_taken);
							System.out.println("Number of doses taken "+citizen_coll.get(i).num_of_doses);
							System.out.println("Next dose due date "+citizen_coll.get(i).next_due_date);
						}
					}
				}
				if(option==8)
				{
					System.exit(0);
				}
				

		}
	

	}

}
