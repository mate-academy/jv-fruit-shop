package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;

import java.util.List;

public interface Worker {
    void processData(List<FruitRecord> records);
}
