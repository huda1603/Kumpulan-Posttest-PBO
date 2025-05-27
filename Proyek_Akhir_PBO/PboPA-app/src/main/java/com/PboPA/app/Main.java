package com.PboPA.app;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

interface musikkk {
    void bunyiMusik();
}

abstract class AlatMusik implements musikkk {
    private String nama_alat;
    private Double harga;
    private String kategori;

    public AlatMusik(String nama_alat, Double harga, String kategori) {
        this.nama_alat = nama_alat;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getNamaAlat() {
        return nama_alat;
    }
    public void setNamaAlat(String nama_alat) {
        this.nama_alat = nama_alat;
    }
    public Double getHarga() {
        return harga;
    }
    public void setHarga(Double harga) {
        this.harga = harga;
    }
    public String getKategori() {
        return kategori;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}

class Drum extends AlatMusik {
    private int id_drum;
    private String bunyi;
    public Drum(int id_drum, String nama_alat, Double harga, String kategori, String bunyi) {
        super(nama_alat, harga, kategori);
        this.id_drum = id_drum;
        this.bunyi = bunyi;
    }
    public int getId() {
        return id_drum;
    }
    public String getBunyi() {
        return bunyi;
    }
    public void tampilkan() {
        System.out.println("ID Drum: " + getId());
        System.out.println("Nama Alat: " + getNamaAlat());
        System.out.println("Harga: " + getHarga());
        System.out.println("Kategori: " + getKategori());
    }
    @Override
    public void bunyiMusik() {
        System.out.println(bunyi);
    }
}

class Gitar extends AlatMusik {
    private int id_gitar;
    private String bunyi;
    public Gitar(int id_gitar, String nama_alat, Double harga, String kategori, String bunyi) {
        super(nama_alat, harga, kategori);
        this.id_gitar = id_gitar;
        this.bunyi = bunyi;
    }
    public int getId() {
        return id_gitar;
    }
    public String getBunyi() {
        return bunyi;
    }
    public void tampilkan() {
        System.out.println("ID Gitar: " + getId());
        System.out.println("Nama Alat: " + getNamaAlat());
        System.out.println("Harga: " + getHarga());
        System.out.println("Kategori: " + getKategori());
    }
    @Override
    public void bunyiMusik() {
        System.out.println(bunyi);
    }
}

class AlatMusikManajer {
    private String namaAlatSebelumEdit;
    private HashMap<String, List<Object>> listAlat = new HashMap<>(); {
        listAlat.put("Drum", new ArrayList<>());
        listAlat.put("Gitar", new ArrayList<>());
    }

    private int idCounter = 1;
    
    public void tambahAlat() {
        Object[] data = isiDataAlat(false);
        String nama_alat = (String) data[0];
        Double harga = (Double) data[1];
        String kategori = (String) data[2];
        String bunyi = (String) data[3];
        if (kategori.equals("Drum")) {
            listAlat.get("Drum").add(new Drum(idCounter, nama_alat, harga, kategori, bunyi));
        }
        else {
            listAlat.get("Gitar").add(new Gitar(idCounter, nama_alat, harga, kategori, bunyi));
        }
        idCounter++;
        System.out.println(nama_alat + " Sebagai " + kategori + " Berhasil Di Tambah");
    }
    
    public void editAlat() {
	if (listAlat.get("Drum").isEmpty() && listAlat.get("Gitar").isEmpty()) {
            System.out.println("Tidak Ada Alat Musik Yang Tersedia Untuk Di Urutkan");
            return;
        }
        Drum d;Gitar g;String nama_alat;
        tampilkanSemuaAlat(true);
        int id_alat = inputInteger("Pilih Alat Musik Berdasarkan ID: ");
        Optional<Object> obj = itemMusik(id_alat);
        if (obj.isEmpty()) {
            System.out.println("Alat Musik Tidak Ditemukan");
            return;
        }
        Object alat = obj.get();
        if (alat instanceof Drum) {
            d = (Drum) alat;
            namaAlatSebelumEdit = d.getNamaAlat();
            System.out.println("Edit Data Drum");
            Object[] data = isiDataAlat(true);
            d.setNamaAlat((String) data[0]);
            d.setHarga((Double) data[1]);
            nama_alat = d.getNamaAlat();
        } else {
            g = (Gitar) alat;
            namaAlatSebelumEdit = g.getNamaAlat();
            System.out.println("Edit Data Gitar");
            Object[] data = isiDataAlat(true);
            g.setNamaAlat((String) data[0]);
            g.setHarga((Double) data[1]);
            nama_alat = g.getNamaAlat();
        }
        System.out.println(nama_alat + " Berhasil Di Edit");
    }
    
    public void hapusAlat() {
	if (listAlat.get("Drum").isEmpty() && listAlat.get("Gitar").isEmpty()) {
            System.out.println("Tidak Ada Alat Musik Yang Tersedia Untuk Di Urutkan");
            return;
        }
        String nama_alat;
        tampilkanSemuaAlat(true);
        int id_alat = inputInteger("Pilih Alat Musik Berdasarkan ID: ");
        Optional<Object> obj = itemMusik(id_alat);
        if (obj.isEmpty()) {
            System.out.println("Alat Musik Tidak Ditemukan");
            return;
        }
        Object alat = obj.get();
        if (alat instanceof Drum) {
            nama_alat = ((Drum) alat).getNamaAlat();
            listAlat.get("Drum").remove((Drum) alat);
        } else {
            nama_alat = ((Gitar) alat).getNamaAlat();
            listAlat.get("Gitar").remove((Gitar) alat);
        }
        System.out.println(nama_alat + " Berhasil Di Hapus");
    }
    
    public void tampilkanSalahSatuAlat() {
	if (listAlat.get("Drum").isEmpty() && listAlat.get("Gitar").isEmpty()) {
            System.out.println("Tidak Ada Alat Musik Yang Tersedia Untuk Di Urutkan");
            return;
        }
        tampilkanSemuaAlat(false);
        int id_alat = inputInteger("Pilih Alat Musik Berdasarkan ID: ");
        Optional<Object> obj = itemMusik(id_alat);
        if (obj.isEmpty()) {
            System.out.println("Alat Musik Tidak Ditemukan");
            return;
        }
        Object alat = obj.get();
        if (alat instanceof Drum) {
            ((Drum) alat).tampilkan();
        } else {
            ((Gitar) alat).tampilkan();
        }
    }
    
    public void tampilkanSemuaAlat(boolean tampilLengkap) {
        List<Object> listDrum = listAlat.get("Drum");
        List<Object> listGitar = listAlat.get("Gitar");
        System.out.println("====================================");
        System.out.println("Drum");
        if (listDrum != null) {
            for (Object obj : listDrum) {
                if (obj instanceof Drum) {
                    Drum d = (Drum) obj;
                    if (tampilLengkap) {
                        d.tampilkan();
                    } else {
                        System.out.println(Integer.toString(d.getId()) + ". " + d.getNamaAlat());
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("====================================");
        System.out.println("Gitar");
        if (listGitar != null) {
            for (Object obj : listGitar) {
                if (obj instanceof Gitar) {
                    Gitar g = (Gitar) obj;
                    if (tampilLengkap) {
                        g.tampilkan();
                    } else {
                        System.out.println(Integer.toString(g.getId()) + ". " + g.getNamaAlat());
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("====================================");
    }
    
    public void cariAlat() {
	if (listAlat.get("Drum").isEmpty() && listAlat.get("Gitar").isEmpty()) {
            System.out.println("Tidak Ada Alat Musik Yang Tersedia Untuk Di Urutkan");
            return;
        }
        List<Object> listDrum = listAlat.get("Drum");
        List<Object> listGitar = listAlat.get("Gitar");
        Scanner scanner = new Scanner(System.in);
        String kata_kunci;
        try {
            System.out.print("Cari Alat Berdasarkan Kata Kunci Nama: ");
            kata_kunci = scanner.next();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("====================================");
        System.out.println("Hasil Pencarian Pada Alat Drum");
        if (listDrum != null) {
            for (Object obj : listDrum) {
                if (obj instanceof Drum) {
                    Drum d = (Drum) obj;
                    if (d.getNamaAlat().contains(kata_kunci)) {
                        d.tampilkan();
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("====================================");
        System.out.println("Hasil Pencarian Pada Alat Gitar");
        if (listGitar != null) {
            for (Object obj : listGitar) {
                if (obj instanceof Gitar) {
                    Gitar g = (Gitar) obj;
                    if (g.getNamaAlat().contains(kata_kunci)) {
                        g.tampilkan();
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("====================================");
    }
    
    public void urutkanAlat() {
	if (listAlat.get("Drum").isEmpty() && listAlat.get("Gitar").isEmpty()) {
            System.out.println("Tidak Ada Alat Musik Yang Tersedia Untuk Di Urutkan");
            return;
        }
        List<Object> listDrum = listAlat.get("Drum");
        List<Object> listGitar = listAlat.get("Gitar");
        Scanner scanner = new Scanner(System.in);
        String pilihKriteria;
        try {
            System.out.println("1. Nama Alat");
            System.out.println("2. Harga");
            System.out.print("Urutkan Alat Musik Berdasarkan: ");
            pilihKriteria = scanner.next();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        if ((pilihKriteria.equals("1") == false) && (pilihKriteria.equals("2") == false)) {
            System.out.println("Pilihan Tidak Valid, Pilih 1 - 2");
            return;
        }
        String pilihJenis;
        try {
            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            System.out.print("Jenis Pengurutan: ");
            pilihJenis = scanner.next();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        if ((pilihJenis.equals("1") == false) && (pilihJenis.equals("2") == false)) {
            System.out.println("Pilihan Tidak Valid, Pilih 1 - 2");
            return;
        }
        if (pilihKriteria.equals("1")) {
            if (pilihJenis.equals("1")) {
                listDrum.sort(Comparator.comparing(d -> ((Drum) d).getNamaAlat()));
                listGitar.sort(Comparator.comparing(g -> ((Gitar) g).getNamaAlat()));
            } else {
                listDrum.sort(Comparator.comparing(d -> ((Drum) d).getNamaAlat()).reversed());
                listGitar.sort(Comparator.comparing(g -> ((Gitar) g).getNamaAlat()).reversed());
            }
        } else {
            if (pilihJenis.equals("1")) {
                listDrum.sort(Comparator.comparingDouble(d -> ((Drum) d).getHarga()));
                listGitar.sort(Comparator.comparingDouble(g -> ((Gitar) g).getHarga()));
            } else {
                listDrum.sort(Comparator.comparingDouble(d -> ((Drum) d).getHarga()).reversed());
                listGitar.sort(Comparator.comparingDouble(g -> ((Gitar) g).getHarga()).reversed());
            }
        }
        tampilkanSemuaAlat(true);
    }

    public void exportData() throws IOException {
        List<Object> listDrum = listAlat.get("Drum");
        List<Object> listGitar = listAlat.get("Gitar");
		Workbook workbook = new XSSFWorkbook();
		CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		CellStyle styleH2 = workbook.createCellStyle();
        styleH2.setAlignment(HorizontalAlignment.CENTER);
        styleH2.setVerticalAlignment(VerticalAlignment.CENTER);
		styleH2.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        styleH2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		CellStyle styleValue = workbook.createCellStyle();
		styleValue.setAlignment(HorizontalAlignment.CENTER);
        styleValue.setVerticalAlignment(VerticalAlignment.CENTER);
		styleValue.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        styleValue.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Sheet sheet1 = workbook.createSheet("Drum");
		String[] header = {"Nama Drum", "Harga", "Bunyi"};
		buatHeader(style, styleH2, sheet1, "Data Drum", header, 2);
		int rowNumb = 2;int cellNumb = 0;
		for (Object obj : listDrum) {
            Drum d = (Drum) obj;
			String[] dataDrum = {d.getNamaAlat(), Double.toString(d.getHarga()), d.getBunyi()};
			buatValue(sheet1, styleValue, rowNumb, cellNumb, dataDrum);
			rowNumb++;cellNumb = 0;
		}
		Sheet sheet2 = workbook.createSheet("Gitar");
		String[] header2 = {"Nama Gitar", "Harga", "Bunyi"};
		buatHeader(style, styleH2, sheet2, "Data Gitar", header2, 2);
		rowNumb = 2;cellNumb = 0;
		for (Object obj : listGitar) {
            Gitar g = (Gitar) obj;
			String[] dataGitar = {g.getNamaAlat(), Double.toString(g.getHarga()), g.getBunyi()};
			buatValue(sheet2, styleValue, rowNumb, cellNumb, dataGitar);
			rowNumb++;cellNumb = 0;
		}
		FileOutputStream fileOut = new FileOutputStream(new File("Data_Manajemen_Alat_Musik.xlsx"));
        workbook.write(fileOut);

        fileOut.close();
        workbook.close();
		System.err.println("Berhasil Di Export");
		System.out.println("===========================");
	}

    public void buatHeader(CellStyle style, CellStyle styleH2, Sheet sheet, String data, String[] header, int panjang) {
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(data);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, panjang));
		cell.setCellStyle(style);

		Row rowHead = sheet.createRow(1);
		int cellNumb = 0;
		for (String h : header) {
			Cell cellHead = rowHead.createCell(cellNumb);
			cellHead.setCellValue(h);
			sheet.autoSizeColumn(cellNumb);
			cellHead.setCellStyle(styleH2);
			cellNumb++;
		}
	}

	public void buatValue(Sheet sheet, CellStyle style, int rowNumb, int cellNumb, String[] data) {
		Row row = sheet.createRow(rowNumb);
		for (String d : data) {
			Cell cell = row.createCell(cellNumb);
			cell.setCellValue(d);;
			sheet.autoSizeColumn(cellNumb);
			cell.setCellStyle(style);
			cellNumb++;
		}
	}

    public void importData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ketentuan Import Data:");
        System.out.println("1. File Harus Berformat xlsx");
        System.out.println("2. File Harus Memiliki 2 Sheet: Drum dan Gitar");
        System.out.println("3. Sheet 'Drum' Harus Memiliki Kolom Header: Nama Drum, Harga, Bunyi");
        System.out.println("4. Sheet 'Gitar' Harus Memiliki Kolom Header: Nama Gitar, Harga, Bunyi");
        System.out.println("5. Nama File Tidak Boleh Ada Spasi, Pakai Underscore _ Sebagai Pengganti Spasi");
        System.out.println("6. Gunakan Double Backslash \\ Untuk Path File");
        System.out.println("7. Value Wajib Pada Baris Ke 3, Seperti Pada Template Yang Sudah Disediakan");
        String path;FileInputStream fileIn;Workbook workbook;
        try {
            System.out.print("Masukkan Path File Berformat xlsx: ");
            path = scanner.next();
            scanner.nextLine();
            fileIn = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Sheet sheet1 = workbook.getSheet("Drum");
        Sheet sheet2 = workbook.getSheet("Gitar");

        for (Row row : sheet1) {
            if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                continue;
            }
            String nama;
            Double harga;
            String bunyi;
            try {
                nama = row.getCell(0).getStringCellValue();
                harga = Double.parseDouble(row.getCell(1).getStringCellValue());
                bunyi = row.getCell(2).getStringCellValue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            if (checkAlat(nama, "Drum") == false) {
                listAlat.get("Drum").add(new Drum(idCounter, nama, harga, "Drum", bunyi));
                idCounter++;
            }
        }
        
        for (Row row : sheet2) {
            if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                continue;
            }
            String nama;
            Double harga;
            String bunyi;
            try {
                nama = row.getCell(0).getStringCellValue();
                harga = Double.parseDouble(row.getCell(1).getStringCellValue());
                bunyi = row.getCell(2).getStringCellValue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            if (checkAlat(nama, "Gitar") == false) {
                listAlat.get("Gitar").add(new Gitar(idCounter, nama, harga, "Gitar", bunyi));
                idCounter++;
            }
        }
        
        fileIn.close();
        workbook.close();
        System.err.println("Berhasil Di Import");
    }

    public void nyalakanAlatMusik() {
	if (listAlat.get("Drum").isEmpty() && listAlat.get("Gitar").isEmpty()) {
            System.out.println("Tidak Ada Alat Musik Yang Tersedia Untuk Di Urutkan");
            return;
        }
        tampilkanSemuaAlat(false);
        int id_alat = inputInteger("Pilih Alat Musik Berdasarkan ID: ");
        Optional<Object> obj = itemMusik(id_alat);
        if (obj.isEmpty()) {
            System.out.println("Alat Musik Tidak Ditemukan");
            return;
        }
        Object alat = obj.get();
        if (alat instanceof Drum) {
            ((Drum) alat).bunyiMusik();
        } else {
            ((Gitar) alat).bunyiMusik();
        }
    }
    
    private Optional<Object> itemMusik(int id) {
        for (Map.Entry<String, List<Object>> entry : listAlat.entrySet()) {
            for (Object obj : entry.getValue()) {
                if (obj instanceof Drum && ((Drum) obj).getId() == id) {
                    return Optional.of(obj);
                } else if (obj instanceof Gitar && ((Gitar) obj).getId() == id) {
                    return Optional.of(obj);
                }
            }
        }
        return Optional.empty();
    }
    
    private Optional<Object> itemMusik(String nama) {
        for (Map.Entry<String, List<Object>> entry : listAlat.entrySet()) {
            for (Object obj : entry.getValue()) {
                if (obj instanceof Drum && ((Drum) obj).getNamaAlat().equals(nama)) {
                    return Optional.of(obj);
                } else if (obj instanceof Gitar && ((Gitar) obj).getNamaAlat().equals(nama)) {
                    return Optional.of(obj);
                }
            }
        }
        return Optional.empty();
    }
    
    private boolean checkAlat(String nama, String kategori) {
        Optional<Object> obj = itemMusik(nama);
        if (obj.isEmpty()) {
            if ((kategori.equals("Drum") == false) && (kategori.equals("Gitar") == false)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    
    private boolean checkAlat(String nama) {
        Optional<Object> obj = itemMusik(nama);
        if (obj.isEmpty()) {
            return false;
        } else {
            if (namaAlatSebelumEdit.equals(nama)) {
                return false;
            } else {
                return true;
            }
        }
    }
    
    private int inputInteger(String placeholder) {
        Scanner scanner = new Scanner(System.in);
        int angka;
        while (true) {
            try {
                System.out.print(placeholder);
                String inputAngka = scanner.next();
                scanner.nextLine();
                angka = Integer.parseInt(inputAngka);
                break;
            } catch (Exception e) {
                System.out.println("Mohon Masukkan Angka Yang Valid");
            }
        }
        return angka;
    }
    
    private Object[] isiDataAlat(boolean isEdit) {
        Scanner scanner = new Scanner(System.in);
        String nama_alat;Double harga;String kategori = null;String bunyi = null;boolean cekAlat;
        while (true) {
            while (true) {
                try {
                    System.out.print("Nama Alat: ");
                    nama_alat = scanner.next();
                    scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    System.out.print("Harga: ");
                    String hargaInput = scanner.next();
                    scanner.nextLine();
                    harga = Double.parseDouble(hargaInput);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (isEdit == false) {
                while (true) {
                    try {
                        System.out.print("Kategori: ");
                        kategori = scanner.next();
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.print("Bunyi Alat: ");
                        bunyi = scanner.next();
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                cekAlat = checkAlat(nama_alat, kategori);
            } else {
                cekAlat = checkAlat(nama_alat);
            }
            if (cekAlat == false) {
                if (isEdit == false) {
                    return new Object[]{nama_alat, harga, kategori, bunyi};
                } else {
                    return new Object[]{nama_alat, harga};
                }
            }
            else {
                if (isEdit == false) {
                    System.out.println("Nama Alat Harus Berbeda Dengan Yang Sudah Ada Dan Kategori Harus Input Drum Atau Gitar");
                } else {
                    System.out.println("Nama Alat Harus Berbeda Dengan Yang Sudah Ada");
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
         AlatMusikManajer manajemenAlatMusik = new AlatMusikManajer();
         Scanner scanner = new Scanner(System.in);
         while (true) {
             int menu;
             System.out.println("Manajemen Toko Alat Musik");
             System.out.println("1. Tambah Alat Musik");
             System.out.println("2. Edit Alat Musik");
             System.out.println("3. Hapus Alat Musik");
             System.out.println("4. Tampilkan Salah Satu Alat Musik");
             System.out.println("5. Tampilkan Semua Alat Musik");
             System.out.println("6. Cari Alat Musik");
             System.out.println("7. Urutkan Alat Musik");
             System.out.println("8. Export Data Alat Musik");
             System.out.println("9. Import Data Alat Musik");
             System.out.println("10. Nyalakan Bunyi Alat Musik");
             System.out.println("0. Keluar");
             try {
                 System.out.print("Pilih Menu: ");
                 menu = scanner.nextInt();
                 if (menu < 0 || menu > 10) {
                     throw new Exception();
                 }
             } catch (Exception e) {
                 System.out.println("Input Tidak Valid, Pilih 0 - 9");
                 continue;
             }
             switch (menu) {
                 case 1:
                     manajemenAlatMusik.tambahAlat();
                     break;
                 case 2:
                     manajemenAlatMusik.editAlat();
                     break;
                 case 3:
                     manajemenAlatMusik.hapusAlat();
                     break;
                 case 4:
                     manajemenAlatMusik.tampilkanSalahSatuAlat();
                     break;
                 case 5:
                     manajemenAlatMusik.tampilkanSemuaAlat(true);
                     break;
                 case 6:
                     manajemenAlatMusik.cariAlat();
                     break;
                 case 7:
                     manajemenAlatMusik.urutkanAlat();
                     break;
                 case 8:
                     try {
                        manajemenAlatMusik.exportData();
                     } catch (IOException e) {
                        System.out.println("Gagal Mengekspor Data: " + e.getMessage());
                     }
                     break;
                 case 9:
                     try {
                        manajemenAlatMusik.importData();
                     } catch (IOException e) {
                        System.out.println("Gagal Mengimpor Data: " + e.getMessage());
                     }
                     break;
                 case 10:
                     manajemenAlatMusik.nyalakanAlatMusik();
                     break;
                 case 0:
                     System.exit(0);
             }
         }
    }
}
