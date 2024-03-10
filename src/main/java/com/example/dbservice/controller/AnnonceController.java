package com.example.dbservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dbservice.model.Annonce;
import com.example.dbservice.service.AnnonceService;

import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping
    public List<Annonce> getAllAnnonces() {
        return annonceService.findAll();
    }

    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable Long id) {
        return annonceService.findById(id);
    }

    @PostMapping
    public Annonce createAnnonce(@RequestBody Annonce annonce) {
        return annonceService.save(annonce);
    }

    @PutMapping("/{id}")
    public Annonce updateAnnonce(@PathVariable Long id, @RequestBody Annonce annonceDetails) {
        Annonce annonce = annonceService.findById(id);
        annonce.setTitle(annonceDetails.getTitle());
        annonce.setDescription(annonceDetails.getDescription());
        return annonceService.save(annonce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
