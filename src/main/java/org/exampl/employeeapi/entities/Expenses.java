package org.exampl.employeeapi.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="expenses")
public class Expenses {
    @Id
    private int expensesid;
    @Column
    private long expensesamount;
  @Column(name="projectid",insertable = false,updatable = false)
    private int projectid;

    @ManyToOne
    @JoinColumn(name="projectid")
    private Project project;
//@OneToOne
//@JoinColumn(name="projectid")
//private Project project;

    public Expenses(int expensesid, long expensesamount, int projectid) {
        this.expensesid = expensesid;
        this.expensesamount = expensesamount;
        this.projectid = projectid;
    }
    public Expenses() {

    }

    public int getExpensesid() {
        return expensesid;
    }

    public void setExpensesid(int expensesid) {
        this.expensesid = expensesid;
    }

    public long getExpensesamount() {
        return expensesamount;
    }

    public void setExpensesamount(long expensesamount) {
        this.expensesamount = expensesamount;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public Project getProject1() {
        return project;
    }

    public void setProject1(Project project1) {
        this.project = project1;
    }
}
