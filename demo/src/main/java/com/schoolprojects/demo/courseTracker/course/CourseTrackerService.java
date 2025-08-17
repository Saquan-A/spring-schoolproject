package com.schoolprojects.demo.courseTracker.course;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolprojects.demo.courseTracker.DTO.courseDTO;
import com.schoolprojects.demo.courseTracker.DTO.assignmentDTO;
import com.schoolprojects.demo.courseTracker.DTO.studentDTO;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class CourseTrackerService {
    
    private final CourseTrackerRepository courseTrackerRepository;
    // We might need other repositories if we want to manage students/assignments independently

    public CourseTrackerService(CourseTrackerRepository courseTrackerRepository) {
        this.courseTrackerRepository = courseTrackerRepository;
    }

    // --- Mappers ---
    private courseDTO toCourseDTO(CourseTracker entity) {
        courseDTO dto = new courseDTO(entity.getId(), entity.getCourseName(), entity.getCourseCode(), entity.getInstructor(), entity.getSemester());
        if (entity.getStudents() != null) {
            dto.setStudents(entity.getStudents().stream().map(this::toStudentDTO).collect(Collectors.toList()));
        }
        if (entity.getAssignments() != null) {
            dto.setAssignments(entity.getAssignments().stream().map(this::toAssignmentDTO).collect(Collectors.toList()));
        }
        return dto;
    }

    private studentDTO toStudentDTO(Student entity) {
        return new studentDTO(entity.getId(), entity.getName(), entity.getStudentId(), entity.getEmail());
    }

    private assignmentDTO toAssignmentDTO(Assignment entity) {
        return new assignmentDTO(entity.getTitle(), entity.getMaxPoints(), 0, entity.getDueDate(), entity.getDescription());
    }


    @Transactional
    public courseDTO createCourse(courseDTO courseDto) {
        CourseTracker courseTracker = new CourseTracker();
        courseTracker.setCourseName(courseDto.getCourseName());
        courseTracker.setCourseCode(courseDto.getCourseCode());
        courseTracker.setInstructor(courseDto.getInstructor());
        courseTracker.setSemester(courseDto.getSemester());
        CourseTracker savedCourse = courseTrackerRepository.save(courseTracker);
        return toCourseDTO(savedCourse);
    }

    @Transactional
    public Optional<courseDTO> updateCourse(String courseCode, courseDTO courseDetails) {
        Optional<CourseTracker> courseOpt = courseTrackerRepository.findByCourseCode(courseCode)
                .stream()
                .findFirst();
        return courseOpt.map(course -> {
            course.setCourseName(courseDetails.getCourseName());
            course.setInstructor(courseDetails.getInstructor());
            course.setSemester(courseDetails.getSemester());
            // Note: Updating students/assignments would be more complex
            return toCourseDTO(courseTrackerRepository.save(course));
        });
    }

    @Transactional
    public boolean deleteCourse(String courseCode) {
        Optional<CourseTracker> courseOpt = courseTrackerRepository.findByCourseCode(courseCode)
                .stream()
                .findFirst();
        if (courseOpt.isPresent()) {
            courseTrackerRepository.delete(courseOpt.get());
            return true;
        }
        return false;
    }

    public List<courseDTO> getAllCourses() {
        List<CourseTracker> courses = courseTrackerRepository.findAll();
        return courses.stream().map(this::toCourseDTO).collect(Collectors.toList());
    }

    public List<courseDTO> getCoursesByInstructor(String instructor) {
        List<CourseTracker> courses = courseTrackerRepository.findByInstructor(instructor);
        return courses.stream().map(this::toCourseDTO).collect(Collectors.toList());
    } 

    public courseDTO updateAssignment(String courseCode, String assignmentTitle, assignmentDTO updatedAssignment) {
        CourseTracker courseTracker = courseTrackerRepository.findByCourseCode(courseCode)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course not found")); // Replace with a proper exception

        for (Assignment assignment : courseTracker.getAssignments()) {
                if (assignment.getTitle().equals(assignmentTitle)) {
                    assignment.setDescription(updatedAssignment.getDescription());
                    assignment.setDueDate(updatedAssignment.getDueDate());
                    // Save the updated course
                    courseTrackerRepository.save(courseTracker);
                return toCourseDTO(courseTracker);
                }
            }
        return null; // or throw an exception
    }

    public List<courseDTO> getCoursesBySemester(String semester) {
        List<CourseTracker> courses = courseTrackerRepository.findBySemester(semester);
        return courses.stream().map(this::toCourseDTO).collect(Collectors.toList());
    }

    public void saveCourse(courseDTO course) {
        // This method can be used for both creating and updating courses
        Optional<CourseTracker> existingCourseOpt = courseTrackerRepository.findByCourseCode(course.getCourseCode())
                .stream()
                .findFirst();

        CourseTracker courseTracker;
        if (existingCourseOpt.isPresent()) {
            courseTracker = existingCourseOpt.get();
            courseTracker.setCourseName(course.getCourseName());
            courseTracker.setInstructor(course.getInstructor());
            courseTracker.setSemester(course.getSemester());
            // Note: Updating students/assignments would be more complex
        } else {
            courseTracker = new CourseTracker();
            courseTracker.setCourseName(course.getCourseName());
            courseTracker.setCourseCode(course.getCourseCode());
            courseTracker.setInstructor(course.getInstructor());
            courseTracker.setSemester(course.getSemester());
        }
        courseTrackerRepository.save(courseTracker);
    }

    public courseDTO getCourseByCode(String courseCode) {
        Optional<CourseTracker> courseOpt = courseTrackerRepository.findByCourseCode(courseCode)
                .stream()
                .findFirst();
        return courseOpt.map(this::toCourseDTO).orElse(null);
    }

}
