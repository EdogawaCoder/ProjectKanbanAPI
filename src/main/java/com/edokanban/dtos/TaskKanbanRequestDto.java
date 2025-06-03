package com.edokanban.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskKanbanRequestDto {

	@Size(min = 8, max = 50, message = "Title must be between 8-50 characters | " + "タイトルは5文字以上8-50文字以下で入力してください")
	@NotBlank(message = "Title cannot be blank | タイトルを空白にしないでください")
	private String title;

	@Size(min = 8, max = 150, message = "Description must be up to 8-150 characters | " + "説明は8-150文字以内で入力してください")
	@NotBlank(message = "Description cannot be blank | 説明を空白にしないでください")
	private String description;

	@Size(min = 8, max = 25, message = "In charge must be between 8-25 characters | " + "担当者は8文字以上25文字以下で入力してください")
	private String inCharge;

	@NotNull(message = "Deadline is required | 締め切り日は必須です" + 
	"Deadline must be today or in the future | 締め切りは今日以降の日付にしてください")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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
