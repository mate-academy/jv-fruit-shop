package core.basesyntax.resources;

import core.basesyntax.*;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OperationWithFruitsTest {
    public static DataValidator dataValidator = new DataValidator();
    public static ReadFromFile reader = new ReadFromFile();
    public static OperationWithFruits operation = new OperationWithFruits();
    private static final String FIRST_FILE_NAME = "txt2";
    private static final String SECOND_FILE_NAME = "txt3";
    private static final String THIRD_FILE_NAME = "txt4";
    private static final String FOURTH_FILE_NAME = "txt6";
    private static final String FIFTH_FILE_NAME = "txt5";
    public static Parser transaction = new Parser();


    @Test
    public void buying_Test_OK() throws Exception {
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

    @Test
    public void buying_Test2_OK() throws Exception {
        List<String> fruitsFromFileString = reader.readFromFile(FOURTH_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        List <Fruit> actual = operation.operationWithFruits(fruitsFromFile);
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", "2020-10-27"));
        expected.add(new Fruit("banana", "2020-10-27"));
        expected.add(new Fruit("banana", "2020-10-27"));
        expected.add(new Fruit("banana", "2020-10-27"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void buying_Test3_OK() throws Exception {
        List<String> fruitsFromFileString = reader.readFromFile(FIFTH_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        List <Fruit> actual = operation.operationWithFruits(fruitsFromFile);
        List<Fruit> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void buying_Test_Fail_Date() throws Exception {
        List<String> fruitsFromFileString = reader.readFromFile(SECOND_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        operation.operationWithFruits(fruitsFromFile);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void buying_Test_Fail_Amount() throws Exception {
        List<String> fruitsFromFileString = reader.readFromFile(THIRD_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parser(fruitsFromFileString);
        operation.operationWithFruits(fruitsFromFile);
    }
}
