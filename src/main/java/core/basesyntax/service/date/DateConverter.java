package core.basesyntax.service.date;

import core.basesyntax.service.FruitTransaction;

import java.util.List;

public interface DateConverter {
    List<FruitTransaction> convertToTransaction(List<String> rawData);
}
