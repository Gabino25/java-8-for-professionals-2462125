package ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {
        String[] names = { "Adnane", "Mary", "Laila", "Dennis", "Nitin", "Sairam", "Maaike" };
        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        // create stream based on array
        Arrays.stream(names).forEach(name -> System.out.println(name));
        Optional<String> resultMin = Arrays.stream(names).min((a, b) -> a.compareTo(b));
        System.out.println(resultMin);

        // create stream based on collection
        Stream<String> listStream = nameList.stream();
        boolean resultListStream = nameList.stream().allMatch(name -> !name.isEmpty());
        System.out.println("all non empty:" + resultListStream);

        boolean allMatchStream = nameList.stream().allMatch(name -> name.startsWith("M"));
        System.out.println("all start with m: " + allMatchStream);

        List<String> listNamesLongerThan5 = nameList.stream().filter(name -> name.length() > 5).collect(Collectors.toList());
        System.out.println(listNamesLongerThan5);

        // create stream using generate method
        Stream<Integer> generateStream = Stream.generate(() -> 5);
        //Stream.generate(() -> 5).forEach(p->System.out.println(p));
        //forever stream
        //Optional<Integer> minGenerate = Stream.generate(() -> 5).min((a, b) -> a.compareTo(b));

        // create stream using iterate method
        Stream<Integer> iterateStream = Stream.iterate(1, x -> x + 2);
        //Stream.iterate(1, x -> x + 2).forEach(p->System.out.println(p));

        IntBinaryOperator intBinaryOperator = new IntBinaryOperator(){
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        };

        int[] ints = { 1, 2, 3, 4, 5 };
        int total = Arrays.stream(ints).reduce(30, (x, y) -> x + y);
        int total2 = Arrays.stream(ints).reduce(30, intBinaryOperator);
        System.out.println("total:"+total);
        System.out.println("total2:"+total);

    }
}
