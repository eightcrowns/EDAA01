package phonebook;
import java.io.Serializable;
import java.util.*;

public class PhoneBook implements Serializable {
	private Map<String,LinkedList<String>> phoneBook;
	
	public PhoneBook() {
		phoneBook = new TreeMap<String, LinkedList<String>>();
	}
	
	
	/** 
	 * Associates the specified number with the specified 
	 * name in this phone book. 
	 * post: If the specified name is not present in this phone book,
	 *        the specified name is added and associated  with
	 *  	  the specified number. Otherwise the specified 
	 *  	  number is added to the set of number associated with name.
	 * @param name The name for which a phone number is to be added
	 * @param number The number associated with the specified name
	 */
	public void put(String name, String number) {
		LinkedList<String> numberList = phoneBook.get(name);
		if (numberList != null) {
			Iterator<String> it = numberList.iterator();
			boolean found = false;
			while (it.hasNext() && !found) {
				if(it.next().equals(number)) {
					found = true;
					break;
				}
			}
			if (!found) {
				numberList.addFirst(number);
			}
		} else {
			numberList = new LinkedList<String>();
			numberList.addFirst(number);
			phoneBook.put(name, numberList);
		}
	}
	
	
	/**
	 * Removes the the specified name from this phone book.
	 * post: If the specified name is present in this phone book,
	 * 		 it is removed. Otherwise this phone book is
	 * 		 unchanged.
	 * @param name The name to be removed.
	 * @return true if the specified name was present.
	 */
	public boolean remove(String name) {
		return phoneBook.remove(name) != null;
	}
	
	/**
	 * Retrieves a list of phone numbers for the specified name. If the 
	 * specified name is not present in this phone book an empty list is 
	 * returned.
	 * @param name The name whose associated phone numbers are to be returned  
	 * @return The phone numbers associated with the specified name
	 */
	public List<String> findNumber(String name) {
		List<String> numbers = phoneBook.get(name);
		if (numbers != null) {
			return numbers;
		} else {
			return new LinkedList<String>();
		}
	}
	
	/**
	 * Retrieves a list of names associated with the specified phone number. 
	 * If the specified number is not present in this phone book an empty 
	 * list is returned.
	 * @param number The number for which the set of associated
	 * names is to be returned.
	 * @return The list of names associated with the specified number.
	 */
	public List<String> findNames(String number) {
		LinkedList<String> names = new LinkedList<String>();
		
		for (Map.Entry<String, LinkedList<String>> e : phoneBook.entrySet()) {
			LinkedList<String> numbers = e.getValue();
			Iterator<String> it = numbers.iterator();
			boolean found = false;
			while (it.hasNext() && !found) {
				if(it.next().equals(number)) {
					names.addFirst(e.getKey());
					found = true;
				}
			}
		}
		return names;
	}
	
	/**
	 * Retrieves the set of all names present in this phone book.
	 * The set's iterator will return the names in ascending order
	 * @return The set of all names present in this phone book
	 */
	public Set<String> names() {
		return phoneBook.keySet();
	}
	
	/**
	 * Returns true if this phone book is empty
	 * @return true if this phone book is empty
	 */	
	public boolean isEmpty() {
		return phoneBook.isEmpty();
	}
	
	/**
	 * Returns the number of names in this phone book
	 * @return The number of names in this phone book
	 */
	public int size() {
		return phoneBook.size();
	}

}
