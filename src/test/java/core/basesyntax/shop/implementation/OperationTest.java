package core.basesyntax.shop.implementation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OperationTest {
    private static Operation operation;
    private static StringSplitter splitter;
    private static final String SPLIT_LINE = "b,apple,100";

    @BeforeAll
    static void beforeAll() {
        splitter = new StringSplitter(SPLIT_LINE);
        operation = new Operation();
    }

    @Test
    void operateData_Ok() {
        assertTrue(operation.operateData(splitter));
    }
}
