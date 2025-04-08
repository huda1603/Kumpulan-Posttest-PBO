package com.AhmadNurHudaPOSTTEST3.app;

public class Olahraga {
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