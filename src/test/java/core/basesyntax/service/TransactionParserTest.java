package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Impl.TransactionParserImpl;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionParserTest {
    private TransactionParser parser;

    @BeforeEach
    void setUp() {
        parser = new TransactionParserImpl();
    }

    @Test
    void parseData_validData_ok() {
        List<String> dataForParsing = List.of("b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50");
        List<FruitTransaction> exceptedData = List.of(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "banana", 20),
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "apple", 100),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "banana", 100),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 13),
                new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 10),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 20),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 5),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "banana", 50));
        List<FruitTransaction> actualTransactions = parser.parseData(dataForParsing);
        Assertions.assertEquals(exceptedData, actualTransactions);
    }

    @Test
    void parse_notValidData_notOk() {
        List<String> dataForParsing = List.of("b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,notValid");
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseData(dataForParsing));
    }

    @Test
    void parse_dataIsNull_notOk() {
        List<String> dataForParsing = null;
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseData(dataForParsing));
    }

    @Test
    void parse_dataIsEmpty_notOk() {
        List<String> dataForParsing = Collections.emptyList();
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseData(dataForParsing));
    }
}