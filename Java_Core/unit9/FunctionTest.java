package unit9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest {

    public static void main(String[] args) {
        Function4();
    }

    private static void Function1() {
        List<Student> students = new ArrayList<>();

        Consumer<Student> c = (Student student) -> {
            if (student.getAge() >= 23) {
                students.add(student);
            }
        };
        c.accept(new Student("Nguyen A", 34));
        System.out.println(students.get(0));
    }

    private static void Function2() {
        String[] names = {"Tran Van A", "Nguyen Thi B", "Nguyen Thi C", "Ta Van C"};
        Integer[] ages = {23, 45, 12, 67};
        IntStream intStream = IntStream.rangeClosed(0, names.length - 1);
        Stream<Student> stream = intStream.mapToObj(value ->
                new Student(names[value], ages[value]));

        Consumer<Student> c = (Student student) -> {
            System.out.println(student);
        };
        stream.forEach(c);
    }

    private static void Function3() {
        String[] names = {"Tran Van A", "Nguyen Thi B", "Nguyen Thi C", "Ta Van C"};
        Integer[] ages = {23, 45, 12, 67};
        IntStream intStream = IntStream.rangeClosed(0, names.length - 1);
        Stream<Student> stream = intStream.mapToObj(value ->
                new Student(names[value], ages[value]));
        Consumer<Student> c = (Student student) -> {
            System.out.println(student);
        };
        Function<Student, String> jsonToFunction = (Student student) -> {
            StringBuilder builder = new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid: ").append(student.getId()).append("\n");
            builder.append("\tname: ").append(student.getName()).append("\n");
            builder.append("\tage: ").append(student.getAge()).append("\n");
            builder.append("}");
            return builder.toString();
        };
        c = (Student student) -> {
            System.out.println(jsonToFunction.apply(student));
        };
        stream.forEach(c);
    }

    private static void Function4() {
        String[] names = {"Tran Van A", "Nguyen Thi B", "Nguyen Thi C", "Ta Van C"};
        Integer[] ages = {23, 45, 12, 67};
        IntStream intStream = IntStream.rangeClosed(0, names.length - 1);
        Stream<Student> stream = intStream.mapToObj(value ->
                new Student(names[value], ages[value]));
        Consumer<Student> c = (Student student) -> {
            System.out.println(student);
        };
        Predicate<Student> predicate = (Student student) ->{
          return student.getAge() > 30;
        };
        Stream<Student> older = stream.filter(predicate);
        older.forEach(c);
    }
}
