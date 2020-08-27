package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.order.Order;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public List<Order> getAll() {
        return Storage.orders;
    }
}
