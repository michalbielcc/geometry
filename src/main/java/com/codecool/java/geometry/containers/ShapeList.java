package com.codecool.java.geometry.containers;
import com.codecool.java.geometry.shapes.*;
import java.util.ArrayList;
import java.util.List;


public class ShapeList {

    private List<Shape> shapes;

    public ShapeList() {
        shapes = new ArrayList<Shape>();
    }
    
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Shape getShapeAt(int index) {
        return shapes.get(index);
    }

    private String generateHeaders() {
        List<Integer> collumnsWidth = getCollumnsWidth(shapes);
        collumnsWidth.add(0, 3);
        List<String> headers = new ArrayList<>();
        List<String> output = new ArrayList<>();
        headers.add("idx");
        headers.add("Class");
        headers.add("toString");
        headers.add("Perimeter");
        headers.add("Formula");
        headers.add("Area");
        headers.add("Formula");
        output.add("│");
        boolean flip = true;
        int repetitions = 0;
        for (int index = 0; index < headers.size(); index ++) {
            output.add(headers.get(index));
            if (collumnsWidth.get(index) > headers.get(index).length()) {
                repetitions = collumnsWidth.get(index) - headers.get(index).length();
                int shift = 1;
                while (repetitions > 0) {
                    if (flip == true) {
                        output.add(output.size() - shift, " ");
                    } else {
                        output.add(" ");
                    }
                    flip = !flip;
                    shift ++;
                    repetitions --;
                }
            }
            output.add("│");
        }
        output.add("\n");
        return String.join("", output);
    }

    public String getShapesTable() {
        List<String> table = new ArrayList<>();
        List<Integer> collumnsWidth = getCollumnsWidth(shapes);     
        String fieldSeparator = "│";
        Integer idx = 1;
        int counter = 1;
        String tableRowSeparator = generateTopMiddleBottomLine(collumnsWidth, 1);
        int separatorLimit = shapes.size() - 1;
        boolean flip = true;
        table.add(generateTopMiddleBottomLine(collumnsWidth, 0));
        table.add(generateHeaders());
        table.add(tableRowSeparator);
        for (Shape shape : shapes) {
            List<String> fields = generateRowFields(shape);
            table.add(fieldSeparator);
            table.add(idx.toString());
            while (counter < 3) {
                table.add(" ");
                counter ++;
            }
            table.add(fieldSeparator);
            counter = 1;
            idx ++;
            for (int index = 0; index < fields.size(); index ++) {
                table.add(fields.get(index));
                if (fields.get(index).length() < collumnsWidth.get(index)) {
                    int repetitions = collumnsWidth.get(index) - fields.get(index).length();
                    int shift = 1;
                while (repetitions > 0) {
                    if (flip == true) {
                        table.add(table.size() - shift, " ");
                    } else {
                        table.add(" ");
                    }
                    flip = !flip;
                    shift ++;
                    repetitions --;
                }
                }
                table.add(fieldSeparator);
            }
            table.add("\n");
            if (shapes.size() > 1 && separatorLimit > 0) {
                table.add(tableRowSeparator);
                separatorLimit --;
            }
        }
        table.add(generateTopMiddleBottomLine(collumnsWidth, 2));
        return String.join("", table);
    }

    private List<String> generateRowFields(Shape shape) {
        List<String> output = new ArrayList<>();
        output.add(shape.getClass().getSimpleName());
        output.add(shape.toString());
        String perimeter = String.format("%.2f", shape.calculatePerimeter());
        output.add(perimeter);
        output.add(shape.getPerimeterFormula());
        String area = String.format("%.2f", shape.calculateArea());
        output.add(area);
        output.add(shape.getAreaFormula());
        return output;
    }

    private List<Integer> getCollumnsWidth(List<Shape> shapes) {
        List<Integer> collumnsWidth = new ArrayList<>();
        collumnsWidth.add(5);
        collumnsWidth.add(8);
        collumnsWidth.add(9);
        collumnsWidth.add(7);
        collumnsWidth.add(4);
        collumnsWidth.add(7);
        for (Shape shape: shapes) {
            for (int index = 0; index < getShapeCollumnsWidth(shape).size(); index ++) {
                if (getShapeCollumnsWidth(shape).get(index) > collumnsWidth.get(index)) {
                    collumnsWidth.remove(index);
                    collumnsWidth.add(index, getShapeCollumnsWidth(shape).get(index));
                }
            }
        }
        return collumnsWidth;
    }

    private String generateTopMiddleBottomLine(List<Integer> collumnsWidth, int modifier) {
        List<String> output = new ArrayList<>();
        String start;
        String middle;
        String end;
        if (modifier == 0) {
            start = "┌";
            middle = "┬";
            end = "┐";
        } else if (modifier == 1) {
            start = "├";
            middle = "┼";
            end = "┤";
        } else {
            start = "└";
            middle = "┴";
            end = "┘";
            
        }
        output.add(start);
        output.add("───");
        output.add(middle);
        for (int index = 0; index < collumnsWidth.size(); index ++) {
            int repetitions = collumnsWidth.get(index);
            while (repetitions > 0) {
                output.add("─");
                repetitions --;
            }
            output.add(middle);
        }
        output.remove(output.size() - 1);
        output.add(end);
        output.add("\n");
        return String.join("", output);
    }

    private List<Integer> getShapeCollumnsWidth(Shape shape) {
        List<Integer> output = new ArrayList<>();
        output.add(shape.getClass().getSimpleName().length());
        output.add(shape.toString().length());
        String perimeter = String.format("%.2f", shape.calculatePerimeter());
        output.add(perimeter.length());
        String area = String.format("%.2f", shape.calculateArea());
        output.add(shape.getPerimeterFormula().length());
        output.add(area.length());
        output.add(shape.getAreaFormula().length());
        return output;
    }

    public Shape getLargestShapeByPerimeter() {
        Shape largestPerimeterShape = new EquilateralTriangle(1);
        double biggestPerimeter = 0;
        for (Shape shape : shapes) {
            double currentPerimeter = shape.calculatePerimeter();
            if (currentPerimeter > biggestPerimeter) {
                biggestPerimeter = currentPerimeter;
            }
        }
        for (Shape shape : shapes) {
            if (shape.calculatePerimeter() == biggestPerimeter) {
                return shape;
            }
        }
        return largestPerimeterShape;

    }

    public Shape getLargestShapeByArea() {
        Shape largestAreaShape = new EquilateralTriangle(1);
        double biggestArea = 0;
        for (Shape shape : shapes) {
            double currentArea = shape.calculateArea();
            if (currentArea > biggestArea) {
                biggestArea = currentArea;
            }
        }
        for (Shape shape : shapes) {
            if (shape.calculateArea() == biggestArea) {
                return shape;
            }
        }
        return largestAreaShape;
    }
}
