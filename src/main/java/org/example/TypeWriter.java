package org.example;

public class TypeWriter {
    private int typingSpeed;
    public TypeWriter(int Speed){
        this.typingSpeed = Speed;
    }
    public void Write(String text){
        System.out.println(text);
    }
    public void WriteLine(String text){
        System.out.print(text);
    }
    public void pause(long seconds){
        try {
            Thread.sleep(seconds);  // Delay of x milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void pause(int seconds){
        try {
            Thread.sleep(seconds);  // Delay of x milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void pause(float seconds){
        try {
            Thread.sleep((long)seconds);  // Delay of x milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void TypeWrite(String text){
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));  // Print each character
            pause(7);
        }
        System.out.println();


    }
}
