package com.example.demo.service.impl;

import com.example.demo.dto.KtpDto;
import com.example.demo.mapper.KtpMapper;
import com.example.demo.model.Ktp;
import com.example.demo.repository.KtpRepository;
import com.example.demo.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository repository;

    @Autowired
    private KtpMapper mapper;

    @Override
    public List<KtpDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getById(Integer id) {
        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        return mapper.toDto(ktp);
    }

    @Override
    public KtpDto create(KtpDto ktpDto) {
        if(repository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        Ktp ktp = mapper.toEntity(ktpDto);
        return mapper.toDto(repository.save(ktp));
    }

    @Override
    public KtpDto update(Integer id, KtpDto ktpDto) {
        Ktp existingKtp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        existingKtp.setNamaLengkap(ktpDto.getNamaLengkap());
        existingKtp.setAlamat(ktpDto.getAlamat());
        existingKtp.setTanggalLahir(ktpDto.getTanggalLahir());
        existingKtp.setJenisKelamin(ktpDto.getJenisKelamin());

        return mapper.toDto(repository.save(existingKtp));
    }

    @Override
    public void delete(Integer id) {
        if(!repository.existsById(id)) throw new RuntimeException("Data tidak ditemukan");
        repository.deleteById(id);
    }
}