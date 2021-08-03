package com.vanessa.citiesapi.states.resource;


import com.vanessa.citiesapi.cities.eneties.City;
import com.vanessa.citiesapi.states.eneties.State;
import com.vanessa.citiesapi.states.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }

    @PostMapping()
    public State postOne(@RequestBody State state){
        return repository.save(state);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id) {
        Optional<State> delete = repository.findById(id);
        if (delete.isPresent()) {
            repository.delete(delete.get());
        } else {
            ResponseEntity.notFound().build();
        }
    }
}
