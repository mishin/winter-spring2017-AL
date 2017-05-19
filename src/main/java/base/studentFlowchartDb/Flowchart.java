package base.studentFlowchartDb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauren on 4/6/2017.
 */
@Document(collection = "flowchart")
public class Flowchart implements Serializable {

    @Id
    private String id;
    private Long studentId;
    private String name;
    private List<PlannedCourse> plannedCourses = new ArrayList<PlannedCourse>();

    public Flowchart() {}

    public Flowchart(Long studentId, String name, List<PlannedCourse> plannedCourses) {
        this.studentId = studentId;
        this.name = name;
        this.plannedCourses.addAll(plannedCourses);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<PlannedCourse> getPlannedCourses() {
        return plannedCourses;
    }

    public void setPlannedCourses(List<PlannedCourse> plannedCourses) {
        this.plannedCourses.clear();
        this.plannedCourses.addAll(plannedCourses);
    }
}
