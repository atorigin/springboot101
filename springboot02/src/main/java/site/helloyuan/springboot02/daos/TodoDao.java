// Spring data jpa reference : https://www.gss.com.tw/blog/spring-data-jpa-1
package site.helloyuan.springboot02.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import site.helloyuan.springboot02.models.Todo;

public interface TodoDao extends JpaRepository<Todo,Long>{
    
    @Query(value = "SELECT * FROM todo", nativeQuery = true)
    java.util.List<Todo> findMyAllTodos();

    @Query(value = "SELECT id FROM todo", nativeQuery = true)
    java.util.List<Long> findMyAllTodoIds();
}
