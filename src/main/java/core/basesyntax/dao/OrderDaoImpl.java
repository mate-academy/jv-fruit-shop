package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.operation.OperationGeneral;
import core.basesyntax.operation.Supply;
//import core.basesyntax.order.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void add(OperationGeneral order) {
        Storage.orders.add(order);
    }

    @Override
    public List<OperationGeneral> getAll() {
        return Storage.orders;
    }
}
