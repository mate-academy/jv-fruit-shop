package app.service.impl;

import app.model.SupplyFruitBatch;
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
    private static List<SupplyFruitBatch> testFruits;
    public static final String RESULT_PATH = "src/main/java/resources/result.csv";
    private static FileWriterService fileWriterService;
    private static FileReadService fileReadService;

    @BeforeClass
    public static void start() {
        fileWriterService = new FileWriterServiceImplementation();
        fileReadService = new FileReadServiceImplementation();
        SupplyFruitBatch firstFruit = new SupplyFruitBatch("banana", 10, LocalDate.parse("2020-08-26"));
        SupplyFruitBatch secondFruit = new SupplyFruitBatch("orange", 10, LocalDate.parse("2020-08-24"));
        SupplyFruitBatch thirdFruit = new SupplyFruitBatch("orange", 10, LocalDate.parse("2020-08-22"));
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
                .collect(Collectors.groupingBy(SupplyFruitBatch::getFruitName)).size();
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
