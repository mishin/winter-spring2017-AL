package base.studentFlowchartDb;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PlannedCourse implements Serializable {

    @Id private String id;
    private Long courseId;
    private Integer year; //1-freshman, 2-sophomore, etc...
    private Integer quarter; //1-fall 2-winter 3-spring 4-summer
    private Integer position;

    public PlannedCourse() {}

    public PlannedCourse(Long courseId, Integer year, Integer quarter, Integer position) {
        this.courseId = courseId;
        this.year = year;
        this.quarter = quarter;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
