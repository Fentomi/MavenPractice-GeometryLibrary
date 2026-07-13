package stream.pr1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CollectionMapping {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3, 4};
    Integer[] incremented = arrayMapping(numbers, e -> e + 2);
    System.out.println(Arrays.toString(incremented)); // [3, 4, 5, 6]

    String[] words = {"a", "b", "c"};
    String[] uppercased = arrayMapping(words, String::toUpperCase);
    System.out.println(Arrays.toString(uppercased)); // [A, B, C]
  }

  @SuppressWarnings("unchecked")
  public static <T> T[] arrayMapping(T[] array, Function<T> func) {
    return Arrays.stream(array)
        .map(func::apply)
        .toArray(size -> (T[]) Array.newInstance(array.getClass().getComponentType(), size));
  }
}