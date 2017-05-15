/**
 * Created by Lauren on 4/6/2017.
 */

package base.catalogDb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Document(collection = "Course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //Id is string in MongoDB
    private String id;
    private String prefix;
    private int number;
    private String title;
    private String educationArea;
    private int numUnits;

    public Course (){};

    public Course(String prefix, int number, String title, String educationArea, int numUnits) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        this.educationArea = educationArea;
        this.numUnits = numUnits;
    }

    public org.bson.Document getDocument() {
        return new org.bson.Document()
                .append("prefix", prefix)
                .append("number", number)
                .append("title", title)
                .append("educationArea", educationArea)
                .append("numUnits", numUnits);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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