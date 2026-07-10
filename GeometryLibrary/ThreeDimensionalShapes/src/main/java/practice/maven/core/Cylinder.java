package practice.maven.core;

/**
 * Класс, представляющий прямой круговой цилиндр.
 */
public class Cylinder implements Shape3D {
  private final double radius;
  private final double height;

  /**
   * Конструктор цилиндра.
   * @param radius радиус основания (должен быть > 0)
   * @param height высота (должна быть > 0)
   * @throws IllegalArgumentException если radius или height <= 0
   */
  public Cylinder(double radius, double height) {
    if (radius <= 0 || height <= 0) {
      throw new IllegalArgumentException("Радиус и высота должны быть положительными.");
    }
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double getVolume() {
    return Math.PI * radius * radius * height;
  }

  @Override
  public double getSurfaceArea() {
    // 2πr² + 2πrh
    return 2 * Math.PI * radius * (radius + height);
  }

  public double getRadius() {
    return radius;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return String.format("Cylinder {radius=%.2f, height=%.2f, volume=%.2f, surface=%.2f}",
        radius, height, getVolume(), getSurfaceArea());
  }
}
