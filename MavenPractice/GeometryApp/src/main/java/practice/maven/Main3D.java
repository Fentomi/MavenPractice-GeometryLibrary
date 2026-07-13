package practice.maven;

import practice.maven.core.Cube;
import practice.maven.core.Sphere;
import practice.maven.core.Cylinder;
import practice.maven.core.Cone;
import practice.maven.core.Shape3D;

import java.util.Arrays;
import java.util.List;

public class Main3D {
  public static void main(String[] args) {
    List<Shape3D> shapes = Arrays.asList(
        new Cube(3),
        new Sphere(2),
        new Cylinder(2, 5),
        new Cone(3, 4)
    );

    System.out.println("Трёхмерные фигуры:");
    shapes.forEach(System.out::println);
  }
}