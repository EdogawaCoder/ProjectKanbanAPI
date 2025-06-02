package com.edokanban.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edokanban.dtos.TaskKanbanRequestDto;
import com.edokanban.entities.TaskKanban;
import com.edokanban.repositories.TaskKanbanRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name="Kanban Controller", description="Kanban tasks management API")
public class TasksKanbanController {
	
	@Autowired TaskKanbanRepository taskKanbanRepository;
	
	@PostMapping
	@Operation(summary = "Create a new Kanban task | 新しいカンバンタスクを作成します", 
	description = "Create a new task in the Kanban board | カンバンボードに新しいタスクを作成します")
	public ResponseEntity<?> post(@RequestBody @Valid TaskKanbanRequestDto request) {
	    return ResponseEntity.ok("Requisição recebida!");
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
	public List<TaskKanban> get() {
		
		return taskKanbanRepository.findAll();
				
		

	}

}
