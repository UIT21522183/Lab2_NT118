package com.example.lab2_4;

public class Employee {
    private String ID;
    private String fullName;
    private boolean checkManager;

    public Employee() {
    }

    public Employee(String ID, String fullName, boolean checkManager) {
        this.ID = ID;
        this.fullName = fullName;
        this.checkManager = checkManager;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isCheckManager() {
        return checkManager;
    }

    public void setCheckManager(boolean checkManager) {
        this.checkManager = checkManager;
    }
}
