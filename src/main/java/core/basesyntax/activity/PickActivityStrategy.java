package core.basesyntax.activity;

import core.basesyntax.managing.storage.HandleGoods;

public interface PickActivityStrategy {
    HandleGoods get(Activities activities);
}
