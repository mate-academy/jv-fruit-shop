package core.basesyntax.parser;

import core.basesyntax.model.Order;

public interface ParseOperation {
    Order parseNewOrder(String row);
}
