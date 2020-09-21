package core.basesyntax;

import core.basesyntax.service.FileService;
import dto.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import parsers.OrderParser;

public class ProductCalculatorTest {
    public static final Storage testStorage = new Storage();
    FileService fileService = new FileService();

    @Test
    public void addProductsToDbTest() {
        orderToDb("src/test/java/resourses/test2.csv");
        Assert.assertEquals(1, testStorage.getAllProducts().size());
        Assert.assertEquals(30, testStorage.getAllProducts().get("banana").get(0).getQuantity());
    }

    @Test
    public void removeSomeProductsFromDbTest() {
        orderToDb("src/test/java/resourses/test8.csv");
        Assert.assertEquals(0, testStorage.getAllProducts().get("banana").get(0).getQuantity());
        Assert.assertEquals(0, testStorage.getAllProducts().get("banana").get(1).getQuantity());
        Assert.assertEquals(50, testStorage.getAllProducts().get("banana").get(2).getQuantity());
    }

    @Test
    public void removeAllProductsFromDbTest() {
        testStorage.removeProductBox("banana", testStorage.getAllProducts().get("banana"));
        Assert.assertFalse(testStorage.getAllProducts().containsKey("banana"));
    }

    private void orderToDb(String filename) {
        List<String> file = fileService.readFile(filename);
        List<Order> orders = new ArrayList<>();
        OrderParser parser = new OrderParser();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        ProductCalculator productCalculator = new ProductCalculator(testStorage);
        productCalculator.ordersToStorage(orders);
    }
}
