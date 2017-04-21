/**
 * Created by Lauren on 4/6/2017.
 */

package base.courseDb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String prefix;
    private Integer number;
    private String title;
    private String educationArea;
    private Integer numUnits;

    public Course (){};

    public Course(String prefix, Integer number, String title, String educationArea, Integer numUnits) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        this.educationArea = educationArea;
        this.numUnits = numUnits;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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