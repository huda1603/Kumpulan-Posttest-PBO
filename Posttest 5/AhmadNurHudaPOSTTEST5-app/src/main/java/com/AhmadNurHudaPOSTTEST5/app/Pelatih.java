package com.AhmadNurHudaPOSTTEST5.app;

public class Pelatih extends Info {
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