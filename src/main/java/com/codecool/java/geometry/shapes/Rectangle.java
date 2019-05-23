package com.codecool.java.geometry.shapes;


public class Rectangle extends Shape {

    
    private Float a;
    private Float b;


    public Rectangle(float a, float b) {
        checkIfArgsGreaterThanZero(a, b);
        this.a = a;
        this.b = b;
    }

    public double calculateArea() {
        double area = a * b;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = 2 * (a + b);
        return perimeter;
    }

    public String getAreaFormula() {
        return "axb";
    }

    public String getPerimeterFormula() {
        return "2a + 2b";
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public String toString() {
        return "Rectangle, a = " + a.toString() + ", b = " + b.toString();
    }
}
