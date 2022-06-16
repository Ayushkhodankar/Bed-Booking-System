package model;

public class Doctor {
	String d_id,d_name,d_email,d_mob,d_address,d_qual,dname,dpass;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String d_id, String d_name, String d_email, String d_mob, String d_address, String d_qual,
			String dname, String dpass) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_email = d_email;
		this.d_mob = d_mob;
		this.d_address = d_address;
		this.d_qual = d_qual;
		this.dname = dname;
		this.dpass = dpass;
	}
	
	public Doctor(String d_name, String d_email, String d_mob, String d_address, String d_qual,
			String dname, String dpass) {
		super();
		
		this.d_name = d_name;
		this.d_email = d_email;
		this.d_mob = d_mob;
		this.d_address = d_address;
		this.d_qual = d_qual;
		this.dname = dname;
		this.dpass = dpass;
	}

	public String getD_id() {
		return d_id;
	}

	public void setD_id(String d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_email() {
		return d_email;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	public String getD_mob() {
		return d_mob;
	}

	public void setD_mob(String d_mob) {
		this.d_mob = d_mob;
	}

	public String getD_address() {
		return d_address;
	}

	public void setD_address(String d_address) {
		this.d_address = d_address;
	}

	public String getD_qual() {
		return d_qual;
	}

	public void setD_qual(String d_qual) {
		this.d_qual = d_qual;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDpass() {
		return dpass;
	}

	public void setDpass(String dpass) {
		this.dpass = dpass;
	}

	
}
