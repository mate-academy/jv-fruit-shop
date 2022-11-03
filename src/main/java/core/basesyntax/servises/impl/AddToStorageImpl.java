package core.basesyntax.servises.impl;

import core.basesyntax.handler.HandlerStrategy;
import core.basesyntax.handler.impl.HandlerStrategyImpl;
import core.basesyntax.servises.AddToStorage;
import core.basesyntax.storage.Storage;
import java.util.List;

public class AddToStorageImpl implements AddToStorage {
    private static final String SPLIT = ",";
    private HandlerStrategy strategy = new HandlerStrategyImpl();

    @Override
    public void addToStorage(List<String> list) {
        for (String line : list) {
            String[] elements = line.split(SPLIT);
            strategy.strategy(elements,Storage.storage);
        }
    }
}
