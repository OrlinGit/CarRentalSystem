import com.rental.carmanager.Car;
import com.rental.carmanager.Truck;
import com.rental.usermanager.User;
import com.rental.usermanager.UserManager;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Car car1 = new Car("Mercedes", "C-klass", 2020);
		Car car2 = new Car("Peugeot", "208", 2017);
		Car car3 = new Car("Citroen", "C-5", 2005);
		Car car4 = new Car("VW", "Passat", 2008);
		Truck truck = new Truck("Man", 1000);
		Truck truck2 = new Truck("Daf", 2000);
		truck2.makeNotAvailable();
		User user1 = new User("Adam", "pass1");
		User user2 = new User("Eve", "pass2");
		User user3 = new User("Peter", "pass3");
		User user4 = new User("Mariya", "pass4");
		UserManager users = new UserManager();
		users.addUser(user1);
		users.addUser(user2);
		users.addUser(user3);
		users.addUser(user4);
		users.printUsers();
		users.writeToFile();

		/*
		|. Create Customer
		||. Available Customer
		1. Add Vehicle
		2. Edit Vehicle
		3. Remove Vehicle
		4. List Available Vehicles
		5. Rent a Vehicle
		6. Return a Vehicle
		7. Save and exit
		 */
	}
}
