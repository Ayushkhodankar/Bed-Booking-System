package model;

public class Bed {

	String room_type,room_no,bed_no,price,status;

	public Bed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bed(String room_type, String room_no, String bed_no, String price, String status) {
		super();
		this.room_type = room_type;
		this.room_no = room_no;
		this.bed_no = bed_no;
		this.price = price;
		this.status = status;
	}

	public Bed(String room_no) {
		
		this.room_no = room_no;
	
		
	}
	public Bed(String room_no, String bed_no, String price) {
		super();
		this.room_no = room_no;
		this.bed_no = bed_no;
		this.price = price;
	}
	/*public Bed(String room_type, String room_no, String bed_no, String price) {
		super();
		this.room_type = room_type;
		this.room_no = room_no;
		this.bed_no = bed_no;
		this.price = price;
	}*/

	public Bed(String room_no, String bed_no, String price, String status) {
		super();
		this.room_no = room_no;
		this.bed_no = bed_no;
		this.price = price;
		this.status = status;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getBed_no() {
		return bed_no;
	}

	public void setBed_no(String bed_no) {
		this.bed_no = bed_no;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
