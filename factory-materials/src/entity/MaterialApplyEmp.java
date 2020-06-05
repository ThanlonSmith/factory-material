package entity;

public class MaterialApplyEmp {
	private int material_id;
	private String name;
	private int unit_price;
	private int godown_id;
	private int flag;
	private int apply_id;
	private String applicant;

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public int getApply_id() {
		return apply_id;
	}

	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}

	public int getGodown_id() {
		return godown_id;
	}

	public void setGodown_id(int godown_id) {
		this.godown_id = godown_id;
	}
}
