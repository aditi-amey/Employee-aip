package org.exampl.employeeapi.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="project")
public class Project {
    @Id
    private int projectid;
    @Column(name = "projectname")
    private String projectName;
    @Column(name = "projectstatus")
    private String projectStatus;
    @Column(name = "projectstartdate")
    private Date projectStartDate;

    public Project() {

    }

    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER)
    List<Employees> employeesList = new ArrayList<>();

     @OneToMany(mappedBy = "project",fetch = FetchType.EAGER)
     List<Expenses>expensesList=new ArrayList<>();
//    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL)
//    private Expenses expenses;

    public Project(int projectid, String projectName, String projectStatus, Date projectStartDate) {
        this.projectid = projectid;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectStartDate = projectStartDate;
    }


    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
}
