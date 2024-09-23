package org.example;

import java.util.Objects;

public class School implements schoolAdmin{
    public int classRoomCapacity;
    public int noOfClasses;
    private ClassRoom[] classes;
    public String Name;
    private TypeWriter typeWriter;
    private Prompt prompt;


    public School(int noOfClasses, int classCapacity, String name, TypeWriter typeWriter, Prompt prompt){
        this.classRoomCapacity = classCapacity;
        this.noOfClasses = noOfClasses;
        this.classes = new ClassRoom[this.noOfClasses];
        this.Name = name;
        this.typeWriter = typeWriter;
        this.prompt = prompt;
        this.typeWriter.TypeWrite("welcome to "+this.Name+" this is a console application to manage the school");
        this.typeWriter.pause(10);
        this.typeWriter.TypeWrite("press help to view all commands");

    }
    public Student studentApplication(){
        this.typeWriter.Write("Fill out this student application form to be admit a student into the school");
        String name = this.prompt.getStringInput("Please enter Student's name:");
        float weight = this.prompt.getFloatInput("enter Student's weight:");
        this.prompt.clear();
        String classname = this.prompt.getStringInput("enter the name of the student's classroom:");

        Student student = new Student(name, weight, classname);
        return student;
    }
    public Student findStudent(String name){
        Student student = null;
        for (ClassRoom aClass : this.classes) {
            for (Student aStudent: aClass.returnStudents()){
               if (Objects.equals(aStudent.Name, name)){
                   student = aStudent;
                   return student;
               }
            }
        }
        return student;
    }
    public ClassRoom findStudentClass(String name){
        ClassRoom classRoom = null;
        for (ClassRoom aClass : this.classes) {
            for (Student aStudent: aClass.returnStudents()){
                if (Objects.equals(aStudent.Name, name)){
                    classRoom = aClass;
                    return aClass;
                }
            }
        }
        return classRoom;
    }
    private int findEmptySlot(){
        int slot = -1;
        for (int i = 0; i < this.classes.length; i ++) {
            if (this.classes[i] == null){
                return i;
            }
        }

        return slot;
    }
    public void createClassRoom(){
        String classname = this.prompt.getStringInput("enter the name for this class");
        int slot = this.findEmptySlot();

        if (slot > -1){
            this.classes[this.findEmptySlot()] = new ClassRoom(classname,this.classRoomCapacity);
        }else{
            this.typeWriter.Write("the school has reached it's maximum number of classes");
        }

    }
    public ClassRoom findClass(String name){
        ClassRoom classRoom = null;
        for (ClassRoom aClass : this.classes) {
            if(aClass != null) {
                if (Objects.equals(aClass.Name, name)) {
                    classRoom = aClass;
                    return aClass;
                }
            }
        }
        return classRoom;
    }
    //public boolean studentInfo(String name, String classRoom){}
    public boolean doesExist(String name){
        boolean exist = false;
        for (ClassRoom aClass : this.classes) {
            if (aClass != null) {
                for (Student aStudent : aClass.returnStudents()) {
                    if (aStudent != null) {
                        if (Objects.equals(aStudent.Name, name)) {
                            exist = true;
                            return exist;
                        }
                    }
                }
            }
        }
        return exist;
    }

    public void admitStudent(){
        Student student = this.studentApplication();
        //this.typeWriter.Write("processing");
        if (!doesExist(student.Name)){
            ClassRoom classRoom = findClass(student.classId);
            if (classRoom != null){
                boolean status = classRoom.addStudent(student);
                if (status == true){
                    this.typeWriter.Write("student admitted succesfully");
                }else{
                    this.typeWriter.Write("the class is full, student cannot be created");
                }
            }else{
                this.typeWriter.Write("the class you entered for the student was not found");
            }
        }else{
            this.typeWriter.Write("student with name "+student.Name+" already exists please try another name");
        }

    }
    public void removeStudent(){}
    public void editScore(){
        String name = this.prompt.getStringInput("enter the student's name");
        Student student = findStudent(name);
        if (student != null){
            float score = this.prompt.getFloatInput("enter the student's score");
            student.Score = score;
        }
    }
}