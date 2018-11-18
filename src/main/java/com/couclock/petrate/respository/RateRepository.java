package com.couclock.petrate.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.couclock.petrate.entity.Pet;

public interface RateRepository extends JpaRepository<Pet, Long> {

}
