package student_management_homework;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> student = new ArrayList<>();
        Student defined = new Student();
        int option; int again;
        do {
            try {
                System.out.println("----------- Welcome to Student-management-console-application ------------");
                System.out.println("1. Select");
                System.out.println("2. Insert students");
                System.out.println("3. Update student's data");
                System.out.println("4. Remove students");
                System.out.println("5. Show all the students");
                System.out.println("6. Search student information");
                System.out.println("7. Exit!");
                System.out.print(">>> Choose option (1-7): ");
                option = input.nextInt();
                switch (option) {
                    case 1 -> {
                      //  Select
                        System.out.println("------------- Selecting student data ---------------");
                        LinkedHashSet<String> Class = new LinkedHashSet<>();
                        LinkedHashSet<Integer> grade = new LinkedHashSet<>();
                        for (Student item : student) {
                            Class.add(item.Class);
                            grade.add(item.grade);
                        }
                        System.out.print ("All Classes: ");
                        for (String c : Class) {
                            System.out.print (c + " ");
                        }
                        System.out.println("\n");
                        System.out.print ("All Grade: ");
                        for (Integer i : grade) {
                            System.out.print (i + " ");
                        }
                        System.out.println("\n");
                        do {
                            System.out.println("1. select by class");
                            System.out.println("2. select by grade");
                            try {
                                System.out.println("Enter the options by number: ");
                                again = input.nextInt();
                            } catch (InputMismatchException inputMismatchException) {
                                input.next();
                                System.out.println("You can input only number!");
                                again = 0;
                            }
                            switch (again) {
                                case 1 -> {
                                    System.out.println("Select students by class : ");
                                    String inputClass = input.next();
                                    for (Student value : student) {
                                        if (inputClass.equals(value.Class)) {
                                            value.output();
                                            System.out.println("\n");
                                        }
                                    }
                                }
                                case 2 -> {
                                    //Insert students
                                    System.out.println("Select students by grade : ");
                                    int inputGrade = input.nextInt();
                                    for (Student value : student) {
                                        if (inputGrade == value.grade) {
                                            value.output();
                                            System.out.println("\n");
                                        }
                                    }
                                }
                            }
                        }while (again == 0);
                    }
                    case 2 -> {
                        System.out.println("------------- insert Student data -----------------");
                        Student obj = new Student();
                        obj.input(input);
                        student.add(obj);
                    }
                    case 3 -> {
                        //Update student's data
                        int update;
                        System.out.println("----------------- update student data ------------------");
                        System.out.println("Enter Student ID: ");
                        String searchId = input.next();
                        for (Student value : student) {
                            if (value.id.equals(searchId)) {
                                do {
                                    System.out.println("1. update score");
                                    System.out.println("2. update grade");
                                    System.out.println("3. Update ID");
                                    System.out.print("Choose the option: "); update = input.nextInt();
                                    switch (update) {
                                        case 1 -> {
                                            System.out.print("Input new score: ");
                                            value.score = input.nextInt();
                                        }
                                        case 2 -> {
                                            System.out.print("Input new grade: ");
                                            value.grade = input.nextInt();
                                            defined.gradeDefined(update);
                                        }
                                        case 3 -> {
                                            System.out.println("New ID: ");
                                            value.id = input.next();
                                        }
                                    }
                                }while (update == 0);
                            }
                        }
                    }
                    case 4 -> {
                        //Remove students
                        int removeAgain;
                        System.out.println("--------------------- Remove Student ----------------------");
                        System.out.println("1. Remove by ID");
                        System.out.println("2. Remove by Name");
                        try {
                            removeAgain = input.nextInt();
                            if (removeAgain > 2 || removeAgain < 0){
                                System.out.println("Option not available!");
                            }
                        }catch (InputMismatchException inputMismatchException){
                            input.next();
                            System.out.println("You can input only number!");
                            removeAgain = 0;
                        }
                        switch (removeAgain) {
                            case 1 -> {
                                System.out.println("Enter student's ID: ");
                                String oldId = input.next();
                                student.removeIf(Student -> Student.id.equals(oldId));
                                System.out.println("Successfully deleted!");
                            }
                            case 2 -> {
                                System.out.println("Enter student's name: ");
                                String oldName = input.next();
                                student.removeIf(Student -> Student.name.equals(oldName));
                                System.out.println("Successfully deleted!");
                            }
                        }
                    }
                    case 5 -> {
                        //Show all the students
                        System.out.println("----------------- Student Information ------------------");
                        for (Student value : student) {
                            value.output();
                            System.out.println(" ");
                        }
                    }
                    case 6->{
                        // Search Student information:
                        int searchOption;
                        do {
                            System.out.println("1. Search by name");
                            System.out.println("2. Search by id");
                            try {
                                searchOption = input.nextInt();
                                if (searchOption < 0 || searchOption > 2) {
                                    System.out.println("option not available!");
                                }
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("You can input only number!");
                                input.next();
                                searchOption = 0;
                            }
                            switch (searchOption){
                                case 1->{
                                    int check = 0;
                                    System.out.print("Enter student name: ");
                                    String search_name = input.next();
                                    for (Student value : student) {
                                        if (search_name.equals(value.name)){
                                            value.output();
                                            check = 1;
                                        }else{
                                            check = 0;
                                        }
                                    }
                                    if (check == 0){
                                        System.out.println("Name not found!");
                                    }
                                }
                                case 2->{
                                    int check = 0;
                                    System.out.print("Enter student id: ");
                                    String searchId = input.next();
                                    for (Student value : student) {
                                        if (searchId.equals(value.name)){
                                            value.output();
                                            check = 1;
                                        }else{
                                            check = 0;
                                        }
                                    }
                                    if (check == 0){
                                        System.out.println("Name not found!");
                                    }
                                }
                            }
                        }while (searchOption == 0);
                    }
                    //Exit!
                    case 7-> System.out.println("______SEE YOU AGAIN, THANKS YOU______");
                }
            }catch (InputMismatchException mismatchException){
                input.next();
                System.out.println("Please try again! You can input only number!");
                option = 0;
            }
        } while (option!=7);
    }
}
