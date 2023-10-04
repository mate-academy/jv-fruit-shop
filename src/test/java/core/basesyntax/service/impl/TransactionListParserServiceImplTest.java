package core.basesyntax.service.impl;

import static core.basesyntax.model.Product.APPLE;
import static core.basesyntax.model.Product.BANANA;
import static core.basesyntax.strategy.FruitTransaction.Operation.BALANCE;
import static core.basesyntax.strategy.FruitTransaction.Operation.PURCHASE;
import static core.basesyntax.strategy.FruitTransaction.Operation.RETURN;
import static core.basesyntax.strategy.FruitTransaction.Operation.SUPPLY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.TransactionListParserService;
import core.basesyntax.strategy.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("ParserImpl Test")
class TransactionListParserServiceImplTest {
    private static TransactionListParserService service;

    @BeforeAll
    static void beforeAll() {
        service = new TransactionListParserServiceImpl();
    }

    @Test
    @DisplayName("Check correct input data - many lines")
    @Order(1)
    void collectToProductList_validInput_ok() {
        List<String> inputList = List.of(
                "type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50");
        List<FruitTransaction> expectedList = List.of(
                new FruitTransaction(BALANCE, BANANA, 20),
                new FruitTransaction(BALANCE, APPLE, 100),
                new FruitTransaction(SUPPLY, BANANA, 100),
                new FruitTransaction(PURCHASE, BANANA, 13),
                new FruitTransaction(RETURN, APPLE, 10),
                new FruitTransaction(PURCHASE, APPLE, 20),
                new FruitTransaction(PURCHASE, BANANA, 5),
                new FruitTransaction(SUPPLY, BANANA, 50));
        assertEquals(expectedList, service.parse(inputList));
    }

    @Test
    @DisplayName("Check correct input data - only titles")
    @Order(2)
    void collectToProductList_onlyTitleLineInput_ok() {
        List<String> inputList = List.of("type,fruit,quantity");
        List<FruitTransaction> expectedList = new ArrayList<>();
        assertEquals(expectedList, service.parse(inputList));
    }

    @Test
    @DisplayName("Check correct input data - one data line")
    @Order(3)
    void collectToProductList_oneLineInput_ok() {
        List<String> inputList = List.of("type,fruit,quantity", "b,banana,20");
        List<FruitTransaction> expectedList =
                List.of(new FruitTransaction(BALANCE, BANANA, 20));
        assertEquals(expectedList, service.parse(inputList));
    }

    @Test
    @DisplayName("Check correct input data - empty list")
    @Order(4)
    void collectToProductList_emptyLineInput_ok() {
        List<String> inputList = new ArrayList<>();
        List<FruitTransaction> expectedList = new ArrayList<>();
        assertEquals(expectedList, service.parse(inputList));
    }

    @Test
    @DisplayName("Check incorrect input data - null-pointer")
    @Order(5)
    void collectToProductList_nullInput_notOk() {
        assertThrows(RuntimeException.class, () -> service.parse(null));
    }

    @Test
    @DisplayName("Check incorrect input data - bad line's format")
    @Order(6)
    void collectToProductList_invalidStringInputFormat_notOk() {
        List<String> inputList = List.of("type,fruit", "b,banana");
        assertThrows(RuntimeException.class, () -> service.parse(inputList));
    }
}
