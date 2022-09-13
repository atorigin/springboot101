package site.helloyuan.springboot02.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.helloyuan.springboot02.daos.TodoDao;
import site.helloyuan.springboot02.models.Todo;

@Service
public class TodoService {
    @Autowired
    TodoDao todoRepository;

    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todos.add(todo));
        return todos;
    }
}
