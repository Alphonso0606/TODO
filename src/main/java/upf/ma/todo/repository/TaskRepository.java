package upf.ma.todo.repository;

import org.springframework.stereotype.Repository;
import upf.ma.todo.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task save(Task task){
        task.setId(nextId++);
        tasks.add(task);

        return task;
    }

    public List<Task> findAll(){
        return tasks;
    }

    public Optional<Task> findById(Long id){
        return tasks.stream()
                .filter(t->t.getId().equals(id))
                .findFirst();
    }

    public void delete(Long id){
        tasks.removeIf(t->t.getId().equals(id));
    }
}
