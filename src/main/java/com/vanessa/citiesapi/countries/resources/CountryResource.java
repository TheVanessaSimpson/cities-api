package com.vanessa.citiesapi.countries.resources;


import java.util.List;
import java.util.Optional;

import com.vanessa.citiesapi.countries.entities.Country;
import com.vanessa.citiesapi.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/countries")
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable long id) {
        Optional<Country> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public Country postOne( @RequestBody Country country){
        return repository.save(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable long id){
        Optional<Country> delete = repository.findById(id);
        if (delete.isPresent()) {
            repository.delete(delete.get());
        }else {
            ResponseEntity.notFound().build();
        }
    }
}
