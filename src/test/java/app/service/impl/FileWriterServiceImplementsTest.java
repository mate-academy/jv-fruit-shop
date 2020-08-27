package app.service.impl;

import app.model.Fruit;
import app.service.FileReadService;
import app.service.FileWriterService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriterServiceImplementsTest {
    private static List<Fruit> testFruits;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String RESULT_PATH = "src/main/java/resources/result.csv";
    private static FileWriterService fileWriterService;
    private static FileReadService fileReadService;

    @BeforeClass
    public static void start() {
        fileWriterService = new FileWriterServiceImplements();
        fileReadService = new FileReadServiceImplements();
        Fruit firstFruit = new Fruit("banana", 10, LocalDate.parse("2020-08-26", FORMATTER));
        Fruit secondFruit = new Fruit("orange", 10, LocalDate.parse("2020-08-24", FORMATTER));
        Fruit thirdFruit = new Fruit("orange", 10, LocalDate.parse("2020-08-22", FORMATTER));
        testFruits = new ArrayList<>();
        testFruits.add(firstFruit);
        testFruits.add(secondFruit);
        testFruits.add(thirdFruit);
    }

    @Test
    public void fileWriterOk() {
        fileWriterService.writeData(testFruits);
        List<List<String>> allData = fileReadService.readFile(RESULT_PATH);
        int sizeFinalTestFruits = testFruits.stream()
                .collect(Collectors.groupingBy(Fruit::getName)).size();
        Assert.assertEquals(allData.size(), sizeFinalTestFruits);
    }

    @Test
    public void emptyListWriter() {
        fileWriterService.writeData(new ArrayList<>());
        List<List<String>> allData = fileReadService.readFile(RESULT_PATH);
        Assert.assertEquals(0, allData.size());
    }
}