package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Order;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public void add(Order order) {
        Storage.orders.add(order);
    }

    public List<Order> getAll() {
        return Storage.orders;
    }
}
