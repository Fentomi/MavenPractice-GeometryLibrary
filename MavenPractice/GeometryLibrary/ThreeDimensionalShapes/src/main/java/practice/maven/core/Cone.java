package practice.maven.core;

/**
 * Класс, представляющий прямой круговой конус.
 */
public class Cone implements Shape3D {
  private final double radius;
  private final double height;

  /**
   * Конструктор конуса.
   * @param radius радиус основания (должен быть > 0)
   * @param height высота (должна быть > 0)
   * @throws IllegalArgumentException если radius или height <= 0
   */
  public Cone(double radius, double height) {
    if (radius <= 0 || height <= 0) {
      throw new IllegalArgumentException("Радиус и высота должны быть положительными.");
    }
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double getVolume() {
    return (1.0 / 3.0) * Math.PI * radius * radius * height;
  }

  @Override
  public double getSurfaceArea() {
    double slant = Math.sqrt(radius * radius + height * height);
    return Math.PI * radius * (radius + slant); // площадь основания + боковая
  }

  public double getRadius() {
    return radius;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return String.format("Cone {radius=%.2f, height=%.2f, volume=%.2f, surface=%.2f}",
        radius, height, getVolume(), getSurfaceArea());
  }
}
