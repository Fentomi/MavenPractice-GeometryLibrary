package practice.maven;

import practice.maven.core.Shape;
import practice.maven.utils.ShapeFactory;
import practice.maven.utils.ShapeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    // Создаём фигуры
    Shape circle = ShapeFactory.createCircle(5);
    Shape rectangle = ShapeFactory.createRectangle(4, 7);
    Shape triangle = ShapeFactory.createTriangle(3, 4, 5);
    Shape bigCircle = ShapeFactory.createCircle(10);

    List<Shape> shapes = Arrays.asList(circle, rectangle, triangle, bigCircle);

    // 1. Вывод всех фигур
    System.out.println("=== Все фигуры ===");
    System.out.println(ShapeUtils.toString(shapes));

    // 2. Суммарная площадь и периметр
    System.out.printf("Суммарная площадь: %.2f%n", ShapeUtils.totalArea(shapes));
    System.out.printf("Суммарный периметр: %.2f%n", ShapeUtils.totalPerimeter(shapes));

    // 3. Средняя площадь
    System.out.printf("Средняя площадь: %.2f%n", ShapeUtils.averageArea(shapes));

    // 4. Фигура с минимальной и максимальной площадью
    System.out.println("Минимальная площадь: " + ShapeUtils.minArea(shapes));
    System.out.println("Максимальная площадь: " + ShapeUtils.maxArea(shapes));

    // 5. Группировка по типу
    Map<Class<?>, List<Shape>> grouped = ShapeUtils.groupByType(shapes);
    System.out.println("Группировка по типу:");
    grouped.forEach((clazz, list) ->
        System.out.println("  " + clazz.getSimpleName() + ": " + list.size() + " шт."));

    // 6. Сортировка по площади
    System.out.println("Сортировка по площади (возрастание):");
    ShapeUtils.sortByArea(shapes).forEach(System.out::println);

    // 7. Проверка наличия фигуры с площадью > 100
    boolean hasLarge = ShapeUtils.hasAreaGreaterThan(shapes, 100);
    System.out.println("Есть фигура с площадью > 100? " + hasLarge);

    // 8. Суммарная площадь только кругов
    double totalCircleArea = ShapeUtils.totalAreaFiltered(shapes, s -> s.getClass().getSimpleName().equals("Circle"));
    System.out.printf("Суммарная площадь кругов: %.2f%n", totalCircleArea);
  }
}