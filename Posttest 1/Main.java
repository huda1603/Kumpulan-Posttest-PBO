import java.util.*;

public class Main {
	public static void main(String[] args) {
		ListEntitas listEntitas = new ListEntitas();
		
		Scanner scanner = new Scanner(System.in);
    	while (true) {
            System.out.println("Sistem Manajemen Klub Olahraga");
    		System.out.println("1. Tampilkan Semua Data Klub Olahraga");
    		System.out.println("2. Tambah Tim Klub Baru");
    		System.out.println("3. Tambah Pemain Baru Untuk Tim");
    		System.out.println("4. Tambah Pelatih Baru");
    		System.out.println("5. Tambah Olahraga Baru");
    		System.out.println("6. Tambah Jadwal Baru");
    		System.out.println("7. Tampilkan Data Tim");
    		System.out.println("8. Tampilkan Data Pemain");
    		System.out.println("9. Tampilkan Data Pelatih");
    		System.out.println("10. Tampilkan Data Olahraga");
    		System.out.println("11. Tampilkan Jadwal");
    		System.out.println("12. Edit Data Tim");
    		System.out.println("13. Edit Data Pemain");
    		System.out.println("14. Edit Data Pelatih");
    		System.out.println("15. Edit Data Olahraga");
    		System.out.println("16. Edit Jadwal");
    		System.out.println("17. Hapus Tim");
    		System.out.println("18. Hapus Pemain");
    		System.out.println("19. Hapus Pelatih");
    		System.out.println("20. Hapus Olahraga");
    		System.out.println("21. Hapus Jadwal");
    		System.out.println("22. Keluar");
    		System.out.print("Pilih: ");
    		int pilihan = scanner.nextInt();
    		
    		switch (pilihan) {
    		    case 1:
    		        tampilkanSemuaData(listEntitas);
    		        break;
    		    case 2:
    		        tambahTimBaru(scanner, listEntitas);
    		        break;
    		    case 3:
    		        tambahPemainBaru(scanner, listEntitas);
    		        break;
    		    case 4:
    		        tambahPelatihBaru(scanner, listEntitas);
    		        break;
    		    case 5:
    		        tambahOlahragaBaru(scanner, listEntitas);
    		        break;
    		    case 6:
    		        tambahJadwalBaru(scanner, listEntitas);
    		        break;
    		    case 7:
    		        tampilkanDataTim(scanner, listEntitas);
    		        break;
    		    case 8:
    		        tampilkanDataPemain(scanner, listEntitas);
    		        break;
    		    case 9:
    		        tampilkanDataPelatih(scanner, listEntitas);
    		        break;
    		    case 10:
    		        tampilkanDataOlahraga(scanner, listEntitas);
    		        break;
    		    case 11:
    		        tampilkanDataJadwal(scanner, listEntitas);
    		        break;
    		    case 12:
    		        editDataTim(scanner, listEntitas);
    		        break;
    		    case 13:
    		        editDataPemain(scanner, listEntitas);
    		        break;
    		    case 14:
    		        editDataPelatih(scanner, listEntitas);
    		        break;
    		    case 15:
    		        editDataOlahraga(scanner, listEntitas);
    		        break;
    		    case 16:
    		        editDataJadwal(scanner, listEntitas);
    		        break;
    		    case 17:
    		        hapusTim(scanner, listEntitas);
    		        break;
    		    case 18:
    		        hapusPemain(scanner, listEntitas);
    		        break;
    		    case 19:
    		        hapusPelatih(scanner, listEntitas);
    		        break;
    		    case 20:
    		        hapusOlahraga(scanner, listEntitas);
    		        break;
    		    case 21:
    		        hapusJadwal(scanner, listEntitas);
    		        break;
    		    case 22:
    		        System.exit(0);
    		    default:
    		        System.out.println("Pilihan Tidak Dalam Rentang 1 - 22");
    		}
    	}
	}
	
	public static void tampilkanSemuaData(ListEntitas listEntitas) {
	    List<Tim> listTim = listEntitas.semuaTim();
	    List<Pemain> listPemain = listEntitas.semuaPemain();
	    List<Pelatih> listPelatih = listEntitas.semuaPelatih();
	    List<Olahraga> listOlahraga = listEntitas.semuaOlahraga();
	    List<JadwalLatihan> listJadwal = listEntitas.semuaJadwalLatihan();
	    
	    System.out.println("===========================");
	    System.out.println("Semua Data Sistem Manajemen Klub Olahraga");
	    System.out.println("============Tim============");
	    if (listTim.isEmpty()) {
	        System.out.println("Tidak Ada Tim Dalam List");
	    }
	    else {
	        for (Tim tim : listTim) {
    	        tim.tampilkanInfo(listPelatih, listOlahraga);
    	    }
	    }
	    System.out.println("============Pemain============");
	    if (listPemain.isEmpty()) {
	        System.out.println("Tidak Ada Pemain Dalam List");
	    }
	    else {
    	    for (Pemain pemain : listPemain) {
    	        pemain.tampilkanInfo(listTim);
    	    }
	    }
	    System.out.println("============Pelatih============");
	    if (listPelatih.isEmpty()) {
	        System.out.println("Tidak Ada Pelatih Dalam List");
	    }
	    else {
    	    for (Pelatih pelatih : listPelatih) {
    	        pelatih.tampilkanInfo();
    	    }
	    }
	    System.out.println("============Olahraga============");
	    if (listOlahraga.isEmpty()) {
	        System.out.println("Tidak Ada Olahraga Dalam List");
	    }
	    else {
    	    for (Olahraga olahraga : listOlahraga) {
    	        olahraga.tampilkanInfo();
    	    }
	    }
	    System.out.println("============Jadwal Latihan============");
	    if (listJadwal.isEmpty()) {
	        System.out.println("Tidak Ada Jadwal Latihan Dalam List");
	    }
	    else {
    	    for (JadwalLatihan jadwal : listJadwal) {
    	        jadwal.tampilkanInfo(listTim, listOlahraga);
    	    }
	    }
	    System.out.println("===========================");
	}
	public static void tambahTimBaru(Scanner scanner, ListEntitas listEntitas) {
	    int id_pelatih;
	    int id_olahraga;
	    int Count = 1;
	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
	    System.out.println("===========================");
	    System.out.println("Tambah Tim Baru");
	    System.out.println("===========================");
	    System.out.print("Nama Tim: ");
	    String nama = scanner.next();
	    System.out.print("Kota Asal: ");
	    String kota_asal = scanner.next();
	    if (pelatihList.isEmpty()) {
	        id_pelatih = 0;
	    }
	    else {
    	    for (Pelatih p : pelatihList) {
    	        System.out.println("[" + Integer.toString(Count) + "]. " + p.getNama() + ", ID: " + Integer.toString(p.getIdPelatih()));
    	        Count++;
    	    }
    	    System.out.print("Pilih Pelatih Berdasarkan ID: ");
    	    id_pelatih = scanner.nextInt();
	    }
	    Count = 1;
	    if (olahragaList.isEmpty()) {
	        id_olahraga = 0;
	    }
	    else {
    	    for (Olahraga o : olahragaList) {
    	        System.out.println("[" + Count + "]. " + o.getNamaOlahraga() + ", ID: " + Integer.toString(o.getIdOlahraga()));
    	        Count++;
    	    }
    	    System.out.print("Pilih Olahraga Berdasarkan ID: ");
    	    id_olahraga = scanner.nextInt();
	    }
	    Tim tim = new Tim(0, nama, kota_asal, id_olahraga, 0, id_pelatih);
	    listEntitas.tambahTim(tim);
	    System.out.println("Berhasil Menambah Tim");
	    System.out.println("===========================");
	}
	public static void tambahPemainBaru(Scanner scanner, ListEntitas listEntitas) {
	    int id_tim;
	    int Count = 1;
	    List<Tim> timList = listEntitas.semuaTim();
	    System.out.println("===========================");
	    System.out.println("Tambah Pemain Baru");
	    System.out.println("===========================");
	    System.out.print("Nama Pemain: ");
	    String nama = scanner.next();
	    System.out.print("Usia: ");
	    int usia = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("Posisi: ");
	    String posisi = scanner.next();
	    System.out.print("Nomor Telepon: ");
	    String nomor = scanner.next();
	    if (timList.isEmpty()) {
	        id_tim = 0;
	    }
	    else {
    	    for (Tim t : timList) {
    	        System.out.println("[" + Count + "]. " + t.getNamaTim() + ", ID: " + t.getIdTim());
    	        Count++;
    	    }
    	    System.out.print("Pilih Tim Berdasarkan ID: ");
    	    id_tim = scanner.nextInt();
	    }
	    Pemain pemain = new Pemain(0, nama, usia, posisi, nomor, id_tim);
	    listEntitas.tambahPemain(pemain);
	    System.out.println("Berhasil Menambah Pemain");
	    System.out.println("===========================");
	}
	public static void tambahPelatihBaru(Scanner scanner, ListEntitas listEntitas) {
	    int Count = 1;
	    System.out.println("===========================");
	    System.out.println("Tambah Pelatih Baru");
	    System.out.println("===========================");
	    System.out.print("Nama Pelatih: ");
	    String nama = scanner.next();
	    System.out.print("Usia: ");
	    int usia = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("Nomor Telepon: ");
	    String nomor = scanner.next();
	    Pelatih pelatih = new Pelatih(0, nama, usia, nomor);
	    listEntitas.tambahPelatih(pelatih);
	    System.out.println("Berhasil Menambah Pelatih");
	    System.out.println("===========================");
	}
	public static void tambahOlahragaBaru(Scanner scanner, ListEntitas listEntitas) {
	    int Count = 1;
	    System.out.println("===========================");
	    System.out.println("Tambah Olahraga Baru");
	    System.out.println("===========================");
	    System.out.print("Nama Olahraga: ");
	    String nama = scanner.next();
	    Olahraga olahraga = new Olahraga(0, nama);
	    listEntitas.tambahOlahraga(olahraga);
	    System.out.println("Berhasil Menambah Olahraga");
	    System.out.println("===========================");
	}
	public static void tambahJadwalBaru(Scanner scanner, ListEntitas listEntitas) {
	    int id_tim, id_olahraga;
	    int Count = 1;
	    List<Tim> timList = listEntitas.semuaTim();
	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
	    System.out.println("===========================");
	    System.out.println("Tambah Jadwal Baru");
	    System.out.println("===========================");
	    System.out.print("Tanggal: ");
	    String tanggal = scanner.next();
	    System.out.print("Waktu: ");
	    String waktu = scanner.next();
	    System.out.print("Lokasi: ");
	    String lokasi = scanner.next();
        if (timList.isEmpty()) {
	        id_tim = 0;
	    }
	    else {	    
    	    for (Tim t : timList) {
    	        System.out.println("[" + Count + "]. " + t.getNamaTim() + ", ID: " + t.getIdTim());
    	        Count++;
    	    }
    	    System.out.print("Pilih Tim Berdasarkan ID: ");
    	    id_tim = scanner.nextInt();
	    }
	    
	    Count = 1;
	    if (olahragaList.isEmpty()) {
	        id_olahraga = 0;
	    }
	    else {
    	    for (Olahraga o : olahragaList) {
    	        System.out.println("[" + Count + "]. " + o.getNamaOlahraga() + ", ID: " + o.getIdOlahraga());
    	        Count++;
    	    }
    	    System.out.print("Pilih Olahraga Berdasarkan ID: ");
    	    id_olahraga = scanner.nextInt();
	    }
	    JadwalLatihan jadwal = new JadwalLatihan(0, tanggal, waktu, lokasi, id_tim, id_olahraga);
	    listEntitas.tambahJadwalLatihan(jadwal);
	    System.out.println("Berhasil Menambah Jadwal Latihan");
	    System.out.println("===========================");
	}
	public static void tampilkanDataTim(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaTim().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("Tidak Ada Tim Dalam List");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    System.out.print("Pilih Tim Berdasarkan ID: ");
    	    int id_tim = scanner.nextInt();
    	    System.out.println("===========================");
    	    Tim tim = listEntitas.tampilkanTim(id_tim).orElse(null);
    	    tim.tampilkanInfo(pelatihList, olahragaList);
    	    System.out.println("===========================");
	    }
	}
	public static void tampilkanDataPemain(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaPemain().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("Tidak Ada Pemain Dalam List");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Tim> timList = listEntitas.semuaTim();
    	    System.out.println("===========================");
    	    System.out.print("Pilih Pemain Berdasarkan ID: ");
    	    int id_pemain = scanner.nextInt();
    	    System.out.println("===========================");
    	    Pemain pemain = listEntitas.tampilkanPemain(id_pemain).orElse(null);
    	    pemain.tampilkanInfo(timList);
    	    System.out.println("===========================");
	    }
	}
	public static void tampilkanDataPelatih(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaPelatih().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("Tidak Ada Pelatih Dalam List");
	        System.out.println("===========================");
	    }
	    else {
    	    System.out.println("===========================");
    	    System.out.print("Pilih Pelatih Berdasarkan ID: ");
    	    int id_pelatih = scanner.nextInt();
    	    System.out.println("===========================");
    	    Pelatih pelatih = listEntitas.tampilkanPelatih(id_pelatih).orElse(null);
    	    pelatih.tampilkanInfo();
    	    System.out.println("===========================");
	    }
	}
	public static void tampilkanDataOlahraga(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaOlahraga().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("Tidak Ada Jenis Olahraga Dalam List");
	        System.out.println("===========================");
	    }
	    else {
    	    System.out.println("===========================");
    	    System.out.print("Pilih Olahraga Berdasarkan ID: ");
    	    int id_olahraga = scanner.nextInt();
    	    System.out.println("===========================");
    	    Olahraga olahraga = listEntitas.tampilkanOlahraga(id_olahraga).orElse(null);
    	    olahraga.tampilkanInfo();
    	    System.out.println("===========================");
	    }
	}
	public static void tampilkanDataJadwal(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaJadwalLatihan().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("Tidak Ada Jadwal Latihan Dalam List");
	        System.out.println("===========================");
	    }
	    else { 
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    System.out.print("Pilih Jadwal Berdasarkan ID: ");
    	    int id_jadwal = scanner.nextInt();
    	    System.out.println("===========================");
    	    JadwalLatihan jadwal = listEntitas.tampilkanJadwalLatihan(id_jadwal).orElse(null);
    	    jadwal.tampilkanInfo(timList, olahragaList);
    	    System.out.println("===========================");
	    }
	}
	public static void editDataTim(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaTim().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    int id_pelatih, id_olahraga;
    	    int Count = 1;
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    for (Tim t : timList) {
    	        t.tampilkanInfo(pelatihList, olahragaList);
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Tim Berdasarkan ID: ");
    	    int id_tim = scanner.nextInt();
    	    System.out.println("===========================");
    	    Tim tim = listEntitas.tampilkanTim(id_tim).orElse(null);
    	    
    	    System.out.println("===========================");
    	    System.out.println("Edit Tim");
    	    System.out.println("===========================");
    	    System.out.print("Edit Nama Tim: ");
    	    String nama = scanner.next();
    	    System.out.print("Edit Kota Asal: ");
    	    String kota_asal = scanner.next();
    	    System.out.print("Edit Jumlah Pemain: ");
    	    int jumlah_pemain = scanner.nextInt();
    	    if (pelatihList.isEmpty()) {
    	        id_pelatih = 0;
    	    }
    	    else {
        	    for (Pelatih p : pelatihList) {
        	        System.out.println("[" + Count + "]. " + p.getNama() + ", ID: " + p.getIdPelatih());
        	        Count++;
        	    }
        	    System.out.print("Pilih Pelatih Berdasarkan ID: ");
        	    id_pelatih = scanner.nextInt();
    	    }
    	    Count = 1;
    	    if (olahragaList.isEmpty()) {
    	        id_olahraga = 0;
    	    }
    	    else {
        	    for (Olahraga o : olahragaList) {
        	        System.out.println("[" + Count + "]. " + o.getNamaOlahraga() + ", ID: " + o.getIdOlahraga());
        	        Count++;
        	    }
        	    System.out.print("Pilih Olahraga Berdasarkan ID: ");
        	    id_olahraga = scanner.nextInt();
    	    }
    	    
    	    tim.setNamaTim(nama);
    	    tim.setKotaAsal(kota_asal);
    	    tim.setJumlahPemain(jumlah_pemain);
    	    tim.setIdPelatih(id_pelatih);
    	    tim.setIdOlahraga(id_olahraga);
    	    boolean isUpdate = listEntitas.updateTim(tim);
    	    if (isUpdate == true) {
    	        System.out.println("Berhasil Di Update");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukam");
    	    }
	    }
	}
	public static void editDataPemain(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaPemain().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    int id_tim;
    	    int Count = 1;
    	    List<Pemain> pemainList = listEntitas.semuaPemain();
    	    List<Tim> timList = listEntitas.semuaTim();
    	    System.out.println("===========================");
    	    for (Pemain p : pemainList) {
    	        p.tampilkanInfo(timList);
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Pemain Berdasarkan ID: ");
    	    int id_pemain = scanner.nextInt();
    	    System.out.println("===========================");
    	    Pemain pemain = listEntitas.tampilkanPemain(id_pemain).orElse(null);
    	    Tim t2 = listEntitas.tampilkanTim(pemain.getIdTim()).orElse(null);
    	    
    	    System.out.println("===========================");
    	    System.out.println("Edit Pemain");
    	    System.out.println("===========================");
    	    System.out.print("Edit Nama Pemain: ");
    	    String nama = scanner.next();
    	    System.out.print("Edit Usia: ");
    	    int usia = scanner.nextInt();
    	    scanner.nextLine();
    	    System.out.print("Edit Posisi: ");
    	    String posisi = scanner.next();
    	    System.out.print("Edit Nomor Telepon: ");
    	    String nomor = scanner.next();
    	    if (timList.isEmpty()) {
    	        id_tim = 0;
    	    }
    	    else {
        	    for (Tim t : timList) {
        	        System.out.println("[" + Count + "]. " + t.getNamaTim() + ", ID: " + t.getIdTim());
        	        Count++;
        	    }
        	    System.out.print("Pilih Tim Berdasarkan ID: ");
        	    id_tim = scanner.nextInt();
        	    
        	    for (Tim t : timList) {
        	        if (t.getIdTim() == id_tim && id_tim != pemain.getIdTim()) {
        	            t.setJumlahPemain(t.getJumlahPemain() + 1);
        	            if (t2 != null) {
            	            t2.setJumlahPemain(t2.getJumlahPemain() - 1);
        	            }
        	            break;
        	        }
        	    }
    	    }
    	    
    	    pemain.setNama(nama);
    	    pemain.setUsia(usia);
    	    pemain.setPosisi(posisi);
    	    pemain.setNomorTelepon(nomor);
    	    pemain.setIdTim(id_tim);
    	    boolean isUpdate = listEntitas.updatePemain(pemain);
    	    if (isUpdate == true) {
    	        System.out.println("Berhasil Di Update");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukam");
    	    }
	    }
	}
	public static void editDataPelatih(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaPelatih().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
    	    System.out.println("===========================");
    	    for (Pelatih p : pelatihList) {
    	        p.tampilkanInfo();
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Pelatih Berdasarkan ID: ");
    	    int id_pelatih = scanner.nextInt();
    	    System.out.println("===========================");
    	    Pelatih pelatih = listEntitas.tampilkanPelatih(id_pelatih).orElse(null);
    	    
    	    System.out.println("===========================");
    	    System.out.println("Edit Pelatih");
    	    System.out.println("===========================");
    	    System.out.print("Edit Nama Pelatih: ");
    	    String nama = scanner.next();
    	    System.out.print("Edit Usia: ");
    	    int usia = scanner.nextInt();
    	    scanner.nextLine();
    	    System.out.print("Edit Nomor Telepon: ");
    	    String nomor = scanner.next();
    	    
    	    pelatih.setNama(nama);
    	    pelatih.setUsia(usia);
    	    pelatih.setNomorTelepon(nomor);
    	    boolean isUpdate = listEntitas.updatePelatih(pelatih);
    	    if (isUpdate == true) {
    	        System.out.println("Berhasil Di Update");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukam");
    	    }
	    }
	}
	public static void editDataOlahraga(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaOlahraga().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    for (Olahraga o : olahragaList) {
    	        o.tampilkanInfo();
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Olahraga Berdasarkan ID: ");
    	    int id_olahraga = scanner.nextInt();
    	    System.out.println("===========================");
    	    Olahraga olahraga = listEntitas.tampilkanOlahraga(id_olahraga).orElse(null);
    	    
    	    System.out.println("===========================");
    	    System.out.println("Edit Olahraga");
    	    System.out.println("===========================");
    	    System.out.print("Edit Nama Olahraga: ");
    	    String nama = scanner.next();
    	    
    	    olahraga.setNamaOlahraga(nama);
    	    boolean isUpdate = listEntitas.updateOlahraga(olahraga);
    	    if (isUpdate == true) {
    	        System.out.println("Berhasil Di Update");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukam");
    	    }
	    }
	}
	public static void editDataJadwal(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaJadwalLatihan().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    int id_tim, id_olahraga;
    	    int Count = 1;
    	    List<JadwalLatihan> jadwalList = listEntitas.semuaJadwalLatihan();
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    for (JadwalLatihan j : jadwalList) {
    	        j.tampilkanInfo(timList, olahragaList);
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Jadwal Berdasarkan ID: ");
    	    int id_jadwal = scanner.nextInt();
    	    System.out.println("===========================");
    	    JadwalLatihan jadwal = listEntitas.tampilkanJadwalLatihan(id_jadwal).orElse(null);
    	    
    	    System.out.println("===========================");
    	    System.out.println("Edit Jadwal Latihan");
    	    System.out.println("===========================");
    	    System.out.print("Edit Tanggal: ");
    	    String tanggal = scanner.next();
    	    System.out.print("Edit Waktu: ");
    	    String waktu = scanner.next();
    	    System.out.print("Edit Lokasi: ");
    	    String lokasi = scanner.next();
    	    if (timList.isEmpty()) {
    	        id_tim = 0;
    	    }
    	    else {
        	    for (Tim t : timList) {
        	        System.out.println("[" + Count + "]. " + t.getNamaTim() + ", ID: " + t.getIdTim());
        	        Count++;
        	    }
        	    System.out.print("Pilih Tim Berdasarkan ID: ");
        	    id_tim = scanner.nextInt();
    	    }
    	    Count = 1;
    	    if (olahragaList.isEmpty()) {
    	        id_olahraga = 0;
    	    }
    	    else {
        	    for (Olahraga o : olahragaList) {
        	        System.out.println("[" + Count + "]. " + o.getNamaOlahraga() + ", ID: " + o.getIdOlahraga());
        	        Count++;
        	    }
        	    System.out.print("Pilih Olahraga Berdasarkan ID: ");
        	    id_olahraga = scanner.nextInt();
    	    }
    	    
    	    jadwal.setTanggal(tanggal);
    	    jadwal.setWaktu(waktu);
    	    jadwal.setLokasi(lokasi);
    	    jadwal.setIdTim(id_tim);
    	    jadwal.setIdOlahraga(id_olahraga);
    	    boolean isUpdate = listEntitas.updateJadwalLatihan(jadwal);
    	    if (isUpdate == true) {
    	        System.out.println("Berhasil Di Update");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukam");
    	    }
	    }
	}
	public static void hapusTim(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaTim().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    for (Tim t : timList) {
    	        t.tampilkanInfo(pelatihList, olahragaList);
    	    }
    	    System.out.println("===========================");
    	    System.out.println("Apabila Tim Dihapus, Pemain Yang Ada Dalam Tim Dan Jadwal Latihan Yang Berkaitan Juga Akan Ikut Terhapus");
    	    System.out.print("Pilih Tim Yang Akan Dihapus Berdasarkan ID: ");
    	    int id_tim = scanner.nextInt();
    	    boolean isDelete = listEntitas.deleteTim(id_tim);
    	    if (isDelete == true) {
    	        System.out.println("Berhasil Dihapus");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukan");
    	    }
    	    System.out.println("===========================");
	    }
	}
	public static void hapusPemain(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaPemain().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Pemain> pemainList = listEntitas.semuaPemain();
    	    System.out.println("===========================");
    	    for (Pemain p : pemainList) {
    	        p.tampilkanInfo(timList);
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Pemain Yang Akan Dihapus Berdasarkan ID: ");
    	    int id_pemain = scanner.nextInt();
    	    boolean isDelete = listEntitas.deletePemain(id_pemain);
    	    if (isDelete == true) {
    	        System.out.println("Berhasil Dihapus");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukan");
    	    }
    	    System.out.println("===========================");
	    }
	}
	public static void hapusPelatih(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaPelatih().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
    	    System.out.println("===========================");
    	    for (Pelatih p : pelatihList) {
    	        p.tampilkanInfo();
    	    }
    	    System.out.println("===========================");
    	    System.out.println("Apabila Pelatih Dihapus, Maka Tim Yang Dilatih Pelatih Tersebut Tidak Akan Memiliki Pelatih Alias Tidak Ada Keterangan");
    	    System.out.print("Pilih Pelatih Yang Akan Dihapus Berdasarkan ID: ");
    	    int id_pelatih = scanner.nextInt();
    	    boolean isDelete = listEntitas.deletePelatih(id_pelatih);
    	    if (isDelete == true) {
    	        System.out.println("Berhasil Dihapus");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukan");
    	    }
    	    System.out.println("===========================");
	    }
	}
	public static void hapusOlahraga(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaOlahraga().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    System.out.println("===========================");
    	    for (Olahraga o : olahragaList) {
    	        o.tampilkanInfo();
    	    }
    	    System.out.println("===========================");
    	    System.out.println("Apabila Jenis Olahraga Dihapus, Maka Tim Yang Berjenis Olahraga Tersebut Tidak Akan Memiliki Jenis Olahraga, Begitu Juga Dengan Jadwal Latihan");
    	    System.out.print("Pilih Olahraga Yang Akan Dihapus Berdasarkan ID: ");
    	    int id_olahraga = scanner.nextInt();
    	    boolean isDelete = listEntitas.deleteOlahraga(id_olahraga);
    	    if (isDelete == true) {
    	        System.out.println("Berhasil Dihapus");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukan");
    	    }
    	    System.out.println("===========================");
	    }
	}
	public static void hapusJadwal(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaJadwalLatihan().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    List<JadwalLatihan> jadwalList = listEntitas.semuaJadwalLatihan();
    	    System.out.println("===========================");
    	    for (JadwalLatihan j : jadwalList) {
    	        j.tampilkanInfo(timList, olahragaList);
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Jadwal Yang Akan Dihapus Berdasarkan ID: ");
    	    int id_jadwal = scanner.nextInt();
    	    boolean isDelete = listEntitas.deleteJadwalLatihan(id_jadwal);
    	    if (isDelete == true) {
    	        System.out.println("Berhasil Dihapus");
    	    }
    	    else {
    	        System.out.println("Data Tidak Ditemukan");
    	    }
    	    System.out.println("===========================");
	    }
	}
}

class Tim {
    private int id_tim;
    private String nama_tim;
    private String kota_asal;
    private int jumlah_pemain;
    private int id_pelatih;
    private int id_olahraga;
    
    public Tim(int id_tim, String nama_tim, String kota_asal, int id_olahraga, int jumlah_pemain, int id_pelatih) {
        this.id_tim = id_tim;
        this.nama_tim = nama_tim;
        this.kota_asal = kota_asal;
        this.id_olahraga = id_olahraga;
        this.jumlah_pemain = jumlah_pemain;
        this.id_pelatih = id_pelatih;
    }
    
    public void setIdTim(int id_tim) {
        this.id_tim = id_tim;
    }
    public void setNamaTim(String nama_tim) {
        this.nama_tim = nama_tim;
    }
    public void setKotaAsal(String kota_asal) {
        this.kota_asal = kota_asal;
    }
    public void setIdOlahraga(int id_olahraga) {
        this.id_olahraga = id_olahraga;
    }
    public void setJumlahPemain(int jumlah_pemain) {
        this.jumlah_pemain = jumlah_pemain;
    }
    public void setIdPelatih(int id_pelatih) {
        this.id_pelatih = id_pelatih;
    }
    
    public int getIdTim() {
        return id_tim;
    }
    public String getNamaTim() {
        return nama_tim;
    }
    public String getKotaAsal() {
        return kota_asal;
    }
    public int getIdOlahraga() {
        return id_olahraga;
    }
    public int getJumlahPemain() {
        return jumlah_pemain;
    }
    public int getIdPelatih() {
        return id_pelatih;
    }
    
    public void tampilkanInfo(List<Pelatih> pelatihList, List<Olahraga> olahragaList) {
        Pelatih pelatih = pelatihList.stream().filter(p -> p.getIdPelatih() == getIdPelatih()).findFirst().orElse(null);
        Olahraga olahraga = olahragaList.stream().filter(o -> o.getIdOlahraga() == getIdOlahraga()).findFirst().orElse(null);
        System.out.println("Tim " + id_tim + ": " + nama_tim);
        System.out.println("Nama Tim: " + nama_tim);
        System.out.println("Kota Asal: " + kota_asal);
        if (olahraga != null) {
            System.out.println("Jenis Olahraga: " + olahraga.getNamaOlahraga());
        }
        else {
            System.out.println("Jenis Olahraga: Tidak Ada Keterangan");
        }
        System.out.println("Jumlah Pemain: " + jumlah_pemain);
        if (pelatih != null) {
            System.out.println("Pelatih: " + pelatih.getNama());
        }
        else {
            System.out.println("Pelatih: Tidak Ada Keterangan");
        }
    }
}

class Olahraga {
    private int id_olahraga;
    private String nama_olahraga;
    
    public Olahraga(int id_olahraga, String nama_olahraga) {
        this.id_olahraga = id_olahraga;
        this.nama_olahraga = nama_olahraga;
    }
    
    public void setIdOlahraga(int id_olahraga) {
        this.id_olahraga = id_olahraga;
    }
    public void setNamaOlahraga(String nama_olahraga) {
        this.nama_olahraga = nama_olahraga;
    }
    
    public int getIdOlahraga() {
        return id_olahraga;
    }
    public String getNamaOlahraga() {
        return nama_olahraga;
    }
    
    public void tampilkanInfo() {
        System.out.println("Olahraga " + id_olahraga + ": " + nama_olahraga);
    }
}

class Info {
    private String nama;
    private int usia;
    private String nomor_telepon;
    
    public Info(String nama, int usia, String nomor_telepon) {
        this.nama = nama;
        this.usia = usia;
        this.nomor_telepon = nomor_telepon;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setUsia(int usia) {
        this.usia = usia;
    }
    public void setNomorTelepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }
    
    public String getNama() {
        return nama;
    }
    public int getUsia() {
        return usia;
    }
    public String getNomorTelepon() {
        return nomor_telepon;
    }
}

class Pemain extends Info {
    private int id_pemain;
    private String posisi;
    private int id_tim;
    
    public Pemain(int id_pemain, String nama, int usia, String posisi, String nomor_telepon, int id_tim) {
        super(nama, usia, nomor_telepon);
        this.id_pemain = id_pemain;
        this.posisi = posisi;
        this.id_tim = id_tim;
    }
    
    public void setIdPemain(int id_pemain) {
        this.id_pemain = id_pemain;
    }
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
    public void setIdTim(int id_tim) {
        this.id_tim = id_tim;
    }
    
    public int getIdPemain() {
        return id_pemain;
    }
    public String getPosisi() {
        return posisi;
    }
    public int getIdTim() {
        return id_tim;
    }
    
    public void tampilkanInfo(List<Tim> timList) {
        Tim tim = timList.stream().filter(t -> t.getIdTim() == getIdTim()).findFirst().orElse(null);
        System.out.println("Pemain " + id_pemain + ": ");
        System.out.println("Nama: " + getNama());
        System.out.println("Usia: " + getUsia());
        System.out.println("Nomor Telp: " + getNomorTelepon());
        System.out.println("Posisi: " + posisi);
        if (tim != null) {
            System.out.println("Tim: " + tim.getNamaTim());
        }
        else {
            System.out.println("Tim: Tidak Ada Keterangan");
        }
    }
}

class Pelatih extends Info {
    private int id_pelatih;
    
    public Pelatih(int id_pelatih, String nama, int usia, String nomor_telepon) {
        super(nama, usia, nomor_telepon);
        this.id_pelatih = id_pelatih;
    }
    
    public void setIdPelatih(int id_pelatih) {
        this.id_pelatih = id_pelatih;
    }
    
    public int getIdPelatih() {
        return id_pelatih;
    }
    
    public void tampilkanInfo() {
        System.out.println("Pelatih " + id_pelatih + ":");
        System.out.println("Nama: " + getNama());
        System.out.println("Usia: " + getUsia());
        System.out.println("Nomor Telp: " + getNomorTelepon());
    }
}

class JadwalLatihan {
    private int id_jadwal;
    private String tanggal;
    private String waktu;
    private String lokasi;
    private int id_tim;
    private int id_olahraga;
    
    public JadwalLatihan(int id_jadwal, String tanggal, String waktu, String lokasi, int id_tim, int id_olahraga) {
        this.id_jadwal = id_jadwal;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.lokasi = lokasi;
        this.id_tim = id_tim;
        this.id_olahraga = id_olahraga;
    }
    
    public void setIdJadwal(int id_jadwal) {
        this.id_jadwal = id_jadwal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public void setIdTim(int id_tim) {
        this.id_tim = id_tim;
    }
    public void setIdOlahraga(int id_olahraga) {
        this.id_olahraga = id_olahraga;
    }
    
    public int getIdJadwal() {
        return id_jadwal;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getWaktu() {
        return waktu;
    }
    public String getLokasi() {
        return lokasi;
    }
    public int getIdTim() {
        return id_tim;
    }
    public int getIdOlahraga() {
        return id_olahraga;
    }
    
    public void tampilkanInfo(List<Tim> timList, List<Olahraga> olahragaList) {
        Tim tim = timList.stream().filter(t -> t.getIdTim() == getIdTim()).findFirst().orElse(null);
        Olahraga olahraga = olahragaList.stream().filter(o -> o.getIdOlahraga() == getIdOlahraga()).findFirst().orElse(null);
        System.out.println("Jadwal " + id_jadwal + ": ");
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Waktu: " + waktu);
        System.out.println("Lokasi: " + lokasi);
        if (tim != null) {
            System.out.println("Tim: " + tim.getNamaTim());
        }
        else {
            System.out.println("Tim: Tidak Ada Keterangan");
        }
        if (olahraga != null) {
            System.out.println("Olahraga: " + olahraga.getNamaOlahraga());
        }
        else {
            System.out.println("Olahraga: Tidak Ada Keterangan");
        }
    }
}

class ListEntitas {
    private List<Tim> timList = new ArrayList<>();
    private List<Pemain> pemainList = new ArrayList<>();
    private List<Pelatih> pelatihList = new ArrayList<>();
    private List<Olahraga> olahragaList = new ArrayList<>();
    private List<JadwalLatihan> jadwalList = new ArrayList<>();
    private int id_counter_tim = 1;
    private int id_counter_pemain = 1;
    private int id_counter_pelatih = 1;
    private int id_counter_olahraga = 1;
    private int id_counter_jadwal = 1;
    
    /*
    Tim
    */
    
    // Create
    public void tambahTim(Tim tim) {
        tim.setIdTim(id_counter_tim);
        this.id_counter_tim = this.id_counter_tim + 1;
        timList.add(tim);
    }
    
    // Read
    public Optional<Tim> tampilkanTim(int id_tim) {
        return timList.stream().filter(tim -> tim.getIdTim() == id_tim).findFirst();
    }
    
    public List<Tim> semuaTim() {
        if (timList == null) {
            return null;
        }
        return new ArrayList<>(timList);
    }
    
    // Update
    public boolean updateTim(Tim tim) {
        Optional<Tim> timLama = tampilkanTim(tim.getIdTim());
        if (timLama.isPresent()) {
            Tim updatedTim = timLama.get();
            updatedTim.setNamaTim(tim.getNamaTim());
            updatedTim.setKotaAsal(tim.getKotaAsal());
            updatedTim.setIdOlahraga(tim.getIdOlahraga());
            updatedTim.setJumlahPemain(tim.getJumlahPemain());
            updatedTim.setIdPelatih(tim.getIdPelatih());
            return true;
        }
        return false;
    }
    
    // Delete
    public boolean deleteTim(int id_tim) {
        boolean isTimDeleted = timList.removeIf(tim -> tim.getIdTim() == id_tim);
        if (isTimDeleted == true) {
            pemainList.removeIf(p -> p.getIdTim() == id_tim);
            jadwalList.removeIf(j -> j.getIdTim() == id_tim);
            return true;
        }
        else {
            return false;
        }
    }
    
    /*
    Pemain
    */
    
    // Create
    public void tambahPemain(Pemain pemain) {
        pemain.setIdPemain(id_counter_pemain);
        this.id_counter_pemain = this.id_counter_pemain + 1;
        pemainList.add(pemain);
        
        if (pemain.getIdTim() != 0) {
            for (Tim tim : timList) {
                if (tim.getIdTim() == pemain.getIdTim()) {
                    tim.setJumlahPemain(tim.getJumlahPemain() + 1);
                }
            }
        }
            
    }
    
    // Read
    public Optional<Pemain> tampilkanPemain(int id_pemain) {
        return pemainList.stream().filter(pemain -> pemain.getIdPemain() == id_pemain).findFirst();
    }
    
    public List<Pemain> semuaPemain() {
        if (pemainList == null) {
            return null;
        }
        return new ArrayList<>(pemainList);
    }
    
    // Update
    public boolean updatePemain(Pemain pemain) {
        Optional<Pemain> pemainLama = tampilkanPemain(pemain.getIdPemain());
        if (pemainLama.isPresent()) {
            Pemain updatedPemain = pemainLama.get();
            updatedPemain.setNama(pemain.getNama());
            updatedPemain.setUsia(pemain.getUsia());
            updatedPemain.setPosisi(pemain.getPosisi());
            updatedPemain.setNomorTelepon(pemain.getNomorTelepon());
            updatedPemain.setIdTim(pemain.getIdTim());
            return true;
        }
        return false;
    }
    
    // Delete
    public boolean deletePemain(int id_pemain) {
        Pemain p = tampilkanPemain(id_pemain).orElse(null);
        boolean isPemainDeleted = pemainList.removeIf(pemain -> pemain.getIdPemain() == id_pemain);
        if (isPemainDeleted == true) {
            if (p.getIdTim() != 0) {
                for (Tim tim : timList) {
                    if (tim.getIdTim() == p.getIdTim()) {
                        tim.setJumlahPemain(tim.getJumlahPemain() - 1);
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /*
    Pelatih
    */
    
    // Create
    public void tambahPelatih(Pelatih pelatih) {
        pelatih.setIdPelatih(id_counter_pelatih);
        this.id_counter_pelatih = this.id_counter_pelatih + 1;
        pelatihList.add(pelatih);
    }
    
    // Read
    public Optional<Pelatih> tampilkanPelatih(int id_pelatih) {
        return pelatihList.stream().filter(pelatih -> pelatih.getIdPelatih() == id_pelatih).findFirst();
    }
    
    public List<Pelatih> semuaPelatih() {
        if (pelatihList == null) {
            return null;
        }
        return new ArrayList<>(pelatihList);
    }
    
    // Update
    public boolean updatePelatih(Pelatih pelatih) {
        Optional<Pelatih> pelatihLama = tampilkanPelatih(pelatih.getIdPelatih());
        if (pelatihLama.isPresent()) {
            Pelatih updatedPelatih = pelatihLama.get();
            updatedPelatih.setNama(pelatih.getNama());
            updatedPelatih.setUsia(pelatih.getUsia());
            updatedPelatih.setNomorTelepon(pelatih.getNomorTelepon());
            return true;
        }
        return false;
    }
    
    // Delete
    public boolean deletePelatih(int id_pelatih) {
        boolean isPelatihDeleted = pelatihList.removeIf(pelatih -> pelatih.getIdPelatih() == id_pelatih);
        if (isPelatihDeleted == true) {
            for (Tim tim : timList) {
                if (tim.getIdPelatih() == id_pelatih) {
                    tim.setIdPelatih(0);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /*
    Olahraga
    */
    
    // Create
    public void tambahOlahraga(Olahraga olahraga) {
        olahraga.setIdOlahraga(id_counter_olahraga);
        this.id_counter_olahraga = this.id_counter_olahraga + 1;
        olahragaList.add(olahraga);
    }
    
    // Read
    public Optional<Olahraga> tampilkanOlahraga(int id_olahraga) {
        return olahragaList.stream().filter(olahraga -> olahraga.getIdOlahraga() == id_olahraga).findFirst();
    }
    
    public List<Olahraga> semuaOlahraga() {
        if (olahragaList == null) {
            return null;
        }
        return new ArrayList<>(olahragaList);
    }
    
    // Update
    public boolean updateOlahraga(Olahraga olahraga) {
        Optional<Olahraga> olahragaLama = tampilkanOlahraga(olahraga.getIdOlahraga());
        if (olahragaLama.isPresent()) {
            Olahraga updatedOlahraga = olahragaLama.get();
            updatedOlahraga.setNamaOlahraga(olahraga.getNamaOlahraga());
            return true;
        }
        return false;
    }
    
    // Delete
    public boolean deleteOlahraga(int id_olahraga) {
        boolean isOlahragaDeleted = olahragaList.removeIf(olahraga -> olahraga.getIdOlahraga() == id_olahraga);
        if (isOlahragaDeleted == true) {
            for (Tim tim : timList) {
                if (tim.getIdOlahraga() == id_olahraga) {
                    tim.setIdOlahraga(0);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /*
    Jadwal Latihan
    */
    
    // Create
    public void tambahJadwalLatihan(JadwalLatihan jadwallatihan) {
        jadwallatihan.setIdJadwal(id_counter_jadwal);
        this.id_counter_jadwal = this.id_counter_jadwal + 1;
        jadwalList.add(jadwallatihan);
    }
    
    // Read
    public Optional<JadwalLatihan> tampilkanJadwalLatihan(int id_jadwal) {
        return jadwalList.stream().filter(jadwallatihan -> jadwallatihan.getIdJadwal() == id_jadwal).findFirst();
    }
    
    public List<JadwalLatihan> semuaJadwalLatihan() {
        if (jadwalList == null) {
            return null;
        }
        return new ArrayList<>(jadwalList);
    }
    
    // Update
    public boolean updateJadwalLatihan(JadwalLatihan jadwallatihan) {
        Optional<JadwalLatihan> jadwalLama = tampilkanJadwalLatihan(jadwallatihan.getIdJadwal());
        if (jadwalLama.isPresent()) {
            JadwalLatihan updatedJadwalLatihan = jadwalLama.get();
            updatedJadwalLatihan.setTanggal(jadwallatihan.getTanggal());
            updatedJadwalLatihan.setWaktu(jadwallatihan.getWaktu());
            updatedJadwalLatihan.setLokasi(jadwallatihan.getLokasi());
            updatedJadwalLatihan.setIdTim(jadwallatihan.getIdTim());
            updatedJadwalLatihan.setIdOlahraga(jadwallatihan.getIdOlahraga());
            return true;
        }
        return false;
    }
    
    // Delete
    public boolean deleteJadwalLatihan(int id_jadwal) {
        boolean isJadwalDeleted = jadwalList.removeIf(jadwallatihan -> jadwallatihan.getIdJadwal() == id_jadwal);
        if (isJadwalDeleted == true) {
            return true;
        }
        else {
            return false;
        }
    }
}