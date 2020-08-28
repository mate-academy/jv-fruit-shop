package core.basesyntax.resources;

import core.basesyntax.*;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OperationWithFruitsTest {

    public static OperationWithFruits operation = new OperationWithFruits();
    private static final String FIRST_FILE_NAME = "txt2";
    private static final String SECOND_FILE_NAME = "txt3";
    private static final String THIRD_FILE_NAME = "txt4";
    public static Parser transaction = new Parser();

    @Test
    public void buying_Test_OK() throws Exception {
        DataValidator dataValidator = new DataValidator();
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFileString = reader.readFromFile(FIRST_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        List <Fruit> actual = operation.operationWithFruits(fruitsFromFile);
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple", "2020-10-17"));
        expected.add(new Fruit("banana", "2020-10-17"));
        expected.add(new Fruit("banana", "2020-10-17"));
        expected.add(new Fruit("orange", "2020-10-17"));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void buying_Test_Fail_Date() throws Exception {
        DataValidator dataValidator = new DataValidator();
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFileString = reader.readFromFile(SECOND_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        operation.operationWithFruits(fruitsFromFile);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void buying_Test_Fail_Amount() throws Exception {
        DataValidator dataValidator = new DataValidator();
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFileString = reader.readFromFile(THIRD_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        operation.operationWithFruits(fruitsFromFile);
    }
}
