package com.schoolprojects.demo.courseTracker.DTO;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class studentDTO {
    
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "ID cannot be null")
    private String studentId;
    @NotNull(message = "Email cannot be null")
    private String email;

    public studentDTO() {}

    public studentDTO(Long id, String name, String studentId, String email) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getEmail() {
        return email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
