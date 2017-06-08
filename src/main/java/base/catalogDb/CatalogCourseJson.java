package base.catalogDb;

/**
 * Created by viviantai on 6/7/17.
 */

public class CatalogCourseJson {

    private String id;
    private String prefix;
    private String suffix;
    private String title;
    private String description;
    private String prerequisites;
    private String units;

    public CatalogCourseJson() {};

    public CatalogCourseJson(String courseId, String prefix, String number, String title, String description, String prerequisites, String numUnits) {
        this.id = courseId;
        this.prefix = prefix;
        this.suffix = number;
        this.title = title;
        this.description = description;
        this.prerequisites = prerequisites;
        this.units = numUnits;
    }

    public String getCourseId() { return this.id; }

    public void setCourseId(String courseId) { this.id = courseId; }

    public String getPrefix() {
        return this.prefix;
    }

    public String getNumber() {
        return this.suffix;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public String getNumUnits() { return this.units; }

    @Override
    public String toString() {
        return String.format(id + "\n" + prefix + "\n" + suffix +
                "\n" + title + "\n" + " " + description + "\n" +
                prerequisites + "\n" + units);

    }
}
