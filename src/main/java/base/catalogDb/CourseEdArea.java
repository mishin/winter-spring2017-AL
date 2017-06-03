package base.catalogDb;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by calvinnguyen on 6/2/17.
 */
public class CourseEdArea implements Serializable {

    @Id
    private String id;
    private int catalogId;
    private String major;
    private List<CatalogCourse> catalogCourses = new ArrayList<CatalogCourse>();

    public CourseEdArea() {}

    public CourseEdArea(int catalogId, String major, List<CatalogCourse> catalogCourses) {
        this.catalogId = catalogId;
        this.major = major;
        this.catalogCourses = catalogCourses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<CatalogCourse> getCatalogCourses() {
        return catalogCourses;
    }

    public void setCatalogCourses(List<CatalogCourse> catalogCourses) {
        this.catalogCourses.clear();
        this.catalogCourses.addAll(catalogCourses);
    }
}
