package com.vanessa.citiesapi.cities.resource;


import com.vanessa.citiesapi.cities.eneties.City;
import com.vanessa.citiesapi.cities.repository.CityRepository;
import com.vanessa.citiesapi.countries.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    @PostMapping()
    public City postOne(@RequestBody City city){
        return repository.save(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id){
        Optional<City> delete = repository.findById(id);
        if (delete.isPresent()) {
            repository.delete(delete.get());
        }else {
            ResponseEntity.notFound().build();
        }
    }
}
