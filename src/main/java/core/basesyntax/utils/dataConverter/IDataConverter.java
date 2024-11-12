package core.basesyntax.utils.dataConverter;

import core.basesyntax.models.FruitTransaction;

import java.util.List;

public interface IDataConverter {
    List<FruitTransaction> toFruitTransactions(List<String> transactionsStrings);
}
