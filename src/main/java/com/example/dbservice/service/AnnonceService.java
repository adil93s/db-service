package com.example.dbservice.service;
import com.example.dbservice.model.Annonce;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AnnonceService {
    List<Annonce> findAll();
    Annonce findById(Long id);
    Annonce save(Annonce annonce);
    void deleteById(Long id);
}
