package model;

public class Manager {
	

	private String m_id, m_name, m_email, m_mob,m_add, m_hosp, m_uname, m_pass;
	
	public Manager() {
		
	}
	
	public Manager(String m_id, String m_name, String m_email, String m_mob, String m_add, String m_hosp,
			String m_uname, String m_pass) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_mob = m_mob;
		this.m_add = m_add;
		this.m_hosp = m_hosp;
		this.m_uname = m_uname;
		this.m_pass = m_pass;
	}

	public Manager(  String m_name, String m_email, String m_mob, String m_add, String m_hosp,
			String m_uname, String m_pass) {
		super();

		this.m_name = m_name;
		this.m_email = m_email;
		this.m_mob = m_mob;
		this.m_add = m_add;
		this.m_hosp = m_hosp;
		this.m_uname = m_uname;
		this.m_pass = m_pass;
	}
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_mob() {
		return m_mob;
	}
	public void setM_mob(String m_mob) {
		this.m_mob = m_mob;
	}
	public String getM_add() {
		return m_add;
	}
	public void setM_add(String m_add) {
		this.m_add = m_add;
	}
	public String getM_hosp() {
		return m_hosp;
	}
	public void setM_hosp(String m_hosp) {
		this.m_hosp = m_hosp;
	}
	public String getM_uname() {
		return m_uname;
	}
	public void setM_uname(String m_uname) {
		this.m_uname = m_uname;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	
	

}
