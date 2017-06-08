/**
 * Created by Lauren on 4/6/2017.
 */

package base.catalogDb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

@Document(collection = "course")
public class CatalogCourse implements Serializable {

    @Id
    //Id is string in MongoDB
    private String courseId;
    private String name;
    private String title;
    //private String educationArea;
    private String description;
    private List<String> prerequisites;
    private int numUnits;

    public CatalogCourse(){};

    public CatalogCourse(String courseId, String name, String title,
                         /*String educationArea,*/ String description, List<String> prerequisites, int numUnits) {
        this.courseId = courseId;
        this.name = name;
        this.title = title;
        //this.educationArea = educationArea;
        this.description = description;
        this.prerequisites = prerequisites;
        this.numUnits = numUnits;
    }

    public org.bson.Document getDocument() {
        return new org.bson.Document()
                .append("courseId", courseId)
                .append("name", name)
                .append("title", title)
                //.append("educationArea", educationArea)
                .append("description", description)
                .append("prerequisites", prerequisites)
                .append("numUnits", numUnits);
    }

    public String getCourseId() { return this.courseId; }

    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getEducationArea() {
//        return this.educationArea;
//    }
//
//    public void setEducationArea(String educationArea) {
//        this.educationArea = educationArea;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getNumUnits() { return this.numUnits; }

    public void setNumUnits(int numUnits) { this.numUnits = numUnits; }
}