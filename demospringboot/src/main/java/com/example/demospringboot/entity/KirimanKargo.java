// Darren Evan Nathanael (825240062)
package com.example.demospringboot.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Kargo") 
public class KirimanKargo extends Kiriman {
    
    private double biayaPerKg;
    private double volumeBarang; 

    // No-Arg Constructor
    public KirimanKargo() {
        super();
    }
    
    // Constructor Lengkap
    public KirimanKargo(String nomorResi, String alamatPengirim, String alamatTujuan, double beratBarang, double biayaPerKg,
            double volumeBarang) {
        super(nomorResi, alamatPengirim, alamatTujuan, beratBarang);
        this.biayaPerKg = biayaPerKg;
        this.volumeBarang = volumeBarang;
    }

    @Override
    public double hitungBiaya() {
        // Logika Hitung Biaya
        return beratBarang * biayaPerKg;
    }

    // Getters and Setters
    
    public double getBiayaPerKg() {
        return biayaPerKg;
    }

    public void setBiayaPerKg(double biayaPerKg) {
        this.biayaPerKg = biayaPerKg;
    }

    public double getVolumeBarang() {
        return volumeBarang;
    }

    public void setVolumeBarang(double volumeBarang) {
        this.volumeBarang = volumeBarang;
    }
}