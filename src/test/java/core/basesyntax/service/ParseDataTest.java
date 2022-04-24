package core.basesyntax.service;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ParseDataTest {
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final String HEADER = "type,fruit,quantity,date";
    public final static String correctLine = "s,apple,200,2020-10-30";
    public final static String correctLine2 = "s,apple,2,2020-10-30";
    public final static String incorrectLine = "Hello world!";
    public final static String incorrectLine2 = "n,apple,200,2020-10-30";
    public final static String incorrectLine3 = "s,apple,200,2020-20-30";

    @Test
    public void recordParserServiceTestOk(){
        LocalDate date = LocalDate.parse("2020-10-30", YYYY_MM_DD);

        List<String> stringList = new ArrayList<>();
        stringList.add(HEADER);
        stringList.add(correctLine);
        stringList.add(correctLine2);

        ParseData record = new ParseData();
        List<Record> records = record.parseRecords(stringList);

        Assert.assertEquals(2, records.size());
        Assert.assertEquals(200, records.get(0).getQuantity());
        Assert.assertEquals("apple", records.get(0).getName());
        Assert.assertEquals(date, records.get(0).getDate());
    }

    @Test(expected = RuntimeException.class)
    public void recordParserServiceTestNoMatchesInputLine(){
        List<String> stringList = new ArrayList<>();
        stringList.add(incorrectLine);
        ParseData recordParserService = new ParseData();
        recordParserService.parseRecords(stringList);
    }

    @Test(expected = RuntimeException.class)
    public void recordParserServiceTestIncorrectType(){
        List<String> stringList = new ArrayList<>();
        stringList.add(incorrectLine2);
        ParseData recordParserService = new ParseData();
        recordParserService.parseRecords(stringList);
    }

    @Test
    public void recordParserServiceTestIncorrectDate(){
        List<String> stringList = new ArrayList<>();
        stringList.add(HEADER);
        stringList.add(incorrectLine3);
        ParseData recordParserService = new ParseData();
        try {
            recordParserService.parseRecords(stringList);
        } catch (DateTimeParseException e) {
            Assert.assertEquals("Text '2020-20-30' could not be parsed:" +
                    " Invalid value for MonthOfYear (valid values 1 - 12): 20", e.getMessage());
        }
    }

}
