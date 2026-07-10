package practice.maven;

import practice.maven.core.Shape;
import practice.maven.utils.ShapeFactory;
import practice.maven.utils.ShapeUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    try {
      // 1. Создаём фигуры через фабрику (из модуля Utils)
      Shape circle = ShapeFactory.createCircle(5);
      Shape rectangle = ShapeFactory.createRectangle(4, 7);
      Shape triangle = ShapeFactory.createTriangle(3, 4, 5);

      // 2. Помещаем их в список
      List<Shape> shapes = Arrays.asList(circle, rectangle, triangle);

      // 3. Выводим все фигуры (используем метод toString из ShapeUtils)
      System.out.println("Все фигуры:");
      System.out.println(ShapeUtils.toString(shapes));

      // 4. Вычисляем и выводим суммарную площадь и периметр
      System.out.printf("Суммарная площадь: %.2f%n", ShapeUtils.totalArea(shapes));
      System.out.printf("Суммарный периметр: %.2f%n", ShapeUtils.totalPerimeter(shapes));

      // 5. Находим фигуру с максимальной площадью
      Shape maxShape = ShapeUtils.maxArea(shapes);
      System.out.println("Фигура с максимальной площадью: " + maxShape);

      // 6. Фильтрация: оставляем только круги
      List<Shape> circles = ShapeUtils.filter(shapes, s -> s.getClass().getSimpleName().equals("Circle"));
      System.out.println("Только круги: " + circles);

    } catch (IllegalArgumentException e) {
      System.err.println("Ошибка: " + e.getMessage());
    }
  }
}