package core.basesyntax.service;

import java.util.List;

public interface TransactionConverter {
    List<TransactionConverterImpl.FruitTransaction> convertLines(List<String> lines);
}
