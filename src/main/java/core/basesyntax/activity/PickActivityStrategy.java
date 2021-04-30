package core.basesyntax.activity;


import core.basesyntax.storage.dao.HandleGoods;

public interface PickActivityStrategy {
    HandleGoods get(Activities activities);
}
