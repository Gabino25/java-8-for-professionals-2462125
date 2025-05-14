package ch1;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class Clocks {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        Instant instant = clock.instant();
        System.out.println(instant);

        Clock clock1 = Clock.systemUTC();
        System.out.println(clock1.instant());

        Clock clock2 = Clock.offset(clock, Duration.ofHours(10));
        System.out.println(clock2.instant());

        Clock clock3 = Clock.system(ZoneId.of("America/Los_Angeles"));
        Instant instant3 = clock3.instant();
        System.out.println("instant3:"+instant3);

        System.out.println(Clock.systemDefaultZone().instant());
        System.out.println(Clock.systemDefaultZone().instant().atZone(Clock.systemDefaultZone().getZone()));
        System.out.println(Clock.systemDefaultZone().instant().atZone(ZoneId.of("America/Los_Angeles")));
    }
}
