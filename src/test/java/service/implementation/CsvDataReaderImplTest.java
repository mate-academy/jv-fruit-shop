package service.implementation;

import static org.junit.Assert.assertEquals;

import db.FruitStorage;
import exception.InvalidDataFormatException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import service.DataReader;

public class CsvDataReaderImplTest {
    public static final String VALID_INPUT = "src/test/resources/valid_input.csv";
    public static final String INVALID_AMOUNT_NAN = "src/test/resources/invalid_amount_NaN.csv";
    public static final String INVALID_FORMAT = "src/test/resources/invalid_format.csv";
    public static final String INVALID_OPERATION_IS_NUMBER = "src/test/resources/"
            + "invalid_operation_isNumber.csv";
    private static final List<FruitTransactionDto> expectedFruits = new ArrayList<>();
    private static final DataReader dataReader = new CsvDataReaderImpl();

    @Before
    public void setUp() {
        expectedFruits.add(new FruitTransactionDto(Operation.BALANCE, new Fruit("papaya"), 200));
        expectedFruits.add(new FruitTransactionDto(Operation.PURCHASE, new Fruit("papaya"), 20));
        expectedFruits.add(new FruitTransactionDto(Operation.SUPPLY, new Fruit("papaya"), 23));
        expectedFruits.add(new FruitTransactionDto(Operation.RETURN, new Fruit("papaya"), 10));
        expectedFruits.add(new FruitTransactionDto(Operation.BALANCE, new Fruit("durian"), 100));
        expectedFruits.add(new FruitTransactionDto(Operation.PURCHASE, new Fruit("durian"), 10));
        expectedFruits.add(new FruitTransactionDto(Operation.SUPPLY, new Fruit("durian"), 13));
        expectedFruits.add(new FruitTransactionDto(Operation.RETURN, new Fruit("durian"), 5));
    }

    @Test
    public void readFrom_ValidFile_OK() {
        List<FruitTransactionDto> actualFruits;
        DataReader reader = new CsvDataReaderImpl();
        actualFruits = reader.readFromFile(VALID_INPUT);
        for (int i = 0; i < actualFruits.size(); i++) {
            assertEquals(expectedFruits.get(i).getOperation(), actualFruits.get(i).getOperation());
            assertEquals(expectedFruits.get(i).getFruit(), actualFruits.get(i).getFruit());
            assertEquals(expectedFruits.get(i).getAmount(), actualFruits.get(i).getAmount());
        }
    }

    @Test(expected = InvalidDataFormatException.class)
    public void readFrom_InvalidFormatNaNAmount_file() {
        dataReader.readFromFile(INVALID_AMOUNT_NAN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFrom_InvalidFormat_file() {
        dataReader.readFromFile(INVALID_FORMAT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFrom_InvalidFormat_OperationIsNumber_file() {
        dataReader.readFromFile(INVALID_OPERATION_IS_NUMBER);
    }

    @AfterClass
    public static void afterClass() {
        FruitStorage.fruitStorage.clear();
    }
}
