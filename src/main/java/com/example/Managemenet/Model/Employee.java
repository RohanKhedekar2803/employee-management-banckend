package com.example.Managemenet.Model;




                    //for operation normal

public class Employee {
	private String first_name;
    private String last_name;
    private String email;
    private Integer id;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + "]";
	}
	public Employee(String first_name, String last_name, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	public Employee(String first_name, String last_name, String email, Integer id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id = id;
	}
	public Employee() {}
    
}
