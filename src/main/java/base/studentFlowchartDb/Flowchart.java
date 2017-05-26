package base.studentFlowchartDb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "flowchart")
public class Flowchart implements Serializable {

    @Id
    private String id;
    private int studentId;
    private String flowchartName;
    private List<PlannedCourse> plannedCourses = new ArrayList<PlannedCourse>();

    public Flowchart() {}

    public Flowchart(int studentId, String name, List<PlannedCourse> plannedCourses) {
        this.studentId = studentId;
        this.flowchartName = name;
        this.plannedCourses.addAll(plannedCourses);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFlowchartName() {
        return flowchartName;
    }

    public void setFlowchartName(String flowchartName) {
        this.flowchartName = flowchartName;
    }

    public List<PlannedCourse> getPlannedCourses() {
        return plannedCourses;
    }

    public void setPlannedCourses(List<PlannedCourse> plannedCourses) {
        this.plannedCourses.clear();
        this.plannedCourses.addAll(plannedCourses);
    }
}
