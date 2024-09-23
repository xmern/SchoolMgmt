package org.example;
import java.util.Scanner;

public class Prompt {
    private TypeWriter typeWriter;
    private Scanner scanner = new Scanner(System.in);
    public Prompt(TypeWriter typeWriter){
        this.typeWriter = typeWriter;
    }
   public void clear(){
       // Add this line to consume the leftover newline after reading the float
       this.scanner.nextLine();
   }
    public String getStringInput(String entry){
        this.typeWriter.Write(entry);
        String input = scanner.nextLine();
        //this.typeWriter.Write(input);
        return input;
    }
    public String getStringInput2(String entry){
        this.typeWriter.WriteLine(entry);
        String input = scanner.next();
        //this.typeWriter.Write(input);
        clear();
        return input;
    }
    public int getIntegerInput(String entry){
        this.typeWriter.Write(entry);
        boolean done = false;
        int input = 0;
        while(! done ){
            try{
                input = scanner.nextInt();
                done = true;
                return input;
            }catch(Exception ex){
              this.typeWriter.Write("Please enter a number");
            }
        }
        return input;
    }
    public float getFloatInput(String entry){
        this.typeWriter.Write(entry);
        boolean done = false;
        float input = 0.0f;
        while(!done){
            try{
                input = scanner.nextFloat();
                done = true;
                return input;
            }catch(Exception ex){
                this.typeWriter.Write("operation failed weight must be a number");

            }
        }
        return input;
    }
}
