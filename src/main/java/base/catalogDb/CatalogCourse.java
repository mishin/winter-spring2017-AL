/**
 * Created by Lauren on 4/6/2017.
 */

package base.catalogDb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

@Document(collection = "course")
public class CatalogCourse implements Serializable {

    @Id
    //Id is string in MongoDB
    private String courseId;
    private String prefix;
    private int number;
    private String title;
    private String educationArea;
    private String description;
    private String prerequisites;
    private int numUnits;

    public CatalogCourse(){};

    public CatalogCourse(String courseId, String prefix, int number, String title,
                         String educationArea, String description, String prerequisites, int numUnits) {
        this.courseId = courseId;
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        this.educationArea = educationArea;
        this.description = description;
        this.prerequisites = prerequisites;
        this.numUnits = numUnits;
    }

    public String getCourseId() { return this.courseId; }

    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEducationArea() {
        return this.educationArea;
    }

    public void setEducationArea(String educationArea) {
        this.educationArea = educationArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getNumUnits() { return this.numUnits; }

    public void setNumUnits(int numUnits) { this.numUnits = numUnits; }
}