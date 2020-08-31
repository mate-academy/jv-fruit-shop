package core.basesyntax;

import core.basesyntax.service.FileService;
import dto.Order;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import parsers.OrderParser;

public class DifferentTests {
    public final static Storage testStorage = new Storage();
    public final static String SECOND_PATH = "src/test/java/resourses/test2.csv";
    public final static String THIRD_PATH = "src/test/java/resourses/test3.csv";
    public final static String FOURTH_PATH = "src/test/java/resourses/test4.csv";
    public final static String FIFTH_PATH = "src/test/java/resourses/test5.csv";
    public final static String SIXTH_PATH = "src/test/java/resourses/test6.csv";
    public final static String SECOND_PATH_OUT = "src/test/java/resourses/expectedOutput2.csv";
    public final static String THIRD_PATH_OUT = "src/test/java/resourses/expectedOutput3.csv";
    public final static String FOURTH_PATH_OUT = "src/test/java/resourses/expectedOutput4.csv";
    public final static String SIXTH_PATH_OUT = "src/test/java/resourses/expectedOutput6.csv";
    public final static String SEVENTH_PATH = "src/test/java/resourses/test7.csv";


    FileService fileService = new FileService();
    OrderParser parser = new OrderParser();
    ProductCalculator productCalculator = new ProductCalculator(testStorage);

    @Test
    public void smallTest() {
        testStorage.getAllProducts().clear();
        List<String> file = fileService.readFile(SECOND_PATH);
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        productCalculator.ordersToStorage(orders);
        fileService.writeToFile(testStorage.getReport(), "src/test/java/resourses/test2Result.csv");
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
        testStorage.getAllProducts().clear();
        List<String> file = fileService.readFile(THIRD_PATH);
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        productCalculator.ordersToStorage(orders);
        fileService.writeToFile(testStorage.getReport(), "src/test/java/resourses/test3Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test3Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(THIRD_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void biggerTest() {
        testStorage.getAllProducts().clear();
        List<String> file = fileService.readFile(SIXTH_PATH);
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        productCalculator.ordersToStorage(orders);
        fileService.writeToFile(testStorage.getReport(), "src/test/java/resourses/test6Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test6Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(SIXTH_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithRefundsOnly() {
        testStorage.getAllProducts().clear();
        List<String> file = fileService.readFile(FOURTH_PATH);
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        productCalculator.ordersToStorage(orders);
        fileService.writeToFile(testStorage.getReport(), "src/test/java/resourses/test4Result.csv");
        try {
            List<String> actual = Files.readAllLines(Path.of("src/test/java/resourses/test4Result.csv"));
            List<String> expected = Files.readAllLines(Path.of(FOURTH_PATH_OUT));
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RuntimeException.class)
    public void buyProductWeDontHaveTest() {
        testStorage.getAllProducts().clear();
        List<String> file = fileService.readFile(FIFTH_PATH);
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        productCalculator.ordersToStorage(orders);
    }

    @Test(expected = RuntimeException.class)
    public void buyMoreProductsThanWeHaveTest () {
        testStorage.getAllProducts().clear();
        List<String> file = fileService.readFile(SEVENTH_PATH);
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        productCalculator.ordersToStorage(orders);
    }
}
