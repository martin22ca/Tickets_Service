package ar.edu.arqSoft.ticketService.baseService.dto;


import ar.edu.arqSoft.ticketService.common.dto.*;
public class StateRequestDto implements DtoEntity{

	private String name;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}