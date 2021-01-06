package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderImplTest {
    private static final String INCORRECT_QUALITY_FRUIT_SHOP_CSV = "src/test/resources/"
            + "incorrectQuantity_fruit_shop.csv";
    private static final String INCORRECT_OPERATION_FRUIT_SHOP_CSV = "src/test/resources/"
            + "incorrectOperation_fruit_shop.csv";
    private static final String CORRECT_FRUIT_SHOP_CSV = "src/test/resources/"
            + "correct_fruit_shop.csv";
    private static final CsvFileReader csvFileReader = new CsvFileReaderImpl();

    @Test(expected = RuntimeException.class)
    public void correctQuantity_notOk() {
        csvFileReader.readFromFile(INCORRECT_QUALITY_FRUIT_SHOP_CSV);
    }

    @Test(expected = RuntimeException.class)
    public void correctOperation_notOk() {
        csvFileReader.readFromFile(INCORRECT_OPERATION_FRUIT_SHOP_CSV);
    }

    @Test
    public void readCsvFile_Ok() {
        List<TransactionDto> expectedTransactionDtoList =
                List.of(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20),
                        new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100),
                        new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 13),
                        new TransactionDto(Operation.RETURN, new Fruit("apple"), 10),
                        new TransactionDto(Operation.SUPPLY, new Fruit("apple"), 20));

        List<TransactionDto> actualTransactionDtoList = csvFileReader
                .readFromFile(CORRECT_FRUIT_SHOP_CSV);
        Assert.assertEquals(expectedTransactionDtoList, actualTransactionDtoList);
    }
}

