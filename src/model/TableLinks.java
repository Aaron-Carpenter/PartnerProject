/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "links")
public class TableLinks {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "LINK_NAME")
    private String linkName;
    
    @Column(name = "LINK")
    private String link;

    @Column(name = "TIME")
    private String time;

    @Column(name = "DESCRIPTION")
    private String description;

    public TableLinks() {
        super();
    }
    
    public TableLinks(String linkName, String link, String description, String time) {
        super();
        this.linkName = linkName;
        this.link = link;
        this.time = time;
        this.description = description;
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
    
    @Override
    public String toString() {
        return "Assessment [id=" + id + ", link=" + link + ", time=" + time + ", description=" + description + "]";
    }
}