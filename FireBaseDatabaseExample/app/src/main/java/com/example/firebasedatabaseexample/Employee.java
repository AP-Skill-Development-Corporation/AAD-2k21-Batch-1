package com.example.firebasedatabaseexample;

public class Employee {
    String ename;
    String eId;
    String eSalary;

    public Employee() {
    }

    public Employee(String ename, String eId, String eSalary) {
        this.ename = ename;
        this.eId = eId;
        this.eSalary = eSalary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

        public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteSalary() {
        return eSalary;
    }

    public void seteSalary(String eSalary) {
        this.eSalary = eSalary;
    }
}
