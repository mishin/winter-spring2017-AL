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

    public PlannedCourse(Long studentId, Long courseId, String quarter) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.quarter = quarter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}
