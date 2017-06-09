package base.studentFlowchartDb;

import java.io.Serializable;

public class CourseCountPair implements Serializable {

    private String courseInfo;
    private Integer count;

    public CourseCountPair(String courseInfo, Integer count) {
        this.courseInfo = courseInfo;
        this.count = count;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
