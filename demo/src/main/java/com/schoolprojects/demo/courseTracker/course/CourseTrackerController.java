package com.schoolprojects.demo.courseTracker.course;
import com.schoolprojects.demo.courseTracker.DTO.courseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseTrackerController {
    
    private final CourseTrackerService courseTrackerService;

    public CourseTrackerController(CourseTrackerService courseTrackerService) {
        this.courseTrackerService = courseTrackerService;
    }

    @GetMapping("/courses/{courseCode}")
    public courseDTO getCourseByCode(@PathVariable String courseCode) {
        return courseTrackerService.getCourseByCode(courseCode);
    }

    @GetMapping("/courses")
    public List<courseDTO> getAllCourses() {
        return courseTrackerService.getAllCourses();
    }

    @PostMapping("/courses")
    public void createCourse(@RequestBody courseDTO course) {
        courseTrackerService.saveCourse(course);
    }

    @PutMapping("/courses/{courseCode}")
    public void updateCourse(@PathVariable String courseCode, @RequestBody courseDTO updatedCourse) {
        courseTrackerService.saveCourse(updatedCourse);
    }

    @DeleteMapping("/courses/{courseCode}")
    public void deleteCourse(@PathVariable String courseCode) {
        courseTrackerService.deleteCourse(courseCode);
    }

    @RequestMapping(value = "/courses/search", method = RequestMethod.GET)
    public List<courseDTO> searchCourses(@RequestParam(required = false) String instructor, @RequestParam(required = false) String semester) {
        if (instructor != null) {
            return courseTrackerService.getCoursesByInstructor(instructor);
        } else if (semester != null) {
            return courseTrackerService.getCoursesBySemester(semester);
        } else {
            return courseTrackerService.getAllCourses();
        }
    }
}
