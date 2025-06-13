package student.manager.dao;

import school.management.OutputMethod;

//import java.util.Scanner;

public class Authenticator {
	private String user = "root";
	private String password = "Root@123";

	void verification() {
//		Scanner scanner = new Scanner(System.in);
		DriverMain.logger.info("Enter User Name");
		String enterUserName = OutputMethod.scanner.next();
		DriverMain.logger.info("Enter Password");
		String pass = OutputMethod.scanner.next();
		if (this.password.equals(pass) && this.user.equals(enterUserName)) {
			DriverMain.logger.info("system LogIn Successfully");
		} else {
			DriverMain.logger.info("Credential Miss Match");
			DriverMain.logger.info("Exiting software");
			System.exit(0);
		}
//		scanner.close();
	}

}
