package core.basesyntax;

import core.basesyntax.service.impl.StrategyCreatorImpl;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.service.interfaces.ReportParser;
import core.basesyntax.service.interfaces.StrategyCreator;
import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.interfaces.DoOperation;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.interfaces.WriteToFile;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestAllMethods {
    String dataPath = "src/test/resources/data";
    String resultPath = "src/test/resources/result";
    String testPath = "src/test/resources/test";

    @Test
    public void ususalTest() {
        Main main = new Main();
        main.main(new String[]{});
        ReadFromFile fileReader = new ReadFromFileImpl();

        List<String> expected = List.of("banana,152", "apple,90");
        List<String> actual = fileReader.readFromFile(resultPath);

        Assert.assertEquals(expected, actual);
        Storage.storage = new HashMap<>();
    }

    @Test
    public void readFromWriteToFileTest() {
        WriteToFile fileWriter = new WriteToFileImpl();
        ReadFromFile fileReader = new ReadFromFileImpl();

        fileWriter.write(testPath, "fruit,quantity\n123\n456\n789");
        List<String> expected = List.of("123", "456", "789");
        List<String> actual = fileReader.readFromFile(testPath);

        Assert.assertEquals(expected, actual);
        Storage.storage = new HashMap<>();
    }

    @Test
    public void combineOutputTest() {
        //ReportParser outputCombiner = new ReportParserImpl();
        Storage.storage.put("key1", 1);
        Storage.storage.put("key2", 2);
        Storage.storage.put("key3", 3);

        String expected = "fruit,quantity" + System.lineSeparator()
                + "key1,1" + System.lineSeparator()
                + "key2,2" + System.lineSeparator() + "key3,3";
        //String actual = outputCombiner.combineOutput();

        //Assert.assertEquals(expected, actual);
        Storage.storage = new HashMap<>();
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsOperationValidTest() {
        DataValidator validator = new DataValidatorImpl();
        StrategyCreator strategyCreator = new StrategyCreatorImpl();

        validator.isOperationValid(strategyCreator.createStrategy(), new String[]{"h"});
        Storage.storage = new HashMap<>();
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsInputIntegerTest() {
        DataValidator validator = new DataValidatorImpl();

        validator.isNumberValid(new String[]{"b", "apple", "string"});
        Storage.storage = new HashMap<>();
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsInputGreaterZeroTest() {
        DataValidator validator = new DataValidatorImpl();

        validator.isNumberValid(new String[]{"b", "apple", "-15"});
        Storage.storage = new HashMap<>();
    }

    @Test
    public void doOperationCreateStrategyTest() {
        //DoOperation operator = new DoOperationImpl();
        StrategyCreator strategyCreator = new StrategyCreatorImpl();
        Storage.storage.put("banana", 10);
        Storage.storage.put("apple", 10);
        String[] record = new String[] {"s", "banana", "10"};

        //operator.doOperation(record, strategyCreator.createStrategy());

        Integer expected = 20;
        Integer actual = Storage.storage.get("banana");

        Assert.assertEquals(expected, actual);
        Storage.storage = new HashMap<>();
    }
}
