package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FruitShopAppTest {

    private static final String ACTUAL_OUTPUT = "src/test/resources/test_output.csv";
    private static final String INPUT = "src/test/resources/data.csv";
    private static final String EXPECTED_OUTPUT = "src/test/resources/data_output.csv";

    @Test
    public void startAppTestOk() {
        FruitShopApp fruitShopApp = new FruitShopApp();
        FileService fileService = new FileServiceImpl();
        fruitShopApp.startApp(INPUT, ACTUAL_OUTPUT);
        List<FruitTransaction> actual = fileService.readFile(ACTUAL_OUTPUT);
        List<FruitTransaction> expected = fileService.readFile(EXPECTED_OUTPUT);
        Assert.assertEquals(actual, expected);
    }
}
