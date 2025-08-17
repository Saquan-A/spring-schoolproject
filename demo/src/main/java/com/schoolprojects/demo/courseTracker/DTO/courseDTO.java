package com.schoolprojects.demo.courseTracker.DTO;

import java.util.List;

public class courseDTO {
    
    private Long id;
    private String courseName;
    private String courseCode;
    private String instructor;
    private String semester; // e.g., "Fall 2023"
    private List<studentDTO> students;
    private List<assignmentDTO> assignments;

    public courseDTO() {}

    public courseDTO(Long id, String courseName, String courseCode, String instructor, String semester) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.semester = semester;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getInstructor() {
        return instructor;
    }
    public String getSemester() {
        return semester;
    }
    public List<studentDTO> getStudents() {
        return students;
    }
    public List<assignmentDTO> getAssignments() {
        return assignments;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public void setStudents(List<studentDTO> students) {
        this.students = students;
    }
    public void setAssignments(List<assignmentDTO> assignments) {
        this.assignments = assignments;
    }

}
