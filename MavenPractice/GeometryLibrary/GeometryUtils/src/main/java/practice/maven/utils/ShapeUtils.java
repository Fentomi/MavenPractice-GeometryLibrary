package practice.maven.utils;

import practice.maven.core.Shape;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Утилитарный класс для работы с геометрическими фигурами.
 */
public final class ShapeUtils {

  private ShapeUtils() { } // запрет создания экземпляров

  /**
   * Вычисляет суммарную площадь всех фигур в коллекции.
   * @param shapes коллекция фигур
   * @return сумма площадей
   */
  public static double totalArea(Collection<? extends Shape> shapes) {
    return shapes.stream().mapToDouble(Shape::getArea).sum();
  }

  /**
   * Вычисляет суммарный периметр всех фигур.
   * @param shapes коллекция фигур
   * @return сумма периметров
   */
  public static double totalPerimeter(Collection<? extends Shape> shapes) {
    return shapes.stream().mapToDouble(Shape::getPerimeter).sum();
  }

  /**
   * Находит фигуру с максимальной площадью.
   * @param shapes коллекция фигур (не пустая)
   * @return фигура с наибольшей площадью
   * @throws IllegalArgumentException если коллекция пуста
   */
  public static Shape maxArea(Collection<? extends Shape> shapes) {
    return shapes.stream()
        .max(Comparator.comparingDouble(Shape::getArea))
        .orElseThrow(() -> new IllegalArgumentException("Collection is empty"));
  }

  /**
   * Возвращает строковое представление списка фигур.
   */
  public static String toString(Collection<? extends Shape> shapes) {
    return shapes.stream()
        .map(Shape::toString)
        .collect(Collectors.joining("\n", "[\n", "\n]"));
  }

  /**
   * Вычисляет среднюю площадь фигур.
   */
  public static double averageArea(Collection<? extends Shape> shapes) {
    return shapes.isEmpty() ? 0 : totalArea(shapes) / shapes.size();
  }

  /**
   * Находит фигуру с минимальной площадью.
   */
  public static Shape minArea(Collection<? extends Shape> shapes) {
    return shapes.stream()
        .min(Comparator.comparingDouble(Shape::getArea))
        .orElseThrow(() -> new IllegalArgumentException("Collection is empty"));
  }

  /**
   * Группирует фигуры по их классу (типу).
   * @return Map<Class<?>, List<Shape>>, где ключ – класс фигуры (Circle.class, Rectangle.class, ...)
   */
  public static Map<Class<?>, List<Shape>> groupByType(Collection<? extends Shape> shapes) {
    return shapes.stream().collect(Collectors.groupingBy(Shape::getClass));
  }

  /**
   * Сортирует фигуры по возрастанию площади.
   */
  public static List<Shape> sortByArea(Collection<? extends Shape> shapes) {
    return shapes.stream()
        .sorted(Comparator.comparingDouble(Shape::getArea))
        .collect(Collectors.toList());
  }

  /**
   * Проверяет, есть ли в коллекции фигура с площадью больше заданного порога.
   */
  public static boolean hasAreaGreaterThan(Collection<? extends Shape> shapes, double threshold) {
    return shapes.stream().anyMatch(s -> s.getArea() > threshold);
  }

  /**
   * Возвращает сумму площадей фигур, удовлетворяющих предикату.
   */
  public static double totalAreaFiltered(Collection<? extends Shape> shapes,
                                         java.util.function.Predicate<? super Shape> predicate) {
    return shapes.stream().filter(predicate).mapToDouble(Shape::getArea).sum();
  }
}
