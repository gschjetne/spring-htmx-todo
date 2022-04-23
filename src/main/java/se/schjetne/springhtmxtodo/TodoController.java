package se.schjetne.springhtmxtodo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo, Model model) {
        todoRepository.save(todo);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PutMapping("/todos/{todoId}/done")
    public String setDone(@PathVariable Long todoId, @RequestParam Optional<String> done, Model model) {
        return todoRepository.findById(todoId).map(it -> {
            it.setDone(done.isPresent());
            todoRepository.save(it);
            model.addAttribute("todo", it);
            return "todo";
        }).orElse("empty");
    }
}
