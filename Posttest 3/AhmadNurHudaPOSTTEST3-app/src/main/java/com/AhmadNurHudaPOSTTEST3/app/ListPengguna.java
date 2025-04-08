package com.AhmadNurHudaPOSTTEST3.app;
import java.util.*;

public class ListPengguna {
	List<Pengguna> penggunaList = new ArrayList<>();
	String username;
	String password;
	String tipeAkun;
	
	public void tambahPengguna(Pengguna pengguna) {
        penggunaList.add(pengguna);
    }
    
    public Optional<Pengguna> tampilkanPengguna(String username) {
        return penggunaList.stream().filter(pengguna -> pengguna.getUsername().equals(username)).findFirst();
    }
    
    public List<Pengguna> semuaPengguna() {
        if (penggunaList == null) {
            return null;
        }
        return new ArrayList<>(penggunaList);
    }
}