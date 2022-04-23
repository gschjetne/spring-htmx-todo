package se.schjetne.springhtmxtodo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}
