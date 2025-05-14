package ch1;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Durations {
    public static void main(String[] args) {
        Duration d1 = Duration.of(5, ChronoUnit.DAYS);
        System.out.println(d1);

        Duration d2 = Duration.ofHours(5);
        System.out.println(d2);

        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.of(15, 0);
        LocalTime lt3 = LocalTime.of(7, 0);
        Duration d3 = Duration.between(lt1, lt2);
        Duration d4 = Duration.between(lt1, lt3);
        System.out.println(d3);
        System.out.println(d4);
    }
}
