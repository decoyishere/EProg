import java.util.ArrayList;
import java.util.List;

public class Person0 implements Person {
	List<Integer> usedIds; 
	List<Integer> seenIds;
	//List<Integer> freshIds; 
	List<Integer> indirectContacts; 
	boolean isPositive = false;
	int age;  
	private NotificationType currentNotification = NotificationType.NoNotification;
	ContactTracer c;
	
	public Person0(int age, ContactTracer c) {
		this.age= age; 
		this.seenIds= new ArrayList<>(); 
		this.usedIds = new ArrayList<>(); 
		this.indirectContacts = new ArrayList<>(); 
		this.isPositive= false; 
		this.currentNotification = NotificationType.NoNotification ;
		this.c = c;
		
	}
	
	public int getAge() {
		return age; 
	}
	
	public boolean isPositive() {
		return isPositive; 
	}
	
	
	@Override
	public List<Integer> getUsedIds() {
		// TODO Auto-generated method stub
		return usedIds;
	}
	

	@Override
	public List<Integer> getSeenIds() {
		// TODO Auto-generated method stub
		return seenIds;
	}

	@Override
	public Person.NotificationType getNotification() {
		// TODO Auto-generated method stub
		return currentNotification;
		
		
	}

	@Override
	public void setTestsPositively() {
		// TODO Auto-generated method stub
		isPositive= true;
		
		// for loop for seen Ids
		for (int id : seenIds) {
			Person0 person= c.map.get(id); 
			c.directContact(this, person); 
			for(int id2: person.seenIds) {
				Person0 person2= c.map.get(id2);
				c.indirectContact(person2, person);
			}
		}
		
		
		
	}
	
	public void setNotification(NotificationType notification) {
		this.currentNotification = notification; 
	}

	



	

	

}
