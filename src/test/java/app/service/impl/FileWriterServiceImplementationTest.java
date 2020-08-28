package app.service.impl;

import app.model.SupplyFruit;
import app.service.FileReadService;
import app.service.FileWriterService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriterServiceImplementationTest {
    private static List<SupplyFruit> testFruits;
    public static final String RESULT_PATH = "src/main/java/resources/result.csv";
    private static FileWriterService fileWriterService;
    private static FileReadService fileReadService;

    @BeforeClass
    public static void start() {
        fileWriterService = new FileWriterServiceImplementation();
        fileReadService = new FileReadServiceImplementation();
        SupplyFruit firstFruit = new SupplyFruit("banana", 10, LocalDate.parse("2020-08-26"));
        SupplyFruit secondFruit = new SupplyFruit("orange", 10, LocalDate.parse("2020-08-24"));
        SupplyFruit thirdFruit = new SupplyFruit("orange", 10, LocalDate.parse("2020-08-22"));
        testFruits = new ArrayList<>();
        testFruits.add(firstFruit);
        testFruits.add(secondFruit);
        testFruits.add(thirdFruit);
    }

    @Test
    public void fileWriterOk() {
        fileWriterService.writeData(testFruits, RESULT_PATH);
        List<List<String>> allData = fileReadService.readFile(RESULT_PATH);
        int sizeFinalTestFruits = testFruits.stream()
                .collect(Collectors.groupingBy(SupplyFruit::getFruitName)).size();
        Assert.assertEquals(allData.size(), sizeFinalTestFruits);
    }

    @Test
    public void emptyListWriter() {
        fileWriterService.writeData(new ArrayList<>(), RESULT_PATH);
        List<List<String>> allData = fileReadService.readFile(RESULT_PATH);
        Assert.assertEquals(0, allData.size());
    }

    @Test(expected = RuntimeException.class)
    public void exceptionWriteTest() {
        fileWriterService.writeData(new ArrayList<>(), "");
    }
}
