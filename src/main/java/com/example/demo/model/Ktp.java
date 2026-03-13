package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ktp")
@Data // Menggunakan Lombok untuk Getter/Setter, jika tidak ada silakan buat manual
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nomor_ktp", unique = true, nullable = false)
    private String nomorKtp;

    private String namaLengkap;
    private String alamat;
    private String tanggalLahir; // Bisa diganti LocalDate jika ingin lebih presisi
    private String jenisKelamin;
}