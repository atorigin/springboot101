package site.helloyuan.springboot02.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.helloyuan.springboot02.daos.TodoDao;
import site.helloyuan.springboot02.models.Todo;
import site.helloyuan.springboot02.services.TodoService;

@RestController
public class TodoController {
    
    // @Autowired
    // TodoDao todoRepository;

    @Autowired
    TodoService todoService;
    
    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }
    
    @Bean
    public CommandLineRunner preSetup(TodoDao repository){
        return (args) -> {

            List<String> defaultItems = new ArrayList<String>() {
                {
                    add("Spring");
                    add("Java");
                    add("ORM");
                }
            };
            List<String> secondItems = new ArrayList<String>() {
                {
                    add("第一項");
                    add("第二項");
                    add("第三項");
                }
            };

            long t = System.currentTimeMillis();
            Timestamp ct = new Timestamp(t);
            
            repository.save(new Todo("Todo01","First Demo Todo list",defaultItems,"Demo",ct,ct));
            repository.save(new Todo("Todo02","Second Demo Todo list",secondItems,"Demo",ct,ct));

            
        };
    }
}
