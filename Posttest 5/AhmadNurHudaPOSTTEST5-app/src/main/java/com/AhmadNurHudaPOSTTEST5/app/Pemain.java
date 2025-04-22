package com.AhmadNurHudaPOSTTEST5.app;
import java.util.*;

public class Pemain extends Info {
    private int id_pemain;
    private String posisi;
    private int id_tim;
    
    public Pemain(String nama, int usia, String posisi, String nomor_telepon, int id_tim) {
        super(nama, usia, nomor_telepon);
        this.posisi = posisi;
        this.id_tim = id_tim;
    }
    public Pemain(String nama, int usia, String nomor_telepon) {
        super(nama, usia, nomor_telepon);
        this.posisi = null;
        this.id_tim = 0;
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
    
    @Override
    public void tampilkanInfo(List<Tim> timList) {
        Tim tim = timList.stream().filter(t -> t.getIdTim() == getIdTim()).findFirst().orElse(null);
        System.out.println("Pemain " + id_pemain + ": ");
        System.out.println("Nama: " + getNama());
        System.out.println("Usia: " + getUsia());
        System.out.println("Nomor Telp: " + getNomorTelepon());
        if (tim != null) {
            System.out.println("Tim: " + tim.getNamaTim());
        } else {
            System.out.println("Tim: Tidak Ada Keterangan");
        }
        if (posisi != null) {
            System.out.println("Posisi: " + posisi);
        } else {
            System.out.println("Posisi: Tidak Ada Keterangan");
        }
    }
}