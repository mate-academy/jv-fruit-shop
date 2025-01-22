package core.basesyntax.DataService;

import core.basesyntax.tranasctions.FruitTransaction;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> data);
}
