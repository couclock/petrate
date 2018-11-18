package com.couclock.petrate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.couclock.petrate.entity.Pet;
import com.couclock.petrate.respository.PetRepository;

@SpringBootApplication
public class PetrateApplication {

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
			Pet myPet = new Pet(petIdx, "Noisette", "Jeune chatte isabelle", getImage("./static/zoa.jpg"));
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Potty")) {
			Pet myPet = new Pet(petIdx, "Potty", "Previously \"Microlax\"", getImage("./static/poisson_rouge.jpg"));
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Coquillette")) {
			Pet myPet = new Pet(petIdx, "Coquillette", "Tortue Hermann Corse", getImage("./static/tortue.jpg"));
			petRepository.save(myPet);
		}
		petIdx++;
		if (!allPets.contains("Grisette")) {
			Pet myPet = new Pet(petIdx, "Grisette", "Gray scared hen", getImage("./static/poule-grise.jpg"));
			petRepository.save(myPet);
		}
		petIdx++;

	}

	private byte[] getImage(String path) throws IOException {
		InputStream is = ClassLoader.getSystemResourceAsStream(path);

		byte[] image = new byte[is.available()];
		is.read(image);

		return image;
	}
}
