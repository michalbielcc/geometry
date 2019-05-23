package com.codecool.java.geometry.shapes;


public class EquilateralTriangle extends Triangle {


    private Float a;


    public EquilateralTriangle(float a) {
        super(a, a, a);
        this.a = a;
    }
    @Override
    public String getPerimeterFormula() {
        return "3a";
    }

    @Override
    public String toString() {
        return "Equilateral Triangle, a = " + a.toString();
    }
}
