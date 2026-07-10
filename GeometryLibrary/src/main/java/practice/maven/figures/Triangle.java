package practice.maven.figures;

import practice.maven.AbstractShape;

public class Triangle extends AbstractShape {
  private final double sideA;
  private final double sideB;
  private final double sideC;

  /**
   * Конструктор треугольника.
   * @param sideA длина первой стороны
   * @param sideB длина второй стороны
   * @param sideC длина третьей стороны
   * @throws IllegalArgumentException если стороны не удовлетворяют неравенству треугольника
   *                                  или какая-либо сторона <= 0
   */
  public Triangle(double sideA, double sideB, double sideC) {
    if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
      throw new IllegalArgumentException("Все стороны должны быть положительными числами.");
    }
    if (!isTriangleValid(sideA, sideB, sideC)) {
      throw new IllegalArgumentException(
          "Стороны не образуют треугольник: не выполняется неравенство треугольника.");
    }
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  /**
   * Проверяет, выполняется ли неравенство треугольника для трёх сторон.
   */
  private static boolean isTriangleValid(double a, double b, double c) {
    return a + b > c && a + c > b && b + c > a;
  }

  @Override
  public double getArea() {
    double s = getPerimeter() / 2; // полупериметр
    return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
  }

  @Override
  public double getPerimeter() {
    return sideA + sideB + sideC;
  }
}