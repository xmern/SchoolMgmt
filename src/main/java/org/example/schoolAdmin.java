package org.example;

public interface schoolAdmin {
    Student studentApplication();
    Student findStudent(String name);
    void admitStudent();
    void removeStudent();
    void editScore();
}