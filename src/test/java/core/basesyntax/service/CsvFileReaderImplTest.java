package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CsvFileReaderImplTest {
    @Test
    public void readFile() {
        List<TransactionDto> expected = new ArrayList<>();
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20));
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100));
        expected.add(new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 100));
        expected.add(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 13));
        expected.add(new TransactionDto(Operation.RETURN, new Fruit("apple"), 10));
        expected.add(new TransactionDto(Operation.PURCHASE, new Fruit("apple"), 20));
        expected.add(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 5));
        expected.add(new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 50));
        List<TransactionDto> actual = new CsvFileReaderImpl().read("test-fruit.csv");
        Assertions.assertEquals(expected, actual);
    }
}
