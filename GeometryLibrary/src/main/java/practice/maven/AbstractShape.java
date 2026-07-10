package practice.maven;

public abstract class AbstractShape implements Shape {
  @Override
  public String toString() {
    return String.format("%s {area=%.2f, perimeter=%.2f}",
        this.getClass().getSimpleName(), getArea(), getPerimeter());
  }
}
