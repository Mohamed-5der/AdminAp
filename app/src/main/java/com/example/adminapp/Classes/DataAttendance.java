package com.example.adminapp.Classes;

public class DataAttendance {
  private  String nameStudent;
  private  String nameGroup;
  private  String dateSend;

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    private  int ImageStudent;

    public DataAttendance(String nameStudent, String nameGroup, int imageStudent,String dateSend) {
        this.dateSend = dateSend;
        this.nameStudent = nameStudent;
        this.nameGroup = nameGroup;
        ImageStudent = imageStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getImageStudent() {
        return ImageStudent;
    }

    public void setImageStudent(int imageStudent) {
        ImageStudent = imageStudent;
    }
}
