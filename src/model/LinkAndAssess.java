
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */

package model;

import javax.persistence.*;

@Entity
@Table(name = "link_and_assess")
public class LinkAndAssess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "link_id", referencedColumnName = "id")
    private TableLinks link;

    @ManyToOne
    @JoinColumn(name = "assessment_id", referencedColumnName = "id")
    private TableAssessments assessment;

    // Include all variables from TableLinks and TableAssessments
    @Column(name = "link_name")
    private String linkName;

    @Column(name = "time")
    private String time;

    @Column(name = "description")
    private String description;

    @Column(name = "severity")
    private String severity;

    public LinkAndAssess() {
        super();
    }

    public LinkAndAssess(TableLinks link, TableAssessments assessment) {
        this.link = link;
        this.assessment = assessment;
        this.linkName = link.getLink();
        this.time = link.getTime();
        this.description = link.getDescription();
        this.severity = assessment.getSeverity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TableLinks getLink() {
        return link;
    }

    public void setLink(TableLinks link) {
        this.link = link;
    }

    public TableAssessments getAssessment() {
        return assessment;
    }

    public void setAssessment(TableAssessments assessment) {
        this.assessment = assessment;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}


