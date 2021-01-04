package core.basesyntax.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import core.basesyntax.validator.impl.OperationValidationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OperationValidationTest {
    private static final String OPERATION_VALID = "r";
    private static final String OPERATION_INVALID = "a";
    private static final List<String> LIST_OF_OPERATIONS = Arrays.asList("bsrp".split(""));
    private static OperationValidation operationValidator;

    @BeforeAll
    static void setUp() {
        operationValidator = new OperationValidationImpl();
    }

    @Test
    void isValidOperation_Ok() {
        boolean actual = operationValidator.isValidOperation(LIST_OF_OPERATIONS, OPERATION_VALID);
        assertTrue(actual);
    }

    @Test
    void isValidOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            operationValidator.isValidOperation(LIST_OF_OPERATIONS, OPERATION_INVALID);
        });
    }
}
