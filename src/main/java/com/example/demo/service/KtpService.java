package com.example.demo.service;

import com.example.demo.dto.KtpDto;
import java.util.List;

public interface KtpService {
    List<KtpDto> getAll();
    KtpDto getById(Integer id);
    KtpDto create(KtpDto ktpDto);
    KtpDto update(Integer id, KtpDto ktpDto);
    void delete(Integer id);
}