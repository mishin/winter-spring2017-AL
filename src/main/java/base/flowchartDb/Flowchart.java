package base.flowchartDb;

import base.courseDb.Course;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lauren on 4/6/2017.
 */
@Entity
public class Flowchart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String name;
    private Integer plannedCourseIds;

    public Flowchart() {}

    public Flowchart(Long studentId, String name, Integer plannedCourseIds) {
        this.studentId = studentId;
        this.name = name;
        this.plannedCourseIds = plannedCourseIds;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlannedCourseIds() {
        return plannedCourseIds;
    }

    public void setPlannedCourseIds(Integer plannedCourseIds) {
        this.plannedCourseIds = plannedCourseIds;
    }
}
