package com.couclock.petrate.respository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.couclock.petrate.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	@Transactional
	public Pet findByIdx(int idx);

	@Query("SELECT coalesce(max(p.idx), 0) FROM Pet p")
	public int findMaxIdx();

}
