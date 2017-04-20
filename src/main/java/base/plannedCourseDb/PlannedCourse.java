package base.plannedCourseDb;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PlannedCourse implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private Long courseId;
    private String quarter;

    public PlannedCourse() {}

    public PlannedCourse(String studentId, String courseId, String quarter) {
        this.setStudentId(studentId);
        this.setCourseId(courseId);
        this.quarter = quarter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId.toString();
    }

    public void setStudentId(String studentId) {
        this.studentId = Long.parseLong(studentId);
    }

    public String getCourseId() {
        return courseId.toString();
    }

    public void setCourseId(String courseId) {
        this.courseId = Long.parseLong(courseId);
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}
