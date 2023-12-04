package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.TransactionsGetter;
import java.util.ArrayList;
import java.util.List;

public class TransactionsGetterImpl implements TransactionsGetter {
    private static final String RECORD_SEPARATOR = ";";
    private final DataConverter dataConverter = new DataConverterImpl();

    @Override
    public List<FruitTransaction> getTransactions(String data) {
        List<FruitTransaction> result = new ArrayList<>();
        String[] records = data.split(RECORD_SEPARATOR);
        for (String record : records) {
            result.add(dataConverter.convertDataToObject(record));
        }
        return result;
    }
}
