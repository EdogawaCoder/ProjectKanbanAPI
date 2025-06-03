package com.edokanban.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.edokanban.dtos.TaskKanbanRequestDto;
import com.edokanban.dtos.TaskKanbanResponseDto;
import com.edokanban.entities.TaskKanban;
import com.edokanban.repositories.TaskKanbanRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/kanban/tasks")
@Tag(name = "Kanban Controller", description = "Kanban tasks management API")
public class TasksKanbanController {

	@Autowired
	TaskKanbanRepository taskKanbanRepository;
	@Autowired
	ModelMapper modelMapper;

	@PostMapping
	@Operation(summary = "Create a new Kanban task | 新しいカンバンタスクを作成します", description = "Create a new task in the Kanban board | カンバンボードに新しいタスクを作成します")
	public ResponseEntity<?> post(@RequestBody @Valid TaskKanbanRequestDto request) {

		TaskKanban task = modelMapper.map(request, TaskKanban.class);

		UUID generatedId = UUID.randomUUID();

		if (taskKanbanRepository.existsById(generatedId)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma tarefa com esse ID.");
		}

		task.setId(generatedId);
		taskKanbanRepository.save(task);

		TaskKanbanResponseDto response = modelMapper.map(task, TaskKanbanResponseDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@PutMapping("{id}")
	@Operation(summary = "Update an existing Kanban task | 既存のカンバンタスクを更新します")
	public ResponseEntity<TaskKanbanResponseDto> put(@PathVariable UUID id,
			@RequestBody @Valid TaskKanbanRequestDto request) {

		TaskKanban task = modelMapper.map(request, TaskKanban.class);
		task.setId(id);

		if (!taskKanbanRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada com o ID: " + id);
		}

		taskKanbanRepository.save(task);

		TaskKanbanResponseDto response = modelMapper.map(task, TaskKanbanResponseDto.class);
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("{id}")
	@Operation(summary = "Delete a Kanban task | カンバンタスクを削除します")
	public TaskKanbanResponseDto delete(@PathVariable UUID id) {

		if (!taskKanbanRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada com o ID: " + id);
		}

		taskKanbanRepository.deleteById(id);

		// No content response
		return modelMapper.map(id, TaskKanbanResponseDto.class);

	}

	@GetMapping
	@Operation(summary = "Get all Kanban tasks | すべてのカンバンタスクを取得します")
	public List<TaskKanbanResponseDto> get() {

		var tasks = taskKanbanRepository.findAll();

		return tasks.stream().map(task -> modelMapper.map(task, TaskKanbanResponseDto.class))
				.collect(Collectors.toList());

	}

}
