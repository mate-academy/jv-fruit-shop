package core.basesyntax;

import core.basesyntax.service.FileService;
import dto.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import parsers.OrderParser;

public class ProductCalculatorTest {
    public final static Storage testStorage = new Storage();
    FileService fileService = new FileService();

    @Test
    public void productCalculatorTest() {
        List<String> file = fileService.readFile("src/test/java/resourses/test2.csv");
        List<Order> orders = new ArrayList<>();
        OrderParser parser = new OrderParser();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        ProductCalculator productCalculator = new ProductCalculator(testStorage);
        productCalculator.ordersToStorage(orders);

        Assert.assertEquals(1, testStorage.getAllProducts().size());
        Assert.assertEquals(30, testStorage.getAllProducts().get("banana").get(0).getQuantity());
    }

    @Test
    public void removeProductTest() {
        testStorage.removeProductBox("banana", testStorage.getAllProducts().get("banana"));
        Assert.assertFalse(testStorage.getAllProducts().containsKey("banana"));
    }

}
