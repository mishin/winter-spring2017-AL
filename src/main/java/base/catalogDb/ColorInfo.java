package base.catalogDb;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by calvinnguyen on 6/6/17.
 */
public class ColorInfo implements Serializable{

    @Id
    private String id;
    private List<Integer> majorCourseIds = new ArrayList<Integer>();
    private List<Integer> supportCourseIds = new ArrayList<Integer>();

    public ColorInfo() {}

    public ColorInfo(List<Integer> majorCourseIds, List<Integer> supportCourseIds) {
        this.majorCourseIds.addAll(majorCourseIds);
        this.supportCourseIds.addAll(supportCourseIds);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public List<Integer> getMajorCourseIds() {
        return majorCourseIds;
    }

    public void setMajorCourseIds(List<Integer> majorCourseIds) {
        this.majorCourseIds.clear();
        this.majorCourseIds.addAll(majorCourseIds);
    }

    public List<Integer> getSupportCourseIds() {
        return supportCourseIds;
    }

    public void setSupportCourseIds(List<Integer> supportCourseIds) {
        this.supportCourseIds.clear();
        this.supportCourseIds.addAll(supportCourseIds);
    }
}
