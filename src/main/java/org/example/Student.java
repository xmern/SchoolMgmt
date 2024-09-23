package org.example;

public class Student {
    String Name;
    float Score;
    float Height;
    String classId;
    public Student(String name, float score , float height, String classId){
        this.Name = name;
        this.Score = score;
        this.Height = height;
    }
    public Student(String name, float score , float height){
        this.Name = name;
        this.Score = score;
        this.Height = height;
    }
    public Student(String name, float height){
        this.Name = name;
        this.Height = height;
    }
    public Student(String name, float height, String classId){
        this.Name = name;
        this.Height = height;
        this.classId = classId;
    }
}
