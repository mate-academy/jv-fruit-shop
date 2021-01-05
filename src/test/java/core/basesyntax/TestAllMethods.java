package core.basesyntax;

import core.basesyntax.service.impl.CombineOutputImpl;
import core.basesyntax.service.impl.CreateStrategyImpl;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.DoOperationImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.service.interfaces.CombineOutput;
import core.basesyntax.service.interfaces.CreateStrategy;
import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.interfaces.DoOperation;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.interfaces.WriteToFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class TestAllMethods {
    String dataPath = "src/test/resources/data";
    String resultPath = "src/test/resources/result";
    String testPath = "src/test/resources/test";

    @Test
    public void ususalTest() {
        Shop shop = new Shop(dataPath, resultPath);
        ReadFromFile fileReader = new ReadFromFileImpl();

        List<String> expected = List.of("banana,152", "apple,90");
        List<String> actual = fileReader.readFromFile(resultPath);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readFromWriteToFileTest() {
        WriteToFile fileWriter = new WriteToFileImpl();
        ReadFromFile fileReader = new ReadFromFileImpl();

        fileWriter.write(testPath, "fruit,quantity\n123\n456\n789");
        List<String> expected = List.of("123", "456", "789");
        List<String> actual = fileReader.readFromFile(testPath);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void combineOutputTest() {
        CombineOutput outputCombiner = new CombineOutputImpl();

        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        String expected = "fruit,quantity\n" + "key1,1\n" + "key2,2\n" + "key3,3";
        String actual = outputCombiner.combineOutput(map);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsOperationValidTest() {
        DataValidator validator = new DataValidatorImpl();
        CreateStrategy strategyCreator = new CreateStrategyImpl();

        validator.isOperationValid(strategyCreator.createStrategy(), new String[]{"h"});
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsInputIntegerTest() {
        DataValidator validator = new DataValidatorImpl();

        validator.isNumberValid(new String[]{"b", "apple", "string"});
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsInputGreaterZeroTest() {
        DataValidator validator = new DataValidatorImpl();

        validator.isNumberValid(new String[]{"b", "apple", "-15"});
    }

    @Test
    public void doOperationCreateStrategyTest() {
        DoOperation operator = new DoOperationImpl();
        CreateStrategy strategyCreator = new CreateStrategyImpl();
        Map<String, Integer> shop = new HashMap<>();
        shop.put("banana", 10);
        shop.put("apple", 10);
        String[] record = new String[] {"s", "banana", "10"};

        operator.doOperation(shop, record, strategyCreator.createStrategy());

        Integer expected = 20;
        Integer actual = shop.get("banana");

        Assert.assertEquals(expected, actual);
    }
}
