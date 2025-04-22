package com.AhmadNurHudaPOSTTEST5.app;
import java.util.*;

public class ListEntitas {
    List<Tim> timList = new ArrayList<>();
    List<Pemain> pemainList = new ArrayList<>();
    List<Pelatih> pelatihList = new ArrayList<>();
    List<Manajer> manajerList = new ArrayList<>();
    List<Olahraga> olahragaList = new ArrayList<>();
    List<JadwalLatihan> jadwalList = new ArrayList<>();
    int id_counter_tim = 1;
    int id_counter_pemain = 1;
    int id_counter_pelatih = 1;
    int id_counter_manajer = 1;
    int id_counter_olahraga = 1;
    int id_counter_jadwal = 1;
    
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
            updatedTim.setIdManajer(tim.getIdManajer());
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
            Tim tim = timList.stream().filter(t -> t.getIdPelatih() == id_pelatih).findFirst().orElse(null);
            if (tim != null) {
                tim.setIdPelatih(0);
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /*
    Manajer
    */
    
    // Create
    public void tambahManajer(Manajer manajer) {
        manajer.setIdManajer(id_counter_manajer);
        this.id_counter_manajer = this.id_counter_manajer + 1;
        manajerList.add(manajer);
    }
    
    // Read
    public Optional<Manajer> tampilkanManajer(int id_manajer) {
        return manajerList.stream().filter(manajer -> manajer.getIdManajer() == id_manajer).findFirst();
    }
    
    public List<Manajer> semuaManajer() {
        if (manajerList == null) {
            return null;
        }
        return new ArrayList<>(manajerList);
    }
    
    // Update
    public boolean updateManajer(Manajer manajer) {
        Optional<Manajer> manajerLama = tampilkanManajer(manajer.getIdManajer());
        if (manajerLama.isPresent()) {
            Manajer updatedManajer = manajerLama.get();
            updatedManajer.setNama(manajer.getNama());
            updatedManajer.setUsia(manajer.getUsia());
            updatedManajer.setNomorTelepon(manajer.getNomorTelepon());
            return true;
        }
        return false;
    }
    
    // Delete
    public boolean deleteManajer(int id_manajer) {
        boolean isManajerDeleted = manajerList.removeIf(manajer -> manajer.getIdManajer() == id_manajer);
        if (isManajerDeleted == true) {
            Tim tim = timList.stream().filter(t -> t.getIdManajer() == id_manajer).findFirst().orElse(null);
            if (tim != null) {
                deleteTim(tim.getIdTim());
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