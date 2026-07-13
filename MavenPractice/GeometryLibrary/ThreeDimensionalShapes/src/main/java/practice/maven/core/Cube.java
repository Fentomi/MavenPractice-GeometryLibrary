package practice.maven.core;

/**
 * Класс, представляющий куб.
 */
public class Cube implements Shape3D {
  private final double side;

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

  /**
   * Вычисляет длину пространственной диагонали куба.
   * @return длина диагонали = side * √3
   */
  public double getDiagonal() {
    return side * Math.sqrt(3);
  }

  @Override
  public String toString() {
    return String.format("Cube {side=%.2f, volume=%.2f, surface=%.2f, diagonal=%.2f}",
        side, getVolume(), getSurfaceArea(), getDiagonal());
  }
}