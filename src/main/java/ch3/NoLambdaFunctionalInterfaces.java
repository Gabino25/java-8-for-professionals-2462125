package ch3;

import java.util.function.Predicate;

public class NoLambdaFunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("M");
            }
        };

        System.out.println(predicate.test("Maaike"));
        System.out.println(predicate.test("Laila"));


        TestMultipleMethods testMultipleMethods = new TestMultipleMethods() {
            @Override
            public void method1() {
                System.out.println("Method 1");
            }

            @Override
            public void method2() {
                System.out.println("Method 2");
            }

            @Override
            public void method3() {
                System.out.println("Method 3");
            }
        };

        testMultipleMethods.method1();
        testMultipleMethods.method2();
        testMultipleMethods.method3();




    }
}
