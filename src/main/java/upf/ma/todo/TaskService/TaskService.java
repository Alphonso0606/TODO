package upf.ma.todo.TaskService;

import org.springframework.stereotype.Service;
import upf.ma.todo.model.Task;
import upf.ma.todo.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService ( TaskRepository taskRepository) {
        this.taskRepository = new TaskRepository();
    }

    public Task create( String title, String description) {
        Task task = taskRepository.save( new Task(title, description));

        return task;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    public Task complete(Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"+id));

        task.setDone(true);

        return task;
    }

    public void delete(Long id){
        taskRepository.delete(id);
    }

}
