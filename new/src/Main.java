
public class Main {

	public static void main(String[] args) {
		JDBCConnector connection = new JDBCConnector();
		//connection.connect(5432, "postgres", "31111");
		connection.connect(5432, "mdandwle", "9W5YHMxa7H_55rfP8fz1NXII7qVVLmAl");
		
		DataGenerator generator = new DataGenerator(connection);
		//Activate the generator to create more observations
		generator.runPv();
		
		//ApplicationGUI gui = new ApplicationGUI(connection);
	}
}
