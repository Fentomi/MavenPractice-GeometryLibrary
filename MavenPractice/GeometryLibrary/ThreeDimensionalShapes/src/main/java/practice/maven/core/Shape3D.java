package practice.maven.core;

/**
 * Интерфейс для всех трёхмерных геометрических фигур.
 */
public interface Shape3D {

  /**
   * Вычисляет объём фигуры.
   * @return объём как double
   */
  double getVolume();

  /**
   * Вычисляет площадь полной поверхности фигуры.
   * @return площадь поверхности как double
   */
  double getSurfaceArea();
}