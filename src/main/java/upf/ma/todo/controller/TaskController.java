package upf.ma.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upf.ma.todo.TaskService.TaskService;
import upf.ma.todo.model.Task;

//@RestController
//@RequestMapping("api/tasks")
@Controller
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    @GetMapping
//    public List<Task> getAllTask(){
//        return taskService.findAll();
//    }
//
//    @PostMapping
//    public ResponseEntity<Task> createTask(@RequestBody Task task){
//        Task created = taskService.create(task.getTitle(), task.getDescription());
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(created);
//    }
//
//    @PutMapping("/{id}/complete")
//    public Task completetask(@PathVariable Long id){
//        return taskService.complete(id);
//    }
//    @DeleteMapping("/{id]")
//    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
//        taskService.delete(id);
//
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping
    public String home(Model model){

        model.addAttribute("tasks", taskService.findAll());

        model.addAttribute("newTask", new Task());

        return "index";
    }

    @PostMapping("/add")
    public String addtask(@ModelAttribute Task task){
        taskService.create(task.getTitle(), task.getDescription());

        return "redirect:/";

    }

    @GetMapping("complete/{id}")
    public String completetask(@PathVariable Long id){
        taskService.complete(id);

        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deletetask(@PathVariable Long id){
        taskService.delete(id);

        return "redirect:/";
    }


}
