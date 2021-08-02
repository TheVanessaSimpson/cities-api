package com.vanessa.citiesapi.countries.repositories;

import com.vanessa.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Long> {
}

