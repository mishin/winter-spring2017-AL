package base.studentFlowchartDb;

import java.util.ArrayList;

public class AggregatePlannedCourseInformation {

    private ArrayList<CourseCountPair> courseCountPairs;

    public AggregatePlannedCourseInformation() {
        courseCountPairs = new ArrayList<CourseCountPair>();
    }

    public void add(String courseInfo, Integer count) {
        courseCountPairs.add(new CourseCountPair(courseInfo, count));
    }

    public ArrayList<CourseCountPair> getCourseCountPairs() {
        return this.courseCountPairs;
    }
}
