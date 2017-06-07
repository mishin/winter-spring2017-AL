package base.catalogDb;

import base.studentFlowchartDb.Flowchart;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by calvinnguyen on 6/2/17.
 */
@Document(collection = "majorInformation")
public class MajorInformation implements Serializable {

    @Id
    private String id;
    private String major;
    private ColorInfo colorInfo;
    private Flowchart defaultFlowchart;

    public MajorInformation() {}

    public MajorInformation(String major, ColorInfo colorInfo, Flowchart defaultFlowchart) {
        this.major = major;
        this.colorInfo = colorInfo;
        this.defaultFlowchart = defaultFlowchart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() { return major; }

    public void setMajor(String major) {
        this.major = major;
    }

    public ColorInfo getColorInfo() { return colorInfo; }

    public void setColorInfo(ColorInfo colorInfo) { this.colorInfo = colorInfo; }

    public Flowchart getDefaultFlowchart() { return defaultFlowchart; }

    public void setDefaultFlowchart(Flowchart defaultFlowchart) { this.defaultFlowchart = defaultFlowchart; }

}
