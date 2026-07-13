package practice.maven.utils;

import practice.maven.core.Circle;
import practice.maven.core.Rectangle;
import practice.maven.core.Triangle;
import practice.maven.core.Shape;

public final class ShapeFactory {

  private ShapeFactory() { }

  public static Shape createCircle(double radius) {
    return new Circle(radius);
  }

  public static Shape createRectangle(double width, double height) {
    return new Rectangle(width, height);
  }

  public static Shape createTriangle(double a, double b, double c) {
    return new Triangle(a, b, c);
  }
}
