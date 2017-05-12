/**
 * Created by Lauren on 4/6/2017.
 */

package base.catalogCourseDb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CatalogCourse implements Serializable {

    @Id private String id;
    private Integer courseId;
    private String prefix;
    private Integer number;
    private String title;
    private String educationArea;
    private Integer numUnits;

    public CatalogCourse(){};

    public CatalogCourse(Integer courseId, String prefix, Integer number, String title, String educationArea, Integer numUnits) {
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

    public Integer getCourseId() { return this.courseId; }

    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
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

    public Integer getNumUnits() { return this.numUnits; }

    public void setNumUnits(Integer numUnits) { this.numUnits = numUnits; }
}