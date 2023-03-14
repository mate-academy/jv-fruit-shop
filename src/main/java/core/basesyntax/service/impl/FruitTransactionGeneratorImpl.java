package core.basesyntax.service.impl;

import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionGeneratorImpl implements FruitTransactionGenerator {
    @Override
    public List<FruitTransaction> createFruitTransaction(List<String[]> metadata) {
        return metadata.stream()
                .map(t ->
                new FruitTransaction(FruitTransaction
                .Operation
                .getByCode(t[0]), t[1], Integer.parseInt(t[2])))
                .collect(Collectors.toList());
    }
}
