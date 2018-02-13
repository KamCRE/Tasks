/**
 * 
 */
package general;


/**
 * @author lancre
 *
 */
public class Employee extends Person implements TotalDeductions {
	
	private String company;
	private double salary;
	
	
	
	public Employee(String myNames) {
		super(myNames);
		this.company = "Technovation Ventures Limited";
	}

	/*public Employee(String myNames, String company, double salary) {
		super(myNames);
		setCompany(company);
		setSalary(salary);
	}
*/
	private void setCompany(String company) {
		this.company = company;
	}

	public void setSalary(double salary2) {
			this.salary = salary2;
	}

	public String getCompany() {
		return company;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public double nhifDeductions() {
		return this.salary * 0.04;
	}

	@Override
	public double nssfDeductions() {
		return this.salary * 0.048 ;
	}

	@Override
	public double taxDeductions() {
		return this.salary * 0.06;
	}
	
	public double totalDeductions() {
		return nhifDeductions()+ nssfDeductions() + taxDeductions();
	}
	public double getNetSalary() {
		return this.salary - totalDeductions();
		
	}

	
	
	

	
	
	
	
	

}
