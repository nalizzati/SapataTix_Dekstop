package model;

import java.time.LocalDate;

public abstract class Event {
    protected int idEvent;
    protected String namaEvent;
    protected LocalDate tanggal;
    protected String lokasi;
    protected String deskripsi;
    protected double hargaDasar;
    protected String kategori;

    public Event(int idEvent, String namaEvent, LocalDate tanggal, String lokasi, String deskripsi, double hargaDasar, String kategori) {
        this.idEvent = idEvent;
        this.namaEvent = namaEvent;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.hargaDasar = hargaDasar;
        this.kategori = kategori;
    }

    // Getter dan Setter (Enkapsulasi)
    public int getIdEvent() { return idEvent; }
    public String getNamaEvent() { return namaEvent; }
    public LocalDate getTanggal() { return tanggal; }
    public String getLokasi() { return lokasi; }
    public String getDeskripsi() { return deskripsi; }
    public double getHargaDasar() { return hargaDasar; }
    public String getKategori() { return kategori; }

    public void setIdEvent(int idEvent) { this.idEvent = idEvent; }
    public void setNamaEvent(String namaEvent) { this.namaEvent = namaEvent; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public void setHargaDasar(double hargaDasar) { this.hargaDasar = hargaDasar; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    // Polimorfisme
    public abstract void displayDetails();
}