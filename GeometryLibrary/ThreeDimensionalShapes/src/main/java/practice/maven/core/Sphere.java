package practice.maven.core;

/**
 * Класс, представляющий сферу.
 */
public class Sphere implements Shape3D {
  private final double radius;

  /**
   * Конструктор сферы.
   * @param radius радиус (должен быть > 0)
   * @throws IllegalArgumentException если radius <= 0
   */
  public Sphere(double radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("Радиус должен быть положительным.");
    }
    this.radius = radius;
  }

  @Override
  public double getVolume() {
    return (4.0 / 3.0) * Math.PI * radius * radius * radius;
  }

  @Override
  public double getSurfaceArea() {
    return 4 * Math.PI * radius * radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return String.format("Sphere {radius=%.2f, volume=%.2f, surface=%.2f}",
        radius, getVolume(), getSurfaceArea());
  }
}
