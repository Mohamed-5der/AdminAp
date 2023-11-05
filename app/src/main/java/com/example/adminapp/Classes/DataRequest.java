package com.example.adminapp.Classes;

public class DataRequest {

    public String oldGroup ;
    public String newGroup ;
    public String nameStudent ;
    public int imgStudent;
    public DataRequest(String oldGroup, String newGroup, String nameStudent, int imgStudent) {
        this.oldGroup = oldGroup;
        this.newGroup = newGroup;
        this.nameStudent = nameStudent;
        this.imgStudent = imgStudent;
    }

    public String getOldGroup() {
        return oldGroup;
    }

    public void setOldGroup(String oldGroup) {
        this.oldGroup = oldGroup;
    }

    public String getNewGroup() {
        return newGroup;
    }

    public void setNewGroup(String newGroup) {
        this.newGroup = newGroup;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getImgStudent() {
        return imgStudent;
    }

    public void setImgStudent(int imgStudent) {
        this.imgStudent = imgStudent;
    }
}
