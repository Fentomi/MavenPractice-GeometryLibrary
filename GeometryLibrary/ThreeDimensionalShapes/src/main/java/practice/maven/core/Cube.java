package practice.maven.core;

/**
 * Класс, представляющий куб.
 */
public class Cube implements Shape3D {
  private final double side;

  /**
   * Конструктор куба.
   * @param side длина ребра (должна быть > 0)
   * @throws IllegalArgumentException если side <= 0
   */
  public Cube(double side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Длина ребра должна быть положительной.");
    }
    this.side = side;
  }

  @Override
  public double getVolume() {
    return side * side * side;
  }

  @Override
  public double getSurfaceArea() {
    return 6 * side * side;
  }

  public double getSide() {
    return side;
  }

  @Override
  public String toString() {
    return String.format("Cube {side=%.2f, volume=%.2f, surface=%.2f}",
        side, getVolume(), getSurfaceArea());
  }
}
