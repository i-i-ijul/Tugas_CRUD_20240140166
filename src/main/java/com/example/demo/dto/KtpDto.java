package com.example.demo.dto;

import lombok.Data;

@Data
public class KtpDto {
    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;
}