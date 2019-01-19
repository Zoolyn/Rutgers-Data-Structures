package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {
	Person firstPerson;		// First Person object in the list

	public PersonList( ) {
		this.firstPerson = null;
	}
	
	// finds Person object in this list with given name
	// if none exists, returns null.  Runs in O(number of persons in this list) 
	public Person lookup(String name){
		
		// traverse the list of Person Linked List
		// check the the string name value
		// return string value if target name matches the name extracted from linked list
		// if target is not found return null
		for(Person ptr = firstPerson; ptr!=null; ptr = ptr.nextPerson){ // traverse through the list
			if(ptr.name.equalsIgnoreCase(name)){ // check to see if "name" = a name in the list
				return ptr; // return Person if the name matches
			}
		}
		return null; //return null if there is no match
	}
	
	// creates a new Person object with name and adds it to the list of 
	// Person objects.  Runs in O(1)
	public Person addPerson(String name){
		
		// add Person Object into the list
		Person newPerson = new Person(name,firstPerson);
		firstPerson = newPerson;
		return newPerson;
		}

}
