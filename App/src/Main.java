import com.rental.vehiclemanager.Car;
import com.rental.vehiclemanager.Truck;
import com.rental.usermanager.User;
import com.rental.usermanager.UserManager;
import com.rental.vehiclemanager.Vehicle;
import com.rental.vehiclemanager.VehicleManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

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
		//users.printUsers();
		users.writeToFile();
		VehicleManager allVehicles = new VehicleManager();
		allVehicles.addVehicle(car1);
		allVehicles.addVehicle(car2);
		allVehicles.addVehicle(car3);
		allVehicles.addVehicle(car4);
		allVehicles.addVehicle(truck);
		allVehicles.addVehicle(truck2);
		HashMap<UUID, User> allUsers = users.getRegisteredUsers();
		allVehicles.printAvailable();
		allVehicles.writeToFile();
		/*
		allVehicles.forEach((id, vehicle) -> System.out.println("UserId: " + id +
														  " UserName: " + user.getName() +
														  " UserPassword: " + user.getPassword()));

		 */
/*
		for(Map.Entry<Integer, Vehicle> vehicle : allVehicles.entrySet()){
			System.out.println("UserID: " + user.getKey() + "UserName: " + user.getValue().getName() +
							   "Password: " + user.getValue().getPassword());
		}

 */



		/*
		|. Create Customer
		||. Available Customer
		1. Add Vehicle
		2. Edit Vehicle
		3. Remove Vehicle
		4. List Available Vehicles
		5. Rent a Vehicle
		6. Return a Vehicle
		7. Save and exit - save and exit - VehicleManager and UserManager
		 */
	}
}
