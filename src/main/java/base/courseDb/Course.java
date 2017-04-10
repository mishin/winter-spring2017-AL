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
    private String number;
    private String title;
    private EducationArea educationArea;

    public Course (){};

    public Course(String prefix, String number, String title, String educationArea) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        this.setEducationArea(educationArea);
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

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEducationArea() {
        if (this.educationArea.equals(EducationArea.MAJOR))
            return "MAJOR";
        else if (this.educationArea.equals(EducationArea.SUPPORT))
            return "SUPPORT";
        else if (this.educationArea.equals(EducationArea.GE))
            return "GE";
        else
            return "NONE";
    }

    public void setEducationArea(String educationArea) {
        if (educationArea.equals("MAJOR"))
            this.educationArea = EducationArea.MAJOR;
        else if (educationArea.equals("SUPPORT"))
            this.educationArea = EducationArea.SUPPORT;
        else if (educationArea.equals("GE"))
            this.educationArea = EducationArea.GE;
        else
            this.educationArea = EducationArea.NONE;
    }
}