// Darren Evan Nathanael (825240062)
package com.example.demospringboot.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Reguler") 
public class KirimanReguler extends Kiriman {
    
    private double biayaPerKg;

    // No-Arg Constructor
    public KirimanReguler() {
        super();
    }
    
    // Constructor Lengkap
    public KirimanReguler(String nomorResi, String alamatPengirim, String alamatTujuan, double beratBarang, double biayaPerKg) {
        super(nomorResi, alamatPengirim, alamatTujuan, beratBarang); 
        this.biayaPerKg = biayaPerKg;
    }

    @Override
    public double hitungBiaya() {
        return beratBarang * biayaPerKg;
    }

    // Getters and Setters
    public double getBiayaPerKg() {
        return biayaPerKg;
    }

    public void setBiayaPerKg(double biayaPerKg) {
        this.biayaPerKg = biayaPerKg;
    }
}