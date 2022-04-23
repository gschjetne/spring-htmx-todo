package se.schjetne.springhtmxtodo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/todos/{todoId}")
    public String editTodo(Model model, @PathVariable Long todoId) {
        final var todo = todoRepository.findById(todoId);
        if (todo.isEmpty()) return "empty";

        model.addAttribute("todo", todo.get());
        return "editTodo";
    }

    @PutMapping("/todos/{todoId}")
    public String saveTodo(@ModelAttribute Todo todo, Model model, @PathVariable Long todoId) {
        final var old = todoRepository.findById(todoId);
        if (old.isEmpty()) return "empty";

        old.ifPresent(it -> {
            it.setDone(todo.getDone());
            it.setTask(todo.getTask());
            todoRepository.save(it);
            model.addAttribute("todo", it);
        });

        return "todo";
    }

    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@PathVariable Long todoId) {
        todoRepository.findById(todoId).ifPresent(todoRepository::delete);
        return "empty";
    }
}
