package edm.music.t3v.model;

public class Danhdau {
	private String idimg;
	private int id;
	public Danhdau(){}

	public Danhdau(String idimg, int id) {
		this.idimg = idimg;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdimg() {
		return idimg;
	}

	public void setIdimg(String idimg) {
		this.idimg = idimg;
	}
}
