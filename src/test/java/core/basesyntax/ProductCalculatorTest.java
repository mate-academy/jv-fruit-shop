package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.ReaderFromFile;
import dto.AbstractOrder;
import dto.BuyerOrder;
import dto.RefunderOrder;
import dto.SupplierOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductCalculatorTest {
    public final static String DATA_FIRST_PATH = "src/test/java/resourses/test1.csv";
    ProductCalculator productCalculator = new ProductCalculator();
    FileService fileService = new ReaderFromFile();
    List<List<String>> file = fileService.readFile(DATA_FIRST_PATH);
    OrderParserLogic parserLogic = new OrderParserLogic();

    @Test
    public void addingDifferentOrders() {
        ProductCalculator.STORAGE.clear();
        AbstractOrder firstOrder = OrderParserLogic.command.get(file.get(0).get(0)).parse(file.get(0));
        AbstractOrder secondOrder = OrderParserLogic.command.get(file.get(1).get(0)).parse(file.get(1));
        AbstractOrder thirdOrder = OrderParserLogic.command.get(file.get(2).get(0)).parse(file.get(2));
        AbstractOrder fourthOrder = OrderParserLogic.command.get(file.get(3).get(0)).parse(file.get(3));
        AbstractOrder fifthOrder = OrderParserLogic.command.get(file.get(4).get(0)).parse(file.get(4));

        productCalculator.productToStorage((SupplierOrder) firstOrder);
        Assert.assertEquals(100, ProductCalculator.STORAGE.
                get(firstOrder.getProductName()).get(0).getQuantity());

        productCalculator.productToStorage((BuyerOrder) secondOrder);
        Assert.assertEquals(50, ProductCalculator.STORAGE.
                get(secondOrder.getProductName()).get(0).getQuantity());

        productCalculator.productToStorage((RefunderOrder) thirdOrder);
        Assert.assertEquals(60, ProductCalculator.STORAGE
                .get(thirdOrder.getProductName()).get(0).getQuantity());

        productCalculator.productToStorage((SupplierOrder) fourthOrder);
        Assert.assertEquals(100, ProductCalculator.STORAGE.
                get(fourthOrder.getProductName()).get(1).getQuantity());

        productCalculator.productToStorage((BuyerOrder) fifthOrder);
        Assert.assertEquals(0, ProductCalculator.STORAGE.
                get(secondOrder.getProductName()).get(0).getQuantity());
        Assert.assertEquals(90,ProductCalculator.STORAGE.
                get(fifthOrder.getProductName()).get(1).getQuantity());
    }
}
