package com.AhmadNurHudaPOSTTEST4.app;
import java.util.*;

public class JadwalLatihan {
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