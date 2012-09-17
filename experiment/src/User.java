
public class User {
	public int UID;
	public static int totalUID;
	
	public User() {
		UID = totalUID;
		totalUID++;
	}
}
