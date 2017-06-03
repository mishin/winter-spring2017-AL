package base.studentFlowchartDb;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class PlannedCourse implements Serializable {

    @Id
    private String id;
    private int courseId;
    private int year; //1-freshman, 2-sophomore, etc...
    private int quarter; //1-fall 2-winter 3-spring 4-summer
    private int position;
    private String educationArea;

    public PlannedCourse() {}

    public PlannedCourse(int courseId, int quarter, int year, int position, String educationArea) {
        this.courseId = courseId;
        this.year = year;
        this.quarter = quarter;
        this.position = position;
        this.educationArea = educationArea;
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

    public String getEducationArea() {
        return this.educationArea;
    }

    public void setEducationArea(String educationArea) {
        this.educationArea = educationArea;
    }
}
