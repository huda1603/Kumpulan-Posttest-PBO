package com.AhmadNurHudaPOSTTEST5.app;

import java.util.List;

public abstract class Info {
    private final String nama;
    private final int usia;
    private final String nomor_telepon;
    
    public Info(String nama, int usia, String nomor_telepon) {
        this.nama = nama;
        this.usia = usia;
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

    abstract void tampilkanInfo(List<Tim> timList);
}