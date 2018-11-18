package com.couclock.petrate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	@ManyToOne
	public Pet firstPet;

	@ManyToOne
	public Pet secondPet;

	public int rateOne;
	public int rateTwo;

}
