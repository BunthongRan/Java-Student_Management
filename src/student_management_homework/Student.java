package student_management_homework;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    String name, id, Class;
    int age, grade;
    float score;
    Student(){

    }

    public Student(String name, String id, String aClass, int age, int grade, float score) {
        this.name = name;
        this.id = id;
        Class = aClass;
        this.age = age;
        this.grade = grade;
        this.score = score;
    }

    void input(Scanner input) throws InputMismatchException {
        do {
            System.out.print("Enter Student name: ");
            name = input.next();
        }while (name == null);

        System.out.print("Enter Student ID: ");
        id = input.next();
        do {
            try {
                System.out.print("Enter Student Age: ");
                age = input.nextInt();
                if (age <= 0 || age >= 100){
                    System.out.println("Age not available!");
                    age = 0;
                }
            }catch (InputMismatchException mismatchException){
                input.next();
                System.out.println("Try again! Age could be integer");
                age = 0;
            }
        }while(age == 0);

        System.out.print("Enter Student's class: ");
        Class = input.next();
        do {
            try {
                System.out.print("Enter score: ");
                score = input.nextFloat();
                if (score < 0 || score > 1000){
                    System.out.println("Score is not available! please try again!\n");
                    score = 0;
                }
            }catch (InputMismatchException inputMismatchException){
                input.next();
                System.out.println("Score must be float number, not string!");
                score = 0;
            }
        }while (score == 0);
        do {
            try{
                System.out.print("Enter grade: ");
                grade = input.nextInt();
                if (grade <= 0){
                    System.out.println("Grade can not be minus!");
                    grade = 0;
                }else if (grade >= 13){
                    System.out.println("Grade has only 1 - 12!");
                    grade = 0;
                }
                System.out.println("\n");
            }catch (InputMismatchException inputMismatchException){
                input.next();
                System.out.println("You can only input only number from 1 to 12");
                grade = 0;
            }
        }while (grade == 0);
        System.out.print("Student information has been inserted !");
    }
    void output(){
        System.out.print ("Name: " + name + "\t\n");
        System.out.print ("ID: " + id + "\t\n");
        System.out.print ("Age: " + age + "\t\n");
        System.out.print ("Class: " + Class + "\t\n");
        System.out.print ("Score: " + score + "\t\n");
        System.out.print ("Grade: " + grade + "\t\n");
    }
    void gradeDefined(int option){
        if (grade > 13 || grade < 0){
            System.out.println("Grade not available!");
            System.out.println("We currently have class from 1-12");
            option = 0;
        }
    }
}
