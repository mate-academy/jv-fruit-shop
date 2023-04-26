package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface WriteScvService {
    void writeDataScvFile(List<FruitTransaction> fruitTransactionList, String fileName);

}
