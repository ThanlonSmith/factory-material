package entity;

public class Employee {
	private int id;
	private String name;
	private int depart_id;
	private String real_name;
	private String depart_name;
	private String mobile_number;

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, int depart_id, String real_name) {
		super();
		this.id = id;
		this.name = name;
		this.depart_id = depart_id;
		this.real_name = real_name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", depart_id=" + depart_id + ", real_name=" + real_name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

}
