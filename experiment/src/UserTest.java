import java.util.ArrayList;


public class UserTest {
	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			users.add(new User());
			users.get(i);
			System.out.println("i=" + i + ", UID=" + users.get(i).UID + ", totalUID=" + User.totalUID);
		}
	}
}
