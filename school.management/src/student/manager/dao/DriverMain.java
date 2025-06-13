package student.manager.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import school.management.*;

public class DriverMain {

	public static final Logger logger = LogManager.getLogger(DriverMain.class);

	public static void main(String[] args) {
		

		OutputMethod outputMethods = new OutputMethod();
		outputMethods.createTables();

		Scanner scanner = new Scanner(System.in);
		Authenticator authenticate = new Authenticator();
		authenticate.verification();

		int choice;

		do {
			
			logger.info("\n--- School Management System ---");
			
			logger.info("1. Add Section");
			logger.info("2. View Section");
			logger.info("3. Edit Section");
			logger.info("0. Exit");
			logger.info("Please enter your choice");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {

			case 1: {
				logger.info("1. Add Grade");
				logger.info("2. Add Subject");
				logger.info("3. Add Teacher");
				logger.info("4. Add Student");
				outputMethods.choice();
				int ch = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				switch (ch) {
				case 1: {
					outputMethods.addGrade(outputMethods);
					break;
				}
				case 2: {
					outputMethods.addSubject(outputMethods);
					break;
				}
				case 3: {
					outputMethods.addTeacher(outputMethods);
					break;
				}
				case 4: {
					outputMethods.addStudent(outputMethods);
					break;
				}
				default:
					logger.info("Invalid input. Please try again.");
				}
				break;
			}

			case 2: {
				logger.info("1. View Grade");
				logger.info("2. View Subject");
				logger.info("3. View Teacher");
				logger.info("4. View Student");
				outputMethods.choice();
				int ch = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				switch (ch) {
				case 1:
					outputMethods.viewGrade();
					break;
				case 2:
					outputMethods.viewSubject();

					break;
				case 3:
					outputMethods.viewTeacher();

					break;
				case 4:
					outputMethods.viewStudents();
					break;
				default:
					outputMethods.defaultFunction();
					break;
				}
				break;
			}

			case 3: {
				logger.info("1. Edit Grade");
				logger.info("2. Edit Subject");
				logger.info("3. Edit Teacher");
				logger.info("4. Edit Student");
				logger.info("Enter your choice: ");
				int ch = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				switch (ch) {
				
				case 1: outputMethods.editGrade();
						break;
						
				case 2: outputMethods.editSubject(outputMethods);
						break;
				
				case 3: outputMethods.editTeacher(outputMethods);
						break;
				
				case 4: outputMethods.editStudents(outputMethods);
					break;
				
				default:
					outputMethods.defaultFunction();
				}
				break;
			}

			case 0:
				logger.info("Exiting the system.");
				break;

			default:
				outputMethods.defaultFunction();
			}
		} while (choice != 0);

		scanner.close();
	}
}