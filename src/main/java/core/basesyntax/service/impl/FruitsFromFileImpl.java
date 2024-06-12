package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitsFromFile;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsFromFileImpl implements FruitsFromFile {
    @Override
    public List<String> getFruitsFromFile(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());
    }
}
