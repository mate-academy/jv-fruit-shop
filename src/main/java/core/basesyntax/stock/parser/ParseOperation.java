package core.basesyntax.stock.parser;

import core.basesyntax.stock.order.Order;

public interface ParseOperation {
    Order parse(String data);
}
