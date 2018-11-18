package com.couclock.petrate.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couclock.petrate.dto.PetDTO;
import com.couclock.petrate.entity.Pet;
import com.couclock.petrate.respository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetRepository petRepository;

	@GetMapping("/{petId}/image")
	public ResponseEntity<Resource> getImage(@PathVariable(value = "petId") long petId) {

		Optional<Pet> result = petRepository.findById(petId);
		if (!result.isPresent()) {
			return null;
		}

		ByteArrayResource resource = new ByteArrayResource(result.get().image);

		return ResponseEntity.ok().contentLength(result.get().image.length)
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}

	@GetMapping("/rnd2")
	public List<PetDTO> getRandom2() {

		int maxIdx = petRepository.findMaxIdx();

		// Nasty bug to comment
		// maxIdx++;

		int randomNum1 = ThreadLocalRandom.current().nextInt(0, maxIdx + 1);
		int randomNum2 = ThreadLocalRandom.current().nextInt(0, maxIdx + 1);
		while (randomNum1 == randomNum2) {
			randomNum2 = ThreadLocalRandom.current().nextInt(0, maxIdx + 1);
		}

		Pet pet1 = petRepository.findByIdx(randomNum1);
		Pet pet2 = petRepository.findByIdx(randomNum2);

		List<PetDTO> pets = Arrays.asList( //
				new PetDTO(pet1.id, pet1.idx, pet1.name, pet1.description), //
				new PetDTO(pet2.id, pet2.idx, pet2.name, pet2.description));

		return pets;

	}

}
