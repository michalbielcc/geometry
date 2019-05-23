package com.codecool.java.geometry.shapes;
import static java.lang.Math.*;


public class Triangle extends Shape {


    private Float a;
    private Float b;
    private Float c;


    public Triangle(float a, float b, float c) {
        checkIfArgsGreaterThanZero(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() {
        double s = (a + b + c) / 2;
        return sqrt(s * (s-a) *(s-b) * (s-c));
    }

    public double calculatePerimeter() {
        double perimeter = a + b + c;
        return perimeter;
    }

    public String getAreaFormula() {
        return "sqrt(s(s-a)(s-b)(s-c))";
    }

    public String getPerimeterFormula() {
        return "a + b + c";
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public String toString() {
        return "Triangle, a = " + a.toString() + ", b = " + b.toString() + ", c = " + c.toString();
    }
}
