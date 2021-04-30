package core.basesyntax.activity;

import core.basesyntax.storage.dao.StorageHandler;

public interface ActivityStrategy {
    StorageHandler get(Activities activities);
}
