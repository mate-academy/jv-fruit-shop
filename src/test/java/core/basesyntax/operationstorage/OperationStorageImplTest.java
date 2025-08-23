package core.basesyntax.operationstorage;

import static core.basesyntax.model.TypeOfOperation.b;
import static core.basesyntax.model.TypeOfOperation.p;
import static core.basesyntax.model.TypeOfOperation.s;

import core.basesyntax.model.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationStorageImplTest {

    @Test
    void getOperationsByTypeAndFruit() {
        Operation o2 = new Operation();
        o2.setTypeOfOperation(b);
        o2.setFruit("lemon");
        o2.setQuantity(82);
        Operation o3 = new Operation();
        o3.setTypeOfOperation(b);
        o3.setFruit("banana");
        o3.setQuantity(157);
        Operation o4 = new Operation();
        o4.setTypeOfOperation(s);
        o4.setFruit("orange");
        o4.setQuantity(10);
        Operation o5 = new Operation();
        o5.setTypeOfOperation(p);
        o5.setFruit("apple");
        o5.setQuantity(4);

        OperationStorageService operationStorageService = new OperationStorageImpl();

        Assertions.assertEquals(o2, operationStorageService
                .getOperationsByTypeAndFruit(b, "lemon").get(0));
        Assertions.assertEquals(o5, operationStorageService
                .getOperationsByTypeAndFruit(p, "apple").get(0));
        Assertions.assertEquals(o4, operationStorageService
                .getOperationsByTypeAndFruit(s, "orange").get(0));

    }
}
