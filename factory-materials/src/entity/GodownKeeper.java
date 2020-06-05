package entity;

public class GodownKeeper {
	private int id;
	private String name;
	private int godown_id;
	private String pwd;
	private String mobile_number;
	private String real_name;

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

	public int getGodown_id() {
		return godown_id;
	}

	public void setGodown_id(int godown_id) {
		this.godown_id = godown_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	@Override
	public String toString() {
		return "GodownKeeper [id=" + id + ", name=" + name + ", godown_id=" + godown_id + ", pwd=" + pwd
				+ ", mobile_number=" + mobile_number + ", real_name=" + real_name + "]";
	}

	public GodownKeeper(int id, String name, int godown_id, String pwd, String mobile_number, String real_name) {
		super();
		this.id = id;
		this.name = name;
		this.godown_id = godown_id;
		this.pwd = pwd;
		this.mobile_number = mobile_number;
		this.real_name = real_name;
	}

	public GodownKeeper() {
		super();
		// TODO Auto-generated constructor stub
	}

}
