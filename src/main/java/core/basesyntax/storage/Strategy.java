package core.basesyntax.storage;

import core.basesyntax.servise.FruitRecordDto;

public interface Strategy {
    int changeBalance(FruitRecordDto fruitRecordDto);
}
