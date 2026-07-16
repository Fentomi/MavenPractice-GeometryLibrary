package practice.streamapi.generatenumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
1. Группируйте заказы по продуктам.
2. Для каждого продукта найдите общую стоимость всех заказов.
3. Отсортируйте продукты по убыванию общей стоимости.
4. Выберите три самых дорогих продукта.
5. Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
*/

public class StreamCollectorsExample {
  public static void main(String[] args) {
    ArrayList<Order> orders = new ArrayList<>(Arrays.asList(
        new Order("Laptop", 1200.0),
        new Order("Smartphone", 800.0),
        new Order("Laptop", 1500.0),
        new Order("Tablet", 500.0),
        new Order("Smartphone", 900.0)
    ));

    System.out.println("  1. Группировка заказов по продуктам:");
    orders.stream()
        .collect(Collectors.groupingBy(Order::getProduct))
        .forEach((s, innerOrder) -> System.out.println(s + innerOrder));

    System.out.println("\n  2. Общая стоимость всех заказов:");
    orders.stream()
        .collect(Collectors.toMap(
            Order::getProduct,
            Order::getCost,
            Double::sum))
        .forEach((s, innerOrder) -> System.out.println(s + ": " + innerOrder));

    System.out.println("\n  3. Сортировка по убыванию общей стоимости:");
    orders.stream()
        .sorted((s1,s2) -> (int) (s2.getCost() - s1.getCost()))
        .forEach(System.out::println);

    System.out.println("\n  4. Три самых дорогих продукта:");
    orders.stream()
        .sorted((s1,s2) -> (int) (s2.getCost() - s1.getCost()))
        .limit(3)
        .forEach(System.out::println);

    System.out.println("\n  5. Список трех самых дорогих продуктов и их общая стоимость:");
    orders.stream()
        .collect(Collectors.groupingBy(
            Order::getProduct,
            Collectors.summingDouble(Order::getCost)))
        .entrySet().stream()
        .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
        .limit(3)
        .forEach(System.out::println);
  }
}