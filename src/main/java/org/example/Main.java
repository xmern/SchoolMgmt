package org.example;

import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       TypeWriter typeWriter = new TypeWriter(1);
       Prompt prompt = new Prompt(typeWriter);
       School mySchool = new School(70,50,"Xc7 microschool", typeWriter, prompt);
       boolean running = true;
       while(running){
           String input = prompt.getStringInput("> ");
           if (Objects.equals(input, "new class")){
               mySchool.createClassRoom();
           } else if (Objects.equals(input, "new student")) {
               mySchool.admitStudent();
           }else if  (Objects.equals(input, "edit score")){
               mySchool.editScore();
           }else if(Objects.equals(input, "help")){
               typeWriter.Write("commands  |  info  \n\nnew class: for creating a new student\nnew student: for creating a student\nedit score: to edit a student's score");
           }
           else if (Objects.equals(input, "exit")) {
               running = false;
           } else {
               typeWriter.Write("unknown command type help to view all commands");
           }
//           System.out.println(input);
       }
    }
}