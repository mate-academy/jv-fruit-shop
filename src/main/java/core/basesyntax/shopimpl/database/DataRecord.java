package core.basesyntax.shopimpl.database;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopActions;

public record DataRecord(ShopActions action, AbstractItem item, Integer amount) {
}
