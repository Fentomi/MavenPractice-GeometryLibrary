package practice.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamCollectMapAdvancedExample {
  public static void main(String[] args) {

    //1. Создайте коллекцию студентов, где каждый студент содержит информацию о предметах,
    //   которые он изучает, и его оценках по этим предметам.
    List<Student> students = Arrays.asList(
        new Student("Student1", new HashMap<String, Integer>() {{
          put("Math", 90);
          put("Physics", 85);
        }}),
        new Student("Student2", new HashMap<String, Integer>() {{
          put("Math", 95);
          put("Physics", 88);
        }}),
        new Student("Student3", new HashMap<String, Integer>() {{
          put("Math", 88);
          put("Chemistry", 92);
        }}),
        new Student("Student4", new HashMap<String, Integer>() {{
          put("Physics", 78);
          put("Chemistry", 85);
        }})
    );

    // 2. Используйте Parallel Stream для обработки данных и создания Map, где ключ - предмет,
    //    а значение - средняя оценка по всем студентам.
    Map<String, Double> averageBySubject = students.parallelStream()
        .flatMap(student -> student.getGrades().entrySet().stream())
        .collect(Collectors.groupingBy(
            Map.Entry::getKey,
            Collectors.averagingDouble(Map.Entry::getValue)
        ));

    // 3. Выведите результат: общую Map с средними оценками по всем предметам.
    averageBySubject.forEach((subject, avg) -> System.out.printf("%s -> %.2f%n", subject, avg));
  }
}