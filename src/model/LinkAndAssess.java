package model;

import javax.persistence.*;

@Entity
@Table(name = "link_and_assess")
public class LinkAndAssess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "link")
    private String link;

    @Column(name = "time")
    private String time;

    @Column(name = "description")
    private String description;
    
    @Column(name = "assessment")
    private String assessment;

    @Column(name = "severity")
    private String severity;

    public LinkAndAssess() {
    }

    public LinkAndAssess(String linkName, String link, String description, String time, String assessment, String severity) {
        this.linkName = linkName;
        this.link = link;
        this.description = description;
        this.time = time;
        this.assessment = assessment;
        this.severity = severity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getAssessment() {
        return assessment;
    }
    
    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
    
    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
    
    public String toString() {
        return "LinkAndAssess [id=" + id +
               ", linkName=" + linkName +
               ", link=" + link +
               ", time=" + time +
               ", description=" + description +
               ", assessment=" + assessment +
               ", severity=" + severity + "]";
    }
}


