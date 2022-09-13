package site.helloyuan.springboot02.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import site.helloyuan.springboot02.models.Todo;

public interface TodoDao extends JpaRepository<Todo,Long>{

}
