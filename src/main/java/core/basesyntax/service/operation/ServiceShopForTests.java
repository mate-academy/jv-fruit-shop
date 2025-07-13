package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ServiceShopForTestsException;

public interface ServiceShopForTests {
    FruitTransaction shopTest(FruitTransaction fruitTransaction)
            throws ServiceShopForTestsException;
}
