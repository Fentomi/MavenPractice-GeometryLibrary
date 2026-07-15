package stream.pr1;

@FunctionalInterface
interface Function<T> {
  T apply(T o);
}