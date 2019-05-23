package com.codecool.java.geometry.shapes;
import static java.lang.Math.sqrt;


public class RegularPentagon extends Shape {


    private Float a;


    public RegularPentagon(float a) {
        checkIfArgsGreaterThanZero(a);
        this.a = a;
    }

    public double calculateArea() {
        double area = (a * a * sqrt(5 * (5 + 2 * sqrt(5))))/4;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = 5 * a;
        return perimeter;
    }

    public String getAreaFormula() {
        return "(a^2 sqrt(5(5+2sqrt(5))))/4";
    }

    public String getPerimeterFormula() {
        return "5a";
    }

    public float getA() {
        return a;
    }

    public String toString() {
        return "Regular Pentagon, a = " + a.toString();
    }
}
