package com.couclock.petrate.dto;

public class PetDTO {

	public long id;

	public int idx;

	public String name;
	public String description;

	public PetDTO(long id, int idx, String name, String description) {
		super();
		this.id = id;
		this.idx = idx;
		this.name = name;
		this.description = description;
	}

}
