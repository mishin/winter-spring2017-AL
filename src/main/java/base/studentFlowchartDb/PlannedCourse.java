package base.studentFlowchartDb;

import base.catalogCourseDb.CatalogCourse;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

public class PlannedCourse implements Serializable {

    @Id
    private String id;
    private int courseId;
    private int year; //1-freshman, 2-sophomore, etc...
    private int quarter; //1-fall 2-winter 3-spring 4-summer
    private int position;

    public PlannedCourse() {}

    public PlannedCourse(int courseId, int quarter, int year, int position) {
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
