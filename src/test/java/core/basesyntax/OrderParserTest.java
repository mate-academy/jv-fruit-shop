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

public class OrderParserTest {
    @Test
    public void orderParserLogicTest() {
        FileService fileService = new ReaderFromFile();
        List<List<String>> file = fileService.readFile("src/test/java/resourses/test1.csv");
        OrderParserLogic parserLogic = new OrderParserLogic();
        AbstractOrder firstOrder = OrderParserLogic.command.get(file.get(0).get(0)).parse(file.get(0));
        AbstractOrder secondOrder = OrderParserLogic.command.get(file.get(1).get(0)).parse(file.get(1));
        AbstractOrder thirdOrder = OrderParserLogic.command.get(file.get(2).get(0)).parse(file.get(2));
        Assert.assertTrue(firstOrder instanceof SupplierOrder);
        Assert.assertTrue(secondOrder instanceof BuyerOrder);
        Assert.assertTrue(thirdOrder instanceof RefunderOrder);
    }
}
