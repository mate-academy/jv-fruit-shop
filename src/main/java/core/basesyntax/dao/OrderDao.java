package core.basesyntax.dao;

import core.basesyntax.operation.OperationGeneral;
import core.basesyntax.operation.Supply;
//import core.basesyntax.order.Order;

import java.util.List;

public interface OrderDao {
    void add(OperationGeneral order);

    List<OperationGeneral> getAll();
}
