package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Program {
    static void main(String[] args) throws ParseException {

        System.out.println("\nINSTANTIATING");
        System.out.println("=============================================================================================================");
        instantiating();
        System.out.println("=============================================================================================================");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("FORMATTING");
        System.out.println("=============================================================================================================");
        formatting();
        System.out.println("=============================================================================================================");


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("OPERATING DATES");
        System.out.println("=============================================================================================================");
        operatingDates();
        System.out.println("=============================================================================================================");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("CLASS DATE");
        System.out.println("=============================================================================================================");
        classDate();
        System.out.println("=============================================================================================================");

    }

    public static void instantiating() {
        //Instantiating a local date (Machine GMT)
        LocalDate localDate1 = LocalDate.now();
        System.out.println("Local date without hour: " + localDate1);

        System.out.println("---------------------------------------------------");

        //Instantiating a local date time (Machine GMT)
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("Local date with hour: " + localDateTime1);

        System.out.println("---------------------------------------------------");

        //Instantiating a global date (UTC)
        Instant instant1 = Instant.now();
        System.out.println("Global date: " + instant1) ;

        System.out.println("---------------------------------------------------");

        //Instantiating a local date passing a string
        LocalDate localDate2 = LocalDate.parse("2026-03-30");
        System.out.println("Local date passing String: " + localDate2);

        System.out.println("---------------------------------------------------");

        //Instantiating a local date time passing a string
        LocalDateTime localDateTime2 = LocalDateTime.parse("2026-03-30T00:01:33");
        System.out.println("Local date time passing String: " + localDateTime2);

        System.out.println("---------------------------------------------------");

        //Instantiating a global date  passing a string
        Instant instant2 = Instant.parse("2026-03-30T01:33:26Z");
        System.out.println("Global date passing String: " + instant2);

        System.out.println("---------------------------------------------------");

        //Instantiating a global with a specific GMT date  passing a string
        Instant instant3 = Instant.parse("2026-03-30T01:33:26-03:00");
        System.out.println("Global date passing String with specific GMT: " + instant3);

        //In this case the output will be the date converted to the Zulu Time

        System.out.println("---------------------------------------------------");

        //Using DateTimeFormatter to instantiate a date with a pattern
        DateTimeFormatter dtm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate3 = LocalDate.parse("30/03/2026", dtm1);
        System.out.println("Local date with time formatter " + localDate3);

        System.out.println("---------------------------------------------------");

        //Using DateTimeFormatter to instantiate a date time with a pattern
        DateTimeFormatter dtm2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localDateTime3 = LocalDateTime.parse("30/03/2026 00:29", dtm2);
        System.out.println("Local date time with time formatter " + localDateTime3);

        System.out.println("---------------------------------------------------");

        //Instantiating a date passing the parameters one by one
        LocalDate localDate4 = LocalDate.of(2026, 3, 30);
        System.out.println("Local date parameters one by one: " + localDate4);

        System.out.println("---------------------------------------------------");

        //Instantiating a date time passing the parameters one by one
        LocalDateTime localDateTime4 = LocalDateTime.of(2026, 3, 30, 0, 32, 20);
        System.out.println("Local date time parameters one by one: " + localDateTime4);
    }

    public static void formatting() {

        //Outputting a local date with a pattern
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("2026-03-30");
        System.out.println("Local date with a pattern: " + localDate.format(dtf1));

        System.out.println("-------------------------------------------------------------------------");

        //Outputting a local date time with a pattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse("2026-03-30T00:53:23");
        System.out.println("Local date time with a pattern: " + localDateTime.format(dtf2));

        System.out.println("-------------------------------------------------------------------------");

        //Outputting a global date time with a pattern
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        Instant instant = Instant.parse("2026-03-30T00:53:23Z");
        System.out.println("Global date with a pattern: " + dtf3.format(instant));

    }

    public static void operatingDates() {

        //Converting global date to local date
        Instant instant = Instant.parse("2026-03-30T01:06:34Z");
        LocalDate localDate = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate2 = LocalDate.ofInstant(instant, ZoneId.of("Portugal"));
        System.out.println("Global date to local date (SYSTEM GMT): " + localDate);
        System.out.println("Global date to local date (SPECIFIC GMT): " + localDate2);

        System.out.println("-------------------------------------------------------------------------");

        //Converting global date to local date time
        Instant instant2 = Instant.parse("2026-12-19T01:06:34Z");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, ZoneId.of("Portugal"));
        System.out.println("Global date to local date time (SYSTEM GMT): " + localDateTime);
        System.out.println("Global date to local date time (SPECIFIC GMT): " + localDateTime2);

        System.out.println("-------------------------------------------------------------------------");

        //Getting day, year and month in a date
        LocalDate localDate3 = LocalDate.parse("2026-12-19");
        System.out.println("Day in the month: " + localDate3.getDayOfMonth());
        System.out.println("Month in the year: " + localDate3.getMonth());
        System.out.println("Year: " + localDate3.getYear());

        System.out.println("-------------------------------------------------------------------------");

        //Getting hour, minutes and seconds in a date time
        LocalDateTime localDateTime3 = LocalDateTime.parse("2026-12-19T23:43:21");
        System.out.println("Hour: " + localDateTime3.getHour());
        System.out.println("Minutes: " + localDateTime3.getMinute());
        System.out.println("Seconds: " + localDateTime3.getSecond());

        System.out.println("-------------------------------------------------------------------------");

        //Adding and removing days of a local date
        LocalDate localDate4 = LocalDate.parse("2026-11-10");
        LocalDate localDate4NextWeek = localDate4.plusDays(7);
        LocalDate localDate4pastWeek = localDate4.minusDays(7);
        System.out.println("Local date with day sum: " + localDate4NextWeek);
        System.out.println("Local date with day removed: " + localDate4pastWeek);

        System.out.println("-------------------------------------------------------------------------");

        //Adding and removing months of a local date time
        LocalDateTime localDateTime4 = LocalDateTime.parse("2026-11-10T01:53:25");
        LocalDateTime localDateTime4NextMonth = localDateTime4.plusMonths(2);
        LocalDateTime localDateTime4PastMonth = localDateTime4.minusMonths(2);
        System.out.println("Local date with month sum: " + localDateTime4NextMonth);
        System.out.println("Local date with month removed: " + localDateTime4PastMonth);

        System.out.println("-------------------------------------------------------------------------");

        //Adding and removing seconds of a global date
        Instant instant3 = Instant.parse("2026-08-12T12:53:45Z");
        Instant instant3NextSecond = instant3.plus(10, ChronoUnit.SECONDS);
        Instant instant3PastSecond = instant3.minus(10, ChronoUnit.SECONDS);
        System.out.println("Global date with second sum: " + instant3NextSecond);
        System.out.println("Global date with second removed: " + instant3PastSecond);

        System.out.println("-------------------------------------------------------------------------");

        //Manipulating duration between dates

        LocalDate localDate5 = LocalDate.parse("2025-12-19");
        LocalDate localDate6 = LocalDate.parse("2026-12-19");
        //Need to put at the start of the day
        Duration duration = Duration.between(localDate5.atStartOfDay(), localDate6.atStartOfDay());
        System.out.println("(Local Date) Duration in days between the dates: " + duration.toDays());

        LocalDateTime localDateTime5 = LocalDateTime.parse("2025-12-19T01:53:25");
        LocalDateTime localDateTime6 = LocalDateTime.parse("2026-12-19T01:53:25");
        Duration duration2 = Duration.between(localDateTime5, localDateTime6);
        System.out.println("(Local Date Time) Duration in days between the dates: " + duration2.toDays());


        Instant instant4 = Instant.parse("2026-08-12T12:53:45Z");
        Instant instant5 = Instant.parse("2028-08-12T12:53:45Z");
        Duration duration3 = Duration.between(instant4, instant5);
        System.out.println("(Global date) Duration in days between the dates: " + duration3.toDays());
    }

    public static void classDate() throws ParseException {

        //Using simple date formatter to a pattern without time
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse("30/03/2026");
        System.out.println("Local date with the java class: " + date);

        System.out.println("-------------------------------------------------------------------------");

        //Using simple date formatter to a pattern with time
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date2 = simpleDateFormat2.parse("30/03/2026 01:31:23");
        System.out.println("Local date time with the java class: " + date2);
        System.out.println("(Formatted) Local date time with the java class: " + simpleDateFormat2.format(date2));

        System.out.println("-------------------------------------------------------------------------");

        //Creating an instant time with the java class
        Date date3 = new Date();
        System.out.println("Date at this instant: " + date3);
        System.out.println("(Formatted) Date at this instant: " + simpleDateFormat2.format(date3));

        System.out.println("-------------------------------------------------------------------------");

        //Adding hours with calendar
        Date date4 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date4);
        calendar.add(Calendar.HOUR_OF_DAY, 4);
        date4 = calendar.getTime();
        System.out.println("Hour in moment with more four hours: " + date4);

        System.out.println("-------------------------------------------------------------------------");

        //Getting units of time by a date
        Date date5 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date5);
        int minutes = calendar2.get(Calendar.MINUTE);
        int hours = calendar2.get(Calendar.HOUR_OF_DAY);
        System.out.printf("Hours in day %d and minutes %d%n", hours, minutes);
    }
}