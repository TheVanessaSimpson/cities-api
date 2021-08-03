package com.vanessa.citiesapi.states.repository;


import com.vanessa.citiesapi.states.eneties.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
