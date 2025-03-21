package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.function.Function;

public class DataConverterImpl implements DataConverter {
    private final Function<String, FruitTransaction> transactionMapper = new TransactionParser();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputTransactions) {
        return inputTransactions.stream()
                .map(transactionMapper)
                .toList();
    }
}
