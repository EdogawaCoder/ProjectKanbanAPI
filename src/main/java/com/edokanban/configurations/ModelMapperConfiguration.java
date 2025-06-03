package com.edokanban.configurations;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edokanban.dtos.TaskKanbanRequestDto;
import com.edokanban.dtos.TaskKanbanResponseDto;
import com.edokanban.entities.TaskKanban;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapping from TaskKanbanRequestDto to TaskKanban entity
        modelMapper.typeMap(TaskKanbanRequestDto.class, TaskKanban.class).addMappings(mapper -> {
            mapper.map(src -> UUID.randomUUID(), TaskKanban::setId); // Generate ID if needed
            mapper.map(src -> new Date(), TaskKanban::setDateCreated); // Automatically set the creation date
        });

        // Mapping from TaskKanban entity to TaskKanbanResponseDto
        modelMapper.typeMap(TaskKanban.class, TaskKanbanResponseDto.class).addMappings(mapper -> {

        });

        return modelMapper;
    }
}
