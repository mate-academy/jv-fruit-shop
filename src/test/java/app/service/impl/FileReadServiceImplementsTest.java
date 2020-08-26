package app.service.impl;

import app.service.FileReadService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FileReadServiceImplementsTest {
    private static FileReadService fileReadService;
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static List<List<String>> testValue;

    @BeforeClass
    public static void start() {
       fileReadService = new FileReadServiceImplements();
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
        thirdRow.add("2020-10-17");
        testValue.add(thirdRow);
        List<String> fourthRow = new ArrayList<>();
        fourthRow.add(SUPPLY);
        fourthRow.add("orange");
        fourthRow.add(String.valueOf(50));
        fourthRow.add("2020-10-01");
        testValue.add(fourthRow);
        List<String> fifthRow = new ArrayList<>();
        fifthRow.add(SUPPLY);
        fifthRow.add("orange");
        fifthRow.add(String.valueOf(80));
        fifthRow.add("2020-10-12");
        testValue.add(fifthRow);
        List<String> sixthRow = new ArrayList<>();
        sixthRow.add(BUY);
        sixthRow.add("orange");
        sixthRow.add(String.valueOf(60));
        sixthRow.add("2020-10-10");
        testValue.add(sixthRow);
        List<String> seventhRow = new ArrayList<>();
        seventhRow.add(RETURN);
        seventhRow.add("orange");
        seventhRow.add(String.valueOf(12));
        seventhRow.add("2020-10-10");
        testValue.add(seventhRow);
        List<String> eighthRow = new ArrayList<>();
        eighthRow.add(RETURN);
        eighthRow.add("orange");
        eighthRow.add(String.valueOf(100));
        eighthRow.add("2020-10-15");
        testValue.add(eighthRow);
        List<String> ninthRow = new ArrayList<>();
        ninthRow.add(BUY);
        ninthRow.add("orange");
        ninthRow.add(String.valueOf(120));
        ninthRow.add("2020-10-10");
        testValue.add(ninthRow);
    }

    @Test
    public void readFileOk() {
        List<List<String>> allData = fileReadService.readFile("C:\\Users\\38093\\Desktop"
                + "\\Mate academy" + "\\jv-fruit-shop_prod\\src\\test\\java\\resources\\test.csv");
        Assert.assertEquals(testValue, allData);
    }
}