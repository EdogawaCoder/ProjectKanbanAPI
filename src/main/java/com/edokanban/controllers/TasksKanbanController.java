package com.edokanban.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name="Kanban Controller", description="Kanban tasks management API")
public class TasksKanbanController {

	@PostMapping
	@Operation(summary = "Create a new Kanban task | 新しいカンバンタスクを作成します", 
	description = "Create a new task in the Kanban board | カンバンボードに新しいタスクを作成します")
	public void post() {

	}

	@PutMapping
	@Operation(summary = "Update an existing Kanban task | 既存のカンバンタスクを更新します")
	public void put() {

	}

	@DeleteMapping
	@Operation(summary = "Delete a Kanban task | カンバンタスクを削除します")
	public void delete() {

	}

	@GetMapping
	@Operation(summary = "Get all Kanban tasks | すべてのカンバンタスクを取得します")
	public void get() {

	}

}
