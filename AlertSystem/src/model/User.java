package model;

public class User {
	
	private String u_id,u_name,u_age,u_mob,u_add,u_gender,u_bgroup,u_sym,u_dprt,u_doa,u_uname,u_pass;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public User(String u_id, String u_name, String u_age, String u_mob, String u_add, String u_gender, String u_bgroup,
			String u_sym, String u_dprt, String u_doa) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_age = u_age;
		this.u_mob = u_mob;
		this.u_add = u_add;
		this.u_gender = u_gender;
		this.u_bgroup = u_bgroup;
		this.u_sym = u_sym;
		this.u_dprt = u_dprt;
		this.u_doa = u_doa;
	}




	public User(String u_id, String u_name, String u_age, String u_mob, String u_add, String u_gender, String u_bgroup,
			String u_uname, String u_pass) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_age = u_age;
		this.u_mob = u_mob;
		this.u_add = u_add;
		this.u_gender = u_gender;
		this.u_bgroup = u_bgroup;
		this.u_uname = u_uname;
		this.u_pass = u_pass;
	}


	public User(String u_name, String u_age, String u_mob, String u_add, String u_gender, String u_bgroup,
			String u_uname, String u_pass) {
		super();
		
		this.u_name = u_name;
		this.u_age = u_age;
		this.u_mob = u_mob;
		this.u_add = u_add;
		this.u_gender = u_gender;
		this.u_bgroup = u_bgroup;
		this.u_uname = u_uname;
		this.u_pass = u_pass;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_age() {
		return u_age;
	}

	public void setU_age(String u_age) {
		this.u_age = u_age;
	}

	public String getU_mob() {
		return u_mob;
	}

	public void setU_mob(String u_mob) {
		this.u_mob = u_mob;
	}

	public String getU_add() {
		return u_add;
	}

	public void setU_add(String u_add) {
		this.u_add = u_add;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_bgroup() {
		return u_bgroup;
	}

	public void setU_bgroup(String u_bgroup) {
		this.u_bgroup = u_bgroup;
	}

	public String getU_sym() {
		return u_sym;
	}

	public void setU_sym(String u_sym) {
		this.u_sym = u_sym;
	}

	public String getU_dprt() {
		return u_dprt;
	}

	public void setU_dprt(String u_dprt) {
		this.u_dprt = u_dprt;
	}

	public String getU_doa() {
		return u_doa;
	}

	public void setU_doa(String u_doa) {
		this.u_doa = u_doa;
	}

	public String getU_uname() {
		return u_uname;
	}

	public void setU_uname(String u_uname) {
		this.u_uname = u_uname;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}

	
	
	
	

}
