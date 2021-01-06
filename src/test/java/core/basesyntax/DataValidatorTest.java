package core.basesyntax;

import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.StrategyCreatorImpl;
import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.interfaces.StrategyCreator;
import core.basesyntax.service.operations.Operation;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataValidatorTest {
    private static DataValidator validator;

    @BeforeClass
    public static void setUp() {
        StrategyCreator strategyCreator = new StrategyCreatorImpl();
        Map<String, Operation> strategy = strategyCreator.createStrategy();
        validator = new DataValidatorImpl(strategy);
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsOperationValidTest_NotOk() {
        validator.isOperationValid(new String[]{"h"});
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsInputIntegerTest_NotOk() {
        validator.isNumberValid(new String[]{"b", "apple", "string"});
    }

    @Test(expected = RuntimeException.class)
    public void dataValidatorIsInputGreaterZeroTest_NotOk() {
        validator.isNumberValid(new String[]{"b", "apple", "-15"});
    }
}
