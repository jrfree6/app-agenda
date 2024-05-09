package br.com.agendaaulaapp;

import androidx.annotation.NonNull;

public class ContactEntity {

	private Long id;
	private String name;
	private String fone;
	private String description;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString(){
		return "Nome:"+ this.name + " - Fone:"+this.fone;
	}
	

}