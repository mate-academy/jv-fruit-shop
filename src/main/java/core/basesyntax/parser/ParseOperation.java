package core.basesyntax.parser;

import core.basesyntax.order.Order;

public interface ParseOperation {
    Order parse(String data);
}
