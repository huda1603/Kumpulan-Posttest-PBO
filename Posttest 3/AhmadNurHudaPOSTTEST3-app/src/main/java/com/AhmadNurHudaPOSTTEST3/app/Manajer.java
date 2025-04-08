package com.AhmadNurHudaPOSTTEST3.app;

public class Manajer extends Info {
    private int id_manajer;
    
    public Manajer(int id_manajer, String nama, int usia, String nomor_telepon) {
        super(nama, usia, nomor_telepon);
        this.id_manajer = id_manajer;
    }
    
    public void setIdManajer(int id_manajer) {
        this.id_manajer = id_manajer;
    }
    
    public int getIdManajer() {
        return id_manajer;
    }
    
    public void tampilkanInfo() {
        System.out.println("Manajer " + id_manajer + ":");
        System.out.println("Nama: " + getNama());
        System.out.println("Usia: " + getUsia());
        System.out.println("Nomor Telp: " + getNomorTelepon());
    }
}