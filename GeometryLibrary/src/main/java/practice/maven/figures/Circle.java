package practice.maven.figures;

import practice.maven.AbstractShape;

public class Circle extends AbstractShape {
  private final double radius;

  /**
   * Конструктор круга.
   * @param radius радиус круга (должен быть > 0)
   * @throws IllegalArgumentException если радиус <= 0
   */
  public Circle(double radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("Радиус должен быть положительным числом.");
    }
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  public double getRadius() {
    return radius;
  }
}