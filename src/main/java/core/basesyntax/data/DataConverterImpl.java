package core.basesyntax.data;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;
import java.util.Objects;

public class DataConverterImpl implements DataConverter {
    private Formater formater;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(s -> {
                    if (formater == null) {
                        formater = new FormaterImpl(s);
                        return null;
                    }
                    return parseFromString(s);
                })
                .filter(Objects::nonNull)
                .toList();
    }

    private FruitTransaction parseFromString(String s) {
        return formater.parseTransaction(s);
    }
}
