package org.exampl.employeeapi;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="project")
public class Project {
    @Id
    private int projectid;
    @Column
    private String projectname;
    @Column
    private String projectstatus;
    @Column
    private Date projectstartdate;
    public Project() {

    }
    @OneToMany(mappedBy = "project")
    List<Employees>employeesList=new ArrayList<>();

    public Project(int projectid, String projectname, String projectstatus, Date projectstartdate) {
        this.projectid = projectid;
        this.projectname = projectname;
        this.projectstatus = projectstatus;
        this.projectstartdate = projectstartdate;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(String projectstatus) {
        this.projectstatus = projectstatus;
    }

    public Date getProjectstartdate() {
        return projectstartdate;
    }

    public void setProjectstartdate(Date projectstartdate) {
        this.projectstartdate = projectstartdate;
    }
}
