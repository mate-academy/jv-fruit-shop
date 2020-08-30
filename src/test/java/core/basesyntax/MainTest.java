package core.basesyntax;

import core.basesyntax.exceptions.NoSuchProductException;
import core.basesyntax.exceptions.NotEnoughProductsException;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.WriterToFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainTest {
    public final static String FIRST_PATH = "src/test/java/resourses/test1.csv";
    public final static String SECOND_PATH = "src/test/java/resourses/test2.csv";
    public final static String THIRD_PATH = "src/test/java/resourses/test3.csv";
    public final static String FOURTH_PATH = "src/test/java/resourses/test4.csv";
    public final static String FIFTH_PATH = "src/test/java/resourses/test5.csv";
    public final static String SIXTH_PATH = "src/test/java/resourses/test6.csv";
    public final static String FIRST_PATH_OUT = "src/test/java/resourses/expectedOutput1.csv";
    public final static String SECOND_PATH_OUT = "src/test/java/resourses/expectedOutput2.csv";
    public final static String THIRD_PATH_OUT = "src/test/java/resourses/expectedOutput3.csv";
    public final static String FOURTH_PATH_OUT = "src/test/java/resourses/expectedOutput4.csv";



    FileService fileService = new ReaderFromFile();
    OrderParserLogic parserLogic = new OrderParserLogic();
    Report report = new Report();
    WriterToFile writeToFile = new WriterToFile();

    @Test
    public void smallTest() {
        ProductCalculator.STORAGE.clear();
        for (List<String> list : fileService.readFile(FIRST_PATH)) {
            parserLogic.parseToStorage(list);
        }
        writeToFile.print(report.getReport(), "src/test/java/resourses/test1Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test1Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(FIRST_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void correctBuyingTest() {
        ProductCalculator.STORAGE.clear();
        for (List<String> list : fileService.readFile(SECOND_PATH)) {
            parserLogic.parseToStorage(list);
        }
        writeToFile.print(report.getReport(), "src/test/java/resourses/test2Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test2Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(SECOND_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithDifProducts() {
        ProductCalculator.STORAGE.clear();
        for (List<String> list : fileService.readFile(THIRD_PATH)) {
            parserLogic.parseToStorage(list);
        }
        writeToFile.print(report.getReport(), "src/test/java/resourses/test3Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test3Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(THIRD_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithRefundsOnly() {
        ProductCalculator.STORAGE.clear();
        for (List<String> list : fileService.readFile(FOURTH_PATH)) {
            parserLogic.parseToStorage(list);
        }
        writeToFile.print(report.getReport(), "src/test/java/resourses/test4Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test4Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(FOURTH_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NoSuchProductException.class)
    public void buyProductWeDontHaveTest() {
        ProductCalculator.STORAGE.clear();
        for (List<String> list : fileService.readFile(FIFTH_PATH)) {
            parserLogic.parseToStorage(list);
        }
    }

    @Test(expected = NotEnoughProductsException.class)
    public void buyMoreProductsThanWeHaveTest () {
        ProductCalculator.STORAGE.clear();
        for (List<String> list : fileService.readFile(SIXTH_PATH)) {
            parserLogic.parseToStorage(list);
        }
    }
}