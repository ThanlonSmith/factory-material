package entity;

public class Warehouse {
	private int id;
	private String material_number;
	private int mn;

	public int getMn() {
		return mn;
	}

	public void setMn(int mn) {
		this.mn = mn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial_number() {
		return material_number;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Warehouse(int id, String material_number) {
		super();
		this.id = id;
		this.material_number = material_number;
	}

	public void setMaterial_number(String material_number) {
		this.material_number = material_number;
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", material_number=" + material_number + "]";
	}
}
