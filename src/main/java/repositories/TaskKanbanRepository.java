package repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edokanban.entities.TaskKanban;

@Repository
public interface TaskKanbanRepository 
				extends JpaRepository<TaskKanban, UUID> {
}

