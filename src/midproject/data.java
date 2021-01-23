package midproject;

public class data {

	private String kodekaryawan;
	private String namakaryawan;
	private String jeniskelamin;
	private String jabatan;
	private int gaji;
	
	// constructor
	public data(String kodekaryawan, String namakaryawan, String jeniskelamin, String jabatan, int gaji) {
		super();
		this.kodekaryawan = kodekaryawan;
		this.namakaryawan = namakaryawan;
		this.jeniskelamin = jeniskelamin;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}

	// setter getter
	public String getKodekaryawan() {
		return kodekaryawan;
	}

	public void setKodekaryawan(String kodekaryawan) {
		this.kodekaryawan = kodekaryawan;
	}

	public String getNamakaryawan() {
		return namakaryawan;
	}

	public void setNamakaryawan(String namakaryawan) {
		this.namakaryawan = namakaryawan;
	}

	public String getJeniskelamin() {
		return jeniskelamin;
	}

	public void setJeniskelamin(String jeniskelamin) {
		this.jeniskelamin = jeniskelamin;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public int getGaji() {
		return gaji;
	}

	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
	


}
