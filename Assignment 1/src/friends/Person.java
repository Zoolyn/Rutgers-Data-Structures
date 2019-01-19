package friends;

public class Person {
	String name;		// the person's name
	Friend firstFriend; // the first friend in the list of this
					    // person's friends
	Person nextPerson;  // the next person in the list of people
	
	public Person(String name, Person nextPerson) {
		this.name = name;
		this.nextPerson = nextPerson;
		}

	// A string representing the list of friends of this person.  
	// O(number of friends in the list)
	public String friendString(){
			
		// traverse
		// print
		String f_list = "";
		Friend ptr;
		ptr = firstFriend;
		if(firstFriend == null){
			return "no friends found";
		}
		while(ptr!=null){
				f_list += ptr.who.name+" ";
				ptr = ptr.nextFriend;
		}
		return f_list.trim(); // replace this line
	
	}
	
	// add friend as a friend of this person
	// O(1)
	public void addFriend(Person friend){
		Friend newFriend = new Friend(friend,firstFriend); // replace this line
		firstFriend = newFriend;
		return;
	}
	
	// remove Person friend as a friend of this person
	// if friend is not a friend of this person, does nothing
	// O(number of friends of this person)
	public void removeFriend(Person friend){
		
		Friend prev;
		Friend ptr;
		prev = null;
		ptr = firstFriend;
		while(ptr!=null){
			if(ptr.who.name.equals(friend.name)){
				if(ptr == firstFriend){
					firstFriend = firstFriend.nextFriend;
				}
				else{
					prev.nextFriend = ptr.nextFriend;
					}
			}
			else{
				prev = ptr;
			}
			ptr = ptr.nextFriend;
		}
		
	}
}
