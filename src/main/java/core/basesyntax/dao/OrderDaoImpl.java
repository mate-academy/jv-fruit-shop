package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.order.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void add(Order order) {
        Storage.orders.add(order);
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }
}
