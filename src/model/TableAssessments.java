/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * @author Noah Arterburn - narterburn@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

package model;

import javax.persistence.*;

@Entity
@Table(name = "assessments")
public class TableAssessments {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ASSESSMENT")
    private String assessment;

    @Column(name = "SEVERITY")
    private String severity;

    public TableAssessments() {
        super();
    }

    public TableAssessments(int id, String assessment, String severity) {
        super();
        this.id = id;
        this.assessment = assessment;
        this.severity = severity;
    }

    public TableAssessments(String assessment, String severity) {
        super();
        this.assessment = assessment;
        this.severity = severity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Assessment [id=" + id + ", assessment=" + assessment + ", severity=" + severity + "]";
    }
}
