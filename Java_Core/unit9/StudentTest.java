package unit9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tran Van A", 23));
        students.add(new Student("Nguyen Thi B", 34));
        students.add(new Student("Nguyen Thi C", 15));
        students.add(new Student("Ta Van D", 46));

        // Example 1
//        Filter<Student> older = student -> student.getAge() >= 30;
//        List<Student> filterd = filter(students, older);
//
//        for (Student student : filterd) {
//            System.out.println(student);
//        }

        // Example 2
//        Stream<Student> stream = students.stream()
//                .filter(student -> student.getAge() >= 30);
//        stream.forEach(student -> System.out.println(student));

        // Example 3
//        Collections.sort(students, (Student st1, Student st2) ->
//                    st1.getAge() - st2.getAge()
//                );
//        students.forEach(student -> System.out.println(student));

        // Example 4
//        Stream<Student> stream = students.stream().sorted(
//                (student1, student2) -> student1.getAge() - student2.getAge()
//        );
//        stream.forEach(student -> System.out.println(student));

        // Example 5
        Comparator<Student> comparator = (student1, student2) -> student1.getAge()-student2.getAge();
        Stream<Student> stream = students.stream().sorted(comparator);
        stream.forEach(student -> System.out.println(student));

        System.out.println("=> Max is " + students.stream().max(comparator));
        int sum = students.stream().mapToInt(Student::getAge).sum();
        System.out.println("=> Average of age is " + sum/students.size());

        students.parallelStream().forEach((it) -> System.out.println("=> " + Thread.currentThread().getName() + " Hello " + it.getName()));
    }

    public static List<Student> filter(List<Student> students, Filter<Student> pred) {
        List list = new ArrayList();
        for (Student student : students) {
            if (pred.valid(student)) {
                list.add(student);
            }
        }
        return list;
    }
}
