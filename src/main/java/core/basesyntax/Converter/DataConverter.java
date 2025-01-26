package core.basesyntax.Converter;

import core.basesyntax.Model.FruitTransaction;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactions(List<String> lines);
}
