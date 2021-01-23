package midproject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class main {
	ArrayList<data>arrlist=new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	public main() {
	int choice =0;
	int countmanager =0;
	int countsupervisor=0;
	int countadmin = 0;
	String enter;
	int j; 
	int i; 
	int k;
	boolean ii = false;
	boolean jj = false;
	boolean kk = false;
	String regex = "^[A-Z]{2}-[0-9]{4}$";
	String regex2= "^[A-z][^%]{2,}$";
	
	do {
		System.out.println("|===============================================|");
		System.out.println("|		   PT.Mentol			| ");
		System.out.println("|     Selamat datang dalam Menu PT. Mentol!	|");
		System.out.println("|         Apa yang ingin anda lakukan?          |");
		System.out.println("|===============================================|");
		System.out.println("|		1. Insert Data			|");
		System.out.println("|		2. View Data			|");
		System.out.println("|		3. Update Data			|");
		System.out.println("|		4. Delete Data			|");
		System.out.println("|		5. Exit				|");
		System.out.println("|===============================================|");
		System.out.print(">>");
		choice=scan.nextInt();scan.nextLine();
		switch(choice) {
		case 1:
		String penampung_kode;
		String penampung_nama;
		String penampung_kelamin;
		String penampung_jabatan;
		int penampung_gaji;
		
		do {
		System.out.println("Input Kode Karyawan dengan format [MM-XXXX] | M = huruf kapital dan X = angka: ");
		System.out.print(">>");
		penampung_kode = scan.nextLine();
		}while(!(penampung_kode.matches(regex)));
		do{
		System.out.println("Input Nama Karyawan [>=3]: ");
		System.out.print(">>");
		penampung_nama =scan.nextLine();
		}while(!(penampung_nama.matches(regex2)));
		do {
		System.out.println("Input Jenis Kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		System.out.print(">>");
		penampung_kelamin =scan.nextLine();
		}while(!(penampung_kelamin.equals("Laki-laki") || penampung_kelamin.equals("Perempuan")));
		do {
		System.out.println("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
		System.out.print(">>");
		penampung_jabatan = scan.nextLine();
		if(penampung_jabatan.equals("Manager")) {
			countmanager++;
		}
		if(penampung_jabatan.equals("Supervisor")) {
			countsupervisor++;
		}
		if(penampung_jabatan.equals("Admin")) {
			countadmin++;
		}
		}while(!(penampung_jabatan.equals("Manager")|| penampung_jabatan.equals("Supervisor") || penampung_jabatan.equals("Admin")));
		do {
		System.out.println("Input Gaji Karyawan [Manager = 8000000 | Supervisor = 6000000 | Admin = 4000000]: ");
		System.out.print(">>");
		penampung_gaji = scan.nextInt();scan.nextLine();
		}while(!(penampung_jabatan.equals("Manager") && penampung_gaji == 8000000 || penampung_jabatan.equals("Supervisor") && penampung_gaji == 6000000 || penampung_jabatan.equals("Admin") && penampung_gaji == 4000000));
		arrlist.add(new data(penampung_kode, penampung_nama, penampung_kelamin, penampung_jabatan, penampung_gaji));
		System.out.println("Berhasil menambahkan karyawan dengan id "+penampung_kode);
		System.out.println("Manager : "+countmanager+" Supervisor : "+countsupervisor+" Admin : "+countadmin);  
		// Validasi bonus gaji dari data yang diinput.
		if(countmanager > 3 && countmanager % 3 == 1 && ii == false) {
			i = (arrlist.size() - countmanager % 3);
			for(int p=0;p<i;p++) {
				if(arrlist.get(p).getJabatan().equals("Manager")) {
					penampung_gaji = arrlist.get(p).getGaji() + (arrlist.get(p).getGaji() * 1/10);
					arrlist.get(p).setGaji(penampung_gaji);
				}
			}
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id "); for(int p=0;p<i;p++) {
				if(arrlist.get(p).getJabatan().equals("Manager")){
				System.out.print(arrlist.get(p).getKodekaryawan());
				if(p<i-1 && arrlist.get(p).getJabatan().equals("Manager")){
					System.out.print(", ");
					}
				}	
			}
			System.out.println("");
			ii = true;
		}
		if(ii == true){
			if(countmanager % 3 == 1) {
				ii = true;
			}
			else {
				ii = false;
			}
		}
		
		if(countadmin > 3 && countadmin % 3 == 1 && jj==false) {
			j = (arrlist.size() - countadmin % 3);
			for(int p=0;p<j;p++) {
				if(arrlist.get(p).getJabatan().equals("Admin")) {
					penampung_gaji = arrlist.get(p).getGaji() + (arrlist.get(p).getGaji() * 1/20);
					arrlist.get(p).setGaji(penampung_gaji);
				}
			}
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id "); for(int p=0;p<j;p++) {
				if(arrlist.get(p).getJabatan().equals("Admin")) {
				System.out.print(arrlist.get(p).getKodekaryawan());
				if(p<j-1 && arrlist.get(p).getJabatan().equals("Admin")) {
					System.out.print(", ");
					}
				}
				
			}
			System.out.println("");
			jj = true;
		}
		if(jj == true){
			if(countadmin % 3 == 1) {
				jj = true;
			}
			else {
				jj = false;
			}
		}
		
		if(countsupervisor > 3 && countsupervisor % 3 == 1 && kk ==false) {
			k = (arrlist.size() - countsupervisor % 3);
			for(int p=0;p<k;p++) {
				if(arrlist.get(p).getJabatan().equals("Supervisor")) {
					penampung_gaji = arrlist.get(p).getGaji() + (arrlist.get(p).getGaji() * 3/40);
					arrlist.get(p).setGaji(penampung_gaji);
				}
			}
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id "); for(int p=0;p<k;p++) {
				if(arrlist.get(p).getJabatan().equals("Supervisor")) {
				System.out.print(arrlist.get(p).getKodekaryawan());
				if(p<k-1 && arrlist.get(p).getJabatan().equals("Supervisor")){
					System.out.print(", ");
					}
				}
			}
			System.out.println("");
		}
		if(kk == true){
			if(countsupervisor % 3 == 1) {
				kk = true;
			}
			else {
				kk = false;
			}
		}
		
		// disorting.
		Collections.sort(arrlist, new Comparator<data>()
				{
					public int compare(data s1,data s2)
					{
						return String.valueOf(s1.getNamakaryawan()).compareTo(s2.getNamakaryawan());
					}
				});
		System.out.println("ENTER to Return");
		enter=scan.nextLine();
		break;
		
		case 2:
		System.out.println(" v Berikut Merupakan List Data yang telah diinput v");
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");	
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		for(int m=0;m<arrlist.size();m++) {
		System.out.format("%s  %2d%s  %15s%s  %28s%s  %13s%s  %12s%s %12s%s\n","|",(m+1),"|",arrlist.get(m).getKodekaryawan(),"|",arrlist.get(m).getNamakaryawan(),"|",arrlist.get(m).getJeniskelamin(),"|",arrlist.get(m).getJabatan(),"|",arrlist.get(m).getGaji(),"|");
		}
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		System.out.println("Manager : "+countmanager+" Supervisor : "+countsupervisor+" Admin : "+countadmin);
		break;
		 
		case 3:
		int update=1;
		String kodebaru;
		String namabaru;
		String kelaminbaru;
		String jabatanbaru;
		int gajibaru;
		
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");	
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		for(int m=0;m<arrlist.size();m++) {
		System.out.format("%s  %2d%s  %15s%s  %28s%s  %13s%s  %12s%s %12s%s\n","|",(m+1),"|",arrlist.get(m).getKodekaryawan(),"|",arrlist.get(m).getNamakaryawan(),"|",arrlist.get(m).getJeniskelamin(),"|",arrlist.get(m).getJabatan(),"|",arrlist.get(m).getGaji(),"|");
		}
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		
		do {
		System.out.println("Pilih Data ke-berapa yang mau diupdate: ");
		System.out.print(">>");
		update=scan.nextInt();scan.nextLine();
		update =update-1; // <biar index nya jadi 0 dianggap 1.
			}while(update > arrlist.size());
		
		do {
		System.out.println("Input Kode Karyawan Baru dengan format [MM-XXXX] | M = huruf kapital dan X = angka: ");
		System.out.print(">>");
		kodebaru=scan.nextLine();
			}while(!(kodebaru.matches(regex)));
		arrlist.get(update).setKodekaryawan(kodebaru);
		
		do {
		System.out.println("Input Nama Karyawan Baru [>=3]: ");
		System.out.print(">>");
		namabaru=scan.nextLine();
			}while(!(namabaru.matches(regex2)));
		arrlist.get(update).setNamakaryawan(namabaru);
		
		do {
		System.out.println("Input Jenis Kelamin Baru [Laki-laki | Perempuan] (Case Sensitive): ");
		System.out.print(">>");
		kelaminbaru=scan.nextLine();
		}while(!(kelaminbaru.equals("Laki-laki") || kelaminbaru.equals("Perempuan")));
		arrlist.get(update).setJeniskelamin(kelaminbaru);
		
		do {
		System.out.println("Input Jabatan Baru [Manager | Supervisor | Admin] (Case Sensitive): ");
		System.out.print(">>");
		jabatanbaru=scan.nextLine();
		}while(!(jabatanbaru.equals("Manager")|| jabatanbaru.equals("Supervisor") || jabatanbaru.equals("Admin")));
	
		// validasi perubahan jabatan
		if(jabatanbaru.equals("Manager")){
			if(arrlist.get(update).getJabatan().equals("Supervisor")){
			countmanager++;
			countsupervisor--;
				}
		else if(arrlist.get(update).getJabatan().equals("Admin")){
			countmanager++;
			countadmin--;
			}
		}
		
		else if(jabatanbaru.equals("Supervisor")) {
			if(arrlist.get(update).getJabatan().equals("Admin")) {
			countsupervisor++;
			countadmin--;
			}
			else if(arrlist.get(update).getJabatan().equals("Manager")) {
			countsupervisor++;
			countmanager--;
		}
		}
		else if(jabatanbaru.equals("Admin")){
			if(arrlist.get(update).getJabatan().equals("Supervisor")) {
				countadmin++;
				countsupervisor--;
			}
			else if(arrlist.get(update).getJabatan().equals("Manager")) {
				countadmin++;
				countmanager--;
			}
		}
		arrlist.get(update).setJabatan(jabatanbaru);
		
		
		
		
		do {
		System.out.println("Input Gaji Karyawan Baru [Manager = 8000000 | Supervisor = 6000000 | Admin = 4000000]: ");
		System.out.print(">>");
		gajibaru=scan.nextInt();scan.nextLine();
		}while((!(jabatanbaru.equals("Manager") && gajibaru == 8000000 || jabatanbaru.equals("Supervisor") && gajibaru == 6000000 || jabatanbaru.equals("Admin") && gajibaru == 4000000)));
		arrlist.get(update).setGaji(gajibaru);
		
		System.out.println("Berhasil menambahkan karyawan Baru dengan id "+namabaru);
		System.out.println("Manager : "+countmanager+" Supervisor : "+countsupervisor+" Admin : "+countadmin);
		
		if(countmanager > 3 && countmanager % 3 == 1 && ii == false) {
			i = (arrlist.size() - countmanager % 3);
			for(int p=0;p<i;p++) {
				if(arrlist.get(p).getJabatan().equals("Manager")) {
					penampung_gaji = arrlist.get(p).getGaji() + (arrlist.get(p).getGaji() * 1/10);
					arrlist.get(p).setGaji(penampung_gaji);
				}
			}
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id "); for(int p=0;p<i;p++) {
				if(arrlist.get(p).getJabatan().equals("Manager")){
				System.out.print(arrlist.get(p).getKodekaryawan());
				if(p<i-1 && arrlist.get(p).getJabatan().equals("Manager")){
					System.out.print(", ");
					}
				}	
			}
			System.out.println("");
			ii = true;
		}
		if(ii == true){
			if(countmanager % 3 == 1) {
				ii = true;
			}
			else {
				ii = false;
			}
		}
		
		
		if(countadmin > 3 && countadmin % 3 == 1 && jj==false) {
			j = (arrlist.size() - countadmin % 3);
			for(int p=0;p<j;p++) {
				if(arrlist.get(p).getJabatan().equals("Admin")) {
					penampung_gaji = arrlist.get(p).getGaji() + (arrlist.get(p).getGaji() * 1/20);
					arrlist.get(p).setGaji(penampung_gaji);
				}
			}
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id "); for(int p=0;p<j;p++) {
				if(arrlist.get(p).getJabatan().equals("Admin")) {
				System.out.print(arrlist.get(p).getKodekaryawan());
				if(p<j-1 && arrlist.get(p).getJabatan().equals("Admin")) {
					System.out.print(", ");
					}
				}
				
			}
			System.out.println("");
			jj = true;
		}
		if(jj == true){
			if(countadmin % 3 == 1) {
				jj = true;
			}
			else {
				jj = false;
			}
		}
		
		
		if(countsupervisor > 3 && countsupervisor % 3 == 1 && kk ==false) {
			k = (arrlist.size() - countsupervisor % 3);
			for(int p=0;p<k;p++) {
				if(arrlist.get(p).getJabatan().equals("Supervisor")) {
					penampung_gaji = arrlist.get(p).getGaji() + (arrlist.get(p).getGaji() * 3/40);
					arrlist.get(p).setGaji(penampung_gaji);
				}
			}
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id "); for(int p=0;p<k;p++) {
				if(arrlist.get(p).getJabatan().equals("Supervisor")) {
				System.out.print(arrlist.get(p).getKodekaryawan());
				if(p<k-1 && arrlist.get(p).getJabatan().equals("Supervisor")){
					System.out.print(", ");
					}
				}
			}
			System.out.println("");
		}
		if(kk == true){
			if(countsupervisor % 3 == 1) {
				kk = true;
			}
			else {
				kk = false;
			}
		}
		
		// sorting again
		Collections.sort(arrlist, new Comparator<data>()
		{
			public int compare(data s1,data s2)
			{
				return String.valueOf(s1.getNamakaryawan()).compareTo(s2.getNamakaryawan());
			}
		});
		
		System.out.println("ENTER to Return");
		enter=scan.nextLine();
		break;
		
		case 4:
		int delete;
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");	
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		for(int m=0;m<arrlist.size();m++) {
		System.out.format("%s  %2d%s  %15s%s  %28s%s  %13s%s  %12s%s %12s%s\n","|",(m+1),"|",arrlist.get(m).getKodekaryawan(),"|",arrlist.get(m).getNamakaryawan(),"|",arrlist.get(m).getJeniskelamin(),"|",arrlist.get(m).getJabatan(),"|",arrlist.get(m).getGaji(),"|");
		}
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		System.out.println("Pilih Data ke-berapa yang mau dihapus: ");
		System.out.print(">>");
		delete=scan.nextInt();scan.nextLine();
		arrlist.remove(delete-1);
		break;
		}
	}while(choice!=5);
	System.out.println("==========|---------------------|Terima Kasih atas Datanya ^^ | PT. Mentol |----------------------|==========");
	System.out.println("==========|Created by : Nicholas Valenthinus Tanoto - BNCC20076 - LnT Java Programming Mid-Project|==========");
	System.out.println("==========|---------------------------------------------------------------------------------------|==========");
	}

	public static void main(String[] args) {
	new main();
	
	}

}
