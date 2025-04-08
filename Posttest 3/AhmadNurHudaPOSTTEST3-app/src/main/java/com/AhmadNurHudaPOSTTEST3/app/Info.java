package com.AhmadNurHudaPOSTTEST3.app;

public class Info {
    private String nama;
    private int usia;
    private String nomor_telepon;
    
    public Info(String nama, int usia, String nomor_telepon) {
        this.nama = nama;
        this.usia = usia;
        this.nomor_telepon = nomor_telepon;
    }
    
    protected void setNama(String nama) {
        this.nama = nama;
    }
    protected void setUsia(int usia) {
        this.usia = usia;
    }
    protected void setNomorTelepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }
    
    protected String getNama() {
        return nama;
    }
    protected int getUsia() {
        return usia;
    }
    protected String getNomorTelepon() {
        return nomor_telepon;
    }
}