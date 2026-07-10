package practice.maven.figures;

import practice.maven.AbstractShape;

public class Rectangle extends AbstractShape {
  private final double width;
  private final double height;

  /**
   * Конструктор прямоугольника.
   * @param width  ширина (должна быть > 0)
   * @param height высота (должна быть > 0)
   * @throws IllegalArgumentException если ширина или высота <= 0
   */
  public Rectangle(double width, double height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Ширина и высота должны быть положительными числами.");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  @Override
  public double getPerimeter() {
    return 2 * (width + height);
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }
}
