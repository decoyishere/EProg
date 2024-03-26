import java.util.HashMap;

public class ContactTracer {
	/**
	 * Erstellt eine neue Person im Kontext dieses Contact Tracers.
	 *
	 * Alle Person Objekte, die von dieser Methode erstellt werden, sollen 
	 * sich gegenseitig begegnen und benachrichtigen können.
	 *
	 */
	
	int ID = 0;
	HashMap<Integer, Person0> map = new HashMap<Integer, Person0>(); 
	
	public Person createPerson(int age) {
		// TODO
		Person p = new Person0(age, this); 
		return p; 
	}

	/**
	 * Protokolliert eine (beidseitige) Begegnung von p1 und p2.
	 */
	public void registerEncounter(Person p1, Person p2) {
		
		Person0 p10 = (Person0)p1;
		Person0 p20  = (Person0)p2; 
		
		int ID1 = ID++; 
		int ID2 = ID++; 
		
		p10.usedIds.add(ID1); 
		p20.usedIds.add(ID2); 
		
		//ID exchange Direct Contact
	
		p10.seenIds.add(ID2); 
		p20.seenIds.add(ID1);
		
		
		
		map.put(ID1, p10); 
		map.put(ID2, p20); 
		
		
		 
		 
	}
	
	
	public void directContact(Person0 p10, Person0 p20) {
		//Direct Contact
		
				if((p20.age>60) && !(p20.isPositive())) {
					//set to HighRisk Not  P2
					p20.setNotification(Person.NotificationType.LowRiskNotification);
					//p10.setTestsPositively();
				}
				
				else if((p20.age<=60)&& !(p20.isPositive())) {
					//Set to HighRisk Not P2
					p20.setNotification(Person.NotificationType.HighRiskNotification);
					//p20.setTestsPositively();
					
				}
				
				else if(p20.isPositive()) {
					//Set NoNotification 
					p20.setNotification(Person.NotificationType.NoNotification);
					
				}
		
	}
	
	public void indirectContact(Person0 p10, Person0 p20) {

		//Indirect contact
		

		//p1.setTestsPositively();
		for( Integer id1: p10.seenIds) {
			for( Integer id2: p20.seenIds) {
				if(id1 == id2) {
					 if((p20.age<=60)&& !(p20.isPositive())) {
						//Set to HighRisk Not P2
						p20.setNotification(Person.NotificationType.NoNotification);
						p20.setTestsPositively();

					}
					 else if((p20.getAge()>60) && !(p20.isPositive())) {
							//set to HighRisk Not  P2
							p20.setNotification(Person.NotificationType.LowRiskNotification);
							p20.setTestsPositively();

						}
					 else if(p20.isPositive()) {
							//Set NoNotification 
							p20.setNotification(Person.NotificationType.NoNotification);
							//p2.setNotification(Person.NotificationType.HighRiskNotification);
						}
				}
			}
			//p10.indirectContacts.add(ID1); 
			//p20.indirectContacts.add(ID2);
		}
	}
}
	
	