package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.model.Fruit;
import core.basesyntax.operations.DataValidator;
import core.basesyntax.operations.FileReaderImpl;
import core.basesyntax.operations.Operator;
import core.basesyntax.operations.Parser;
import core.basesyntax.operations.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OperatorTest {
    public static DataValidator dataValidator = new DataValidator();
    public static FileReaderImpl reader = new FileReaderImpl();
    public static Operator operation = new Operator();
    private static final String FIRST_FILE_NAME = "src/test/resources/txt2.csv";
    private static final String SECOND_FILE_NAME = "src/test/resources/txt3.csv";
    private static final String THIRD_FILE_NAME = "src/test/resources/txt4.csv";
    private static final String FOURTH_FILE_NAME = "src/test/resources/txt6.csv";
    private static final String FIFTH_FILE_NAME = "src/test/resources/txt5.csv";
    public static Parser transaction = new Parser();
    public static FruitDao fruitDao = new FruitDaoImpl();

@Before
public void setUp() {
    fruitDao.getAll().clear();
}
    @Test
    public void buying_Test_OK() {
        List<String> fruitsFromFileString = reader.readFromFile(FIRST_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parse(fruitsFromFileString);
        List <Fruit> actual = operation.processTransaction(fruitsFromFile);
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple", "2020-10-17"));
        expected.add(new Fruit("banana", "2020-10-17"));
        expected.add(new Fruit("banana", "2020-10-17"));
        expected.add(new Fruit("orange", "2020-10-17"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void buying_Test2_OK() {
        List<String> fruitsFromFileString = reader.readFromFile(FOURTH_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parse(fruitsFromFileString);
        List <Fruit> actual = operation.processTransaction(fruitsFromFile);
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", "2020-10-27"));
        expected.add(new Fruit("banana", "2020-10-27"));
        expected.add(new Fruit("banana", "2020-10-27"));
        expected.add(new Fruit("banana", "2020-10-27"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void buying_Test3_OK() {
        List<String> fruitsFromFileString = reader.readFromFile(FIFTH_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parse(fruitsFromFileString);
        List <Fruit> actual = operation.processTransaction(fruitsFromFile);
        List<Fruit> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void buying_Test_Fail_Date() {
        List<String> fruitsFromFileString = reader.readFromFile(SECOND_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parse(fruitsFromFileString);
        operation.processTransaction(fruitsFromFile);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void buying_Test_Fail_Amount() {
        List<String> fruitsFromFileString = reader.readFromFile(THIRD_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFileString);
        List <Transaction> fruitsFromFile = transaction.parse(fruitsFromFileString);
        operation.processTransaction(fruitsFromFile);
    }
}
