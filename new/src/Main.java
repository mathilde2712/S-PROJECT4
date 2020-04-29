
public class Main {

	public static void main(String[] args) {
		JDBCConecctor connection = new JDBCConnector();
		//connection.connect("localhost", 5432, "postgres", "31111");
		connection.connect("drona.db.elephantsql.com",5432, "mdandwle", "9W5YHMxa7H_55rfP8fz1NXII7qVVLmAl");
		
		ObservationDataGenerator generator = new ObservationDataGenerator(connection);
		//Activate the generator to create more observations
		generator.start();
		
		ApplicationGUI gui = new ApplicationGUI(connection);
	}

