package practice.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOfElements {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 12);
    System.out.println(countOfElements(list));
  }

  public static <T> Map<String, Integer> countOfElements(Collection<T> collection) {
    return collection.stream().collect(Collectors.toMap(Object::toString, e -> 1, Integer::sum));
  }
}
