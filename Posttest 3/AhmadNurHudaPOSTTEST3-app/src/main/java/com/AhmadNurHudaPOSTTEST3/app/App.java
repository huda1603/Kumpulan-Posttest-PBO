package com.AhmadNurHudaPOSTTEST3.app;

import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
		ListEntitas listEntitas = new ListEntitas();
		ListPengguna listPengguna = new ListPengguna();
		Scanner scanner = new Scanner(System.in);
		menu(scanner, listEntitas, listPengguna);
	}
	
	public static void tampilkanSemuaData(ListEntitas listEntitas) {
	    List<Tim> listTim = listEntitas.semuaTim();
	    List<Pemain> listPemain = listEntitas.semuaPemain();
	    List<Pelatih> listPelatih = listEntitas.semuaPelatih();
	    List<Manajer> listManajer = listEntitas.semuaManajer();
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
    	        tim.tampilkanInfo(listPelatih, listManajer, listOlahraga);
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
	    System.out.println("============Manajer============");
	    if (listManajer.isEmpty()) {
	        System.out.println("Tidak Ada Manajer Dalam List");
	    }
	    else {
    	    for (Manajer manajer : listManajer) {
    	        manajer.tampilkanInfo();
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
	    int id_manajer;
	    int id_olahraga;
	    int Count = 1;
	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
	    List<Manajer> manajerList = listEntitas.semuaManajer();
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
	    if (manajerList.isEmpty()) {
	        id_manajer = 0;
	    }
	    else {
    	    for (Manajer m : manajerList) {
    	        System.out.println("[" + Count + "]. " + m.getNama() + ", ID: " + Integer.toString(m.getIdManajer()));
    	        Count++;
    	    }
    	    System.out.print("Pilih Manajer Berdasarkan ID: ");
    	    id_manajer= scanner.nextInt();
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
	    Tim tim = new Tim(0, nama, kota_asal, id_olahraga, 0, id_pelatih, id_manajer);
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
	public static void tambahManajerBaru(Scanner scanner, ListEntitas listEntitas) {
	    System.out.println("===========================");
	    System.out.println("Tambah Manajer Baru");
	    System.out.println("===========================");
	    System.out.print("Nama Manajer: ");
	    String nama = scanner.next();
	    System.out.print("Usia: ");
	    int usia = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("Nomor Telepon: ");
	    String nomor = scanner.next();
	    Manajer manajer = new Manajer(0, nama, usia, nomor);
	    listEntitas.tambahManajer(manajer);
	    System.out.println("Berhasil Menambah Manajer");
	    System.out.println("===========================");
	}
	public static void tambahOlahragaBaru(Scanner scanner, ListEntitas listEntitas) {
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
    	    List<Manajer> manajerList = listEntitas.semuaManajer();
    	    System.out.println("===========================");
    	    System.out.print("Pilih Tim Berdasarkan ID: ");
    	    int id_tim = scanner.nextInt();
    	    System.out.println("===========================");
    	    Tim tim = listEntitas.tampilkanTim(id_tim).orElse(null);
    	    tim.tampilkanInfo(pelatihList, manajerList, olahragaList);
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
	public static void tampilkanDataManajer(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaManajer().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("Tidak Ada Manajer Dalam List");
	        System.out.println("===========================");
	    }
	    else {
    	    System.out.println("===========================");
    	    System.out.print("Pilih Manajer Berdasarkan ID: ");
    	    int id_manajer = scanner.nextInt();
    	    System.out.println("===========================");
    	    Manajer manajer = listEntitas.tampilkanManajer(id_manajer).orElse(null);
    	    manajer.tampilkanInfo();
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
    	    int id_pelatih, id_olahraga, id_manajer;
    	    int Count = 1;
    	    List<Tim> timList = listEntitas.semuaTim();
    	    List<Pelatih> pelatihList = listEntitas.semuaPelatih();
    	    List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
    	    List<Manajer> manajerList = listEntitas.semuaManajer();
    	    System.out.println("===========================");
    	    for (Tim t : timList) {
    	        t.tampilkanInfo(pelatihList, manajerList, olahragaList);
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
    	    Count = 1;
    	    if (manajerList.isEmpty()) {
    	        id_manajer = 0;
    	    }
    	    else {
        	    for (Manajer m : manajerList) {
        	        System.out.println("[" + Count + "]. " + m.getNama() + ", ID: " + m.getIdManajer());
        	        Count++;
        	    }
        	    System.out.print("Pilih Manajer Berdasarkan ID: ");
        	    id_manajer = scanner.nextInt();
    	    }
    	    
    	    tim.setNamaTim(nama);
    	    tim.setKotaAsal(kota_asal);
    	    tim.setJumlahPemain(jumlah_pemain);
    	    tim.setIdPelatih(id_pelatih);
    	    tim.setIdManajer(id_manajer);
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
	public static void editDataManajer(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaManajer().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Manajer> manajerList = listEntitas.semuaManajer();
    	    System.out.println("===========================");
    	    for (Manajer m : manajerList) {
    	        m.tampilkanInfo();
    	    }
    	    System.out.println("===========================");
    	    System.out.print("Pilih Manajer Berdasarkan ID: ");
    	    int id_manajer = scanner.nextInt();
    	    System.out.println("===========================");
    	    Manajer manajer = listEntitas.tampilkanManajer(id_manajer).orElse(null);
    	    
    	    System.out.println("===========================");
    	    System.out.println("Edit Manajer");
    	    System.out.println("===========================");
    	    System.out.print("Edit Nama Manajer: ");
    	    String nama = scanner.next();
    	    System.out.print("Edit Usia: ");
    	    int usia = scanner.nextInt();
    	    scanner.nextLine();
    	    System.out.print("Edit Nomor Telepon: ");
    	    String nomor = scanner.next();
    	    
    	    manajer.setNama(nama);
    	    manajer.setUsia(usia);
    	    manajer.setNomorTelepon(nomor);
    	    boolean isUpdate = listEntitas.updateManajer(manajer);
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
    	    List<Manajer> manajerList = listEntitas.semuaManajer();
    	    System.out.println("===========================");
    	    for (Tim t : timList) {
    	        t.tampilkanInfo(pelatihList, manajerList, olahragaList);
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
	public static void hapusManajer(Scanner scanner, ListEntitas listEntitas) {
	    if (listEntitas.semuaManajer().isEmpty()) {
	        System.out.println("===========================");
	        System.out.println("List Kosong");
	        System.out.println("===========================");
	    }
	    else {
    	    List<Manajer> manajerList = listEntitas.semuaManajer();
    	    System.out.println("===========================");
    	    for (Manajer m : manajerList) {
    	        m.tampilkanInfo();
    	    }
    	    System.out.println("===========================");
    	    System.out.println("Apabila Manajer Dihapus, Maka Tim Yang Di Manajemen Manager Tersebut Akan Terhapus");
    	    System.out.print("Pilih Manajer Yang Akan Dihapus Berdasarkan ID: ");
    	    int id_manajer = scanner.nextInt();
    	    boolean isDelete = listEntitas.deleteManajer(id_manajer);
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

	public static void exportData(ListEntitas listEntitas) throws IOException {
		List<Tim> timList = listEntitas.semuaTim();
		List<Pemain> pemainList = listEntitas.semuaPemain();
		List<Pelatih> pelatihList = listEntitas.semuaPelatih();
		List<Manajer> manajerList = listEntitas.semuaManajer();
		List<Olahraga> olahragaList = listEntitas.semuaOlahraga();
		List<JadwalLatihan> jadwalList = listEntitas.semuaJadwalLatihan();
		Workbook workbook = new XSSFWorkbook();
		CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		CellStyle styleH2 = workbook.createCellStyle();
        styleH2.setAlignment(HorizontalAlignment.CENTER);
        styleH2.setVerticalAlignment(VerticalAlignment.CENTER);
		styleH2.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        styleH2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		CellStyle styleValue = workbook.createCellStyle();
		styleValue.setAlignment(HorizontalAlignment.CENTER);
        styleValue.setVerticalAlignment(VerticalAlignment.CENTER);
		styleValue.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        styleValue.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Sheet sheet1 = workbook.createSheet("Tim");
		String[] header = {"ID Tim", "Nama Tim", "Kota Asal", "ID Olahraga", "Jumlah Pemain", "ID Pelatih", "ID Manajer"};
		buatHeader(style, styleH2, sheet1, "Data Tim", header, 6);
		int rowNumb = 2;int cellNumb = 0;
		for (Tim t : timList) {
			String[] dataTim = {Integer.toString(t.getIdTim()), t.getNamaTim(), t.getKotaAsal(), Integer.toString(t.getIdOlahraga()), Integer.toString(t.getJumlahPemain()), Integer.toString(t.getIdPelatih()), Integer.toString(t.getIdManajer())};
			buatValue(sheet1, styleValue, rowNumb, cellNumb, dataTim);
			rowNumb++;cellNumb = 0;
		}
		Sheet sheet2 = workbook.createSheet("Pemain");
		String[] header2 = {"ID Pemain", "Nama", "Usia", "Pemain", "No Telp", "ID Tim"};
		buatHeader(style, styleH2, sheet2, "Data Pemain", header2, 5);
		rowNumb = 2;cellNumb = 0;
		for (Pemain pm : pemainList) {
			String[] dataPemain = {Integer.toString(pm.getIdPemain()), pm.getNama(), Integer.toString(pm.getUsia()), pm.getPosisi(), pm.getNomorTelepon(), Integer.toString(pm.getIdTim())};
			buatValue(sheet2, styleValue, rowNumb, cellNumb, dataPemain);
			rowNumb++;cellNumb = 0;
		}
		Sheet sheet3 = workbook.createSheet("Pelatih");
		String[] header3 = {"ID Pelatih", "Nama", "Usia", "No Telp"};
		buatHeader(style, styleH2, sheet3, "Data Pelatih", header3, 3);
		rowNumb = 2;cellNumb = 0;
		for (Pelatih pl : pelatihList) {
			String[] dataPelatih = {Integer.toString(pl.getIdPelatih()), pl.getNama(), Integer.toString(pl.getUsia()), pl.getNomorTelepon()};
			buatValue(sheet3, styleValue, rowNumb, cellNumb, dataPelatih);
			rowNumb++;cellNumb = 0;
		}
		Sheet sheet4 = workbook.createSheet("Olahraga");
		String[] header4 = {"ID Olahraga", "Nama Olahraga"};
		buatHeader(style, styleH2, sheet4, "Data Olahraga", header4, 1);
		rowNumb = 2;cellNumb = 0;
		for (Olahraga o : olahragaList) {
			String[] dataOlahraga = {Integer.toString(o.getIdOlahraga()), o.getNamaOlahraga()};
			buatValue(sheet4, styleValue, rowNumb, cellNumb, dataOlahraga);
			rowNumb++;cellNumb = 0;
		}
		Sheet sheet5 = workbook.createSheet("Jadwal Latihan");
		String[] header5 = {"ID Jadwal", "Tanggal", "Waktu", "Lokasi", "ID Tim", "ID Olahraga"};
		buatHeader(style, styleH2, sheet5, "Data Jadwal Latihan", header5, 5);
		rowNumb = 2;cellNumb = 0;
		for (JadwalLatihan j : jadwalList) {
			String[] dataJadwal = {Integer.toString(j.getIdJadwal()), j.getTanggal(), j.getWaktu(), j.getLokasi(), Integer.toString(j.getIdTim()), Integer.toString(j.getIdOlahraga())};
			buatValue(sheet5, styleValue, rowNumb, cellNumb, dataJadwal);
			rowNumb++;cellNumb = 0;
		}
		Sheet sheet6 = workbook.createSheet("Manajer");
		String[] header6 = {"ID Manajer", "Nama", "Usia", "No Telp"};
		buatHeader(style, styleH2, sheet6, "Data Manajer", header6, 3);
		rowNumb = 2;cellNumb = 0;
		for (Manajer m : manajerList) {
			String[] dataManajer = {Integer.toString(m.getIdManajer()), m.getNama(), Integer.toString(m.getUsia()), m.getNomorTelepon()};
			buatValue(sheet6, styleValue, rowNumb, cellNumb, dataManajer);
			rowNumb++;cellNumb = 0;
		}
		FileOutputStream fileOut = new FileOutputStream(new File("Data_Manajemen_Klub_Olahraga.xlsx"));
        workbook.write(fileOut);

        fileOut.close();
        workbook.close();
		System.err.println("Berhasil Di Export");
		System.out.println("===========================");
	}

	public static void importData(Scanner scanner, ListEntitas listEntitas) throws IOException {
		System.out.println("===========================\nPERHATIKAN FORMAT ISI FILE!\n===========================");
		System.out.println("Note 1 (Wajib): 1 Worksheet 1 Entitas");
		System.out.println("	Contoh: Entitas Tim Di Worksheet1, Entitas Pemain Di Worksheet2, Begitu Juga Dengan Entitas Pelatih, Olahraga dan Jadwal Latihan");
		System.out.println("Note 2 (Wajib): Worksheet Harus Berurutan Mulai Dari\nWorksheet Pertama -> Tim\nWorksheet Kedua -> Pemain\nWorksheet Ketiga -> Pelatih\nWorksheet Keempat -> Olahraga\nWorksheet Kelima -> Jadwal Latihan");
		System.out.println("Note 3 (Wajib): Semua Value Properties Dari Setiap Entitas, Wajib Dimulai Dari Kolom Awal/0");
		System.out.println("	Contoh: Entitas Pelatih, Propertiesnya:");
		System.out.println("	(1).Value nama -> Kolom 0,\n(2).Value Usia -> Kolom 1,\n(3).Value No Telp -> Kolom 2");
		System.out.println("Note 4 (Wajib): Tipe Data Pada Semua Properties Di Dalam Sel Wajib STRING");
		System.out.println("Note 5 (Opsional): Posisi Baris Header Di Baris 0 Dan Properties Di Baris 1, Yang Terpenting Header Harus DiAtas Value");
		System.out.println("Note 6 (Opsional): Jika Ingin Pakai Header, Wajib Letakkan Di Kolom 0");
		System.out.println("Note 7 (Opsional): Tidak Mewajibkan Menulis Id Entitas, Id Entitas Otomatis Diatur Oleh Program, Namun jika dilakukan, Id Entitas akan tetap mengganti Id Lama dengan Id Baru Yang Sudah di Program");
		System.out.println("===========================\nGunakan Double Backslash (\\ 2 Kali) Untuk Menulis Path Directory");
		scanner.nextLine();
		System.out.print("Input Directory File Excel (xlsx): ");
		String pathFile = scanner.nextLine();
		FileInputStream file = new FileInputStream(new File(pathFile));
        Workbook workbook = new XSSFWorkbook(file);
        
		for (int i = 0;i<6;i++) {
		    Sheet sheet = workbook.getSheetAt(i);
		    int rowNumb = 0;
		    boolean found = false;
		    while (true) {
		        Row row = sheet.getRow(rowNumb);
		        Cell cell = row.getCell(0);
		        if (cell != null && cell.getStringCellValue().toLowerCase().contains("data") != true) {
		            found = true;
		            if (cell.getStringCellValue().toLowerCase().contains("nama") || cell.getStringCellValue().toLowerCase().contains("anggal") || cell.getStringCellValue().toLowerCase().contains("id")) {
		                rowNumb = rowNumb+1;
		                break;
		            }
		            else if (isAngkaOrString(cell) == true) {
		                break;
		            }
		            rowNumb++;
		        }
		        else {
		            rowNumb++;
		        }
		    }
		    if (found == true) {
    		    while (true) {
    		        Row rowV = sheet.getRow(rowNumb);
					if (rowV == null) {
						break;
					}
    		        boolean isImported = importValue(i, rowV, listEntitas);
    		        if (isImported != true) {
    		            break;
    		        }
    		        rowNumb++;
    		    }
		    }
		}
		file.close();
        workbook.close();
		System.out.println("Berhasil Di Import");
		System.out.println("===========================");
	}

	public static void buatHeader(CellStyle style, CellStyle styleH2, Sheet sheet, String data, String[] header, int panjang) {
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(data);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, panjang));
		cell.setCellStyle(style);

		Row rowHead = sheet.createRow(1);
		int cellNumb = 0;
		for (String h : header) {
			Cell cellHead = rowHead.createCell(cellNumb);
			cellHead.setCellValue(h);
			sheet.autoSizeColumn(cellNumb);
			cellHead.setCellStyle(styleH2);
			cellNumb++;
		}
	}

	public static void buatValue(Sheet sheet, CellStyle style, int rowNumb, int cellNumb, String[] data) {
		Row row = sheet.createRow(rowNumb);
		for (String d : data) {
			Cell cell = row.createCell(cellNumb);
			cell.setCellValue(d);;
			sheet.autoSizeColumn(cellNumb);
			cell.setCellStyle(style);
			cellNumb++;
		}
	}
	
	public static boolean importValue(int i, Row row, ListEntitas listEntitas) {
	    boolean valueDepanIsAngka;
	    List<String> valueList = valueLists(row);
		boolean valKosong = valueList.isEmpty();
	    try {
	        Double.parseDouble(valueList.get(0));
	        valueDepanIsAngka = true;
	    }
	    catch (Exception e) {
	        valueDepanIsAngka = false;
	    }
	    if (valKosong != true) {
    		if (i == 0) {
    		    if (valueDepanIsAngka == true) {
    		        Tim importTim = new Tim((int) Double.parseDouble(valueList.get(0)), valueList.get(1), valueList.get(2), (int) Double.parseDouble(valueList.get(3)), 0, (int) Double.parseDouble(valueList.get(5)), (int) Double.parseDouble(valueList.get(6)));
                	listEntitas.tambahTim(importTim);
    		    }
    		    else {
    				System.out.println(valueList);
                    Tim importTim = new Tim(0, valueList.get(0), valueList.get(1), (int) Double.parseDouble(valueList.get(2)), 0, (int) Double.parseDouble(valueList.get(4)), (int) Double.parseDouble(valueList.get(5)));
                	listEntitas.tambahTim(importTim);
    		    }
    		}
    		else if (i == 1) {
    			if (valueDepanIsAngka == true) {
        			Pemain importPemain = new Pemain((int) Double.parseDouble(valueList.get(0)), valueList.get(1), (int) Double.parseDouble(valueList.get(2)), valueList.get(3), valueList.get(4), (int) Double.parseDouble(valueList.get(5)));
        			listEntitas.tambahPemain(importPemain);
    			}
    			else {
    			    Pemain importPemain = new Pemain(0, valueList.get(0), (int) Double.parseDouble(valueList.get(1)), valueList.get(2), valueList.get(3), (int) Double.parseDouble(valueList.get(4)));
        			listEntitas.tambahPemain(importPemain);
    			}
    		}
    		else if (i == 2) {
    			if (valueDepanIsAngka == true) {
        			Pelatih importPelatih = new Pelatih((int) Double.parseDouble(valueList.get(0)), valueList.get(1), (int) Double.parseDouble(valueList.get(2)), valueList.get(3));
        			listEntitas.tambahPelatih(importPelatih);
    			}
    			else {
    			    Pelatih importPelatih = new Pelatih(0, valueList.get(0), (int) Double.parseDouble(valueList.get(1)), valueList.get(2));
        			listEntitas.tambahPelatih(importPelatih);
    			}
    		}
    		else if (i == 3) {
    			if (valueDepanIsAngka == true) {
        			Olahraga importOlahraga = new Olahraga((int) Double.parseDouble(valueList.get(0)), valueList.get(1));
        			listEntitas.tambahOlahraga(importOlahraga);
    			}
    			else {
    			    Olahraga importOlahraga = new Olahraga(0, valueList.get(0));
        			listEntitas.tambahOlahraga(importOlahraga);
    			}
    		}
    		else if (i == 4) {
    			if (valueDepanIsAngka == true) {
        			JadwalLatihan importJadwal = new JadwalLatihan((int) Double.parseDouble(valueList.get(0)), valueList.get(1), valueList.get(2), valueList.get(3), (int) Double.parseDouble(valueList.get(4)), (int) Double.parseDouble(valueList.get(5)));
        			listEntitas.tambahJadwalLatihan(importJadwal);
    			}
    			else {
    			    JadwalLatihan importJadwal = new JadwalLatihan(0, valueList.get(0), valueList.get(1), valueList.get(2), (int) Double.parseDouble(valueList.get(3)), (int) Double.parseDouble(valueList.get(4)));
        			listEntitas.tambahJadwalLatihan(importJadwal);
    			}
    		}
			else {
    			if (valueDepanIsAngka == true) {
        			Manajer importManajer = new Manajer((int) Double.parseDouble(valueList.get(0)), valueList.get(1), (int) Double.parseDouble(valueList.get(2)), valueList.get(3));
        			listEntitas.tambahManajer(importManajer);
    			}
    			else {
    			    Manajer importManajer = new Manajer(0, valueList.get(0), (int) Double.parseDouble(valueList.get(1)), valueList.get(2));
        			listEntitas.tambahManajer(importManajer);
    			}
    		}
    		return true;
	    }
	    else {
	        return false;
	    }
	}
	
	public static List<String> valueLists(Row rowValue) {
	    List<String> valueList = new ArrayList<>();
		for (Cell cellValue : rowValue) {
		    if (cellValue == null) {
                break;
			}
			else {
				if (cellValue.getCellType() == CellType.NUMERIC) {
					valueList.add(Double.toString(cellValue.getNumericCellValue()));
				}
				else {
					valueList.add(cellValue.getStringCellValue());
				}
			}
        }
        return new ArrayList<>(valueList);
	}
	
	public static boolean isAngkaOrString(Cell cell) {
	    boolean isAngka = false;boolean isString = false;
	    try {
            cell.getNumericCellValue();
            isAngka = true;
        } catch (Exception e) {
            if (cell == null || cell.getStringCellValue() == "") {
                return false;
            }
            else {
                isString = true;
            }
        }
        if (isAngka == true || isString == true) {
            return true;
        }
		else {
			return false;
		}
	}
	
	public static int adminMenu(Scanner scanner) {
	    System.out.println("===========================");
	    System.out.println("Sistem Manajemen Klub Olahraga");
	    System.out.println("1. Tampilkan Semua Data Klub Olahraga");
    	System.out.println("2. Tambah Tim Klub Baru");
    	System.out.println("3. Tambah Pemain Baru Untuk Tim");
    	System.out.println("4. Tambah Pelatih Baru");
    	System.out.println("5. Tambah Manajer Baru");
    	System.out.println("6. Tambah Olahraga Baru");
    	System.out.println("7. Tambah Jadwal Baru");
    	System.out.println("8. Tampilkan Data Tim");
    	System.out.println("9. Tampilkan Data Pemain");
    	System.out.println("10. Tampilkan Data Pelatih");
    	System.out.println("11. Tampilkan Data Manajer");
    	System.out.println("12. Tampilkan Data Olahraga");
    	System.out.println("13. Tampilkan Jadwal");
    	System.out.println("14. Edit Data Tim");
    	System.out.println("15. Edit Data Pemain");
    	System.out.println("16. Edit Data Pelatih");
    	System.out.println("17. Edit Data Manajer");
    	System.out.println("18. Edit Data Olahraga");
    	System.out.println("19. Edit Jadwal");
    	System.out.println("20. Hapus Tim");
    	System.out.println("21. Hapus Pemain");
    	System.out.println("22. Hapus Pelatih");
    	System.out.println("23. Hapus Manajer");
    	System.out.println("24. Hapus Olahraga");
    	System.out.println("25. Hapus Jadwal");
    	System.out.println("26. Export Data Ke Excel");
		System.out.println("27. Import Data Dari Excel");
    	System.out.println("28. Keluar");
    	System.out.println("29. Logout");
	    System.out.print("Pilih Menu:");
	    int pilih = scanner.nextInt();
	    System.out.println("===========================");
	    if (pilih > 0 && pilih < 30) {
	        return pilih;
	    }
		else {
			return 0;
		}
	}
	
	public static int userMenu(Scanner scanner) {
	    System.out.println("===========================");
	    System.out.println("Menu User");
	    System.out.println("1. Tampilkan Semua Data Klub Olahraga");
    	System.out.println("2. Tampilkan Data Tim");
    	System.out.println("3. Tampilkan Data Pemain");
    	System.out.println("4. Tampilkan Data Pelatih");
    	System.out.println("5. Tampilkan Data Manajer");
    	System.out.println("6. Tampilkan Data Olahraga");
    	System.out.println("7. Tampilkan Jadwal");
    	System.out.println("8. Keluar");
    	System.out.println("9. Logout");
	    System.out.print("Pilih Menu:");
	    int pilih = scanner.nextInt();
	    System.out.println("===========================");
	    if (pilih > 0 && pilih < 10) {
	        return pilih;
	    }
		else {
			return 0;
		}
	}
	
	public static void registerAkun(Scanner scanner, ListPengguna listPengguna) {
	    System.out.println("===========================");
	    String username;
	    while (true) {
    	    System.out.print("Buat Username: ");
    	    username = scanner.next();
    	    if (listPengguna.tampilkanPengguna(username).orElse(null) != null) {
    	        System.out.println("Username Sudah Terpakai");
    	    }
    	    else {
    	        break;
    	    }
	    }
	    System.out.print("Buat Password: ");
	    String password = scanner.next();
	    
		String tipeAkun;
	    while (true) {
    	    System.out.println("1. Admin");
    	    System.out.println("2. User");
    	    System.out.print("Pilih Tipe Akun: ");
    	    int tipe = scanner.nextInt();
    	    
    	    if (tipe == 1) {
    	        tipeAkun = "Admin";
    	        break;
    	    }
    	    else if (tipe == 2) {
    	        tipeAkun = "User";
    	        break;
    	    }
    	    else {
    	        System.out.println("Pilih 1-2");
    	    }
	    }
		Pengguna pengguna = new Pengguna(username, password, tipeAkun);
	    listPengguna.tambahPengguna(pengguna);
	    System.out.println("Berhasil Menambah Akun Pengguna");
	    System.out.println("===========================");
	}
	
	public static String loginAkun(Scanner scanner, ListPengguna listPengguna) {
		System.out.println("===========================");
	    System.out.print("Masukkan Username: ");
	    String username = scanner.next();
	    System.out.print("Masukkan Password: ");
	    String password = scanner.next();
	    
	    Pengguna p = listPengguna.tampilkanPengguna(username).orElse(null);
	    
	    if (p != null && p.getPassword().equals(password)) {
	        System.out.println("Berhasil Login");
    	    System.out.println("===========================");
	        return p.getTipe();
	    }
	    System.out.println("Akun Tidak Ditemukan");
        System.out.println("===========================");
	    return null;
	}
	
	public static void menu(Scanner scanner, ListEntitas listEntitas, ListPengguna listPengguna) {
	    while (true) {
	        System.out.println("===========================");
	        System.out.println("1. Register");
	        System.out.println("2. Login");
    	    System.out.print("Pilih Menu: ");
    	    int pilih = scanner.nextInt();
    	    if (pilih == 1) {
    	        registerAkun(scanner, listPengguna);
    	    }
    	    else if (pilih == 2) {
    	        String tipe = loginAkun(scanner, listPengguna);
    	        if (tipe != null) {
    	            app(tipe, scanner, listEntitas, listPengguna);
    	        }
    	    }
    	    else {
    	        System.out.println("Pilih 1-2");
    	    }
	    }
	}
	
	public static void app(String tipe, Scanner scanner, ListEntitas listEntitas, ListPengguna listPengguna) {
		while (true) {
			int pilihan;
            if (tipe == "Admin") {
                pilihan = adminMenu(scanner);
				if (pilihan < 1 || pilihan > 29) {
					System.out.println("Pilih 1 - 29");
				}
            }
            else {
                pilihan = userMenu(scanner);
                if (pilihan > 1 && pilihan < 8) {
                    pilihan += 6;
                }
                else if (pilihan > 7 && pilihan < 10) {
                    pilihan += 20;
                }
				else {
					System.out.println("Pilih 1 - 9");
				}
            }
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
    		        tambahManajerBaru(scanner, listEntitas);
    		        break;
    		    case 6:
    		        tambahOlahragaBaru(scanner, listEntitas);
    		        break;
    		    case 7:
    		        tambahJadwalBaru(scanner, listEntitas);
    		        break;
    		    case 8:
    		        tampilkanDataTim(scanner, listEntitas);
    		        break;
    		    case 9:
    		        tampilkanDataPemain(scanner, listEntitas);
    		        break;
    		    case 10:
    		        tampilkanDataPelatih(scanner, listEntitas);
    		        break;
    		    case 11:
    		        tampilkanDataManajer(scanner, listEntitas);
    		        break;
    		    case 12:
    		        tampilkanDataOlahraga(scanner, listEntitas);
    		        break;
    		    case 13:
    		        tampilkanDataJadwal(scanner, listEntitas);
    		        break;
    		    case 14:
    		        editDataTim(scanner, listEntitas);
    		        break;
    		    case 15:
    		        editDataPemain(scanner, listEntitas);
    		        break;
    		    case 16:
    		        editDataPelatih(scanner, listEntitas);
    		        break;
    		    case 17:
    		        editDataManajer(scanner, listEntitas);
    		        break;
    		    case 18:
    		        editDataOlahraga(scanner, listEntitas);
    		        break;
    		    case 19:
    		        editDataJadwal(scanner, listEntitas);
    		        break;
    		    case 20:
    		        hapusTim(scanner, listEntitas);
    		        break;
    		    case 21:
    		        hapusPemain(scanner, listEntitas);
    		        break;
    		    case 22:
    		        hapusPelatih(scanner, listEntitas);
    		        break;
    		    case 23:
    		        hapusManajer(scanner, listEntitas);
    		        break;
    		    case 24:
    		        hapusOlahraga(scanner, listEntitas);
    		        break;
    		    case 25:
    		        hapusJadwal(scanner, listEntitas);
    		        break;
    		    case 26:
					try {
						exportData(listEntitas);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 27:
					try {
						importData(scanner, listEntitas);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 28:
					System.exit(0);
				case 29:
					menu(scanner, listEntitas, listPengguna);
    		}
    	}
	}
}