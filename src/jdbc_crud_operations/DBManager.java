package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 1. Load driver --> Petrol
// 2. Create Connections --> Keys
// 3. Create Statements --> Gear Change
// 4. Execute Statement 
// 5. Get & Show Result
// 6. Close Connection

public class DBManager {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/crud_jdbc";
	private String username = "root";
	private String password = "root";

	// READ

	public void readData() {

		try {

			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM employee");

			while (result.next()) {
				System.out.println("Id: " + result.getInt(1));
				System.out.println("Name: " + result.getString(2) + " " + result.getString(3));
				System.out.println("Email: " + result.getString(4));
				System.out.println("Department: " + result.getString(5));
				System.out.println("Salary: " + result.getDouble(6));
				System.out.println("----------------");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// INSERT

	public void insertData(String fName, String lName, String email, String department, double sal) {

		String query = "INSERT INTO employee (First_Name,Last_Name,Email,Department,Salary) VALUES('" + fName + "',' "
				+ lName + "', '" + email + "', '" + department + "', '" + sal + "')";

		try {

			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);

			if (result > 0) {
				System.out.println("Inserted Successfully!");
			} else {
				System.out.println("Insertion Failed!");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// UPDATE

	public void updateData(int id, String fName) {

		String query = "UPDATE employee SET First_Name = '" + fName + "' WHERE Emp_Id = '" + id + "' ";

		try {

			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);

			if (result > 0) {
				System.out.println("Updated Successfully!");
			} else {
				System.out.println("Updation Failed!");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// DELETE

	public void deleteData(int id) {

		String query = "DELETE FROM employee WHERE Emp_Id = '" + id + "' ";

		try {

			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);

			if (result > 0) {
				System.out.println("Deleted Successfully!");
			} else {
				System.out.println("Deletion Failed!");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		DBManager dbManager = new DBManager();

		dbManager.readData();
		// dbManager.insertData("Satish", "Chougule", "satish@gmail.com", "CA", 76000);
		// dbManager.updateData(4, "Kartik");
		// dbManager.deleteData(8);

	}

}
