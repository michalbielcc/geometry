package com.codecool.java.geometry.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a abstract class representing geometrical shape.
 */
public abstract class Shape {
    /**
     * Calculates shape's area.
     * @return area of the shape
     */
    public abstract double calculateArea();

    /**
     * Calculates shape's perimeter.
     * @return perimeter of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * Returns formula for the area of the shape as a string.
     * @return area formula
     */
    public abstract String getAreaFormula();
    
    /**
     * Returns formula for the perimeter of the shape as a string.
     * @return perimeter formula
     */
    public abstract String getPerimeterFormula();

    /**
     * Check if any of args are not below 0.
     * Throws IllegalArgumentException if any of the parameters is 0 or less.
     * @param args
     * @return true if any of args are greater than 0
     */
    public static boolean checkIfArgsGreaterThanZero(float... args) throws IllegalArgumentException {
        for (Float arg : args) {
            if (arg <= 0) {
                throw new IllegalArgumentException("All arguments must be greater than 0"); 
            }
        }
        return true;
    }
}
