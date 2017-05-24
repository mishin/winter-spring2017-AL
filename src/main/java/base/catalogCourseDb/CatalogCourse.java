/**
 * Created by Lauren on 4/6/2017.
 */

package base.catalogCourseDb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

@Document(collection = "course")
public class CatalogCourse implements Serializable {

    @Id
    private String id; //Id is string in MongoDB
    private int courseId;
    private String prefix;
    private int number;
    private String title;
    private String educationArea;
    private int numUnits;

    public CatalogCourse(){};

    public CatalogCourse(int courseId, String prefix, int number, String title, String educationArea, int numUnits) {
        this.courseId = courseId;
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        this.educationArea = educationArea;
        this.numUnits = numUnits;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCourseId() { return this.courseId; }

    public void setCourseId(int courseId) { this.courseId = courseId; }

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

    public int getNumUnits() { return this.numUnits; }

    public void setNumUnits(int numUnits) { this.numUnits = numUnits; }
}