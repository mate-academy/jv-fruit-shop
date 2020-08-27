package core.basesyntax.stock.dao;

import core.basesyntax.stock.db.Storage;
import core.basesyntax.stock.order.Order;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public List<Order> getAll() {
        return Storage.orders;
    }
}
