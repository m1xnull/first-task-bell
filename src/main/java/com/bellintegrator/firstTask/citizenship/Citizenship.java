package com.bellintegrator.firstTask.citizenship;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Citizenship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @Column(length = 50, nullable = false)
    @JsonView(Views.UI.class)
    private String name;

    @Column(nullable = false)
    @JsonView(Views.UI.class)
    private int code;

    public Citizenship() {
    }

    public Citizenship(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
