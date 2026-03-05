package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String list(Model model) {
        List<TodoItemView> todos = List.of(
                new TodoItemView(1L, "Spring Bootを学習する", "未着手"),
                new TodoItemView(2L, "ToDo一覧画面を作成する", "進行中"),
                new TodoItemView(3L, "Controllerを実装する", "完了")
        );
        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @GetMapping("/new")
    public String newTodo() {
        return "todo/new";
    }

    @GetMapping("/confirm")
    public String confirm() {
        return "todo/confirm";
    }

    public record TodoItemView(Long id, String title, String status) {
    }
}
