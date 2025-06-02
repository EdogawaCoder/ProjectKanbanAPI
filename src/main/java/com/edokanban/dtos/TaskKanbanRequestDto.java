package com.edokanban.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class TaskKanbanRequestDto {
	@Size(min = 5, max = 80, message = "Title must be between 5 and 80 characters | " + "タイトルは5文字以上80文字以下で入力してください")
	@NotBlank(message = "Title cannot be blank | タイトルを空白にしないでください")
	private String title;
	
	@Size(max = 500, message = "Description must be up to 500 characters | " + "説明は500文字以内で入力してください")
	@NotBlank(message = "Description cannot be blank | 説明を空白にしないでください")
	private String description;
	
	@Size(min = 3, max = 50, message = "In charge must be between 3 and 50 characters | " + "担当者は3文字以上50文字以下で入力してください")
	private String inCharge;
	
	@NotNull(message = "Creation date is required | 作成日は必須です")
	@PastOrPresent(message = "Creation date must be today or in the future | 作成日は今日以降の日付にしてください")
	private Date dateCreated;

	@NotNull(message = "Deadline is required | 締め切り日は必須です")
	@PastOrPresent(message = "Deadline must be today or in the future | 締め切りは今日以降の日付にしてください")
	private Date dateLimit;

	@NotNull(message = "Started field is required | 開始の有無を指定してください")
	private Boolean started;

	@NotNull(message = "Finished field is required | 完了の有無を指定してください")
	private Boolean finished;

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
