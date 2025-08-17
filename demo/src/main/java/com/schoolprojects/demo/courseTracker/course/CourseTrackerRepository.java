package com.schoolprojects.demo.courseTracker.course;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseTrackerRepository extends JpaRepository<CourseTracker, Long> {
    // Example of a derived query: find all courses for a specific instructor
    List<CourseTracker> findByInstructor(String instructor);
    
    // Example of a more complex derived query
    List<CourseTracker> findBySemesterAndCourseCode(String semester, String courseCode);

    List<CourseTracker> findByCourseCode(String courseCode);

    List<CourseTracker> findBySemester(String semester);
}
