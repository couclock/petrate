package com.couclock.petrate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	public int idx;

	public String name;
	public String description;

	@Lob
	public byte[] image;

	public Pet() {
	}

	public Pet(int idx, String name, String description, byte[] image) {
		super();
		this.idx = idx;
		this.name = name;
		this.description = description;
		this.image = image;
	}

}
