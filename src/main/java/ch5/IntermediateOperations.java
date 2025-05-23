package ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        String[] names = { "Adnane", "Mary", "Laila", "Dennis", "Nitin", "Sairam", "Maaike" };
        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        // filter
        nameList.stream().filter(s -> s.startsWith("M")).forEach(s -> System.out.println(s));


        Function<String,String> mapFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + " student";
            }
        };
        // map
        // nameList.stream().map(s -> s + " student").forEach(s -> System.out.println(s));
        nameList.stream().map(mapFunction).forEach(s -> System.out.println(s));

        // flatmap
        String[][] names2d = { names, names };

        Function<String[],Stream<String>> flatMapFunction = new Function<String[], Stream<String>>() {
            @Override
            public Stream<String> apply(String[] strings) {
                return Stream.of(strings);
            }
        };

        IntFunction<String[]> intFunction = new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        };

//        String[] names1d = Stream.of(names2d)
//                .flatMap(arr -> Stream.of(arr))
//                .peek(s -> System.out.println("peek:" + s))
//                .toArray(size -> new String[size]);

        String[] names1d = Stream.of(names2d)
                .flatMap(flatMapFunction)
                .peek(s -> System.out.println("peek:" + s))
                .toArray(intFunction);

//        for(String name : names1d) {
//            System.out.println("1d arr: " + name);
//        }

        // skip and limit
        Arrays.stream(names1d).skip(1).forEach(s -> System.out.println("skip: " + s));
        Arrays.stream(names1d).limit(1).forEach(s -> System.out.println("limit: " + s));
        Arrays.stream(names1d).skip(3).limit(5).forEach(s -> System.out.println("skip and limit: " + s));

        // distinct
        long nrOfDistinctValues = Arrays.stream(names1d).distinct().count();
        System.out.println("distinct values: " + nrOfDistinctValues);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        // sorted
        Arrays.stream(names1d).sorted().forEach(s -> System.out.println("sorted asc: " + s));
        Arrays.stream(names1d).sorted(comparator).forEach(s -> System.out.println("sorted desc: " + s));

    }
}
