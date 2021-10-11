package springdata;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEES") 
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId = -1;
	
	private String name;
	private String region;
	 
	@Column(name="salary")
	private double dosh;
	
	public Employee() {
		// Empty no-arg constructor.
	}
	
	public Employee(long employeeId, String name, double dosh, String region) {
		this.employeeId = employeeId;
		this.name = name;
		this.dosh = dosh;
		this.region = region;
	}

	public long getEmployeeId() {
		return employeeId;
	}

    public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public double getDosh() {
		return dosh;
	}
	
    public void setDosh(double dosh) {
		this.dosh = dosh;
	}
	
    public String getRegion() {
		return region;
	}
	
    public void setRegion(String region) {
		this.region = region;
	}
    
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Employee) {
			Employee otherEmp = (Employee)other;
			result = (this.employeeId == otherEmp.employeeId);
		}
		return result;
	}
	
	@Override 
	public int hashCode() {
		return (int)employeeId;
	}

	@Override
	public String toString() {
		return String.format("Employee [employeeId=%s, name=%s, region=%s, dosh=%s]", employeeId, name, region, dosh);
	}
}
