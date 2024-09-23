package org.example;

public class ClassRoom {
    public String Name;
    private Student[] students;
    public ClassRoom(String name,int roomSize){
        this.Name = name;
        this.students =  new Student[roomSize];
    }
    public Student[] returnStudents(){
        return this.students;
    }
    private int findEmptySlot(){
        int slot = -1;
        for (int i = 0; i < this.students.length; i ++) {
            if (this.students[i] == null){
                return i;
            }
        }

        return slot;
    }
    public boolean addStudent(Student student){
        boolean succesful = false;
        int slot = this.findEmptySlot();
        if (slot > -1){
            this.students[slot] = student;
            succesful = true;
        }
        return succesful;

    }
}
