package app.service.impl;

import app.model.Fruit;
import app.service.FruitParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FruitParserImplementsTest {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static List<List<String>> testValue;
    private static FruitParser parserImplements;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeClass
    public static void start() {
        parserImplements = new FruitParserImplements();
        testValue = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add(SUPPLY);
        firstRow.add("banana");
        firstRow.add(String.valueOf(100));
        firstRow.add("2020-10-17");
        testValue.add(firstRow);
        List<String> secondRow = new ArrayList<>();
        secondRow.add(BUY);
        secondRow.add("banana");
        secondRow.add(String.valueOf(13));
        secondRow.add("2020-10-15");
        testValue.add(secondRow);
        List<String> thirdRow = new ArrayList<>();
        thirdRow.add(RETURN);
        thirdRow.add("banana");
        thirdRow.add(String.valueOf(10));
        thirdRow.add("xxxx-10-17");
        testValue.add(thirdRow);
    }

    @Test
    public void fruitParserOk() {
        Fruit testFirstFruit = new Fruit("banana", 100,
                LocalDate.parse("2020-10-17", formatter));
        Fruit testSecondFruit = new Fruit("banana", 13,
                LocalDate.parse("2020-10-15", formatter));
        Fruit firstResult = parserImplements.parse(testValue.get(0));
        Fruit secondResult = parserImplements.parse(testValue.get(1));
        Assert.assertEquals(firstResult, testFirstFruit);
        Assert.assertEquals(secondResult, testSecondFruit);
    }

    @Test(expected = RuntimeException.class)
    public void exception() {
        Fruit testSecondFruit = parserImplements.parse(testValue.get(2));
    }
}