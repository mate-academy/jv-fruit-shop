package core.basesyntax;

import core.basesyntax.service.FileService;
import dto.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import parsers.OrderParser;

public class ReportTest {

    public static final Storage testStorage = new Storage();
    FileService fileService = new FileService();

    @Test
    public void createCorrectReportTest() {
        List<String> file = fileService.readFile("src/test/java/resourses/test2.csv");
        List<Order> orders = new ArrayList<>();
        OrderParser parser = new OrderParser();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        ProductCalculator productCalculator = new ProductCalculator(testStorage);
        productCalculator.ordersToStorage(orders);
        String actual = testStorage.getReport();
        String expected = "fruit,quantity\n"
                + "banana,130\n";
        Assert.assertEquals(actual, expected);
    }
}
