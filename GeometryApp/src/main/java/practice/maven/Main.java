package practice.maven;

import practice.maven.figures.*;

public class Main {
  public static void main(String[] args) {
    try {
      Circle circle = new Circle(5);
      System.out.println(circle);

      Rectangle rectangle = new Rectangle(4, 7);
      System.out.println(rectangle);

      Triangle triangle = new Triangle(3, 4, 5);
      System.out.println(triangle);

      // Попытка создать недопустимый треугольник (вызовет исключение)
      // Triangle invalid = new Triangle(1, 1, 3);
    } catch (IllegalArgumentException e) {
      System.err.println("Ошибка: " + e.getMessage());
    }
  }
}