package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.operation.Supply;

import java.util.List;

public class OrderDaoImpl implements OrderDao<Supply> {
    @Override
    public void add(Supply order) {
        Storage.orders.add(order);
    }

    @Override
    public List<Supply> getAll() {
        return Storage.orders;
    }
}
