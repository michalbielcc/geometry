package com.codecool.java.geometry.shapes;

public class Square extends Rectangle {


    private Float a;



    public Square(float a) {
        super(a, a);
        this.a = a;
    }

    public String getAreaFormula() {
        return "a^2";
    }

    public String getPerimeterFormula() {
        return "4a";
    }

    @Override
    public String toString() {
        return "Rectangle, a = " + a.toString();
    }
}
