// Darren Evan Nathanael (825240062)
package com.example.demospringboot.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Kilat") 
public class KirimanKilat extends Kiriman {
    
    private double biayaPerKg;
    private double biayaDasarKilat;

    // No-Arg Constructor
    public KirimanKilat() {
        super();
    }

    // Constructor Lengkap
    public KirimanKilat(String nomorResi, String alamatPengirim, String alamatTujuan, double beratBarang, double biayaPerKg,
            double biayaDasarKilat) {
        super(nomorResi, alamatPengirim, alamatTujuan, beratBarang);
        this.biayaPerKg = biayaPerKg;
        this.biayaDasarKilat = biayaDasarKilat;
    }

    @Override
    public double hitungBiaya() {
        // Logika Hitung Biaya
        return (beratBarang * biayaPerKg) + biayaDasarKilat;
    }

    // Getters and Setters
    
    public double getBiayaPerKg() {
        return biayaPerKg;
    }

    public void setBiayaPerKg(double biayaPerKg) {
        this.biayaPerKg = biayaPerKg;
    }

    public double getBiayaDasarKilat() {
        return biayaDasarKilat;
    }

    public void setBiayaDasarKilat(double biayaDasarKilat) {
        this.biayaDasarKilat = biayaDasarKilat;
    }
}