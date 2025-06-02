package com.edokanban.entities;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_tasks_kanban")

public class TaskKanban {

	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	@Column(name = "description", length = 500)
	private String description;
	@Column(name = "in_charge", length = 50, nullable = false)
	private String inCharge;
	@Temporal(TemporalType.TIMESTAMP)
	//// Date 型で日付と時刻を保存・表示します（ISO形式のフォーマットを使用）
	// Save and display date and time using Date type (in ISO format)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "America/Sao_Paulo")
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "America/Sao_Paulo")
	@Column(name = "date_limit", nullable = false)
	private Date dateLimit;
	@Column(name = "started", nullable = false)
	private Boolean started;
	@Column(name = "finished", nullable = false)
	private Boolean finished;
	

	public TaskKanban() {
	}


	public TaskKanban(UUID id, String title, String description, String inCharge, Date dateCreated, Date dateLimit,
			Boolean started, Boolean finished) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.inCharge = inCharge;
		this.dateCreated = dateCreated;
		this.dateLimit = dateLimit;
		this.started = started;
		this.finished = finished;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
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


	@Override
	public String toString() {
		return "TaskKanban [id=" + id + ", title=" + title + ", description=" + description + ", inCharge=" + inCharge
				+ ", dateCreated=" + dateCreated + ", dateLimit=" + dateLimit + ", started=" + started + ", finished="
				+ finished + "]";
	}
	
	
	
	
	
}