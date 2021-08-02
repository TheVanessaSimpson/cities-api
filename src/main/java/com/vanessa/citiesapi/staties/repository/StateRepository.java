package com.vanessa.citiesapi.staties.repository;


import com.vanessa.citiesapi.staties.eneties.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
