package com.AhmadNurHudaPOSTTEST3.app;
import java.util.*;

public class Tim {
    private int id_tim;
    private String nama_tim;
    private String kota_asal;
    private int jumlah_pemain;
    private int id_pelatih;
    private int id_manajer;
    private int id_olahraga;
    
    public Tim(int id_tim, String nama_tim, String kota_asal, int id_olahraga, int jumlah_pemain, int id_pelatih, int id_manajer) {
        this.id_tim = id_tim;
        this.nama_tim = nama_tim;
        this.kota_asal = kota_asal;
        this.id_olahraga = id_olahraga;
        this.jumlah_pemain = jumlah_pemain;
        this.id_pelatih = id_pelatih;
        this.id_manajer = id_manajer;
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
    public void setIdManajer(int id_manajer) {
        this.id_manajer = id_manajer;
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
    public int getIdManajer() {
        return id_manajer;
    }
    
    public void tampilkanInfo(List<Pelatih> pelatihList, List<Manajer> manajerList, List<Olahraga> olahragaList) {
        Pelatih pelatih = pelatihList.stream().filter(p -> p.getIdPelatih() == getIdPelatih()).findFirst().orElse(null);
        Manajer manajer = manajerList.stream().filter(m -> m.getIdManajer() == getIdManajer()).findFirst().orElse(null);
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
        if (manajer != null) {
            System.out.println("Manajer: " + manajer.getNama());
        }
        else {
            System.out.println("Manajer: Tidak Ada Keterangan");
        }
    }
}