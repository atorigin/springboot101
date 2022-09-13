package site.helloyuan.springboot02.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
public class Todo {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @ElementCollection
    private List<String> items;
    @Column
    private String tag;
    @Column
    private Timestamp create_timestamp;
    @Column
    private Timestamp update_timestamp;
    
    public Todo() {
    }

    public Todo(String name, String description, List<String> items, String tag, Timestamp create_timestamp,
            Timestamp update_timestamp) {
        this.name = name;
        this.description = description;
        this.items = items;
        this.tag = tag;
        this.create_timestamp = create_timestamp;
        this.update_timestamp = update_timestamp;
    }
    
}
