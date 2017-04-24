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
    private Integer quarter; //1-fall 2-winter 3-spring 4-summer
    private Integer year; //1-freshman, 2-sophomore, etc...
    private Integer position; //position within a quarter (where in a column it was planned)

    public PlannedCourse() {}

    public PlannedCourse(Long studentId, Long courseId, Integer quarter, Integer year, Integer position) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.quarter = quarter;
        this.year = year;
        this.position = position;
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

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPosition() { return position; }

    public void setPosition(Integer position) { this.position = position; }
}
