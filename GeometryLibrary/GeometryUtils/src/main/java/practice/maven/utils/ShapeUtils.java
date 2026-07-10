package practice.maven.utils;

import practice.maven.core.Shape;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
   * Фильтрует фигуры по условию (предикату).
   * @param shapes коллекция фигур
   * @param predicate условие, которому должна удовлетворять фигура
   * @return список фигур, удовлетворяющих условию
   */
  public static List<Shape> filter(Collection<? extends Shape> shapes,
                                   java.util.function.Predicate<? super Shape> predicate) {
    return shapes.stream().filter(predicate).collect(Collectors.toList());
  }

  /**
   * Возвращает строковое представление списка фигур.
   */
  public static String toString(Collection<? extends Shape> shapes) {
    return shapes.stream()
        .map(Shape::toString)
        .collect(Collectors.joining("\n", "[\n", "\n]"));
  }
}
