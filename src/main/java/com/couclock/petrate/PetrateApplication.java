package com.couclock.petrate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.couclock.petrate.entity.Pet;
import com.couclock.petrate.respository.PetRepository;

@SpringBootApplication
public class PetrateApplication {

	private final static Logger logger = LoggerFactory.getLogger(PetrateApplication.class);

	@Autowired
	private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(PetrateApplication.class, args);
	}

	@Bean
	public void populate() throws IOException {

		List<String> allPets = petRepository.findAll().stream() //
				.map(p -> p.name) //
				.collect(Collectors.toList());

		int petIdx = 0;

		if (!allPets.contains("Noisette")) {
			Pet myPet = new Pet(petIdx, "Noisette", "Young \"isabelle\" cat", "static/zoa.jpg");
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Potty")) {
			Pet myPet = new Pet(petIdx, "Potty", "Goldfish, formerly \"Microlax\"", "static/poisson_rouge.jpg");
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Coquillette")) {
			Pet myPet = new Pet(petIdx, "Coquillette", "Hermann Corsica turtle", "static/tortue.jpg");
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Grisette")) {
			Pet myPet = new Pet(petIdx, "Grisette", "Grey scared hen", "static/poule-grise.jpg");
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Coquine")) {
			Pet myPet = new Pet(petIdx, "Coquine", "Red hen", "static/poule-rousse.jpg");
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Bubulle 1")) {
			Pet myPet = new Pet(petIdx, "Bubulle 1", "First roach", "static/gardon_1.jpg");
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Bubulle 2")) {
			Pet myPet = new Pet(petIdx, "Bubulle 2", "Second roach", "static/gardon_2.jpg");
			petRepository.save(myPet);
		}
		petIdx++;

	}

}
