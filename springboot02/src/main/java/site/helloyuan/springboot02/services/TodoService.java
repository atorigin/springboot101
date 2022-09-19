package site.helloyuan.springboot02.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import site.helloyuan.springboot02.daos.TodoDao;
import site.helloyuan.springboot02.models.Todo;

@Service
public class TodoService {
    @Autowired
    TodoDao todoRepository;

    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<Todo>();
        todoRepository.findAll().forEach(todo -> todos.add(todo));
        return todos;
    }

    // Limit 查詢，這個應該比較常用，一般不會撈整張表
    public List<Long> getTodosId() {
        List<Long> ids = new ArrayList<Long>();
        todoRepository.findAll(PageRequest.of(0, 20)).forEach(todo -> ids.add(todo.getId()));
        // return ids;
        return todoRepository.findMyAllTodoIds();
    }

    // 原生 SQL 查詢，看起來可以用 Query Annotations 帶 nativeQuery = true 參數做到，但不知道複雜查詢，如多表能否做到，不帶 nativeQuery 的話要用 JPQL 語法
    public List<Todo> test() {
        return todoRepository.findMyAllTodos();
    }
    
}
