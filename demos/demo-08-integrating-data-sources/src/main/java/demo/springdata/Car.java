package demo.springdata;

import javax.persistence.*;

@Entity
@Table(name="CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carId = -1;

	private String registrationNumber;
	private String make;
	private String model;

	public Car() {
		// Empty no-arg constructor.
	}

	public Car(long carId, String name, String make, String model) {
		this.carId = carId;
		this.registrationNumber = name;
		this.make = make;
		this.model = model;
	}

	public long getCarId() {
		return carId;
	}

    public void setCarId(long employeeId) {
		this.carId = employeeId;
	}
	
    public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String name) {
		this.registrationNumber = name;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String region) {
		this.make = region;
	}

	public String getModel() {
		return model;
	}
	
    public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Car) {
			Car otherEmp = (Car)other;
			result = (this.carId == otherEmp.carId);
		}
		return result;
	}
	
	@Override 
	public int hashCode() {
		return (int) carId;
	}

	@Override
	public String toString() {
		return String.format(
				"Car [carId=%s, reg=%s, make=%s, model=%s]",
				carId,
				registrationNumber,
				make,
				model);
	}
}
