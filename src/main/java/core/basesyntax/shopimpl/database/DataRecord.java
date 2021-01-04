package core.basesyntax.shopimpl.database;

import core.basesyntax.model.shopstrategy.ShopActions;

public record DataRecord(ShopActions action, String item, Integer amount) {
}
