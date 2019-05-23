package com.codecool.java.geometry.shapes;
import static java.lang.Math.*;

public class Circle extends Shape {


    private Float r;


    public Circle(float r) {
        checkIfArgsGreaterThanZero(r);
        this.r = r;
    }

    public double calculateArea() {
        double area = PI * r * r; 
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = 2 * PI * r;
        return perimeter;
    }

    public String getAreaFormula() {
        return "π×r^2";
    }

    public String getPerimeterFormula() {
        return "2×π×r";
    }

    public Float getR() {
        return r;
    }

    public String toString() {
        return "Circle, r = " + r.toString();
    }
 }
