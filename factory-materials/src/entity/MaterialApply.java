package entity;

public class MaterialApply {
	private int id;
	private String name;
	private String address;
	private String mobile_nubmer;
	private String others;
	private String applicant;
	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_nubmer() {
		return mobile_nubmer;
	}

	public void setMobile_nubmer(String mobile_nubmer) {
		this.mobile_nubmer = mobile_nubmer;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public MaterialApply(int id, String name, String address, String mobile_nubmer, String others) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile_nubmer = mobile_nubmer;
		this.others = others;
	}

	public MaterialApply() {
		super();
		// TODO Auto-generated constructor stub
	}

}
