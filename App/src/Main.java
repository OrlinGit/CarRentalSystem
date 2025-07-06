import com.rental.rentalmanager.RentalManager;
import com.rental.usermanager.User;
import com.rental.usermanager.UserManager;
import com.rental.vehiclemanager.Car;
import com.rental.vehiclemanager.Truck;
import com.rental.vehiclemanager.VehicleManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static UserManager userManager = new UserManager();
	private static VehicleManager vehicleManager = new VehicleManager();
	private static RentalManager rentalManager = new RentalManager();

	public static void main(String[] args) throws IOException {
		boolean isRunning = true;
			userManager.getRegisteredUsers();
			System.out.println("Welcome to the Car Rental System!");
			User currentUser = userInterface();
			while (currentUser == null){
				currentUser = userInterface();
			}
		while (isRunning) {
			rentInterface(currentUser);
		}



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
		allVehicles.printAllVehicles();
		allVehicles.writeToFile();
	}



	public static void rentInterface(User user) throws IOException {
		List<String> validOptions = List.of("1", "2", "3", "4", "5", "6", "7");
		System.out.println("""
				Welcome to the vehicle management menu!\
				
				Choose one of the following options:\
				
				1. Add Vehicle\
				
				2. Edit Vehicle\
				
				3. Remove Vehicle\
				
				4. List Available Vehicles\
				
				5. Rent a Vehicle\
				
				6. Return a Vehicle\
				
				7. Save and exit
				
				""");
		System.out.print("Enter option: ");
		String input = reader.readLine();
		while (!validOptions.contains(input)) {
			System.out.println("""
					Your input is not valid!\
					
					Please try again:
					""");
			input = reader.readLine();
		}
		switch (input) {
			case "1":
				addVehicle();
				break;
			case "2":
				break;
			case "3":
				removeVehicle();
				break;
			case "4":
				vehicleManager.printAllVehicles();
				break;
			case "5":
				rentVehicle(user);
				break;
			case "6":
				returnVehicle();
				break;
			case "7":
				saveAndExit();
				break;
		}

	}

	public static void returnVehicle() throws IOException {
		System.out.println("Enter id on vehicle to return: ");
		int id = Integer.parseInt(reader.readLine());
		while(0 < id || id < rentalManager.rentedVehicles.size() ){
			System.out.println("Entered id is not valid! Please enter valid id: ");
			id = Integer.parseInt(reader.readLine());
		}
		rentalManager.returnVehicle(id);
	}

	public static void rentVehicle(User user) throws IOException {
		System.out.println("Enter the id of the vehicle you would like to rent: ");
		int id = Integer.parseInt(reader.readLine());
		while(0 < id || id < vehicleManager.size()){
			System.out.println("The id is not valid! Enter valid id: ");
			id = Integer.parseInt(reader.readLine());
		}
		System.out.println("Enter date to take the vehicle in format yyyy-mm-dd: ");
		LocalDate rentDate = LocalDate.parse(reader.readLine());
		System.out.println("Enter date to return the vehicle in format yyyy-mm-dd: ");
		LocalDate returnDate = LocalDate.parse(reader.readLine());
		rentalManager.rentVehicle(vehicleManager.getVehicle(id), user, rentDate, returnDate);
	}

	public static void removeVehicle() throws IOException {
		System.out.println("Enter the id of the vehicle you want to remove: ");
		int id = Integer.parseInt(reader.readLine());
		vehicleManager.removeVehicle(id - 1);
	}

	public static void addVehicle() throws IOException {
		List<String> validOptions = List.of("1", "2");
		List<String> notAcceptable = List.of(",", "-", "\\", ".", ",", "!");
		String make;
		System.out.println("""
				What vehicle yuo would like to create?\
				
				1. Car\
				
				2. Truck\
				
				""");
		System.out.print("Enter option: ");
		String input = reader.readLine();
		while (!validOptions.contains(input)) {
			System.out.println("""
					Your input is not valid!\
					
					Please try again:
					""");
			input = reader.readLine();
		}
		switch (input) {
			case "1":
				System.out.println("""
						You can not use the following symbols:\
						
						",", "-", "\\", ".", ",", "!"\
						
						""");
				System.out.println("Enter car make: ");
				make = reader.readLine();
				while (notAcceptable.stream().anyMatch(make::contains)) {
					System.out.println("Your input is invalid!");
					System.out.println("Enter car make: ");
					make = reader.readLine();
				}
				System.out.println("Enter car model: ");
				String model = reader.readLine();
				while (notAcceptable.stream().anyMatch(model::contains)) {
					System.out.println("Your input is invalid!");
					System.out.println("Enter car model: ");
					model = reader.readLine();
				}
				System.out.println("You must put a valid year of production that is between 1900 and 2025 year!");
				int year = Integer.parseInt(reader.readLine());
				while (1900 > year || year > 2025) {
					System.out.println("Invalid input! Enter new year: ");
					year = Integer.parseInt(reader.readLine());
				}
				vehicleManager.addVehicle(VehicleManager.makeCar(make, model, year));
				break;
			case "2":
				System.out.println("""
						You can not use the following symbols:\
						
						",", "-", "\\", ".", ",", "!"\
						
						""");
				System.out.println("Enter truck make: ");
				make = reader.readLine();
				while (notAcceptable.stream().anyMatch(make::contains)) {
					System.out.println("Your input is invalid!");
					System.out.println("Enter car make: ");
					make = reader.readLine();
				}
				System.out.println("You must put a valid weight that is not a decimal number and is between 0 and 40 000!");
				int weight = Integer.parseInt(reader.readLine());
				while (0 < weight || weight > 40000){
					System.out.println("Your input is not valid! Enter valid weight: ");
					weight = Integer.parseInt(reader.readLine());
					vehicleManager.addVehicle(VehicleManager.makeTruck(make, weight));
				}
				break;
		}
	}

	private static User userInterface() throws IOException {
		List<String> validOptions = List.of("1", "2", "3");
		System.out.println("""
				In order to use our system you need to be registered user!\
				
				Please choose one of the options:\
				
				1. I am registered user.\
				
				2. I want to register.\
				
				3. I want to exit the system.\
				""");

		System.out.print("Enter option: ");
		String input = reader.readLine();
		while (!validOptions.contains(input)) {
			System.out.println("""
					Your input is not valid!\
					
					Please try again:
					""");
			input = reader.readLine();
		}
		if (input.equals("1")) {
			return checkUser();
		} else if (input.equals("2")) {
			return registerUser();
		} else if (input.equals("3")) {
			saveAndExit();
		}
		return null;
	}

	public static User checkUser() throws IOException {
		System.out.println("Please enter your credentials:");
		System.out.println("Username: ");
		String username = reader.readLine();
		System.out.println("Password: ");
		String password = reader.readLine();
		return userManager.checkUser(username, password);
	}

	public static User registerUser() throws IOException {
		System.out.println("Please enter your credentials:");
		System.out.println("Username: ");
		String username = reader.readLine();
		System.out.println("Password: ");
		String password = reader.readLine();
		return userManager.registerUser(username, password);
	}

	public static void saveAndExit() throws IOException {
		rentalManager.writeToFile();
		vehicleManager.writeToFile();
		userManager.writeToFile();
		System.out.println("""
				Thank you for using our system!\
				
				Goodbye!
				
				""");
		System.exit(0);
	}

}
