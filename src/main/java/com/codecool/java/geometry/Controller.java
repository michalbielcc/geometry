package com.codecool.java.geometry;

import com.codecool.java.geometry.containers.ShapeList;
import com.codecool.java.geometry.shapes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Controller {

    static ShapeList shapes = new ShapeList();
    
    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static String getInput(String message) {
        Scanner reader = new Scanner(System.in); 
        System.out.print(message);
        String choice = reader.nextLine();
        return choice;
    }

    public static void run() {
        clearScreen();
	    boolean isRunning = true;
        while (isRunning) {
            String option = getInput("[1] Add shape\n[2] Show shape list\n[3] Show shape with the largest perimeter\n[4] Show shape with the largest area\n[5] Show formulas\n[0] Exit program ");
            if (option.equals("1")) {
                addNewShape();
            } else if (option.equals("2")) {
                clearScreen();
                String table = shapes.getShapesTable();
                System.out.println(table);
            } else if (option.equals("3")) {
                clearScreen();
                if (shapes.getShapeAt(0) == null) {
                    System.out.println("List is empty");
                } else {
                    System.out.println("Largest Shape by perimeter is: " + shapes.getLargestShapeByPerimeter() + "\n");
                }
            } else if (option.equals("4")) {
                clearScreen();
                if (shapes.getShapeAt(0) == null) {
                    System.out.println("List is empty");
                } else {
                    System.out.println("Largest Shape by area is: " + shapes.getLargestShapeByArea() + "\n");
                }
            } else if (option.equals("5")) {
                clearScreen();
                showFOrmulas();

            } else if (option.equals("0")) {
                clearScreen();
                isRunning = false;
            } else {
                clearScreen();
            }
        }        
    }

    private static void addNewShape() {

        boolean addingShape = true;
        String option;
        while(addingShape) {
            clearScreen();
            System.out.println("Add new shape:\n");
            option = getInput("[1] Circle\n[2] Equilateral Triangle\n[3] Rectangle\n[4] Square\n[5] Triangle\n[6] Regular Pentagon\n[0] Go back ");

            if (option.equals("1")) {
                clearScreen();
                boolean repeat = true;
                while (repeat) {
                    String radius = getInput("Enter radius: ");
                    if (checkIfFloat(radius) == true) {
                        Shape shape = new Circle(Float.parseFloat(radius));
                        shapes.addShape(shape);
                        repeat = false;
                    }
                }
            } else if (option.equals("2")) {
                clearScreen();
                boolean repeat = true;
                while (repeat) {
                    String side = getInput("Enter equilateral triangle side length: ");
                    if (checkIfFloat(side) == true) {
                        Shape shape = new EquilateralTriangle(Float.parseFloat(side));
                        shapes.addShape(shape);
                        repeat = false;
                    }
                }
            } else if (option.equals("3")) {
                clearScreen();
                boolean repeat = true;
                while (repeat) {
                    String sideA = getInput("Enter side 'a' length: ");
                    String sideB = getInput("Enter side 'b' length: ");
                    if (checkIfFloat(sideA) == true && checkIfFloat(sideB) == true) {
                        Shape shape = new Rectangle(Float.parseFloat(sideA), Float.parseFloat(sideB));
                        shapes.addShape(shape);
                        repeat = false;
                    }
                }
            } else if (option.equals("4")) {
                clearScreen();
                boolean repeat = true;
                while (repeat) {
                    String side = getInput("Enter square side length: ");
                    if (checkIfFloat(side) == true) {
                        Shape shape = new Square(Float.parseFloat(side));
                        shapes.addShape(shape);
                        repeat = false;
                    }
                }
            } else if (option.equals("5")) {
                boolean repeat = true;
                while (repeat) {
                    String sideA = getInput("Enter triangle side a length: ");
                    String sideB = getInput("Enter triangle side b length: ");
                    String sideC = getInput("Enter triangle side c length: ");
                    if (checkIfFloat(sideA) == true &&checkIfFloat(sideB) == true && checkIfFloat(sideC) == true) {
                        Shape shape = new Triangle(Float.parseFloat(sideA), Float.parseFloat(sideB), Float.parseFloat(sideC));
                        shapes.addShape(shape);
                        repeat = false;
                    }
                }
            }else if (option.equals("6")) {
                clearScreen();
                boolean repeat = true;
                while (repeat) {
                    String side = getInput("Enter regular pentagon side length: ");
                    if (checkIfFloat(side) == true) {
                        Shape shape = new RegularPentagon(Float.parseFloat(side));
                        shapes.addShape(shape);
                        repeat = false;
                    }
                }
            } else if (option.equals("0")) {
                clearScreen();
                addingShape = false;
            }
        }
    }

    private static boolean checkIfFloat(String string) {
        try {
            Float.parseFloat(string);
        } catch(NumberFormatException e){
            System.out.println("Use digits and comma only");
            return false;
        }
        return true;
    }

    private static void showFOrmulas() {
        clearScreen();
        boolean repeat = true;
        while (repeat) {
            String choice = getInput("\nChoose which shape formulas you want to see\n\n[1] Circle\n[2]Equilateral Triangle\n[3]Rectangle\n[4]Square\n[5]Triangle\n[6]Regular Pentagon\n[0]Go back: ");
            if (choice.equals("1")) {
                clearScreen();
                System.out.println("Perimeter = 2×π×r Area = π×r2");
            } else if (choice.equals("2")) {
                clearScreen();
                System.out.println("Perimeter = 3a, Area = sqrt(s(s-a)(s-b)(s-c)), where s = (a+b+c)/2");
            } else if (choice.equals("3")) {
                clearScreen();
                System.out.println("Perimeter = 2a + 2b, Area = a×b");
            } else if (choice.equals("4")) {
                clearScreen();
                System.out.println("Perimeter = 4a, Area = a×b");
            } else if (choice.equals("5")) {
                clearScreen();
                System.out.println("Perimeter = a + b + c, Area = sqrt(s(s-a)(s-b)(s-c)), where s = (a+b+c)/2");
            } else if (choice.equals("6")) {
                clearScreen();
                System.out.println("Perimeter = 5a, Area = (a2 sqrt(5(5+2sqrt(5))))/4");
            } else if (choice.equals("0")) {
                clearScreen();
                repeat = false;
            } else {
                clearScreen();
            }
        }
    }   
}
