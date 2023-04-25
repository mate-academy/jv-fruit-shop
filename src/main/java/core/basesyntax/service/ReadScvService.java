package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ReadScvService {
    public List<Fruit> readFromFileDataCsv();
    public List<FruitTransaction> readFromFileInputCsv();
}
