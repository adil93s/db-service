package com.example.dbservice.service.impl;

import com.example.dbservice.model.Annonce;
import com.example.dbservice.repository.AnnonceRepository;
import com.example.dbservice.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public List<Annonce> findAll() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce findById(Long id) {
        Optional<Annonce> result = annonceRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Annonce save(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public void deleteById(Long id) {
        annonceRepository.deleteById(id);
    }
}
