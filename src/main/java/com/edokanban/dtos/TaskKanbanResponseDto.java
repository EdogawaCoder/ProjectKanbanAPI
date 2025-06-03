package com.edokanban.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskKanbanResponseDto {

	private String id;
	private String title;
	private String description;
	private String inCharge;
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
	private Date dateCreated;
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
	private Date dateLimit;
	private Boolean started;
	private Boolean finished;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInCharge() {
		return inCharge;
	}

	public void setInCharge(String inCharge) {
		this.inCharge = inCharge;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

}
