package springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EmployeeService {

	private Scanner scanner = new Scanner(System.in);

	@Autowired
	private EmployeeRepository repository;

	// New method, for the exercise.
	public void doHandsomePayRise() {
		int rowsAffected = repository.payRiseToEmployeesInRegion(5_000_000, "London");
		System.out.printf("%d employees given handsome pay rise\n", rowsAffected);
		displayEmployees("All employees after pay rise: ", repository);
	}

	public void queryEntities() {
		
		try {
			// Get a scalar value.
			long empCount = repository.getEmployeeCount();
			System.out.printf("Employee count: %d\n", empCount);
			
			// Get one record.
			long id = promptForId("Enter id of employee to get: ");
			Employee emp = repository.getEmployee(id);
			System.out.printf("Employee %d: %s\n", id, emp);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void modifyEntities() {

		try {
			// Insert an employee.
			Employee newEmp = new Employee(-1, "Simon Peter", 10000, "Israel");
			repository.insertEmployee(newEmp);
			displayEmployees("All employees after insert: ", repository);

			// Update an employee.
			long id = promptForId("Enter id of employee to update: ");
			repository.employeePayRise(id, 1000);
			displayEmployees("All employees after update: ", repository);

			// Delete an employee.
			id = promptForId("Enter id of employee to delete: ");
			repository.deleteEmployee(id);
			displayEmployees("All employees after delete: ", repository);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private long promptForId(String message) {
		System.out.printf("\n%s\n", message);
		return scanner.nextLong();
	}

	private static void displayEmployees(String message, EmployeeRepository repository) {
		List<Employee> employees = repository.getEmployees();
		System.out.printf("\n%s\n", message);
		for (Employee emp: employees) {
			System.out.println(emp);
		}
	}
}
