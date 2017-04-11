package base.plannedCourseDb;

import javax.persistence.*;

/**
 * Created by Lauren on 4/6/2017.
 */
@Entity
public class PlannedCourse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long courseId;
    private String quarter;

    public PlannedCourse() {}

    public PlannedCourse(String courseId, String quarter) {
        this.setCourseId(courseId);
        this.quarter = quarter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
