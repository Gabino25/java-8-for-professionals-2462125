package ch1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Consumer;

public class ZonesAndDates {
    public static void main(String[] args) {
//        for(String zoneId : ZoneId.getAvailableZoneIds()) {
//            ZoneId zoneId1 = ZoneId.of(zoneId);
//            String zoneIdDisplayname = zoneId1.getDisplayName(TextStyle.FULL, Locale.US);
//            System.out.println(zoneId + " : " + zoneIdDisplayname);
//        }

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String zoneId) {
                ZoneId zoneId1 = ZoneId.of(zoneId);
               String zoneIdDisplayname = zoneId1.getDisplayName(TextStyle.FULL, Locale.US);
               System.out.println(zoneId + " : " + zoneIdDisplayname);
            }
        } ;

        ZoneId.getAvailableZoneIds().stream().forEach(consumer);

        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt, zoneId);
        System.out.println(ldt);
        System.out.println(zdt1);

        ZonedDateTime zdt2 = ldt.atZone(zoneId);
        ZonedDateTime zdt3 = ZonedDateTime.now();
        System.out.println(zdt3.getZone());
    }
}
