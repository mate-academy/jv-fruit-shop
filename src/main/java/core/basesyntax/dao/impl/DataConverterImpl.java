package core.basesyntax.dao.impl;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> transactionsReport = new ArrayList<>();
        for (String line : report){
            String[] values = line.split(COMA_SEPARATOR);
            Operation operation = Operation.valueOf(values[0].toUpperCase());
            String fruit = values[1];
            int quantity = Integer.parseInt(values[2]);
            transactionsReport.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactionsReport;
    }
}
